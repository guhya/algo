package net.guhya.algo.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Job {
	
	private int id;
	private int duration;
	private boolean success;
	private List<Job> dependencies;
	
	public Job(int id, int duration, boolean success) {
		this.id = id;
		this.duration = duration;
		this.success = success;
		this.dependencies = new ArrayList<Job>();
	}
	
	public Job(int id, int duration, boolean success, List<Job> dependencies) {
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
	public List<Job> getDependencies() {
		return dependencies;
	}
	public void setDependencies(List<Job> dependencies) {
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

}
