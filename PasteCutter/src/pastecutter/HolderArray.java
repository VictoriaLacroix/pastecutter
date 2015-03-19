package pastecutter;

import java.awt.event.*;
import javax.swing.*;

public class HolderArray extends JPanel{

	//butt list
	JButton[] buttons;
	//Current index to insert to.
	int currentIndex;

	//Amount of buttons on the UI.
	private static int buttCount = 5;

	public HolderArray(ActionListener parent){
		buttons = new JButton[buttCount];
		currentIndex = 0;
		setLayout(new GridLayout(buttCount, 1));
		for(int i = 0; i < buttCount; ++i){
			buttons[i] = new JButton();
			buttons[i] = setActionCommand("" + i);
		}
	}

	/**
	 *	:)
	 */
	public void insert(String s){
		buttons[currentIndex].setText(s);
		++currentIndex;
		currentIndex = (currentIndex >= buttCount) ? buttCount-1: currentIndex;
	}

	public String get(int i){
		if(i > 0){
			.
		}else{
			return buttons[0].getText();
		}
	}
}
