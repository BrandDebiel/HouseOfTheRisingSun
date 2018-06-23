import java.awt.*;

//Maakt basisvorm driehoek
public class ShapeTriangle implements PartDrawInterFace
{
	private int m_Left;
	private int m_Top;
	private int m_Width; 
	private int m_Height;
	
	private Color m_Color;
	
	public ShapeTriangle(Color color, int left, int top, int width, int height)
	{
		setColor(color);
		m_Left = left;
		m_Top = top;
		m_Width = width;
		m_Height = height*-1;		
			
	}
	
	public void setColor(Color color)
	{
		m_Color = color;
	}
	
	public void drawShape(Graphics graphics)
	{
		int[] m_Xpoints = {m_Left, m_Left+m_Width, m_Left+(m_Width/2)};		
		int[] m_Ypoints = {m_Top, m_Top, m_Height};
		
		graphics.setColor(m_Color);
		graphics.fillPolygon(m_Xpoints, m_Ypoints, 3);	
	}
	
}