package com.base.engine;

public class Vector3f
{
	private float x;
	private float y;
	private float z;

	public Vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = x;
	}

	// LENGTH**************************************************
	public float length()
	{
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	// DOT*****************************************************
	public float dot(Vector3f r)
	{
		return x * r.getX() + y * r.getY() + z * r.getZ();
	}

	// CROSSPRODUCT*******************************************
	public Vector3f cross(Vector3f r)
	{
		float x_ = y * r.getZ() - z * r.getY();
		float y_ = z * r.getX() - x * r.getZ();
		float z_ = x * r.getY() - y * r.getX();

		return new Vector3f(x_, y_, z_);
	}

	// NORMALIZE***********************************************
	public Vector3f normalize()
	{
		float length = length();

		x /= length;
		y /= length;
		z /= length;

		return this;
	}

	// ROTATE***************************************************
	public Vector3f rotate()
	{
		return null;
	}

	// ADDING****************************************************
	public Vector3f add(Vector3f r)
	{
		return new Vector3f(x + r.getX(), y + r.getY(), z + r.getZ());
	}

	public Vector3f add(float r)
	{
		return new Vector3f(x + r, y + r, z + r);
	}

	// SUBTRACTION***********************************************
	public Vector3f subtract(Vector3f r)
	{
		return new Vector3f(x - r.getX(), y - r.getY(), z - r.getZ());
	}

	public Vector3f subtract(float r)
	{
		return new Vector3f(x - r, y - r, z - r);
	}

	// MULTIPLICATION******************************************
	public Vector3f multiply(Vector3f r)
	{
		return new Vector3f(x * r.getX(), y * r.getY(), z * r.getZ());
	}

	public Vector3f multiply(float r)
	{
		return new Vector3f(x * r, y * r, z * r);
	}

	// DIVISION **************************************************
	public Vector3f divide(Vector3f r)
	{
		return new Vector3f(x / r.getX(), y / r.getY(), z / r.getZ());
	}

	public Vector3f divide(float r)
	{
		return new Vector3f(x / r, y / r, z / r);
	}

	// GETTERS & SETTERS(IRISH :D) *************************************

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public float getZ()
	{
		return z;
	}

	public void setZ(float z)
	{
		this.z = z;
	}
}
