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
			System.out.println(job);
		}
	}
	
	public static void main(String[] args) {
		Job job0 = new Job(0, 1, true);
		Job job1 = new Job(1, 2, true);
		Job job2 = new Job(2, 1, false);
		Job job3 = new Job(3, 1, true);
		
		Scheduler sch = new Scheduler();
		sch.addJob(job0);
		sch.addJob(job1);
		sch.addJob(job2);
		sch.addJob(job3);
		
		sch.printJobList();
	}
}
