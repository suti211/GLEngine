package com.base.engine;

public class MainComponent
{

	public static final int HEIGTH = 600;
	public static final int WIDHT = 800;
	public static final String TITLE = "GLEngine_0.1a";

	// maincomponent skeleton
	public MainComponent()
	{

	}

	// starts the engine ... haha
	public void start()
	{
		run();
	}

	// stops the engine
	public void stop()
	{

	}

	// logic update function
	private void run()
	{
		while (!Window.isCloseRequested())
		{
			render();
		}
	}

	// render function
	private void render()
	{
		Window.render();
	}

	// Cleanup after closing program
	private void cleanUp()
	{

	}

	public static void main(String[] args)
	{
		Window.createWindow(WIDHT, HEIGTH, TITLE);

		MainComponent engine = new MainComponent();

		engine.start();
	}

}
