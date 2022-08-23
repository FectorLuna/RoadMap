package RoadMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders;

public class TaskObjectGUI {

	private ClassifiedTaskGUI[] roadmaps;
	private String[] titles = {"Front End", "Backend", "Unknown", "Unknown"};
	
	
	private static final Color margins = new Color(79, 169, 94);
	private static final Color background = new Color(122, 255, 144);
	
	public TaskObjectGUI(int width, int height, int rows) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createWindow(width, height, rows);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public TaskObjectGUI(String[] loadedRoadmaps) {
		
	}
	
	public JFrame createWindow(int width, int height, int nbrOfRows) {
		
		JFrame f = new JFrame("RoadMap of Programming");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container pane = f.getContentPane();
		
		//*************************************************************************************//

		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		
		
		Font headline = new Font("SansSerif", Font.BOLD, 20);
		topPanel.add(Box.createRigidArea(new Dimension(57,30)));
		
		for(int j = 0; j < titles.length; j++) {
			JTextField t = new JTextField(titles[j]);
			t.setEditable(false);
			t.setFont(headline);
			t.setHorizontalAlignment(JTextField.CENTER);
			t.setBackground(ClassifiedTaskGUI.getColorScheme()[j][0]);
			t.setBorder(BorderFactory.createLineBorder(margins));
			topPanel.add(t);
		}
		pane.add(topPanel, BorderLayout.NORTH);
		
		//*************************************************************************************//
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		for(int i = 1; i <= nbrOfRows; i++) {
			JTextField t = new JTextField("Prio " + String.valueOf(i));
			t.setEditable(false);
			t.setFont(headline);
			t.setAlignmentX(JTextField.CENTER);
			t.setBorder(BorderFactory.createLineBorder(margins));
			t.setBackground(background);
			leftPanel.add(t);	
		}
		pane.add(leftPanel, BorderLayout.WEST);
		
		//*************************************************************************************//

		
		JPanel midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(nbrOfRows-1, 5, 4, 2));
		
		
		pane.add(midPanel, BorderLayout.CENTER);
		
		
		
		
		//*************************************************************************************//
		
		JPanel menuPanel = new JPanel();
		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.X_AXIS));
		
		JButton addTask = new JButton("Add Task");
		JButton editTask = new JButton("Edit Task");
		JButton removeTask = new JButton("Remove Task");
		
		addTask.addActionListener(e -> addTask());
		editTask.addActionListener(e -> editTask());
		removeTask.addActionListener(e -> removeTask());
		
		menuPanel.add(addTask);
		menuPanel.add(editTask);
		menuPanel.add(removeTask);
		
		pane.add(menuPanel, BorderLayout.SOUTH);
		
		//*************************************************************************************//
		
		f.setSize(width, height);
		f.setVisible(true);
		return f;
	}
	

	
	
	
	
	
	
	
	public ClassifiedTaskGUI[] convertToTasks(String[] loaded) {
		return null;
	}

	private void addTask() {
		JFrame newFrame = new JFrame("Add Task");
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container pane = newFrame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		JTextField taskNameHeadline = new JTextField();
		taskNameHeadline.setEditable(false);
		taskNameHeadline.setText("Name of task:");
		taskNameHeadline.setHorizontalAlignment(JTextField.CENTER);
		taskNameHeadline.setSize(new Dimension(500,1000));
		
		JTextField taskName = new JTextField();
		
		
		JTextField descHeadline = new JTextField();
		JTextArea desc = new JTextArea();
		JComboBox<String> type = new JComboBox<String>(titles);
		
		pane.add(taskNameHeadline);
		pane.add(taskName);
		pane.add(descHeadline);
		pane.add(desc);
		pane.add(type);
		
		newFrame.pack();
		//newFrame.setSize(200, 200);
		newFrame.setVisible(true);
		
		
		
	}
	
	private void removeTask() {
		
	}
	
	private void editTask() {
		
	}
	
	
	public static void main(String[] args) {
		String title = "HTML and CSS-basics";
		String desc = "Getting comfortable with base-level CSS and HTML. Also good requierment to be comfortable with >Visual Studio Code";
		
		Color[] col = {new Color(255, 134, 66), new Color(196, 54, 44)};
		//new ClassifiedTaskGUI(300, 300, title, desc, 3, 0);
		new TaskObjectGUI(1200,900, 3);
		
		
		

	}
}
