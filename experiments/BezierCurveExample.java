package experiments;
import javax.swing.*;
import java.awt.*;

public class BezierCurveExample extends JFrame {

    public BezierCurveExample() {
        super("Bezier Curve Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int x1 = 400;
        int y1 = 300;
        int x2 = 0;
        int y2 = 250;

        int ctrlX = x1 + 100; // Adjust this value for curvature
        int ctrlY = y1 - 20; // Adjust this value for curvature

        drawBezierCurve(g, x1, y1, ctrlX, ctrlY, x2, y2, 2); // Adjust thickness here
    }

    private void drawBezierCurve(Graphics g, int x1, int y1, int ctrlX, int ctrlY, int x2, int y2, int thickness) {
        int resolution = 500;

        for (int t = 0; t <= resolution; t++) {
            float u = t / (float) resolution;
            float uComp = 1 - u;

            int x = (int) (uComp * uComp * x1 + 2 * uComp * u * ctrlX + u * u * x2);
            int y = (int) (uComp * uComp * y1 + 2 * uComp * u * ctrlY + u * u * y2);

            drawHorizontalLine(g, x, y, thickness, thickness);
        }
    }

    private void plot(Graphics g, int x, int y, int thickness) {
        int halfThickness = thickness / 2;

        for (int i = -halfThickness; i <= halfThickness; i++) {
            for (int j = -halfThickness; j <= halfThickness; j++) {
                plot(g, x + i, y + j);
            }
        }
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

    private void drawHorizontalLine(Graphics g, int x1, int y1, int width, int len) {
        drawRectangle(g, x1, y1, x1 + len, y1 + width);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BezierCurveExample());
    }
}
