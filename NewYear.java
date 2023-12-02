import java.awt.*;
import javax.swing.*;

class MyColor extends Color {
    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    public MyColor(String hex) {
        super(Integer.parseInt(hex.substring(1, 3), 16),
                Integer.parseInt(hex.substring(3, 5), 16),
                Integer.parseInt(hex.substring(5, 7), 16));
    }

    public static final Color BACKGROUND = new Color(226, 153, 142);
    public static final Color HOUSE_WALL = new Color(188, 100, 92);
    public static final Color WINDOW = new Color(221, 167, 99);
    public static final Color TABLE = new Color(96, 99, 85);
    public static final Color NIGHTTIME = new Color(19, 84, 122);
    public static final Color MONITOR_BORDER = new Color(172,177,183);
    public static final Color SHADOW_MONITOR_BORDER = new Color(123,126,133);

    public static final Color LINE = BLACK;

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
        drawRectangle(g, 0, 0, 600, 600, MyColor.BACKGROUND);

        // ลายผนัง
        int lineSpacing = 60;
        for (int x = 40; x <= 600; x += lineSpacing) {
            drawVerticalLine(g, x, 0, 600, MyColor.HOUSE_WALL);
        }

        drawRectangle(g, 0, 425, 600, 600, MyColor.TABLE); // โต๊ะ
        drawRectangle(g, 0, 423, 600, 425, MyColor.BLACK); // ขอบโต๊ะ

        // กรอบหน้าต่างสีขาว
        drawRectangle(g, 400, 50, 600, 280, MyColor.WINDOW); 
        drawRectangle(g, 390, 280, 600, 310, MyColor.WINDOW);
        drawRectangle(g, 410, 310, 600, 330, MyColor.WINDOW);

        // ขอบหน้าต่างแนวนอน
        drawHorizontalLine(g, 400, 49, 200); 
        drawHorizontalLine(g, 390, 280, 210);
        drawHorizontalLine(g, 390, 310, 210);
        drawHorizontalLine(g, 410, 330, 190);

        // ขอบหน้าต่างแนวตั้ง
        drawVerticalLine(g, 400, 49, 231); 
        drawVerticalLine(g, 390, 280, 31);
        drawVerticalLine(g, 410, 310, 21);

        // ท้องฟ้า
        drawRectangle(g, 420, 70, 600, 265, MyColor.NIGHTTIME);

        // กรอบแนวนอนท้องฟ้า
        drawHorizontalLine(g, 420, 70, 180);
        drawHorizontalLine(g, 420, 265, 180);

        // กรอบแนวตั้งท้องฟ้า
        drawVerticalLine(g, 419, 70, 197);

        // Monitor Border
        drawRectangle(g, 0, 100, 340, 380, MyColor.MONITOR_BORDER);

        // Shadow Monitor Border
        // drawRectangle(g, 0, 100, 340, 380, MyColor.SHADOW_MONITOR_BORDER);



    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    private void drawRectangle(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        g.setColor(color);
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                plot(g, x, y);
            }
        }
    }

    private void drawHorizontalLine(Graphics g, int x1, int y1, int len) {
        drawRectangle(g, x1, y1, x1 + len, y1 + LINE_WIDTH, MyColor.LINE);
    }

    private void drawVerticalLine(Graphics g, int x1, int y1, int len) {
        drawRectangle(g, x1, y1, x1 + LINE_WIDTH, y1 + len, MyColor.LINE);
    }

    private void drawVerticalLine(Graphics g, int x1, int y1, int len, Color color) {
        drawRectangle(g, x1, y1, x1 + LINE_WIDTH, y1 + len, color);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    private void drawArc(Graphics g, int x, int y, int width, int height, int startAngle, int arcAngle) {
        g.drawArc(x, y, width, height, startAngle, arcAngle);
    }

}
