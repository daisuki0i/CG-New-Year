import java.awt.*;
import javax.swing.*;

class MyColor extends Color {
    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    public static final Color WINDOW = new Color(236, 186, 88);
    public static final Color BACKGROUND = new Color(235, 223, 171);
    public static final Color TABLE = new Color(87, 66, 65);
    public static final Color NIGHTTIME = new Color(19, 84, 122);
    public static final Color LINE = BLACK;
}

public class NewYear extends JPanel {
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

        drawRectangle(g, 0, 425, 600, 600, MyColor.TABLE); // โต๊ะ
        drawRectangle(g, 0, 423, 600, 425, MyColor.BLACK); // ขอบโต๊ะ

        drawRectangle(g, 400, 50, 600, 250, MyColor.WINDOW); // หน้าต่าง
        drawRectangle(g, 390, 250, 600, 280, MyColor.WINDOW);
        drawRectangle(g, 410, 280, 600, 290, MyColor.WINDOW);

        drawHorizontalLine(g, 400, 49, 200); // ขอบหน้าต่างแนวนอน
        drawHorizontalLine(g, 390, 250, 210);
        drawHorizontalLine(g, 390, 280, 210);
        drawHorizontalLine(g, 410, 290, 190);

        drawVerticalLine(g, 400, 49, 201); // ขอบหน้าต่างแนวตั้ง
        drawVerticalLine(g, 390, 250, 31);
        drawVerticalLine(g, 410, 280, 11);

        drawRectangle(g, 420, 70, 600, 235, MyColor.NIGHTTIME);

        drawHorizontalLine(g, 420, 70, 180);
        drawHorizontalLine(g, 420, 235, 180);

        drawVerticalLine(g, 419, 70, 167);

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
        drawRectangle(g, x1, y1, x1 + len, y1 + 2, MyColor.LINE);
    }

    private void drawVerticalLine(Graphics g, int x1, int y1, int len) {
        drawRectangle(g, x1, y1, x1 + 2, y1 + len, MyColor.LINE);
    }
}
