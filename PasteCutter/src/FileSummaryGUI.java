package question1;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;

/**
 * A class that provides a GUI to give the user a summary of a text file's contents. It's output can also be saved to a
 * text file. The output is not cleared upon opening a new file, allowing the user to save a sort of multi-summary.
 * 
 * @author Pat Lacroix #0296738
 */
@SuppressWarnings("serial")
public class FileSummaryGUI extends JFrame implements ActionListener{
	// class fields initialized early to save space
	JPanel panel = new JPanel();
	JTextArea textOutput = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textOutput);
	JMenuBar topBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem fileOpen = new JMenuItem("Open");
	JMenuItem fileSave = new JMenuItem("Save");
	JMenuItem fileClear = new JMenuItem("Clear Output");
	JMenuItem fileExit = new JMenuItem("Exit");
	JFileChooser fileInterface = new JFileChooser();
	FileFilter txtFilter = new FileNameExtensionFilter("Text File", "txt");
	
	/**
	 * Arranges all the elements in the GUI.
	 */
	public FileSummaryGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "File Summary"));
		fileInterface.setFileFilter(txtFilter);
		fileOpen.addActionListener(this);
		fileOpen.setActionCommand("open");
		fileOpen.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
		fileSave.addActionListener(this);
		fileSave.setActionCommand("save");
		fileSave.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
		fileClear.addActionListener(this);
		fileClear.setActionCommand("clear");
		fileClear.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK));
		fileExit.addActionListener(this);
		fileExit.setActionCommand("exit");
		fileExit.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK));
		fileMenu.add(fileOpen);
		fileMenu.add(fileSave);
		fileMenu.add(fileClear);
		fileMenu.add(fileExit);
		topBar.add(fileMenu);
		textOutput.setEditable(false);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		panel.add(scrollPane, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
		add(topBar, BorderLayout.NORTH);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Creates an anonymous FileSummaryGUI.
	 * 
	 * @param args
	 *            console args
	 */
	public static void main(String[] args){
		new FileSummaryGUI();
	}
	
	/**
	 * Processes stats from the input list and outputs it into the particular JTextArea provided
	 * 
	 * @param list
	 *            Strings to process
	 * @param output
	 *            Output
	 */
	public void processStringListStats(String path, ArrayList<String> list, JTextArea output){
		output.setText(output.getText() + "Summary of: " + path + "\n\n");
		output.setText(output.getText() + "Total number of lines: " + list.size() + "\n");
		int totalChars = 0;
		int totalWords = 0;
		int[] lineChars = new int[list.size()];
		int[] lineWords = new int[list.size()];
		for(int i = 0; i < list.size(); i++){
			lineChars[i] = list.get(i).length();
			totalChars += lineChars[i];
			StringTokenizer st = new StringTokenizer(list.get(i));
			lineWords[i] = st.countTokens();
			totalWords += lineWords[i];
		}
		output.setText(output.getText() + "Total number of words: " + totalWords + "\n");
		output.setText(output.getText() + "Total number of characters: " + totalChars + "\n\n");
		for(int i = 0; i < list.size(); i++){
			output.setText(output.getText() + "Line " + i + "-> Characters: " + lineChars[i] + "; Words: "
					+ lineWords[i] + "\n");
		}
		output.setText(output.getText() + "\n");
		pack();
		pack();
	}
	
	/**
	 * actionPerformed method that is fired each time a button from the menu is pressed.
	 * 
	 * @param event
	 *            ActionEvent containing an ActionCommand string that differentiates the buttons (as opposed to using 4
	 *            separate classes).
	 */
	public void actionPerformed(ActionEvent event){
		if(event.getActionCommand().equals("open")){
			// opens a file and processes it through the processStringListStats() method.
			int returnValue = fileInterface.showOpenDialog(null);
			while(returnValue != JFileChooser.APPROVE_OPTION){
				returnValue = fileInterface.showOpenDialog(null);
			}
			try{
				Scanner fileIn = new Scanner(fileInterface.getSelectedFile());
				/*
				 * We use an ArrayList here because our file can have a variable length.
				 */
				ArrayList<String> textList = new ArrayList<String>();
				while(fileIn.hasNext()){
					textList.add(fileIn.nextLine());
				}
				processStringListStats(fileInterface.getSelectedFile().getAbsolutePath(), textList, textOutput);
				fileIn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(event.getActionCommand().equals("save")){
			// saves the text in textOutput to a file specified by the user
			int returnValue = fileInterface.showSaveDialog(null);
			while(returnValue != JFileChooser.APPROVE_OPTION){
				returnValue = fileInterface.showSaveDialog(null);
			}
			try{
				PrintWriter writer = new PrintWriter(fileInterface.getSelectedFile());
				writer.print(textOutput.getText());
				writer.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}else if(event.getActionCommand().equals("clear")){
			// clears output
			textOutput.setText("");
		}else if(event.getActionCommand().equals("exit")){
			// exits
			System.exit(0);
		}else{
			// just in case
			System.out.println("Error with menu buttons.");
		}
	}
}
