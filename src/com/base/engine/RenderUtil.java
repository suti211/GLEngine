package com.base.engine;

import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_CW;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_VERSION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glCullFace;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glFrontFace;
import static org.lwjgl.opengl.GL11.glGetString;
import static org.lwjgl.opengl.GL30.GL_FRAMEBUFFER_SRGB;

public class RenderUtil
{
	// Clears screen and depth buffer
	public static void clearScreen()
	{
		// TODO: Stencil Buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}

	// initializes openGL
	public static void initGraphics()
	{
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // blackens everything

		glFrontFace(GL_CW);
		glCullFace(GL_BACK); // back face wont be rendered
		glEnable(GL_CULL_FACE); // gets rid of the second instance of faces
		glEnable(GL_DEPTH_TEST);

		// TODO: Depth clamp for later

		glEnable(GL_FRAMEBUFFER_SRGB); // free exponential gamma correction
	}

	public static String getOpenGLVersion()
	{
		return glGetString(GL_VERSION);
	}
}
