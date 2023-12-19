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

    public static final Color FERRIS_WHEEL = Color.decode("#AD7A77");
    public static final Color VIVID_VISION = Color.decode("#615063");
    public static final Color ALASKAN_CRUISE = Color.decode("#37466f");
    public static final Color SASQUATCH_SOCKS = Color.decode("#ff4b7b");
    public static final Color ANTARCTIC_BLUE = Color.decode("#2b385e");
    public static final Color FRIJID_PINK = Color.decode("#FF8B7F");

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

        BufferedImage mainBuffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D mg = mainBuffer.createGraphics();

        drawBackground(mg);

        drawArc(mg, new Point(0, 342), new Point(150, 347), new Point(600, 364), new Point(750, 479),
                 MyColor.FRIJID_PINK);
        drawArc(mg, new Point(0, 340), new Point(150, 342), new Point(600, 360), new Point(750, 470),
                MyColor.ANTARCTIC_BLUE);

        drawArc(mg, new Point(0, 290), new Point(150, 292), new Point(600, 310), new Point(750, 420),
                MyColor.ANTARCTIC_BLUE);
        drawArc(mg, new Point(0, 287), new Point(150, 287), new Point(600, 304), new Point(750, 416),
                MyColor.FRIJID_PINK);
        drawArc(mg, new Point(0, 282), new Point(150, 284), new Point(600, 302), new Point(750, 412),
                MyColor.FRIJID_PINK);

        drawRoad(mg);

        drawBarriers(mg);

        drawBarrierShadow(mg);

        // drawCar(mg);

         // color fill
        mainBuffer = floodFill(mainBuffer, new Point(13, 330), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(33, 330), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(53, 330), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(73, 330), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(93, 331), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(118, 332), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(143, 333), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(168, 335), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(193, 337), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(218, 339), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(243, 341), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(273, 343), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(303, 345), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(333, 348), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(363, 352), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(413, 358), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(463, 366), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(513, 376), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(563, 386), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);

        mainBuffer = floodFill(mainBuffer, new Point(80, 415), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.FERRIS_WHEEL); // เส้นถนน 1
        mainBuffer = floodFill(mainBuffer, new Point(520, 550), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.VIVID_VISION); // เส้นถนน 2
        mainBuffer = floodFill(mainBuffer, new Point(300, 400), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ALASKAN_CRUISE); // ถนน

        int[] xPoints = new int[] { 5, 25, 45, 65, 85, 105, 110, 135, 160, 185, 210, 235, 265, 295, 325, 355, 405, 455,
                505 };
        for (int i = 0; i < xPoints.length; i++) {
            mainBuffer = floodFill(mainBuffer, new Point(xPoints[i], 335), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                    MyColor.SASQUATCH_SOCKS);
        }
        mainBuffer = floodFill(mainBuffer, new Point(555, 350), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.SASQUATCH_SOCKS);

        mainBuffer = floodFill(mainBuffer, new Point(5, 285), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.SASQUATCH_SOCKS);
        mainBuffer = floodFill(mainBuffer, new Point(5, 288), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(555, 396), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.ANTARCTIC_BLUE);
        mainBuffer = floodFill(mainBuffer, new Point(5, 346), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                MyColor.SASQUATCH_SOCKS);

        drawCar(mg);

        g.drawImage(mainBuffer, 0, 0, null);

        g.setColor(MyColor.RED);
        g.fillRect(160, 480, 5, 5);
    }

    // draw methods
    private void drawBackground(Graphics g) {
        int y = 0;
        for (int i = 0; i < MyColor.BACKGROUND_GRADIENT_COLOR.length; i++) {
            if (i == MyColor.BACKGROUND_GRADIENT_COLOR.length - 1) {
                fillRect(g, 0, y, 600, 600 - y, MyColor.BACKGROUND_GRADIENT_COLOR[i]);
            }
            fillRect(g, 0, y, 600, 40, MyColor.BACKGROUND_GRADIENT_COLOR[i]);
            y += 40;
        }
    }

    private void drawRoad(Graphics g) {
        drawArc(g, new Point(0, 350), new Point(150, 352), new Point(600, 370), new Point(750, 480),
                2, MyColor.FRIJID_PINK);
        // เส้นถนน 1
        drawLine(g, new Point(1, 400), new Point(40, 400), MyColor.FERRIS_WHEEL);
        drawLine(g, new Point(120, 440), new Point(159, 440), MyColor.FERRIS_WHEEL);
        drawArc(g, new Point(1, 400), new Point(55, 415), new Point(66, 415), new Point(120, 440),
                MyColor.FERRIS_WHEEL);
        drawArc(g, new Point(40, 400), new Point(95, 415), new Point(106, 415), new Point(159, 440),
                MyColor.FERRIS_WHEEL);

        // เส้นถนน 2
        drawLine(g, new Point(491, 520), new Point(430, 520), MyColor.ALASKAN_CRUISE);
        drawLine(g, new Point(571, 600), new Point(600, 600), MyColor.ALASKAN_CRUISE);
        drawArc(g, new Point(491, 520), new Point(536, 550), new Point(560, 550), new Point(600, 600),
                MyColor.ALASKAN_CRUISE);
        drawArc(g, new Point(430, 520), new Point(475, 550), new Point(499, 550), new Point(539, 600),
                MyColor.ALASKAN_CRUISE);
    }

    private void drawBarriers(Graphics g) {
        // draw barrier
        int[] yPoints = { 340, 340, 340, 340, 340, 340, 340, 341, 341 };
        int xStart = 10;
        int poleWidth = 10;
        for (int i = 0; i < yPoints.length; i++) {
            drawLine(g, new Point(xStart, yPoints[i]), new Point(xStart, yPoints[i] - 50), 2, MyColor.FRIJID_PINK);
            xStart += poleWidth;
        }

        yPoints = new int[] { 342, 342, 343, 343, 344, 345, 346, 347, 348, 349, 350, 351 };
        xStart = 105;
        int stepWidth = 15;
        for (int i = 0; i < yPoints.length; i++) {
            drawLine(g, new Point(xStart, yPoints[i]), new Point(xStart, yPoints[i] - 50), 2, MyColor.FRIJID_PINK);
            xStart = (i % 2 == 0) ? xStart + poleWidth : xStart + stepWidth;
        }

        yPoints = new int[] { 352, 353, 354, 355, 357, 358, 360, 361 };
        xStart = 260;
        stepWidth = 20;
        for (int i = 0; i < yPoints.length; i++) {
            drawLine(g, new Point(xStart, yPoints[i]), new Point(xStart, yPoints[i] - 50), 2, MyColor.FRIJID_PINK);
            xStart = (i % 2 == 0) ? xStart + poleWidth : xStart + stepWidth;
        }

        yPoints = new int[] { 366, 368, 375, 376, 383, 385, 393, 396, 405 };
        xStart = 400;
        stepWidth = 40;
        for (int i = 0; i < yPoints.length; i++) {
            drawLine(g, new Point(xStart, yPoints[i]), new Point(xStart, yPoints[i] - 50), 2, MyColor.FRIJID_PINK);
            xStart = (i % 2 == 0) ? xStart + poleWidth : xStart + stepWidth;
        }
    }

    private void drawBarrierShadow(Graphics g) {
        drawLine(g, new Point(15, 340), new Point(15, 290), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(35, 340), new Point(35, 290), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(55, 340), new Point(55, 290), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(75, 340), new Point(75, 290), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(95, 341), new Point(95, 291), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(120, 342), new Point(120, 292), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(145, 343), new Point(145, 293), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(170, 345), new Point(170, 295), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(195, 347), new Point(195, 297), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(220, 349), new Point(220, 299), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(245, 351), new Point(245, 301), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(275, 353), new Point(275, 303), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(305, 355), new Point(305, 305), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(335, 358), new Point(335, 308), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(365, 362), new Point(365, 312), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(415, 368), new Point(415, 318), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(465, 376), new Point(465, 326), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(515, 386), new Point(515, 336), MyColor.ANTARCTIC_BLUE);
        drawLine(g, new Point(565, 396), new Point(565, 346), MyColor.ANTARCTIC_BLUE);
    }

    private void drawCar(Graphics g) {
        // draw car
        drawLine(g,new Point(160, 467), new Point(350, 532), MyColor.RED);
        drawLine(g,new Point(160, 480), new Point(350, 555), MyColor.RED);

        // backwheel
        drawArc(g, new Point(285, 528), new Point(283, 538), new Point(280, 558), new Point(290, 568), MyColor.RED);
        drawArc(g, new Point(290, 568), new Point(295, 583), new Point(315, 565), new Point(317, 550) , MyColor.RED);
        drawArc(g, new Point(317, 550), new Point(320, 540), new Point(319, 515), new Point(314, 516), MyColor.RED);
        drawArc(g, new Point(314, 516), new Point(305, 511), new Point(300, 510), new Point(285, 528), MyColor.RED);

        // frontwheel
        drawArc(g, new Point(160, 480), new Point(159, 470), new Point(158, 455), new Point(155, 452), MyColor.RED);
        drawArc(g, new Point(155, 452), new Point(147, 447), new Point(130, 457), new Point(133, 480), MyColor.RED);
        drawArc(g, new Point(133, 480), new Point(134, 483), new Point(132, 493), new Point(155, 491), MyColor.RED);
        drawArc(g, new Point(155, 491), new Point(160, 490), new Point(160, 480), new Point(159, 470), MyColor.RED);
    }

    // algo methods
    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    private void fillRect(Graphics g, int x, int y, int width, int height, Color color) {
        for (int i = 0; i < height; i++) {
            drawLine(g, new Point(x, y + i), new Point(x + width, y + i), color);
        }
    }

    private void drawGradientBackground(Graphics g) {
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
        // Perform flood fill algorithm to replace target_colour with replacement_colour
        Queue<Point> q = new LinkedList<>();
        int targetRGB = target_colour.getRGB();
        int replacementRGB = replacement_colour.getRGB();

        if (targetRGB == replacementRGB) {
            return m;
        }

        int width = m.getWidth();
        int height = m.getHeight();
        int originalRGB = m.getRGB(p.x, p.y);

        if (originalRGB == replacementRGB) {
            return m;
        }

        q.add(p);

        while (!q.isEmpty()) {
            Point currentPoint = q.poll();
            int x = currentPoint.x;
            int y = currentPoint.y;

            if (m.getRGB(x, y) != targetRGB) {
                continue;
            }

            m.setRGB(x, y, replacementRGB);

            if (x > 0 && m.getRGB(x - 1, y) == targetRGB) {
                q.add(new Point(x - 1, y));
            }
            if (x < width - 1 && m.getRGB(x + 1, y) == targetRGB) {
                q.add(new Point(x + 1, y));
            }
            if (y > 0 && m.getRGB(x, y - 1) == targetRGB) {
                q.add(new Point(x, y - 1));
            }
            if (y < height - 1 && m.getRGB(x, y + 1) == targetRGB) {
                q.add(new Point(x, y + 1));
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
        int y = p1.y;

        for (int i = 0; i <= dx; i++) {
            for (int j = 0; j < thickness; j++) {
                for (int k = 0; k < thickness; k++) {
                    plot(g, x + k, y + j);
                }
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
        drawArc(g, p1, p2, p3, p4, 1, color);
    }

    private void drawArc(Graphics g, Point p1, Point p2, Point p3, Point p4, int thickness, Color color) {
        // markControlPoints(g, p1, p2, p3, p4);
        g.setColor(color);
        int n = 1000;
        for (int i = 0; i <= n; i++) {
            double t = (double) i / n;
            int x = (int) (Math.pow(1 - t, 3) * p1.x + 3 * t * Math.pow(1 - t, 2) * p2.x
                    + 3 * Math.pow(t, 2) * (1 - t) * p3.x + Math.pow(t, 3) * p4.x);
            int y = (int) (Math.pow(1 - t, 3) * p1.y + 3 * t * Math.pow(1 - t, 2) * p2.y
                    + 3 * Math.pow(t, 2) * (1 - t) * p3.y + Math.pow(t, 3) * p4.y);
            for (int j = -thickness / 2; j <= thickness / 2; j++) {
                for (int k = -thickness / 2; k <= thickness / 2; k++) {
                    plot(g, x + j, y + k);
                }
            }
        }
    }

    private void markControlPoints(Graphics g, Point p1, Point p2, Point p3, Point p4) {
        g.setColor(MyColor.RED);
        int i = 1;
        for (Point p : new Point[] { p1, p2, p3, p4 }) {
            g.fillRect(p.x, p.y, 4, 4);
            g.drawChars(("P" + i).toCharArray(), 0, 2, p.x + 5, p.y + 5);
            i++;
        }
    }

}
