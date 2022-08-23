package RoadMap;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.text.JTextComponent;

public class TaskGUI extends TaskObject {

	protected int width;
	protected int height;
	protected JPanel panel;
	
	public TaskGUI(int width, int height, String title, String desc, Color[] c) {
		super(title, desc);
		this.width = width;
		this.height = height;
		
		panel = createWindow(width, height, c);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	private JPanel createWindow(int width, int height, Color[] colors) {
		
		JPanel p = new JPanel(new BorderLayout());
		JTextField textTitle = new JTextField(title);
		JTextArea textDesc = new JTextArea(desc);
		textTitle.setHorizontalAlignment(JTextField.CENTER);
		
		colorComponent(textTitle, colors);
		colorComponent(textDesc, colors);
		
		textTitle.setSize(100, 100);
		textTitle.setEditable(false);
		textDesc.setSize(200, 100);
		textDesc.setLineWrap(true);
		textDesc.setWrapStyleWord(true);
		textDesc.setEditable(false);
		
		JPanel p2 = new JPanel(new BorderLayout());
		JProgressBar progBar = new JProgressBar();
		progBar.setModel(new DefaultBoundedRangeModel(percentage, 0, 0, 100));
		progBar.setBorderPainted(true);
		progBar.setString("Progress: "+percentage+" %");
		progBar.setStringPainted(true);
		colorComponent(progBar, colors);
		p2.add(progBar, BorderLayout.WEST);
		
		
		ImageIcon incButtIcon = createImageIcon("play-button-new.png");
		ImageIcon decButtIcon = createImageIcon("play-button-reverse-new.png");
		
		JButton incButt = new JButton(incButtIcon);
		JButton decButt = new JButton(decButtIcon);
		
		incButt.addActionListener(e -> buttonPressed('+', progBar));
		decButt.addActionListener(e -> buttonPressed('-', progBar));
		colorComponent(incButt, colors);
		colorComponent(decButt, colors);
		
		p2.add(incButt, BorderLayout.EAST);
		p2.add(decButt, BorderLayout.CENTER);
		
		p.add(textTitle, BorderLayout.NORTH);
		p.add(textDesc, BorderLayout.CENTER);
		p.add(p2, BorderLayout.SOUTH);
		
		p.setBackground(new Color(0, 0, 0));
		
		p.setVisible(true);
		colorComponent(p, colors);
		
		return p;

	}
	
	protected static ImageIcon createImageIcon(String path) {
	    java.net.URL imgURL = TaskGUI.class.getResource(path);
	    return new ImageIcon(imgURL);
	}
	
	protected void buttonPressed(char c, JProgressBar prog) {
		if(c == '+') {
			if(getPercentage() < 100) {
				updatePercentage(10);
			}
		} else if (c == '-'){
			if(getPercentage() > 0) {
				updatePercentage(-10);
			}
		}
		prog.setValue(percentage);
		prog.setString("Progress: "+percentage+" %");
		
	}
	protected void colorComponent(JComponent c, Color[] colors) {
		if(c instanceof JTextComponent) {
			c.setBackground(colors[0]);
			c.setBorder(BorderFactory.createLineBorder(colors[1]));
		} else {
			c.setBackground(colors[0]);
			c.setForeground(colors[1]);		
			
		}
	}

}