package com.base.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window
{
	public static void createWindow(int width, int height, String title)
	{
		Display.setTitle(title);
		try
		{
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();

		} catch (LWJGLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
