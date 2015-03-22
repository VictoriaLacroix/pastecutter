import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HolderArray extends JPanel implements ActionListener{

	//butt list
	JButton[] buttons;

	//Amount of buttons on the UI.
	private static int buttCount = 10;

	public HolderArray(ActionListener parent){
		buttons = new JButton[buttCount];
<<<<<<< HEAD
		resetLayout(false);
=======
		setLayout(new GridLayout(buttCount, 1));
>>>>>>> 84cbd03c8a939f039a42b0339dc3407d5f81381a
		for(int i = 0; i < buttCount; ++i){
			buttons[i] = new JButton();
			buttons[i].addActionListener(parent);
			buttons[i].addActionListener(this);
			buttons[i].setActionCommand("");
			add(buttons[i]);
		}
		setPreferredSize(new Dimension(100,480));
	}

<<<<<<< HEAD
	public void resetLayout(boolean ishoriz){
		if(ishoriz){
			//horizontal orientation
			setLayout(new GridLayout(1,buttCount));
			setPreferredSize(new Dimension(480,100));
		}else{
			//vertical
			setLayout(new GridLayout(buttCount,1));
			setPreferredSize(new Dimension(100,480));
		}
	}

=======
>>>>>>> 84cbd03c8a939f039a42b0339dc3407d5f81381a
	/**
	 *	Inserts a string at the top of the array and cascades the rest down.
	 */
	public void insert(String s){
		for(int i = buttCount-1; i > 0; --i){
			buttons[i].setText(buttons[i-1].getText());
<<<<<<< HEAD
			buttons[i].setToolTipText(buttons[i].getText());
			buttons[i].setActionCommand(buttons[i].getText());
		}
		buttons[0].setText(s);
		buttons[0].setToolTipText(buttons[0].getText());
=======
			buttons[i].setActionCommand(buttons[i].getText());
		}
		buttons[0].setText(s);
>>>>>>> 84cbd03c8a939f039a42b0339dc3407d5f81381a
		buttons[0].setActionCommand(s);
	}

	/**
	 *	Rearranges the buttons accordingly.
	 */
	public void actionPerformed(ActionEvent e){
		Object src = e.getSource();
		int callingIndex = -1; String topText = "";
		for(int i = 0; i < buttCount; ++i){
			if(src.equals(buttons[i])){ callingIndex = i; topText = buttons[i].getText(); }
		}
		if(callingIndex <= 0) return;
		for(int j = callingIndex; j > 0; --j){
			buttons[j].setText(buttons[j-1].getText());
			buttons[j].setActionCommand(buttons[j-1].getText());
		}
		buttons[0].setText(topText);
		buttons[0].setActionCommand(topText);
	}
}
