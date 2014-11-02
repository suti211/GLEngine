package com.base.engine;

public class Quaternion
{
	private float x;
	private float y;
	private float z;
	private float w;

	public Quaternion(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	// LENGTH**********************************************
	public float length()
	{
		return (float) Math.sqrt(x * x + y * y + z * z + w * w);
	}

	// NORMALIZE*******************************************
	public Quaternion normalize()
	{
		float length = length();

		x /= length;
		y /= length;
		z /= length;
		w /= length;

		return this;
	}

	// CONJUGATE********************************************
	public Quaternion conjugate()
	{
		return new Quaternion(-x, -y, -z, w);
	}

	// QUATERNION MULTIPLICATION****************************
	public Quaternion multiply(Quaternion r)
	{
		float w_ = w * r.getW() - x * r.getX() - y * r.getY() - z * getZ();
		float x_ = x * r.getW() + w * r.getX() + y * r.getZ() - z * getY();
		float y_ = y * r.getW() + w * r.getY() + z * r.getX() - x * getZ();
		float z_ = z * r.getW() + w * r.getZ() + x * r.getY() + z * getX();

		return new Quaternion(x_, y_, z_, w_);
	}

	// HOLLY SHIT*******************************************
	public Quaternion multiply(Vector3f r)
	{
		float w_ = -x * r.getX() - y * r.getY() - z * r.getZ();
		float x_ = w * r.getX() + y * r.getZ() - z * r.getY();
		float y_ = w * r.getY() + z * r.getX() - x * r.getZ();
		float z_ = w * r.getZ() + x * r.getY() - y * r.getX();

		return new Quaternion(x_, y_, z_, w_);
	}

	// GETTERS SETTERS *************************************
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

	public float getW()
	{
		return w;
	}

	public void setW(float w)
	{
		this.w = w;
	}

}
