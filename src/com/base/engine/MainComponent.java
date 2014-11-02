package com.base.engine;

public class MainComponent
{

	public static final int HEIGTH = 600;
	public static final int WIDHT = 800;
	public static final String TITLE = "GLEngine_0.1a";
	public static final double FRAME_CAP = 5000.0;

	private boolean isRunning;

	// MainComponent skeleton
	public MainComponent()
	{
		isRunning = false;
	}

	// starts the engine ... haha
	public void start()
	{
		if (!isRunning) // running check
			run();
	}

	// stops the engine
	public void stop()
	{
		if (isRunning) // running check
			isRunning = false;
	}

	// logic update function
	private void run()
	{
		isRunning = true;

		while (isRunning)
		{
			if (Window.isCloseRequested())
				stop();

			render();
		}

		// the engine isn't running here so we call the cleanup method
		cleanUp();
	}

	// render function
	private void render()
	{
		Window.render();
	}

	// Cleanup after closing program
	private void cleanUp()
	{
		Window.dispose();
	}

	public static void main(String[] args)
	{
		Window.createWindow(WIDHT, HEIGTH, TITLE);

		MainComponent engine = new MainComponent();

		engine.start();
	}

}
