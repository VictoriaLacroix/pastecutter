import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * I built a new one to test things.
 */
public class UI extends JFrame implements ActionListener{
	
	HolderArray	holder;
	JTextArea	text;
	JMenuBar	bar;
	JButton		copy;
	copyListener	copyList;

	public UI(){
		copy = new JButton("copy");
		copy.addActionListener(copyList);
		holder = new HolderArray(this);
		
		bar = new JMenuBar();
		bar.add(copy);
	
		text = new JTextArea("Text!");
		text.setPreferredWidth(640);
		text.setPreferredHeight(480);
	
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
		UI u = new UI();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() != ""){ text.replaceSelection(e.getActionCommand()); }
	}
	
	/**
	 * Needed a third ActionListener
	 */
	private class copyListener implements ActionListener{
		UI ui;

		public copyListener(UI pastecutter){
			ui = pastecutter;
		}

		public void actionPerformed(ActionEvent e){
			ui.copy();
		}
	}
}
