package tm;

public class DummyGroups {
	public DummyGroups() {
		ThreadGroup a = new ThreadGroup("Group-A");
		ThreadGroup b = new ThreadGroup("Group-B");
		ThreadGroup c = new ThreadGroup("Group-C");
		ThreadGroup cSub = new ThreadGroup(c, "Group-C-Sub");
		(new Thread(a, new TestWorker(), "a1")).start();
		(new Thread(a, new TestWorker(), "a2")).start();
		(new Thread(b, new TestWorker(), "b1")).start();
		(new Thread(b, new TestWorker(),"b2")).start();
		(new Thread(c, new TestWorker(), "c1")).start();
		(new Thread(c, new TestWorker(), "c2")).start();
		(new Thread(cSub, new TestWorker(),"cSub1")).start();
		(new Thread(cSub, new TestWorker(), "cSub2")).start();
	}

	public static void main(String arg[]) {
		new DummyGroups();
	}

}
