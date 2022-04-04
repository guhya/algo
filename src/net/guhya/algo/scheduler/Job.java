package net.guhya.algo.scheduler;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Job implements Runnable {
	
	private int id;
	private int duration;
	private boolean success;
	private Set<Job> dependencies;
	private CountDownLatch latch;
	
	public Job(int id, int duration, boolean success) {
		this.id = id;
		this.duration = duration;
		this.success = success;
		this.dependencies = new HashSet<Job>();
	}
	
	public Job(int id, int duration, boolean success, Set<Job> dependencies) {
		this.id = id;
		this.duration = duration;
		this.success = success;
		this.dependencies = dependencies;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Set<Job> getDependencies() {
		return dependencies;
	}
	public void setDependencies(Set<Job> dependencies) {
		this.dependencies = dependencies;
	}
	public void addDependency(Job job) {
		this.dependencies.add(job);
	}
	
	public String toString() {
		return String.valueOf(id);
	}

	public String toPrettyString() {
		String dep = "";
		for (Job job : dependencies) {
			dep += job.id + " ";
		}
		return id+"\t| "+duration+" \t| "+success+"\t\t| [ "+dep+"]";
	}
	
	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (latch != null) this.latch.countDown();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
