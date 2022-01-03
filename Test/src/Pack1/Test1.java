package Pack1;

import java.applet.*;
import java.awt.*;

/*
public class Test1 extends Applet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub



	}

}
*/
public class Test1 extends Applet
{
	
	String s1, s2, s3;
	
	public void init()
	{
		if((s1 == getParameter("arg1"))) s1 = "Nu am gasit arg1 in html";
		
	}
	public void paint(Graphics g)
	{
		g.drawString("s1 = " + s1, 20, 20);
	}
}