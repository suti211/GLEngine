package com.base.engine;

public class Matrix4f
{
	private float[][] m;

	public Matrix4f()
	{
		m = new float[4][4];
	}

	// IT WAS SO PAINFUL(egys�gm�trixokok)*******************
	public Matrix4f identity()
	{
		m[0][0] = 1;
		m[0][1] = 0;
		m[0][2] = 0;
		m[0][3] = 0;
		m[1][0] = 0;
		m[1][1] = 1;
		m[1][2] = 0;
		m[1][3] = 0;
		m[2][0] = 0;
		m[2][1] = 0;
		m[2][2] = 1;
		m[2][3] = 0;
		m[3][0] = 0;
		m[3][1] = 0;
		m[3][2] = 0;
		m[3][3] = 1;

		return this;
	}

	// MULTIPLICATION*****************************************
	public Matrix4f multiply(Matrix4f r)
	{
		Matrix4f result = new Matrix4f();

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				result.set(
						i,
						j,
						m[i][0] * result.get(0, j) + m[i][1] * result.get(1, j)
								+ m[i][2] * result.get(2, j) + m[i][3]
								* result.get(3, j));
			}
		}

		return result;
	}

	// GETERRS, SETTERS***************************************
	public float[][] getM()
	{
		return m;
	}

	public void setM(float[][] m)
	{
		this.m = m;
	}

	public float get(int x, int y)
	{
		return m[x][y];
	}

	public void set(int x, int y, float value)
	{
		m[x][y] = value;
	}
}
