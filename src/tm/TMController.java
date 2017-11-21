package tm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class TMController implements ActionListener {
	private TMView view;
	private ThreadMonitor tm;
	private Timer timer;
	public TMController(){
		tm = new ThreadMonitor();
		view = new TMView(this);
		timer = new Timer(5000, this);
		timer.setActionCommand("Refresh");
		timer.start();
	}
	public List<String> getGroups(){
		List<String> out = new ArrayList<>();
		ThreadGroup[] threadGroups = tm.getTree();
		for(ThreadGroup tg: threadGroups){
			out.add(tg.getName());
		}
		return out;
	}

	public List<ThreadInfo> getThreads(){
		return tm.getThreads();
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(("FilterChange".equals(actionEvent.getActionCommand())) && !view.isSelected() && view.isSelected()){
		} else{
			tm.set();
		}
		if ("Start".equals(actionEvent.getActionCommand())) {
			String in = view.getNew();
			if(!in.equals("")){
				tm.newThread(in);
			}
		} else if ("Stop".equals(actionEvent.getActionCommand())) {
			String in = view.getStop();
			if(!in.equals("")){
				tm.stopThread(in);
			}
		} else if ("Search".equals(actionEvent.getActionCommand())) {
			String in = view.getSearch();
			if(!in.equals("")){
				tm.search(in);
			}
		} else if("Refresh".equals(actionEvent.getActionCommand())){
			tm.set();
		}
		if(view.isSelected()){
			tm.filter(view.getFilter());
		}
		timer.restart();
		view.displayThreads();
		System.out.println(actionEvent.getActionCommand());
	}
}
