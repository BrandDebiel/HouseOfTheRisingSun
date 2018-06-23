import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener 
{
	
	private int m_PanelWidth;
	private int m_PanelHeight;
	
	private House m_House;
	private Timer m_Timer;
	private int m_Rsun;
	private int m_Gsun;
	private int m_Bsun;
	private int m_Rback;
	private int m_Gback;
	private int m_Bback;	
	private Boolean m_IsSunrising;
	private Boolean m_SynchSun;
	
	private Sun m_Sun;
	private int m_XPositionSun;
	private int m_YPositionSun;
	private int m_DiameterSun;
	private double m_APositionSun;
	private double m_BPositionSun;
	
	//Constructor met de declaraties voor de onderdelen huis en zon
	public AnimationPanel(int width, int height)
	{
		m_PanelWidth = width;
		m_PanelHeight = height;
		
		m_DiameterSun = m_PanelWidth / 16;
		m_XPositionSun = -400;
		m_YPositionSun = 0;
		m_APositionSun = 400;
		m_BPositionSun = 200;
		
		m_House = new House(m_PanelWidth/4, m_PanelHeight/4, m_PanelWidth/4, m_PanelHeight/4);
		m_Sun = new Sun(Color.yellow, m_XPositionSun, m_YPositionSun, m_DiameterSun);
		m_Timer = new Timer(10, (ActionListener) this);
		
		m_IsSunrising = true;
		m_SynchSun = true;
		
		m_Rsun = 255;
		m_Gsun = 0;
		m_Bsun = 0;
		
		m_Rback = 255;
		m_Gback = 150;
		m_Bback = 0;		

		m_Timer.start();
		
	}

	//Zorg dat onderdelen getekend worden
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		m_Sun.drawShape(graphics);
		m_House.drawShape(graphics);
		
	}
	
	//Start animmatie
	public void actionPerformed(ActionEvent e)
	{
		if(m_IsSunrising && m_SynchSun)
		{
			if(m_Gsun > 2)
				m_Gsun-=3;
			if(m_Bback > 1)
				m_Bback-=2;	
			if(m_Rback < 254)
				m_Rback+=2;			
		}
		if(!m_IsSunrising)
		{
			if(m_Gsun < 253)
				m_Gsun+=3;
			if(m_Bback < 254)
				m_Bback+=2;
			if(m_Rback > 1)
				m_Rback-=2;
		}
				
		//Zorg dat de zon een boog beweging maakt
		m_YPositionSun = (int) ((double)(m_BPositionSun/m_APositionSun) * Math.sqrt((m_APositionSun*m_APositionSun) - ((m_XPositionSun)*(m_XPositionSun))))+600;
		m_XPositionSun++;
				
		//Set nieuwe positie
		m_Sun.setPosition(350-m_XPositionSun, m_PanelHeight-m_YPositionSun);
		
		if(m_XPositionSun > 400)
		{
			m_XPositionSun = -400;
			m_SynchSun = true;
		}
		if(m_XPositionSun < -200 || m_XPositionSun > 200)
		{
			m_House.setWindowColor(Color.yellow);
			m_IsSunrising = true;
		}
		else
		{
			m_House.setWindowColor(Color.black);
			m_IsSunrising = false;
		}

		//Set nieuwe kleur en teken de onderdelen
		m_Sun.setColor(new Color(m_Rsun,m_Gsun,m_Bsun));
		this.setBackground(new Color(m_Rback, m_Gback, m_Bback));
		this.repaint();		

	}
}
