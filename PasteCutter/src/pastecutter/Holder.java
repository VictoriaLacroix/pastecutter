package pastecutter;

import java.util.Date;

import javax.swing.JButton;

public class Holder extends JButton{
	
	public Date time;
	
	public Holder(){
		super();
		time = new Date();
	}
	
	public void setTime(Date time){
		this.time = time;
	}
	
	public Date getTime(){
		return time;
	}

}
