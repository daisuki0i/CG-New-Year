package experiments;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class SlightlyCurved extends JFrame {

    public SlightlyCurved() {
        setTitle("Slightly Curved");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel curvePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSlightlyCurved(g);
            }
        };

        add(curvePanel);
    }

    private void drawSlightlyCurved(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // วาดเส้นโค้ง
        int x1 = 0;
        int y1 = height / 2;
        int ctrlX = width / 2;
        int ctrlY = height / 2 - 20;  // สูงสุดของเส้นโค้ง
        int x2 = width;
        int y2 = height / 2;

        QuadCurve2D curve = new QuadCurve2D.Float(x1, y1, ctrlX, ctrlY, x2, y2);

        // ตั้งค่าสีและวาดเส้นโค้ง
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(curve);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SlightlyCurved slightlyCurved = new SlightlyCurved();
            slightlyCurved.setVisible(true);
        });
    }
}


