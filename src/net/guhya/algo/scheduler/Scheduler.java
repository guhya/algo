package net.guhya.algo.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Scheduler {
	
	private List<Job> jobList 					= new ArrayList<>();
	private BlockingQueue<Job> jobQueue 		= new LinkedBlockingQueue<>();
	static List<Job> completedJobList 			= Collections.synchronizedList(new ArrayList<>());
	static List<Job> failedJobList 				= Collections.synchronizedList(new ArrayList<>());
	static List<Job> skippedJobList 			= Collections.synchronizedList(new ArrayList<>());
	
	public void addJob(Job job) {
		jobList.add(job);
	}
	
	public void printJobList() {
		for (Job job : jobList) {
			System.out.println(job.toPrettyString());
		}
	}
	
	private boolean queueJob() {
		int[] inDegree = new int[jobList.size()];
		for (int i=0; i<jobList.size(); i++) {
			inDegree[i] = jobList.get(i).getDependencies().size();
		}
		
		LinkedList<Job> q = new LinkedList<>();
		for (int i=0; i<inDegree.length; i++) {
			if (inDegree[i] == 0) q.add(jobList.get(i));
		}
		
		while (!q.isEmpty()) {
			Job j = q.removeFirst();
			jobQueue.add(j);
			for (int i=0; i<jobList.size(); i++) {
				if (jobList.get(i).getDependencies().contains(j)) {
					inDegree[i]--;
					if (inDegree[i] == 0) {
						q.add(jobList.get(i));
					}
				}
			}
		}
		
		return jobQueue.size() == jobList.size();
	}
	
	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

	public BlockingQueue<Job> getJobQueue() {
		return jobQueue;
	}
	
	public void run() throws InterruptedException, ExecutionException {
		this.printJobList();
		if (!this.queueJob()) {
			System.out.println("cyclic dependencies: true");
		} else {
			long start = System.currentTimeMillis();
			final int POOL_SIZE = this.jobQueue.size();
			ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
			while (!this.jobQueue.isEmpty()) {
				Job job = this.jobQueue.poll();
				CountDownLatch latch = new CountDownLatch(job.getDependencies().size());
				for (Job dependency : job.getDependencies()) {
					dependency.setLatch(latch);
					pool.execute(dependency);
				}
				latch.await();
				boolean ok = true;
				for (Job dependency : job.getDependencies()) {
					if (!dependency.isSuccess()) {
						ok = false;
						break;
					}
				}
				
				if (ok) {
					pool.execute(job);
					if (job.isSuccess())
						completedJobList.add(job);
					else
						failedJobList.add(job);
				} else {
					skippedJobList.add(job);
				}					
			}
			long finish = System.currentTimeMillis();
			long timeElapsed = finish - start;
			System.out.println("output:");
			System.out.println("completed jobs: " + completedJobList);
			System.out.println("failed jobs: " + failedJobList);
			System.out.println("skipped jobs: " + skippedJobList);
			System.out.println("finished in " + (timeElapsed/1000) + " seconds");
		}
	}
	

	public static void main(String[] args) {
		Job job0 = new Job(0, 5, true);
		Job job1 = new Job(1, 2, true);
		Job job2 = new Job(2, 1, false);
		Job job3 = new Job(3, 1, true);
		Job job4 = new Job(4, 1, false);
		Job job5 = new Job(5, 1, true);
		Job job6 = new Job(6, 1, true);
		Job job7 = new Job(7, 1, true);
		job2.addDependency(job1);
		job3.addDependency(job2);
		job4.addDependency(job1);
		job4.addDependency(job5);
		job4.addDependency(job6);
		job6.addDependency(job5);
		job7.addDependency(job6);
		
		Scheduler sch = new Scheduler();
		sch.addJob(job0);
		sch.addJob(job1);
		sch.addJob(job2);
		sch.addJob(job3);
		sch.addJob(job4);
		sch.addJob(job5);
		sch.addJob(job6);
		sch.addJob(job7);
		
		/*
		Job job0 = new Job(0, 1, true);
		Job job1 = new Job(1, 2, true);
		Job job2 = new Job(2, 1, false);
		Job job3 = new Job(3, 1, true);
		job2.addDependency(job0);
		job2.addDependency(job1);
		job3.addDependency(job0);
		job3.addDependency(job2);
		Scheduler sch = new Scheduler();
		sch.addJob(job0);
		sch.addJob(job1);
		sch.addJob(job2);
		sch.addJob(job3);
		*/
		
		try {
			sch.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
