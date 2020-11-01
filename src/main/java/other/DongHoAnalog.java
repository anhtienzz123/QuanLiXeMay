package other;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class DongHoAnalog extends JPanel {
	private static final long serialVersionUID = 1L;
	final float degrees06 = (float) (PI / 30);
	final float degrees30 = degrees06 * 5;
	final float degrees90 = degrees30 * 3;

	final int size = 300;
	final int spacing = 10;
	final int diameter = size - 2 * spacing;
	final int cx = diameter / 2 + spacing;
	final int cy = diameter / 2 + spacing;

	/**
	 * Create the panel.
	 */
	public DongHoAnalog() {
		setPreferredSize(new Dimension(size, size));
		setBackground(Color.WHITE);

		new Timer(1000, (ActionEvent e) -> {
			repaint();
		}).start();
	}
	@Override
	public void paintComponent(Graphics gg) {
		super.paintComponent(gg);
		Graphics2D g = (Graphics2D) gg;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		drawFace(g);

		final LocalTime time = LocalTime.now();
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();

		float angle = degrees90 - (degrees06 * second);
		drawHand(g, angle, diameter / 2 - 30, Color.red);

		float minsecs = (minute + second / 60.0F);
		angle = degrees90 - (degrees06 * minsecs);
		drawHand(g, angle, diameter / 3 + 10, Color.black);

		float hourmins = (hour + minsecs / 60.0F);
		angle = degrees90 - (degrees30 * hourmins);
		drawHand(g, angle, diameter / 4 + 10, Color.black);
	}

	private void drawFace(Graphics2D g) {
		g.setStroke(new BasicStroke(2));
		g.setColor(Color.white);
		g.fillOval(spacing, spacing, diameter, diameter);
		g.setColor(Color.black);
		g.drawOval(spacing, spacing, diameter, diameter);
		g.drawString("3", diameter - 10, spacing + 145);
		g.drawString("9", diameter -260 , spacing +145 );
		g.drawString("6", diameter -140 , spacing +270 );
        g.drawString("12", diameter -140, spacing + 20);
        
	}

	private void drawHand(Graphics2D g, float angle, int radius, Color color) {
		int x = cx + (int) (radius * cos(angle));
		int y = cy - (int) (radius * sin(angle));
		g.setColor(color);
		g.drawLine(cx, cy, x, y);
	}
  public static void main(String[] args) {
  SwingUtilities.invokeLater(() -> {
     JFrame f = new JFrame();
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setTitle("Clock");
     f.setResizable(false);
     f.add(new DongHoAnalog(), BorderLayout.CENTER);
     f.pack();
     f.setLocationRelativeTo(null);
     f.setVisible(true);
  });
}

}



/*
 * 
 * package other;
 * 
 * import java.awt.BasicStroke; import java.awt.BorderLayout; import
 * java.awt.Color; import java.awt.Graphics; import java.awt.Graphics2D; import
 * java.awt.RenderingHints; import java.awt.geom.Arc2D; import
 * java.util.Calendar; import javax.swing.JFrame; import javax.swing.JPanel;
 * 
 * public class DongHoAnalog extends JPanel implements Runnable {
 * 
 * int xs, ys, xm, ym, xh, yh; Thread clockThread = new Thread(this);
 * 
 * public DongHoAnalog() { setBackground(Color.WHITE);
 * this.setDoubleBuffered(true); clockThread.start(); }
 * 
 * public void paintComponent(Graphics g) { Graphics2D g2d = (Graphics2D) g;
 * g2d.translate(getWidth() / 2, getHeight() / 2); int side = getWidth() >
 * getHeight() ? getHeight() : getWidth(); g2d.scale(side / 250, side / 250);
 * setAllRenderingHints(g2d); drawClockFace(g2d); drawClockHands(g2d); }
 * 
 * @Override public void run() { while (true) { int s =
 * Calendar.getInstance().get(Calendar.SECOND); xs = (int) (Math.cos(s * Math.PI
 * / 30 - Math.PI / 2) * 80 + 0); ys = (int) (Math.sin(s * Math.PI / 30 -
 * Math.PI / 2) * 80 + 0);
 * 
 * int m = Calendar.getInstance().get(Calendar.MINUTE); xm = (int) (Math.cos(m *
 * Math.PI / 30 - Math.PI / 2) * 75 + 0); ym = (int) (Math.sin(m * Math.PI / 30
 * - Math.PI / 2) * 75 + 0);
 * 
 * int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); xh = (int)
 * (Math.cos((h * 30 + m / 2) * Math.PI / 180 - Math.PI / 2) * 60 + 0); yh =
 * (int) (Math.sin((h * 30 + m / 2) * Math.PI / 180 - Math.PI / 2) * 60 + 0);
 * 
 * repaint(); try { Thread.sleep(500); } catch (InterruptedException ex) { } } }
 * 
 * private void setAllRenderingHints(Graphics2D g) {
 * g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
 * RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
 * g.setRenderingHint(RenderingHints.KEY_DITHERING,
 * RenderingHints.VALUE_DITHER_ENABLE);
 * g.setRenderingHint(RenderingHints.KEY_RENDERING,
 * RenderingHints.VALUE_RENDER_QUALITY);
 * g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
 * RenderingHints.VALUE_ANTIALIAS_ON);
 * g.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
 * g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
 * RenderingHints.VALUE_FRACTIONALMETRICS_ON);
 * g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
 * RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
 * g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
 * RenderingHints.VALUE_COLOR_RENDER_QUALITY);
 * g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
 * RenderingHints.VALUE_STROKE_PURE);
 * 
 * }
 * 
 * private void drawClockFace(Graphics2D g) { g.setPaint(Color.white);
 * g.fill(new Arc2D.Double(-110, -110, 220, 220, 0, 360, Arc2D.CHORD));
 * g.setColor(Color.darkGray); g.setStroke(new BasicStroke(4.0f)); g.draw(new
 * Arc2D.Double(-110, -110, 220, 220, 0, 360, Arc2D.CHORD));
 * 
 * for (int i = 0; i < 60; i++) { if ((i % 5) != 0) { g.setStroke(new
 * BasicStroke(1.0f)); g.setColor(Color.darkGray); g.drawLine(92, 0, 96, 0); }
 * else { g.setColor(new Color(255, 22, 10)); g.setStroke(new
 * BasicStroke(2.0f)); g.drawLine(88, 0, 96, 0); } g.rotate((Math.PI / 180.0) *
 * 6.0); } }
 * 
 * private void drawClockHands(Graphics2D g) { g.setColor(new Color(220, 22,
 * 10)); g.setStroke(new BasicStroke(5.0f)); g.drawLine(0, 0, xh, yh);
 * g.setStroke(new BasicStroke(3.0f)); g.drawLine(0, 0, xm, ym);
 * g.setColor(Color.black); g.setStroke(new BasicStroke(2.0f)); g.drawLine(0, 0,
 * xs, ys); g.setColor(Color.black); g.fillOval(-5, -5, 10, 10);
 * g.setColor(Color.white); g.fillOval(-2, -2, 4, 4); }
 * 
 * // public static void main(String[] args) { // JFrame f = new JFrame(); //
 * f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // f.setSize(300, 300); //
 * DongHoAnalog a = new DongHoAnalog(); // f.add(a, BorderLayout.CENTER); //
 * f.setVisible(true); // } }
 */
