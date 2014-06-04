package net.kreatious.shapescreen;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class RectangleMan extends Component implements KeyEventDispatcher,
		Runnable {
	private static final long serialVersionUID = 8019228865943308367L;
	private int vX;
	private int vY;

	public void initialize() {
		setSize(30, 30);
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(this);
		Main.addActor(this);
	}

	/**
	 * Draws rectangle man! He's a rectangular blob...
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.MAGENTA);
		g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

		g2.setColor(Color.BLUE);
		g2.drawRect(0, 0, getWidth() - 2, getHeight() - 2);

		super.paint(g);
	}

	/**
	 * Rectangle man reacts to the keyboard!
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_RELEASED) {
			vX = 0;
			vY = 0;
		} else if (e.getID() == KeyEvent.KEY_PRESSED) {
			if (e.getKeyCode() == KeyEvent.VK_A) {
				vX = -1;
			}

			if (e.getKeyCode() == KeyEvent.VK_D) {
				vX = 1;
			}
			if (e.getKeyCode() == KeyEvent.VK_W) {
				vY = -1;
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				vY = 1;
			}
		}

		return false;
	}

	/**
	 * Moves rectangle man!
	 */
	@Override
	public void run() {
		setLocation(getX() + vX, getY() + vY);
	}
}
