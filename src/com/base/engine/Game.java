package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game
{
	private Mesh mesh;

	public Game()
	{
		mesh = new Mesh();

		Vertex[] data = new Vertex[] { new Vertex(new Vector3f(-1, -1, 0)),
				new Vertex(new Vector3f(0, 1, 0)),
				new Vertex(new Vector3f(1, -1, 0)), };
		mesh.addVertices(data);
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
		mesh.draw();
	}
}
