package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game
{
	public Game()
	{

	}

	public void input()
	{
		// Test Code -------------------------
		if (Input.getKeyDown(Keyboard.KEY_UP))
			System.out.println("UP Arrow press Detected");

		if (Input.getKeyUp(Keyboard.KEY_UP))
			System.out.println("UP Arrow release Detected");

		if (Input.getMouseDown(1))
			System.out.println("Right click press Detected at: "
					+ Input.getMousePosition().toString());

		if (Input.getMouseUp(1))
			System.out.println("right click release Detected");
	}

	public void update()
	{

	}

	public void render()
	{

	}
}
