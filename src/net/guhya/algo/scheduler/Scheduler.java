package net.guhya.algo.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	
	private List<Job> jobList = new ArrayList<>();
	
	public void addJob(Job job) {
		jobList.add(job);
	}
	
	public void printJobList() {
		for (Job job : jobList) {
			System.out.println(job.toPrettyString());
		}
	}
	
	private boolean isCyclicUtil() {
		return false;
	}
	
	private boolean isCyclic() {
		List<List<Job>> depGraph = new ArrayList<>();
		for (Job job : jobList) {
			depGraph.add(job.getDependencies());
		}
		
		return false;
	}
	
	public static void main(String[] args) {
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
		
		sch.printJobList();
		sch.isCyclic();
	}
}
