import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * I built a new one to test things.
 */
public class Editor extends JFrame implements ActionListener{

	JPanel		mainpanel;	
	HolderArray	holder;
	JTextArea	text;
	JMenuBar	bar;
	JMenu		editMenu;
	JMenuItem	copy, cut;
	JMenu		layoutMenu;
	JMenuItem	top, bottom, left, right;
	commandListener	cmdList;

	public Editor(){
		mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());

		copy = new JMenuItem("Copy");
		copy.setActionCommand("copy");
		copy.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.ALT_MASK));
		cut = new JMenuItem("Cut");
		cut.setActionCommand("cut");
		cut.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.ALT_MASK));
		top = new JMenuItem("Top");
		top.setActionCommand("top");
		top.setAccelerator(KeyStroke.getKeyStroke('I', KeyEvent.ALT_MASK));
		bottom = new JMenuItem("Bottom");
		bottom.setActionCommand("bottom");
		bottom.setAccelerator(KeyStroke.getKeyStroke('K', KeyEvent.ALT_MASK));
		left = new JMenuItem("Left");
		left.setActionCommand("left");
		left.setAccelerator(KeyStroke.getKeyStroke('J', KeyEvent.ALT_MASK));
		right = new JMenuItem("Right");
		right.setActionCommand("right");
		right.setAccelerator(KeyStroke.getKeyStroke('L', KeyEvent.ALT_MASK));

		cmdList = new commandListener(this);
		copy.addActionListener(cmdList);
		cut.addActionListener(cmdList);
		top.addActionListener(cmdList);
		bottom.addActionListener(cmdList);
		left.addActionListener(cmdList);
		right.addActionListener(cmdList);

		

		bar = new JMenuBar();
		layoutMenu = new JMenu("Layout");
		layoutMenu.add(top);
		layoutMenu.add(bottom);
		layoutMenu.add(left);
		layoutMenu.add(right);
		editMenu = new JMenu("Edit");
		editMenu.add(cut);
		editMenu.add(copy);
		bar.add(editMenu);
		bar.add(layoutMenu);
	
		text = new JTextArea("Text!");
		text.setPreferredSize(new Dimension(640,480));
	
		holder = new HolderArray(this);

		setLayout(new BorderLayout());

		mainpanel.add(text, BorderLayout.CENTER);
		mainpanel.add(holder, BorderLayout.WEST);

		add(bar, BorderLayout.NORTH);
		add(mainpanel, BorderLayout.CENTER);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void copy(){
		String s = text.getSelectedText();
		if(s == "" || s == null){ return; }
		holder.insert(s);
	}

	public void cut(){
		String s = text.getSelectedText();
		text.replaceSelection("");
		if(s == "" || s == null){ return; }
		holder.insert(s);
	}

	public void resetLayout(int orientation){
		remove(holder);
		switch(orientation){
			case 0: holder.resetLayout(true); mainpanel.add(holder, BorderLayout.NORTH); break; //top
			case 1: holder.resetLayout(true); mainpanel.add(holder, BorderLayout.SOUTH); break; //bottom
			case 2: holder.resetLayout(false); mainpanel.add(holder, BorderLayout.WEST); break; //left
			case 3: holder.resetLayout(false); mainpanel.add(holder, BorderLayout.EAST); break; //right
			default: break;
		}
		validate();
	}

	public static void main(String[] args){
		Editor u = new Editor();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() != ""){ text.replaceSelection(e.getActionCommand()); }
	}
	
	/**
	 * Needed a third ActionListener
	 */
	private class commandListener implements ActionListener{
		Editor ui;

		public commandListener(Editor pastecutter){
			ui = pastecutter;
		}

		public void actionPerformed(ActionEvent e){
			String cmd = e.getActionCommand();
			if(cmd == "copy"){
				ui.copy();
			}else if(cmd == "cut"){
				ui.cut();
			}else{
				if(cmd == "top"){
					ui.resetLayout(0);
				}else if(cmd == "bottom"){
					ui.resetLayout(1);
				}else if(cmd == "left"){
					ui.resetLayout(2);
				}else if(cmd == "right"){
					ui.resetLayout(3);
				}
			}
		}
	}
}
