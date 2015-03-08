import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * I built a new one to test things.
 */
public class Editor extends JFrame implements ActionListener{
	
	HolderArray	holder;
	JTextArea	text;
	JMenuBar	bar;
	JButton		copy;
	copyListener	copyList;

	public Editor(){
		copy = new JButton("copy");
		copyList = new copyListener(this);
		copy.addActionListener(copyList);
		
		bar = new JMenuBar();
		bar.add(copy);
	
		text = new JTextArea("Text!");
		text.setPreferredSize(new Dimension(640,480));
	
		holder = new HolderArray(this);
		
		setLayout(new BorderLayout());

		add(text, BorderLayout.CENTER);
		add(holder, BorderLayout.WEST);
		add(bar, BorderLayout.NORTH);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void copy(){
		String s = text.getSelectedText();
		if(s == "" || s == null){ return; }
		holder.insert(s);
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
	private class copyListener implements ActionListener{
		Editor ui;

		public copyListener(Editor pastecutter){
			ui = pastecutter;
		}

		public void actionPerformed(ActionEvent e){
			
			ui.copy();
		}
	}
}
