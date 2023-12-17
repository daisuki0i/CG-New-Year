package experiments;

import javax.swing.*;
import java.awt.*;

public class GradientBackgroundExample extends JFrame {

    public GradientBackgroundExample() {
        setTitle("Gradient Background Example");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GradientPanel gradientPanel = new GradientPanel();
        add(gradientPanel);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GradientBackgroundExample().setVisible(true);
        });
    }
}

class GradientPanel extends JPanel {

    private Color[] gradientColors = {
            new Color(0x363183),
            new Color(0x3B3386),
            new Color(0x3F3583),
            new Color(0x4A3486),
            new Color(0x523784),
            new Color(0x663E85),
            new Color(0x744388)
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Create a gradient paint
        GradientPaint gradientPaint = new GradientPaint(0, 0, gradientColors[0], 0, 400, gradientColors[gradientColors.length - 1]);

        // Set the paint to the graphics context
        g2d.setPaint(gradientPaint);

        // Fill the background with the gradient
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();
    }
}

