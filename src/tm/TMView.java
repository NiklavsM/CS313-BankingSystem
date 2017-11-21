package tm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TMView extends JFrame {
	private JButton searchButton;
	private JTextField textSearch;
	private JButton stopButton;
	private JButton startButton;
	private JPanel mainPanel;
	private JTextArea threadDisplay;
	private JTextField textNew;
	private JTable table;
	private JTextField textStop;
	private JCheckBox filterCheck;
	private JComboBox comboFilter;
	private JButton refreshButton;
	private TMController controller;
	private List<String> groups;
	public TMView(TMController controller) {
		super("Thread Monitor");
		this.controller = controller;
		setContentPane(mainPanel);
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		groups = new ArrayList<>();
		filterCheck.setSelected(false);
		startButton.setActionCommand("Start");
		searchButton.setActionCommand("Search");
		stopButton.setActionCommand("Stop");
		filterCheck.setActionCommand("Filter");
		refreshButton.setActionCommand("Refresh");
		comboFilter.setActionCommand("FilterChange");

		startButton.setEnabled(true);
		searchButton.setEnabled(true);
		stopButton.setEnabled(true);
		filterCheck.setEnabled(true);
		refreshButton.setEnabled(true);
		comboFilter.setEnabled(true);
		System.out.println("Setting listener");

		startButton.addActionListener(this.controller);
		searchButton.addActionListener(this.controller);
		stopButton.addActionListener(this.controller);
		filterCheck.addActionListener(this.controller);
		refreshButton.addActionListener(this.controller);


		displayThreads();
		comboFilter.addActionListener(this.controller);
		this.setVisible(true);
	}

	public void displayThreads() {
		ThreadTableModel ttm = new ThreadTableModel(controller.getThreads());
		table.setModel(ttm);
		List<String> groupNames = controller.getGroups();


		for(String s: groupNames){
			if(!groups.contains(s)) {
				comboFilter.addItem(s);
				groups.add(s);
			}
		}
		for(String s: groups){
			if(!groupNames.contains(s)){
				comboFilter.removeItem(s);
			}
		}
	}
	public boolean isSelected(){
		return filterCheck.isSelected();
	}
	public String getNew(){
		return textNew.getText();
	}
	public String getStop(){
		return textStop.getText();
	}
	public String getSearch(){
		return textSearch.getText();
	}
	public String getFilter(){
		return (String)comboFilter.getSelectedItem();
	}

}


