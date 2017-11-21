package tm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadMonitor {
	private ThreadGroup root;
	private ThreadGroup[] tree;
	private Map<Long, String> idName;
	private List<Thread> threads;
	private Map<Long, Thread> idThread;
	private List<ThreadInfo> threadInfos;

	public ThreadMonitor(){
		set();
		System.out.println(threadInfos);
	}
	public void set(){
		getRoot();
		generateTree();
		getThreadInfo();
	}
	public List<ThreadInfo> getThreads() {
		return threadInfos;
	}

	private void getRoot(){
		Thread t = Thread.currentThread();
		ThreadGroup tg = t.getThreadGroup();
		boolean flag = false;
		while(!flag){
			ThreadGroup test = tg.getParent();
			if (test == null){
				flag = true;
			} else {
				tg = tg.getParent();
			}

		}
		root = tg;
	}

	private void generateTree(){
		int n = root.activeGroupCount();

		ThreadGroup[] tempTree = new ThreadGroup[n+1];
		root.enumerate(tempTree);
		tree = new ThreadGroup[n+1];
		tree[0] = root;
		int i = 1;
		for(ThreadGroup t: tempTree){
			if(t != null) {
				tree[i] = t;
				i++;
			}
		}
	}

	private void getThreadInfo(){

		int n = tree[0].activeCount();
		Thread[] tList = new Thread[n];
		tree[0].enumerate(tList);
		List<String> nameList = new ArrayList<>();
		idName = new HashMap<>();
		idThread = new HashMap<>();
		threads = new ArrayList<>();
		threadInfos = new ArrayList<>();
		for(Thread t: tList){
			if (t != null) {
				threads.add(t);
				String name = t.getName();
				nameList.add(name);
				String tgName = t.getThreadGroup().getName();
				long id = t.getId();
				idName.put(id, name);
				idThread.put(id, t);
				Thread.State state = t.getState();
				int priority = t.getPriority();
				boolean isDaemon = t.isDaemon();
				threadInfos.add(new ThreadInfo(tgName, name, id, state, priority, isDaemon));
			}
		}

	}

	public void search(String in){
		List<ThreadInfo> out = new ArrayList<>();
		for(ThreadInfo ti: threadInfos){
			if(ti.getName().equals(in)){
				out.add(ti);
			}
		}
		threadInfos = out;
	}

	public void filter(String in){
		List<ThreadInfo> out = new ArrayList<>();
		for(ThreadInfo ti : threadInfos){

			if(ti.getTgName().equals(in)){
				out.add(ti);
			}
		}
		threadInfos = out;
	}

	public void newThread(String in){
			Thread t = new Thread(new TestWorker(), in);
			t.start();
			getThreadInfo();
	}

	public boolean stopThread(String in){
		List<Long> ids = new ArrayList<>();
		for (ThreadInfo ti : threadInfos){
			if(ti.getName().equals(in)){
				ids.add(ti.getId());
			}
		}
		if(!ids.isEmpty()) {
			for (Thread t : threads) {
				for (Long id: ids){
					if (t.getId() == id){
						t.interrupt(); 				// this may need to be changed
					}
				}
			}
			return true;
		} else{
			return false;
		}
	}
	public ThreadGroup[] getTree(){
		return tree;
	}
}
