package com.base.engine;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input
{
	public static final int NUM_KEYCODES = 256;
	public static final int NUM_MOUSEBUTTONS = 7;

	// Keyboard key Lists
	private static ArrayList<Integer> currentKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> downKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> upKeys = new ArrayList<Integer>();

	// mouse button lists
	private static ArrayList<Integer> currentMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> downMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> upMouse = new ArrayList<Integer>();

	public static void update()
	{
		upKeys.clear();

		// if we don't pressing now, but it was pressed, it must be released,
		// so we adding it to the released keys list
		for (int i = 0; i < NUM_KEYCODES; i++)
		{
			if (!getKey(i) && currentKeys.contains(i))
			{
				upKeys.add(i);
			}
		}

		upMouse.clear();

		// if we don't pressing now, but it was pressed, it must be released,
		// so we adding it to the released keys list
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
		{
			if (!getMouse(i) && currentMouse.contains(i))
			{
				upMouse.add(i);
			}
		}

		downKeys.clear();

		// if we pressed it now, and it wasn't pressed before, it must be
		// pressed down
		for (int i = 0; i < NUM_KEYCODES; i++)
		{
			if (getKey(i) && !currentKeys.contains(i))
			{
				downKeys.add(i);
			}
		}

		downMouse.clear();

		// if we pressed it now, and it wasn't pressed before, it must be
		// pressed down
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
		{
			if (getMouse(i) && !currentMouse.contains(i))
			{
				downMouse.add(i);
			}
		}

		currentKeys.clear();

		// if we press it now, we add it to the currently pressed keys list.
		for (int i = 0; i < NUM_KEYCODES; i++)
		{
			if (getKey(i))
			{
				currentKeys.add(i);
			}
		}

		currentMouse.clear();

		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
		{
			if (getMouse(i))
				currentMouse.add(i);
		}
	}

	// gets the state of the given key.
	public static boolean getKey(int keyCode)
	{
		return Keyboard.isKeyDown(keyCode);
	}

	// returns bool only in 1 frame, keypress detection
	public static boolean getKeyDown(int keyCode)
	{
		return downKeys.contains(keyCode);
	}

	// key release detection
	public static boolean getKeyUp(int keyCode)
	{
		return upKeys.contains(keyCode);
	}

	// mouse button detection
	public static boolean getMouse(int mouseButton)
	{
		return Mouse.isButtonDown(mouseButton);
	}

	public static boolean getMouseDown(int mouseButton)
	{
		return downMouse.contains(mouseButton);
	}

	public static boolean getMouseUp(int mouseButton)
	{
		return upMouse.contains(mouseButton);
	}

	// ------------------------------------------------------------------
	// ------------------------------------------------------------------

	public static Vector2f getMousePosition()
	{
		return new Vector2f(Mouse.getX(), Mouse.getY());
	}
}
