import java.awt.*;

//Maakt basisvorm cirkel (zon)
public class Sun implements PartDrawInterFace
{

	private int m_Left;
	private int m_Top;
	private int m_Diameter; 

	
	private Color m_Color;
	
	public Sun(Color color, int left, int top, int diameter)
	{
		setColor(color);
		m_Left = left;
		m_Top = top;
		m_Diameter = diameter;
		
	}
	
	public void setColor(Color color)
	{
		m_Color = color;
		
	}
	
	public void drawShape(Graphics graphics)
	{
		graphics.setColor(m_Color);
		graphics.fillOval(m_Left, m_Top, m_Diameter, m_Diameter);
	}
	
	public void setPosition(int left, int top)
	{
		m_Left = left;
		m_Top = top;
	}
	
}