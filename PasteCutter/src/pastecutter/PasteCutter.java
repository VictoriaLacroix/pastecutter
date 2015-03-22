package pastecutter;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PasteCutter extends JFrame implements ActionListener{
	
	//element declaration
	private JTextArea textMain;
<<<<<<< HEAD
	private Holder[] holder;
=======
	private HolderArray holder;
>>>>>>> 84cbd03c8a939f039a42b0339dc3407d5f81381a
	private JMenuItem copy, paste;
	private JScrollPane scroller;
	private JRadioButtonMenuItem north, south, east, west, hidden;
	private ButtonGroup location;
	private JPanel top, bottom, left, right, main;
	private JMenuBar menuBar;
	private JMenu menu;

	Container cp = getContentPane();
	
	public PasteCutter(){
		setTitle("PasteCutter");
		
		/*
		 * element initialization
		 */
		textMain = new JTextArea();
		textMain.setLineWrap(true);
		textMain.setWrapStyleWord(true);
		textMain.setText("Hello World!");
		
		//menu buttons
		north = new JRadioButtonMenuItem("Top");
		east = new JRadioButtonMenuItem("Right");
		south = new JRadioButtonMenuItem("Bottom");
		west = new JRadioButtonMenuItem("Left");
		hidden = new JRadioButtonMenuItem("Hidden");
		hidden.setSelected(true);
		
		//PASTECUTTER boxes
		holder = new Holder[5];
		for(int i = 0; i < holder.length; ++i)
			holder[i] = new Holder();
		
		//button group
		location = new ButtonGroup();	
		location.add(north);
		location.add(east);
		location.add(south);
		location.add(west);
		location.add(hidden);
		
		//menu items
		menuBar = new JMenuBar();
		menu = new JMenu("View");
		menuBar.add(menu);
		menu.add(north);
		menu.add(east);
		menu.add(south);
		menu.add(west);
		menu.add(hidden);
		//copypasta
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		copy.addActionListener(this);
		paste.addActionListener(this);
		copy.setActionCommand("copy");
		paste.setActionCommand("paste");
		menuBar.add(copy);
		menuBar.add(paste);
		
		
		/*
		 * panel initialization
		 */
		//holding panes
		// deprecated, basically.
		top = new JPanel();
		top.setLayout(new GridLayout(1,5));
		top.setPreferredSize((new Dimension(100, 100)));
		bottom = new JPanel(); 
		bottom.setLayout(new GridLayout(1,5));
		bottom.setPreferredSize((new Dimension(100, 100)));
		left = new JPanel();
		left.setLayout(new GridLayout(5,1));
		left.setPreferredSize((new Dimension(100, 100)));
		right = new JPanel();
		right.setLayout(new GridLayout(5,1));
		right.setPreferredSize((new Dimension(100, 100)));

		//main text
		scroller = new JScrollPane(textMain);
		main = new JPanel();
		main.setLayout(new BorderLayout());		
		main.add(scroller, BorderLayout.CENTER);
		
		//content pane
		cp.setLayout(new BorderLayout());
		cp.add(menuBar, BorderLayout.NORTH);
		cp.add(main, BorderLayout.CENTER);

		/*
			Commenting for now
		//menu radio button names
		north.setActionCommand("north");
		south.setActionCommand("south");
		east.setActionCommand("east");
		west.setActionCommand("west");
		hidden.setActionCommand("hidden");
		
		//menu radio button listeners
		north.addActionListener(this);
		south.addActionListener(this);
		east.addActionListener(this);
		west.addActionListener(this);
		hidden.addActionListener(this);
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * menu action listeners
		 *
		if(e.getActionCommand() == "north"){
			main.remove(bottom);
			main.remove(left);
			main.remove(right);
			main.add(top, BorderLayout.NORTH);
			for(int i = 0; i < holder.length; ++i)
				top.add(holder[i]);				
			cp.validate();
		}
		else if(e.getActionCommand() == "south"){
			main.add(bottom, BorderLayout.SOUTH);
			main.remove(left);
			main.remove(right);
			main.remove(top);
			for(int i = 0; i < holder.length; ++i)
				bottom.add(holder[i]);		
			cp.validate();
		}
		else if(e.getActionCommand() == "east"){
			main.remove(bottom);
			main.remove(left);
			main.add(right, BorderLayout.EAST);
			main.remove(top);
			for(int i = 0; i < holder.length; ++i)
				right.add(holder[i]);		
			cp.validate();
		}
		else if(e.getActionCommand() == "west"){
			main.remove(bottom);
			main.add(left, BorderLayout.WEST);
			main.remove(right);
			main.remove(top);
			for(int i = 0; i < holder.length; ++i)
				left.add(holder[i]);		
			cp.validate();
		}
		else if(e.getActionCommand() == "hidden"){
			main.remove(bottom);
			main.remove(left);
			main.remove(right);
			main.remove(top);
			cp.validate();
		}
		//
		else if(e.getActionCommand() == "copy"){
			
		}
<<<<<<< HEAD
=======
		*/
>>>>>>> 84cbd03c8a939f039a42b0339dc3407d5f81381a
	}

	public static void main(String[] args) {
		PasteCutter frame = new PasteCutter();
		frame.setSize(1024,576); //16:9
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
}
