package com.base.engine;

public class MainComponent
{

	public static final int HEIGTH = 600;
	public static final int WIDHT = 800;
	public static final String TITLE = "GLEngine_0.11a";
	public static final double FRAME_CAP = 5000.0;

	private boolean isRunning;
	private Game game;

	// MainComponent skeleton
	public MainComponent()
	{
		isRunning = false;
		game = new Game();

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

		int frames = 0;
		long frameCounter = 0;

		final double frameTime = 1.0 / FRAME_CAP;

		long lastTime = Time.getTime(); // this will the time, when the previous
										// frame began drawing
		double unprocessedTime = 0;

		while (isRunning)
		{
			boolean render = false;

			long startTime = Time.getTime(); // create this in every frame
			long passedTime = startTime - lastTime; // we get how much time this
													// frame took to draw
			lastTime = startTime; // the current frame is now the previous

			unprocessedTime += passedTime / (double) Time.SECOND; // gets us how
																	// much time
																	// we need
																	// to
																	// process
																	// still
			frameCounter += passedTime;

			while (unprocessedTime > frameTime)
			{
				render = true;

				unprocessedTime -= frameTime;

				if (Window.isCloseRequested())
					stop();

				// TODO: Update Game !!!
				Time.setDelta(frameTime);
				game.input();
				Input.update();
				game.update();

				// CONSOLE FPS COUnTER
				if (frameCounter > Time.SECOND)
				{
					System.out.println("FPS: " + frames);
					frames = 0;
					frameCounter = 0;
				}
			}

			if (render)
			{
				render();
				frames++;
			} else
				try
				{
					Thread.sleep(1); // if we don't need to render, we don't
										// waste any time to wait for the loop
										// to finish
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

		// the engine isn't running here so we call the cleanup method
		cleanUp();
	}

	// render function
	private void render()
	{
		game.render();
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
