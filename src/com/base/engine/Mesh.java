package com.base.engine;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glGenBuffers;

public class Mesh
{
	private int vbo;
	private int size;

	public Mesh()
	{
		vbo = glGenBuffers();
		size = 0;
	}

	public void addVertices(Vertex[] vertices)
	{
		size = vertices.length * Vertex.SIZE;

		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		// glBufferData(GL_ARRAY_BUFFER, data, usage);
	}
}
