package net.kreatious.shapescreen;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class WaffleMan extends Component implements KeyEventDispatcher,
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
	 * Draws Waffle man! He's an old dancing waffle man...
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.ORANGE);
		g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

		g2.setColor(Color.BLUE);
		g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

		final int WAFFLE_LINES = 3;
		for(int i = 0; i != WAFFLE_LINES; i++)
		{
			final int WAFFLE_X = (getWidth() - 1) / WAFFLE_LINES * i;
			g2.drawLine(WAFFLE_X, 0, WAFFLE_X, getHeight() - 1);
		}
		
		super.paint(g);
	}

	/**
	 * Waffle man reacts to the keyboard!
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_RELEASED) {
			vX = 0;
			vY = 0;
		} else if (e.getID() == KeyEvent.KEY_PRESSED) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				vX = -1;
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				vX = 1;
			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				vY = -1;
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				vY = 1;
			}
		}

		return false;
	}

	/**
	 * Moves Waffle man!
	 */
	@Override
	public void run() {
		setLocation(getX() + vX, getY() + vY);
	}
}
