/*
 * Developer: Dennis van der Vlugt
 * Studentnumber: 418679
 * 
 * HogeSchool InHolland
 * 
 * Java 2
 * 
 * "HouseOfTheRisingSunMainFrame" 
 * 
 */

import javax.swing.JFrame;

/*
 * Class: HouseOfTheRisingSunMainFrame
 * 
 * Creates main application frame 
 * 
 */

public class HouseOfTheRisingSunMainFrame extends JFrame 
{
	
	private AnimationPanel m_AnimationPanel;	//Maak hoofdpaneel
	
	public HouseOfTheRisingSunMainFrame()
	{
		m_AnimationPanel = new AnimationPanel(1000,800);
		setContentPane(m_AnimationPanel);		//set het animatieframe
	}
	
	public static void main(String args[])
	{
		//Creeer window
		JFrame mainFrame = new HouseOfTheRisingSunMainFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("House of the Rising Sun");
		mainFrame.setSize(800,600);
		mainFrame.setVisible(true);
	}	

}