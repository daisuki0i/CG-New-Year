import java.awt.*;
import javax.swing.*;

class MyColor extends Color {
    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    public static final Color BACKGROUND = Color.decode("#E2998E");
    public static final Color HOUSE_WALL = Color.decode("#BC645C");
    public static final Color WINDOW = Color.decode("#DDA763");
    public static final Color TABLE = Color.decode("#606355");
    public static final Color NIGHTTIME = Color.decode("#13547A");
    public static final Color MONITOR_BORDER = Color.decode("#ACB1B7");
    public static final Color SHADOW_MONITOR_BORDER = Color.decode("#7B7D83");
    public static final Color COMPUTER_MONITOR = Color.decode("#F4E289");
    public static final Color VS_CODE_BACKGROUND = Color.decode("#2C2929");

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

        // พื้นหลัง
        drawRectangle(g, 0, 0, 600, 600, MyColor.BACKGROUND);

        // ลายผนัง
        int lineSpacing = 55;
        for (int x = 35; x < 600; x += lineSpacing) {
            drawVerticalLine(g, x, 0, 600, MyColor.HOUSE_WALL);
        }

        // Table
        drawRectangle(g, 0, 425, 600, 600, MyColor.TABLE); 

        // ขอบ Table
        drawRectangle(g, 0, 423, 600, 425, MyColor.BLACK); 

        // Window Frame
        drawRectangle(g, 405, 50, 600, 280, MyColor.WINDOW); 
        drawRectangle(g, 395, 280, 600, 303, MyColor.WINDOW);
        drawRectangle(g, 412, 300, 600, 314, MyColor.WINDOW);

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
        drawRectangle(g, 419, 63, 600, 268, MyColor.NIGHTTIME);

        // ขอบแนวนอน Sky
        drawHorizontalLine(g, 419, 63, 181);
        drawHorizontalLine(g, 419, 266, 181);

        // ขอบแนวตั้ง Sky
        drawVerticalLine(g, 419, 63, 205);

        // Monitor Border
        drawRectangle(g, 0, 100, 340, 380, MyColor.MONITOR_BORDER);

        // กรอบแนวนอน Monitor Border
        drawHorizontalLine(g, 0, 100, 340);
        drawHorizontalLine(g, 0, 380, 340);

        // ขอบแนวตั้ง Monitor Border
         drawVerticalLine(g, 340, 100, 282);

        // Shadow Monitor Border
        drawRectangle(g, 0, 111, 330, 121, MyColor.SHADOW_MONITOR_BORDER);
        drawRectangle(g, 0, 361, 330, 370, MyColor.SHADOW_MONITOR_BORDER);

        // ขอบแนวนอน Shadow Monitor Border
        drawHorizontalLine(g, 0, 110, 330);
        drawHorizontalLine(g, 0, 119, 330);
        
        drawHorizontalLine(g, 0, 361, 330);
        drawHorizontalLine(g, 0, 369, 330);

        // ขอบแนวตั้ง Shadow Monitor Border
        drawVerticalLine(g, 330, 110, 261);

        // Computer Monitor
        drawRectangle(g, 0, 121, 330, 361, MyColor.COMPUTER_MONITOR);

        // App Window
        drawRectangle(g, 20, 135, 295, 345, MyColor.WHITE);

        // ขอบแนวนอน App Window
        drawHorizontalLine(g, 20, 134, 275);
        drawHorizontalLine(g, 20, 345, 275);

        // ขอบแนวตั้ง App Window
        drawVerticalLine(g, 20, 134, 211);
        drawVerticalLine(g, 295, 134, 213);

        // VS CODE
        drawRectangle(g, 30, 160, 200, 345, MyColor.VS_CODE_BACKGROUND);

        // VS CODE 2
        drawRectangle(g, 205, 160, 285, 345, MyColor.VS_CODE_BACKGROUND);

        // ขอบแนวนอน VS CODE
        drawHorizontalLine(g, 30, 159, 255);

        // ขอบแนวตั้ง VS CODE
        drawVerticalLine(g, 30, 159, 186);
        drawVerticalLine(g, 200, 159, 186);

        // ขอบแนวตั้ง VS CODE 2
        drawVerticalLine(g, 205, 159, 186);
        drawVerticalLine(g, 285, 159, 186);




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
