import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SmoothGradientBackgroundExample extends JFrame {

    private Color[] gradientColors = {
            new Color(0x363183),
            new Color(0x3B3386),
            new Color(0x3F3583),
            new Color(0x4A3486),
            new Color(0x523784),
            new Color(0x663E85),
            new Color(0x744388)
    };

    public SmoothGradientBackgroundExample() {
        setTitle("Smooth Gradient Background Example");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            float ratio = (float) y / (height - 1);

            Color blendedColor = lerpColors(gradientColors, ratio);
            g.setColor(blendedColor);

            g.drawLine(0, y, width, y);
        }
    }

    private Color lerpColors(Color[] colors, float ratio) {
        int[] rgbValues = new int[3];

        for (int i = 0; i < 3; i++) {
            float start = (float) colors[0].getRGBColorComponents(null)[i];
            System.out.println(Arrays.toString(colors[0].getRGBColorComponents(null)));
            float end = (float) colors[colors.length - 1].getRGBColorComponents(null)[i];

            float result = start + ratio * (end - start);
            rgbValues[i] = (int) (result * 255);
        }

        return new Color(rgbValues[0], rgbValues[1], rgbValues[2]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SmoothGradientBackgroundExample().setVisible(true);
        });
    }
}
