package net.kreatious.shapescreen;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JApplet;

/**
 * Draws a rectangle to the screen! Isn't it pretty?
 * 
 * @author JStuder
 */
public class Main extends JApplet {
	private static final long serialVersionUID = 3410629826447753789L;
	private static final ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();

	/**
	 * Create the applet. The magic starts here!
	 */
	public Main() {
		// Use absolute positioning
		getContentPane().setLayout(null);
		
		// Add rectangle man!
		RectangleMan rectangleMan = new RectangleMan();
		rectangleMan.setLocation(70, 75);
		rectangleMan.initialize();
		getContentPane().add(rectangleMan);
	}
	
	public static final void addActor(Runnable actor)
	{
		pool.scheduleAtFixedRate(actor, 0, 20, TimeUnit.MILLISECONDS);
	}
}
