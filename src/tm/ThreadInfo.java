package tm;

public class ThreadInfo {

	private String tgName;
	private String name;
	private long id;
	private Thread.State state;
	private int priority;
	private boolean isDaemon;



	public ThreadInfo(String tgName, String name, long id, Thread.State state, int priority, boolean isDaemon) {
		this.tgName = tgName;
		this.name = name;
		this.id = id;
		this.state = state;
		this.priority = priority;
		this.isDaemon = isDaemon;
	}

	public String toString() {
		return tgName + " " + name + " " + id + " " + state + " " + priority + " " + isDaemon;
	}

	public String getTgName() {
		return tgName;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public Thread.State getState() {
		return this.state;
	}

	public int getPriority() {
		return this.priority;
	}

	public boolean isDaemon() {
		return isDaemon;
	}

}
