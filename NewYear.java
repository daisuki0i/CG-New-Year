import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

class MyColor extends Color {
    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    public static final Color[] BACKGROUND_GRADIENT_COLOR = {
            Color.decode("#363183"),
            Color.decode("#3B3386"),
            Color.decode("#3F3583"),
            Color.decode("#4A3486"),
            Color.decode("#523784"),
            Color.decode("#663E85"),
            Color.decode("#744388")

    };

    public static final Color HOUSE_WALL = Color.decode("#BC645C");
    public static final Color WINDOW = Color.decode("#DDA763");
    public static final Color TABLE = Color.decode("#606355");
    public static final Color NIGHTTIME = Color.decode("#13547A");
    public static final Color MONITOR_BORDER = Color.decode("#ACB1B7");
    public static final Color SHADOW_MONITOR_BORDER = Color.decode("#7B7D83");
    public static final Color COMPUTER_MONITOR = Color.decode("#F4E289");
    public static final Color VS_CODE_BACKGROUND = Color.decode("#2C2929");
    public static final Color CODE_COLOR_ORANGE = Color.decode("#DA6F31");
    public static final Color CODE_COLOR_GREEN = Color.decode("#179158");

    public static final Color LINE = BLACK;

    public static final Color SKY = Color.decode("#653D84");

}

public class NewYear extends JPanel {
    final int LINE_WIDTH = 2;

    public static void main(String[] args) {
        NewYear n = new NewYear();

        JFrame f = new JFrame();
        f.add(n);
        f.setTitle("NewYear");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null); // หน้าต่างอยู่ตรงกลาง

    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        drawBackground(g2);

        g.drawImage(buffer, 0, 0, null);
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    private void drawBackground(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Create a gradient paint
        GradientPaint gradientPaint = new GradientPaint(0, 0, MyColor.BACKGROUND_GRADIENT_COLOR[0], 0, 400,
                MyColor.BACKGROUND_GRADIENT_COLOR[MyColor.BACKGROUND_GRADIENT_COLOR.length - 1]);

        // Set the paint to the graphics context
        g2d.setPaint(gradientPaint);

        // Fill the background with the gradient
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();
    }

    public BufferedImage floodFill(BufferedImage m, Point p, Color target_colour, Color replacement_colour) {
        // ทำการเติมสี replacement_colour ในพื้นที่ที่มีสี target_colour ด้วยวิธี Flood Fill
        Queue<Point> q = new LinkedList<>();
        m.setRGB(p.x, p.y, replacement_colour.getRGB());
        q.add(new Point(p.x, p.y));

        while (!q.isEmpty()) {
            Point currentPoint = q.poll();
            Point south = new Point(currentPoint.x, currentPoint.y + 1);
            Point north = new Point(currentPoint.x, currentPoint.y - 1);
            Point east = new Point(currentPoint.x + 1, currentPoint.y);
            Point west = new Point(currentPoint.x - 1, currentPoint.y);

            if (m.getRGB(south.x, south.y) == target_colour.getRGB()) {
                m.setRGB(south.x, south.y, replacement_colour.getRGB());
                q.add(south);
            }
            if (m.getRGB(north.x, north.y) == target_colour.getRGB()) {
                m.setRGB(north.x, north.y, replacement_colour.getRGB());
                q.add(north);
            }
            if (m.getRGB(east.x, east.y) == target_colour.getRGB()) {
                m.setRGB(east.x, east.y, replacement_colour.getRGB());
                q.add(east);
            }
            if (m.getRGB(west.x, west.y) == target_colour.getRGB()) {
                m.setRGB(west.x, west.y, replacement_colour.getRGB());
                q.add(west);
            }
        }

        return m;
    }

    private void drawLine(Graphics g, Point p1, Point p2, int thickness, Color color) {
        g.setColor(color);

        // Bresenham's line algorithm
        int dx = Math.abs(p2.x - p1.x);
        int dy = Math.abs(p2.y - p1.y);
        int sx = (p1.x < p2.x) ? 1 : -1;
        int sy = (p1.y < p2.y) ? 1 : -1;
        boolean isSwapped = false;

        if (dy > dx) {
            int temp = dx;
            dx = dy;
            dy = temp;
            isSwapped = true;
        }

        int D = 2 * dy - dx;
        int x = p1.x;
        int y = p2.x;

        for (int i = 0; i < dx; i++) {
            for (int j = 0; j < thickness; j++) {
                plot(g, x, y + j);
            }
            while (D >= 0) {
                if (isSwapped) {
                    x += sx;
                } else {
                    y += sy;
                }
                D -= 2 * dx;
            }

            if (isSwapped) {
                y += sy;
            } else {
                x += sx;
            }

            D += 2 * dy;
        }
    }

    private void drawLine(Graphics g, Point p1, Point p2, Color color) {
        drawLine(g, p1, p2, 1, color);
    }

    private void drawArc(Graphics g, Point p1, Point p2, Point p3, Point p4, Color color) {
        g.setColor(color);
        int n = 1000;
        for (int i = 0; i <= n; i++) {
            double t = (double) i / n;
            int x = (int) (Math.pow(1 - t, 3) * p1.x + 3 * t * Math.pow(1 - t, 2) * p2.x
                    + 3 * Math.pow(t, 2) * (1 - t) * p3.x + Math.pow(t, 3) * p4.x);
            int y = (int) (Math.pow(1 - t, 3) * p1.y + 3 * t * Math.pow(1 - t, 2) * p2.y
                    + 3 * Math.pow(t, 2) * (1 - t) * p3.y + Math.pow(t, 3) * p4.y);
            plot(g, x, y);
        }
    }
}
