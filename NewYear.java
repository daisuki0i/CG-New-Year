import java.awt.*;
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
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Create a gradient paint
        GradientPaint gradientPaint = new GradientPaint(0, 0, MyColor.BACKGROUND_GRADIENT_COLOR[0], 0, 400, MyColor.BACKGROUND_GRADIENT_COLOR[MyColor.BACKGROUND_GRADIENT_COLOR.length - 1]);

        // Set the paint to the graphics context
        g2d.setPaint(gradientPaint);

        // Fill the background with the gradient
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();

        int x1 = 600;
        int y1 = 400;
        int x2 = 0;
        int y2 = 350;

        int ctrlX = x1 + 100; // Adjust this value for curvature
        int ctrlY = y1 - 50; // Adjust this value for curvature

        drawBezierCurve(g, x1, y1, ctrlX, ctrlY, x2, y2, 2); // Adjust thickness here

        y1 -= 12;
        y2 -= 12;
        ctrlY -= 12;
        drawBezierCurve(g, x1, y1, ctrlX, ctrlY, x2, y2, 2); // Adjust thickness here

        y1 -= 42;
        y2 -= 42;
        ctrlY -= 42;
        drawBezierCurve(g, x1, y1, ctrlX, ctrlY, x2, y2, 2); // Adjust thickness here

        y1 -= 10;
        y2 -= 10;
        ctrlY -= 10;
        drawBezierCurve(g, x1, y1, ctrlX, ctrlY, x2, y2, 2); // Adjust thickness here
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    private void fillRectangle(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        for (int y = y1; y < y2; y++) {
            drawLine(g, x1, y, x2, y, color);
        }
    }

    private void drawHorizontalLine(Graphics g, int x1, int y1, int len) {
        fillRectangle(g, x1, y1, x1 + len, y1 + LINE_WIDTH, MyColor.LINE);
    }

    private void drawVerticalLine(Graphics g, int x1, int y1, int len) {
        fillRectangle(g, x1, y1, x1 + LINE_WIDTH, y1 + len, MyColor.LINE);
    }

    private void drawVerticalLine(Graphics g, int x1, int y1, int len, Color color) {
        fillRectangle(g, x1, y1, x1 + LINE_WIDTH, y1 + len, color);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2, int thickness, Color color) {
        g.setColor(color);

        // Bresenham's line algorithm
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwapped = false;

        if (dy > dx) {
            int temp = dx;
            dx = dy;
            dy = temp;
            isSwapped = true;
        }

        int D = 2 * dy - dx;
        int x = x1;
        int y = y1;

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

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        drawLine(g, x1, y1, x2, y2, 1, color);
    }

    private void drawArc(Graphics g, int x, int y, int width, int height, int startAngle, int arcAngle, Color color) {
        g.setColor(color);
        g.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    private void drawBezierCurve(Graphics g, int x1, int y1, int ctrlX, int ctrlY, int x2, int y2, int thickness) {
        int resolution = 900;

        for (int t = 0; t <= resolution; t++) {
            float u = t / (float) resolution;
            float uComp = 1 - u;

            int x = (int) (uComp * uComp * x1 + 2 * uComp * u * ctrlX + u * u * x2);
            int y = (int) (uComp * uComp * y1 + 2 * uComp * u * ctrlY + u * u * y2);

            drawHorizontalLine(g, x, y, thickness, thickness);
        }
    }

    private void drawRectangle(Graphics g, int x1, int y1, int x2, int y2) {
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                plot(g, x, y);
            }
        }
    }

    private void drawHorizontalLine(Graphics g, int x1, int y1, int width, int len) {
        drawRectangle(g, x1, y1, x1 + len, y1 + width);
    }

    private void old(Graphics g) {
        // พื้นหลัง
        // fillRectangle(g, 0, 0, 600, 600, MyColor.BACKGROUND);

        // ลายผนัง
        int lineSpacing = 55;
        for (int x = 35; x < 600; x += lineSpacing) {
            drawVerticalLine(g, x, 0, 600, MyColor.HOUSE_WALL);
        }

        // Table
        fillRectangle(g, 0, 425, 600, 600, MyColor.TABLE);

        // ขอบ Table
        fillRectangle(g, 0, 423, 600, 425, MyColor.BLACK);

        // Window Frame
        fillRectangle(g, 405, 50, 600, 280, MyColor.WINDOW);
        fillRectangle(g, 395, 280, 600, 303, MyColor.WINDOW);
        fillRectangle(g, 412, 300, 600, 314, MyColor.WINDOW);

        // ขอบแนวนอน Window Frame
        drawHorizontalLine(g, 405, 49, 195);
        drawHorizontalLine(g, 395, 280, 205);
        drawHorizontalLine(g, 395, 301, 205);
        drawHorizontalLine(g, 411, 314, 189);

        // ขอบแนวตั้ง Window Frame
        drawVerticalLine(g, 405, 49, 231);
        drawVerticalLine(g, 395, 280, 23);
        drawVerticalLine(g, 410, 302, 13);

        // Sky
        fillRectangle(g, 419, 63, 600, 268, MyColor.NIGHTTIME);

        // ขอบแนวนอน Sky
        drawHorizontalLine(g, 419, 63, 181);
        drawHorizontalLine(g, 419, 266, 181);

        // ขอบแนวตั้ง Sky
        drawVerticalLine(g, 419, 63, 205);

        // Monitor Border
        fillRectangle(g, 0, 100, 340, 380, MyColor.MONITOR_BORDER);

        // กรอบแนวนอน Monitor Border
        drawHorizontalLine(g, 0, 100, 340);
        drawHorizontalLine(g, 0, 380, 340);

        // ขอบแนวตั้ง Monitor Border
        drawVerticalLine(g, 340, 100, 282);

        // Shadow Monitor Border
        fillRectangle(g, 0, 111, 330, 121, MyColor.SHADOW_MONITOR_BORDER);
        fillRectangle(g, 0, 361, 330, 370, MyColor.SHADOW_MONITOR_BORDER);

        // ขอบแนวนอน Shadow Monitor Border
        drawHorizontalLine(g, 0, 110, 330);
        drawHorizontalLine(g, 0, 119, 330);

        drawHorizontalLine(g, 0, 361, 330);
        drawHorizontalLine(g, 0, 369, 330);

        // ขอบแนวตั้ง Shadow Monitor Border
        drawVerticalLine(g, 330, 110, 261);

        // Computer Monitor
        fillRectangle(g, 0, 121, 330, 361, MyColor.COMPUTER_MONITOR);

        // App Window
        fillRectangle(g, 20, 135, 295, 345, MyColor.WHITE);

        // ขอบแนวนอน App Window
        drawHorizontalLine(g, 20, 134, 275);
        drawHorizontalLine(g, 20, 345, 275);

        // ขอบแนวตั้ง App Window
        drawVerticalLine(g, 20, 134, 211);
        drawVerticalLine(g, 295, 134, 213);

        // VS CODE
        fillRectangle(g, 30, 160, 200, 345, MyColor.VS_CODE_BACKGROUND);

        // VS CODE 2
        fillRectangle(g, 205, 160, 285, 345, MyColor.VS_CODE_BACKGROUND);

        // ขอบแนวนอน VS CODE
        drawHorizontalLine(g, 30, 159, 255);

        // ขอบแนวตั้ง VS CODE
        drawVerticalLine(g, 30, 159, 186);
        drawVerticalLine(g, 200, 159, 186);

        // ขอบแนวตั้ง VS CODE 2
        drawVerticalLine(g, 205, 159, 186);
        drawVerticalLine(g, 285, 159, 186);

        // CODE COLOR
        fillRectangle(g, 35, 170, 55, 174, MyColor.CODE_COLOR_ORANGE);
        fillRectangle(g, 60, 170, 100, 174, MyColor.WHITE);
        fillRectangle(g, 105, 170, 125, 174, MyColor.CODE_COLOR_GREEN);
        fillRectangle(g, 130, 170, 145, 174, MyColor.RED);
        fillRectangle(g, 150, 170, 175, 174, MyColor.WHITE);
        fillRectangle(g, 180, 170, 195, 174, MyColor.YELLOW);

        // CODE COLOR 2
        fillRectangle(g, 220, 170, 280, 174, MyColor.WHITE);
        // Monitor Stand
        fillRectangle(g, 100, 382, 150, 435, MyColor.MONITOR_BORDER);

        // ขอบแนวนอน Monitor Stand
        drawHorizontalLine(g, 100, 435, 50);

        // ขอบแนวตั้ง Monitor Stand
        drawVerticalLine(g, 100, 381, 54);
        drawVerticalLine(g, 150, 381, 56);

        // Monitor Stand Shadow
        fillRectangle(g, 152, 382, 165, 430, MyColor.SHADOW_MONITOR_BORDER);
        int[] xPoints = { 152, 165, 152 };
        int[] yPoints = { 430, 430, 435 };
        g.fillPolygon(xPoints, yPoints, 3);

        // ขอบแนวตั้ง Monitor Stand Shadow
        drawVerticalLine(g, 165, 381, 49);
        drawLine(g, 152, 435, 166, 430, 2, MyColor.LINE);
    }

}
