import java.awt.*;
import javax.swing.*;

public class NewYear extends JPanel {
    final Color MIDNIGHT_BLUE = new Color(54, 69, 79);
    final Color BACKGROUND = new Color(96, 130, 182);
    final Color CAMEL = new Color(193, 154, 107);

    public static void main(String[] args) {
        NewYear n = new NewYear();

        JFrame f = new JFrame();
        f.add(n);
        f.setTitle("NewYear");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null); // หน้าต่างอยู่ตรงกลาง
    }

    public void paintComponent(Graphics g) {
        g.setColor(BACKGROUND);
        drawRectangle(g, 0, 0, 600, 600);

        g.setColor(CAMEL);
        drawRectangle(g, 0, 425, 600, 600);

        g.setColor(Color.WHITE);;
        drawRectangle(g, 400, 50, 600, 250);
        drawRectangle(g, 390, 250, 600, 280);
        drawRectangle(g, 410, 280, 600, 290);

        
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    private void drawRectangle(Graphics g, int x1, int y1, int x2, int y2) {
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                plot(g, x, y);
            }
        }
    }
}
