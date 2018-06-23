import java.awt.*;

//Maak basisvorm rechthoek
public class ShapeRectangle implements PartDrawInterFace
{

	private int m_Left;
	private int m_Top;
	private int m_Width; 
	private int m_Height;
	
	private Color m_Color;	

	public ShapeRectangle(Color color, int left, int top, int width, int height)
	{
		setColor(color);
		m_Left = left;
		m_Top = top;
		m_Width = width;
		m_Height = height;
		
	}
	
	public void setColor(Color color)
	{
		m_Color = color;
	}
	
	public void drawShape(Graphics graphics)
	{
		graphics.setColor(m_Color);
		graphics.fillRect(m_Left, m_Top, m_Width, m_Height);		
	}
	
}
