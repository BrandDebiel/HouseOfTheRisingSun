import java.awt.*;
import java.util.ArrayList;


public class House 
{
	
	private int m_Left;
	private int m_Top;
	private int m_Width; 
	private int m_Height;
	
	private ArrayList<PartDrawInterFace> partList;
	
	public House(int left, int top, int width, int height)
	{
		partList = new ArrayList<PartDrawInterFace>();		
		
		m_Left = left;
		m_Top = top;
		m_Width = width;
		m_Height = height;
		
		partList.add(new ShapeRectangle(Color.blue, m_Left, m_Top + (m_Height/2), m_Width, m_Height/2));
		partList.add(new ShapeTriangle(Color.red, m_Left, m_Top + (m_Height/2), m_Width, m_Height - 2* m_Top));
		partList.add(new ShapeRectangle(Color.black, m_Left+(m_Width/8), m_Top + (m_Height/2 + m_Height/4), m_Width/8, m_Height/4));
		partList.add(new ShapeRectangle(Color.black, m_Left+(m_Width/2), m_Top + (m_Height/2 + m_Height/4), m_Width/3, m_Height/5));
		partList.add(new ShapeRectangle(Color.black, m_Left+(m_Width/2), m_Top + (m_Height/2), m_Width/3, m_Height/5));
		partList.add(new ShapeRectangle(Color.black, m_Left+(m_Width/8), m_Top + (m_Height/2), m_Width/3, m_Height/5));
		
	}
	
	public void drawShape(Graphics graphics)
	{
		for(PartDrawInterFace parts : partList)
		{
			parts.drawShape(graphics);
		}
	}
	
	public void setWindowColor(Color color)
	{
		for(int i = 2; i < partList.size(); i++)
		{
			partList.get(i).setColor(color);
		}		
	}

}
