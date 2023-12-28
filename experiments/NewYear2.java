package experiments;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        public static final Color POST_BLUE = Color.decode("#003445");
        public static final Color CREAM = Color.decode("#E8917F");
        public static final Color CHINESE_NEW_YEAR = Color.decode("#ff3073");
        public static final Color BREONNE_BLUE = Color.decode("#2e5b80");
        public static final Color VIOLET_INDIGO = Color.decode("#3d2863");
        public static final Color SUPERIOR_BLUE = Color.decode("#3c5c73");
        public static final Color PRINCE_CHARMING = Color.decode("#cc2179");
        public static final Color AMOR = Color.decode("#eb2d7f");
        public static final Color STRAWBERRY_FRAPPE = Color.decode("#ff9fa1");
        public static final Color ROSE_TURKISH_DELIGHT = Color.decode("#dc5279");
        public static final Color LIMOGES = Color.decode("#26406d");
        public static final Color PASSIONATE_BLUE = Color.decode("#1e3060");
        public static final Color STAR_PURPLE = Color.decode("#9e8ac0");
        public static final Color STAR_CREAM = Color.decode("#f9c7bf");

}

public class NewYear2 extends JPanel {
        final int LINE_WIDTH = 2;

        public static void main(String[] args) {
                NewYear2 n = new NewYear2();
                n.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                                int x = e.getX();
                                int y = e.getY();
                                System.out.println("x: " + x + " y: " + y);
                        }
                });

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

                mainBuffer = drawBuilding(mg, mainBuffer);
                drawElectricPosts(mg);
                mainBuffer = drawRoad(mg, mainBuffer);
                drawBarriers(mg);
                drawBarrierShadow(mg);
                // drawCar(mg);

                mainBuffer = floodFill(mainBuffer, new Point(95, 389), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.ALASKAN_CRUISE); // ถนน

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

                int[] xPoints = new int[] { 5, 25, 45, 65, 85, 105, 110, 135, 160, 185, 210, 235, 265, 295, 325, 355,
                                405, 455,
                                505 };
                for (int i = 0; i < xPoints.length; i++) {
                        mainBuffer = floodFill(mainBuffer, new Point(xPoints[i], 335),
                                        MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                        MyColor.SASQUATCH_SOCKS);
                }
                mainBuffer = floodFill(mainBuffer, new Point(555, 350), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.SASQUATCH_SOCKS);

                // ราวรั้วบน
                mainBuffer = floodFill(mainBuffer, new Point(5, 285), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.SASQUATCH_SOCKS);
                mainBuffer = floodFill(mainBuffer, new Point(5, 288), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.ANTARCTIC_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(450, 322), MyColor.CHINESE_NEW_YEAR,
                                MyColor.ANTARCTIC_BLUE);
                // ราวรั้วล่าง
                mainBuffer = floodFill(mainBuffer, new Point(555, 396), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.ANTARCTIC_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(5, 346), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.SASQUATCH_SOCKS);

                drawCar(mg);
                drawStar(mg);
                g.drawImage(mainBuffer, 0, 0, null);

                plotDebug(g, new Point(322, 281), 2);
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

        private BufferedImage drawRoad(Graphics g, BufferedImage mainBuffer) {
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

                mainBuffer = floodFill(mainBuffer, new Point(450, 420), MyColor.CHINESE_NEW_YEAR,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(590, 420), MyColor.ANTARCTIC_BLUE,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(350, 399), MyColor.PRINCE_CHARMING,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(417, 414), MyColor.PRINCE_CHARMING,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(291, 383), MyColor.LIMOGES,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(181, 379), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(156, 387), MyColor.AMOR,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(237, 377), MyColor.LIMOGES,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(261, 377), MyColor.PRINCE_CHARMING,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(15, 362), MyColor.LIMOGES,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(38, 362), MyColor.PASSIONATE_BLUE,
                                MyColor.ALASKAN_CRUISE);
                mainBuffer = floodFill(mainBuffer, new Point(137, 367), MyColor.PASSIONATE_BLUE,
                                MyColor.ALASKAN_CRUISE);
                return mainBuffer;
        }

        private void drawBarriers(Graphics g) {

                drawArc(g, new Point(0, 342), new Point(150, 347), new Point(600, 364), new Point(750, 479),
                                MyColor.FRIJID_PINK);
                drawArc(g, new Point(0, 340), new Point(150, 342), new Point(600, 360), new Point(750, 470),
                                MyColor.ANTARCTIC_BLUE);

                drawArc(g, new Point(0, 290), new Point(150, 292), new Point(600, 310), new Point(750, 420),
                                MyColor.ANTARCTIC_BLUE);
                drawArc(g, new Point(0, 287), new Point(150, 287), new Point(600, 304), new Point(750, 416),
                                MyColor.FRIJID_PINK);
                drawArc(g, new Point(0, 282), new Point(150, 284), new Point(600, 302), new Point(750, 412),
                                MyColor.FRIJID_PINK);
                // draw barrier
                int[] yPoints = { 340, 340, 340, 340, 340, 340, 340, 341, 341 };
                int xStart = 10;
                int poleWidth = 10;
                for (int i = 0; i < yPoints.length; i++) {
                        drawLine(g, new Point(xStart, yPoints[i]), new Point(xStart, yPoints[i] - 50), 2,
                                        MyColor.FRIJID_PINK);
                        xStart += poleWidth;
                }

                yPoints = new int[] { 342, 342, 343, 343, 344, 345, 346, 347, 348, 349, 350, 351 };
                xStart = 105;
                int stepWidth = 15;
                for (int i = 0; i < yPoints.length; i++) {
                        drawLine(g, new Point(xStart, yPoints[i]), new Point(xStart, yPoints[i] - 50), 2,
                                        MyColor.FRIJID_PINK);
                        xStart = (i % 2 == 0) ? xStart + poleWidth : xStart + stepWidth;
                }

                yPoints = new int[] { 352, 353, 354, 355, 357, 358, 360, 361 };
                xStart = 260;
                stepWidth = 20;
                for (int i = 0; i < yPoints.length; i++) {
                        drawLine(g, new Point(xStart, yPoints[i]), new Point(xStart, yPoints[i] - 50), 2,
                                        MyColor.FRIJID_PINK);
                        xStart = (i % 2 == 0) ? xStart + poleWidth : xStart + stepWidth;
                }

                yPoints = new int[] { 366, 368, 375, 376, 383, 385, 393, 396, 405 };
                xStart = 400;
                stepWidth = 40;
                for (int i = 0; i < yPoints.length; i++) {
                        drawLine(g, new Point(xStart, yPoints[i]), new Point(xStart, yPoints[i] - 50), 2,
                                        MyColor.FRIJID_PINK);
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

                // backwheel
                drawArc(g, new Point(285, 528), new Point(283, 538), new Point(280, 558), new Point(290, 568),
                                MyColor.RED);
                drawArc(g, new Point(290, 568), new Point(295, 583), new Point(315, 565), new Point(317, 550),
                                MyColor.RED);
                drawArc(g, new Point(317, 550), new Point(320, 540), new Point(319, 515), new Point(314, 516),
                                MyColor.RED);
                drawArc(g, new Point(314, 516), new Point(305, 511), new Point(300, 510), new Point(285, 528),
                                MyColor.RED);

                // frontwheel
                drawArc(g, new Point(160, 480), new Point(159, 470), new Point(158, 455), new Point(155, 452),
                                MyColor.RED);
                drawArc(g, new Point(155, 452), new Point(147, 447), new Point(130, 457), new Point(133, 480),
                                MyColor.RED);
                drawArc(g, new Point(133, 480), new Point(134, 483), new Point(132, 493), new Point(155, 491),
                                MyColor.RED);
                drawArc(g, new Point(155, 491), new Point(160, 490), new Point(160, 480), new Point(159, 470),
                                MyColor.RED);

                // body
                drawLine(g, new Point(175, 452), new Point(335, 508), MyColor.RED); // เส้นตรง1 ก่อนถึงล้อหลัง
                drawLine(g, new Point(175, 467), new Point(335, 522), MyColor.RED); // เส้นตรง2 ก่อนถึงล้อหลัง
                drawLine(g, new Point(160, 478), new Point(340, 539), MyColor.RED); // เส้นตรง3 ก่อนถึงล้อหลัง
                drawLine(g, new Point(155, 485), new Point(350, 555), MyColor.RED); // เส้นตรง4 ก่อนถึงล้อหลัง
                drawArc(g, new Point(335, 508), new Point(345, 510), new Point(350, 514), new Point(370, 512), 1,
                                MyColor.RED); // เส้นโค้ง1
                                              // บริเวณล้อรถ
                drawArc(g, new Point(335, 522), new Point(345, 524), new Point(350, 528), new Point(370, 526), 1,
                                MyColor.RED); // เส้นโค้ง2
                                              // บริเวณล้อรถ
                drawArc(g, new Point(340, 539), new Point(350, 541), new Point(355, 545), new Point(375, 543), 1,
                                MyColor.RED); // เส้นโค้ง3
                                              // บริเวณล้อรถ
                drawArc(g, new Point(350, 555), new Point(360, 557), new Point(365, 561), new Point(385, 559),
                                MyColor.RED); // เส้นโค้ง4
                                              // บริเวณล้อรถ
                drawLine(g, new Point(370, 512), new Point(505, 500), MyColor.RED); // เส้นตรง1 หลังล้อหลัง
                drawLine(g, new Point(370, 526), new Point(510, 515), MyColor.RED); // เส้นตรง2 หลังล้อหลัง
                drawLine(g, new Point(375, 543), new Point(500, 535), MyColor.RED); // เส้นตรง3 หลังล้อหลัง
                drawLine(g, new Point(385, 559), new Point(495, 550), MyColor.RED); // เส้นตรง4 หลังล้อหลัง
                drawArc(g, new Point(505, 500), new Point(508, 490), new Point(508, 485), new Point(515, 515),
                                MyColor.RED); // เส้นโค้งของเส้นที่
                                              // 1กับ2
                                              // เชื่อมกันตรงท้ายรถ
                drawArc(g, new Point(500, 535), new Point(520, 525), new Point(515, 515), new Point(510, 515),
                                MyColor.RED); // เส้นโค้งของเส้นที่
                                              // 2กับ3
                                              // เชื่อมกันตรงท้ายรถ
                drawLine(g, new Point(495, 550), new Point(510, 530), MyColor.RED); // เส้นตรงของเส้นที่ 3กับ4
                                                                                    // เชื่อมกันตรงท้ายรถ

                drawArc(g, new Point(175, 467), new Point(165, 450), new Point(140, 420), new Point(132, 465),
                                MyColor.RED);
                drawArc(g, new Point(175, 452), new Point(160, 435), new Point(135, 405), new Point(132, 465),
                                MyColor.RED);

                drawArc(g, new Point(283, 532), new Point(289, 490), new Point(310, 520), new Point(319, 542), 1,
                                MyColor.RED);

                // car structure
                drawLine(g, new Point(132, 450), new Point(132, 420), MyColor.RED);
                drawArc(g, new Point(132, 420), new Point(135, 410), new Point(143, 405), new Point(160, 400), 1,
                                MyColor.RED);
                drawLine(g, new Point(160, 400), new Point(200, 380), MyColor.RED);
                drawArc(g, new Point(200, 380), new Point(210, 375), new Point(220, 370), new Point(240, 370), 1,
                                MyColor.RED);
                drawLine(g, new Point(240, 370), new Point(310, 380), MyColor.RED);
                drawArc(g, new Point(310, 380), new Point(320, 385), new Point(330, 390), new Point(355, 450), 1,
                                MyColor.RED);
                drawArc(g, new Point(355, 450), new Point(360, 460), new Point(360, 470), new Point(360, 512), 1,
                                MyColor.RED);
                drawLine(g, new Point(215, 372), new Point(290, 352), MyColor.RED);
                drawArc(g, new Point(290, 352), new Point(300, 350), new Point(310, 350), new Point(313, 350), 1,
                                MyColor.RED);
                drawLine(g, new Point(313, 350), new Point(445, 370), MyColor.RED);
                drawArc(g, new Point(445, 370), new Point(470, 385), new Point(480, 390), new Point(505, 450), 1,
                                MyColor.RED);
                drawArc(g, new Point(505, 450), new Point(510, 460), new Point(510, 470), new Point(510, 495), 1,
                                MyColor.RED);
                drawLine(g, new Point(310, 380), new Point(452, 375), MyColor.RED);

                // ท้ายรถ
                drawLine(g, new Point(360, 470), new Point(507, 460), MyColor.RED);
                drawLine(g, new Point(420, 475), new Point(450, 473), MyColor.RED);
                drawArc(g, new Point(420, 475), new Point(418, 477), new Point(416, 477), new Point(415, 480), 1,
                                MyColor.RED);
                drawLine(g, new Point(415, 480), new Point(415, 490), MyColor.RED);
                drawArc(g, new Point(415, 490), new Point(416, 493), new Point(419, 493), new Point(420, 495), 1,
                                MyColor.RED);
                drawLine(g, new Point(420, 495), new Point(450, 493), MyColor.RED);
                drawArc(g, new Point(450, 493), new Point(453, 490), new Point(454, 490), new Point(455, 487), 1,
                                MyColor.RED);
                drawLine(g, new Point(455, 477), new Point(455, 487), MyColor.RED);
                drawArc(g, new Point(455, 477), new Point(453, 476), new Point(452, 474), new Point(450, 473), 1,
                                MyColor.RED);

                drawLine(g, new Point(360, 480), new Point(393, 478), MyColor.RED);
                drawArc(g, new Point(393, 478), new Point(397, 480), new Point(398, 480), new Point(400, 482), 1,
                                MyColor.RED);
                drawLine(g, new Point(400, 482), new Point(400, 493), MyColor.RED);
                drawArc(g, new Point(400, 493), new Point(398, 496), new Point(397, 496), new Point(393, 498), 1,
                                MyColor.RED);
                drawLine(g, new Point(360, 500), new Point(393, 498), MyColor.RED);

                drawLine(g, new Point(474, 472), new Point(507, 470), MyColor.RED);
                drawArc(g, new Point(474, 472), new Point(472, 473), new Point(470, 473), new Point(467, 476), 1,
                                MyColor.RED);
                drawLine(g, new Point(467, 476), new Point(467, 489), MyColor.RED);
                drawArc(g, new Point(467, 489), new Point(468, 492), new Point(470, 493), new Point(474, 492), 1,
                                MyColor.RED);
                drawLine(g, new Point(474, 492), new Point(507, 490), MyColor.RED);
        }

        private void drawElectricPosts(Graphics g) {
                // electric wire 1
                drawArc(g, new Point(530, 125), new Point(533, 149), new Point(629, 179), new Point(665, 143), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(300, 170), new Point(380, 210), new Point(480, 160), new Point(530, 125), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(90, 200), new Point(220, 240), new Point(290, 200), new Point(300, 170), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(0, 250), new Point(40, 260), new Point(85, 220), new Point(90, 200), 2,
                                MyColor.POST_BLUE);

                // electric wire 2
                drawArc(g, new Point(500, 125), new Point(503, 149), new Point(599, 179), new Point(635, 160), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(280, 170), new Point(360, 210), new Point(460, 160), new Point(510, 125), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(80, 200), new Point(210, 240), new Point(280, 200), new Point(290, 170), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(0, 252), new Point(40, 260), new Point(85, 210), new Point(80, 200), 2,
                                MyColor.POST_BLUE);

                // electric wire 3
                drawArc(g, new Point(460, 245), new Point(490, 260), new Point(559, 280), new Point(600, 280), 2,
                                MyColor.POST_BLUE);

                // electric wire 4
                drawArc(g, new Point(460, 245), new Point(490, 250), new Point(565, 265), new Point(600, 260), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(265, 225), new Point(290, 240), new Point(365, 280), new Point(460, 245), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(65, 255), new Point(120, 280), new Point(220, 255), new Point(265, 225), 2,
                                MyColor.POST_BLUE);
                drawArc(g, new Point(0, 280), new Point(20, 280), new Point(50, 265), new Point(65, 255), 2,
                                MyColor.POST_BLUE);

                // 1st post
                drawLine(g, new Point(460 - 3, 375), new Point(460 - 3, 125), 5, MyColor.CREAM);
                drawLine(g, new Point(455 - 3, 160), new Point(455 - 3, 140), 15, MyColor.CREAM);
                drawLine(g, new Point(455 - 3, 250), new Point(455 - 3, 230), 15, MyColor.CREAM);
                drawLine(g, new Point(460, 375), new Point(460, 125), 5, MyColor.POST_BLUE);
                drawLine(g, new Point(455, 160), new Point(455, 140), 15, MyColor.POST_BLUE);
                drawLine(g, new Point(455, 250), new Point(455, 230), 15, MyColor.POST_BLUE);
                drawLine(g, new Point(460, 122), new Point(530, 122), 3, MyColor.CREAM);
                drawLine(g, new Point(530, 125), new Point(530, 130), 3, MyColor.CREAM);
                drawLine(g, new Point(500, 125), new Point(500, 130), 3, MyColor.CREAM);

                // 2nd post
                drawLine(g, new Point(263 - 2, 292), new Point(263 - 2, 170), 3, MyColor.CREAM);
                drawLine(g, new Point(260 - 2, 190), new Point(260 - 2, 180), 9, MyColor.CREAM);
                drawLine(g, new Point(260 - 2, 225), new Point(260 - 2, 220), 12, MyColor.CREAM);
                drawLine(g, new Point(260 - 2, 272), new Point(260 - 2, 260), 15, MyColor.CREAM);
                drawLine(g, new Point(263, 292), new Point(263, 170), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(260, 190), new Point(260, 180), 9, MyColor.POST_BLUE);
                drawLine(g, new Point(260, 225), new Point(260, 220), 12, MyColor.POST_BLUE);
                drawLine(g, new Point(260, 272), new Point(260, 260), 15, MyColor.POST_BLUE);
                drawLine(g, new Point(263, 168), new Point(300, 168), 2, MyColor.CREAM);
                drawLine(g, new Point(300, 170), new Point(300, 172), 2, MyColor.CREAM);
                drawLine(g, new Point(280, 170), new Point(280, 172), 2, MyColor.CREAM);

                // 3rd post
                drawLine(g, new Point(65 - 1, 280), new Point(65 - 1, 200), 2, MyColor.CREAM);
                drawLine(g, new Point(65, 280), new Point(65, 200), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(65, 199), new Point(90, 199), 1, MyColor.CREAM);
                drawLine(g, new Point(90, 200), new Point(90, 202), 1, MyColor.CREAM);
                drawLine(g, new Point(80, 200), new Point(80, 202), 1, MyColor.CREAM);
        }

        private BufferedImage drawBuilding(Graphics g, BufferedImage mainBuffer) {
                drawLine(g, new Point(585, 180), new Point(600, 180), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(585, 180), new Point(585, 430), 2, MyColor.ANTARCTIC_BLUE);
                drawLine(g, new Point(585, 430), new Point(600, 430), 2, MyColor.ANTARCTIC_BLUE);
                drawLine(g, new Point(590, 37), new Point(600, 37), 2, MyColor.BREONNE_BLUE);
                Polygon poly = new Polygon();
                poly.addPoint(585, 183);
                poly.addPoint(500, 37);
                poly.addPoint(590, 37);
                g.fillPolygon(poly);
                drawLine(g, new Point(500, 37), new Point(447, 48), 2, MyColor.CHINESE_NEW_YEAR);
                drawLine(g, new Point(447, 48), new Point(447, 430), 2, MyColor.CHINESE_NEW_YEAR);
                drawLine(g, new Point(447, 430), new Point(585, 430), 2, MyColor.CHINESE_NEW_YEAR);
                drawLine(g, new Point(538, 95), new Point(447, 115), 2, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(535, 95), new Point(600, 95), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(585, 180), new Point(447, 197), 2, MyColor.SUPERIOR_BLUE); //
                drawLine(g, new Point(585, 265), new Point(447, 282), 2, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(585, 265), new Point(600, 265), 2, MyColor.POST_BLUE);
                // รั้วบนตึก
                drawLine(g, new Point(565, 22), new Point(600, 22), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(565, 22), new Point(565, 35), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(575, 22), new Point(575, 35), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(585, 22), new Point(585, 35), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(595, 22), new Point(595, 35), 2, MyColor.POST_BLUE);
                // เส้นขอบหน้าต่าง
                drawLine(g, new Point(536, 60), new Point(565, 60), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(553, 90), new Point(585, 90), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(534, 60), new Point(553, 90), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(565, 60), new Point(585, 88), 4, MyColor.POST_BLUE);
                // เส้นหน้าต่าง
                drawLine(g, new Point(540, 64), new Point(564, 64), 2, MyColor.CHINESE_NEW_YEAR);
                drawLine(g, new Point(554, 88), new Point(581, 88), 2, MyColor.CHINESE_NEW_YEAR);
                drawLine(g, new Point(539, 64), new Point(554, 88), 2, MyColor.CHINESE_NEW_YEAR);
                drawLine(g, new Point(564, 64), new Point(582, 88), 2, MyColor.CHINESE_NEW_YEAR);
                drawLine(g, new Point(549, 75), new Point(570, 75), 4, MyColor.CHINESE_NEW_YEAR);
                // หน้าต่างบานที่2 ขวา
                drawLine(g, new Point(585, 125), new Point(600, 125), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(585, 125), new Point(600, 159), 2, MyColor.POST_BLUE);
                g.setColor(MyColor.CHINESE_NEW_YEAR);
                Polygon poly1 = new Polygon();
                poly1.addPoint(580, 137);
                poly1.addPoint(600, 137);
                poly1.addPoint(600, 172);
                g.fillPolygon(poly1);

                // building
                mainBuffer = floodFill(mainBuffer, new Point(500, 58), MyColor.BACKGROUND_GRADIENT_COLOR[1],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(595, 60), MyColor.BACKGROUND_GRADIENT_COLOR[1],
                                MyColor.BREONNE_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(595, 89), MyColor.BACKGROUND_GRADIENT_COLOR[2],
                                MyColor.BREONNE_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(500, 98), MyColor.BACKGROUND_GRADIENT_COLOR[2],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(500, 118), MyColor.BACKGROUND_GRADIENT_COLOR[2],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(595, 118), MyColor.BACKGROUND_GRADIENT_COLOR[2],
                                MyColor.BREONNE_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(595, 122), MyColor.BACKGROUND_GRADIENT_COLOR[3],
                                MyColor.BREONNE_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(500, 120), MyColor.BACKGROUND_GRADIENT_COLOR[3],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(500, 138), MyColor.BACKGROUND_GRADIENT_COLOR[3],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(500, 158), MyColor.BACKGROUND_GRADIENT_COLOR[3],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(500, 178), MyColor.BACKGROUND_GRADIENT_COLOR[4],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(449, 161), MyColor.BACKGROUND_GRADIENT_COLOR[4],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(449, 190), MyColor.BACKGROUND_GRADIENT_COLOR[4],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(500, 195), MyColor.BACKGROUND_GRADIENT_COLOR[4],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(595, 170), MyColor.BACKGROUND_GRADIENT_COLOR[4],
                                MyColor.BREONNE_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(595, 197), MyColor.BACKGROUND_GRADIENT_COLOR[4],
                                MyColor.ANTARCTIC_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(500, 215), MyColor.BACKGROUND_GRADIENT_COLOR[5],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(449, 200), MyColor.BACKGROUND_GRADIENT_COLOR[5],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(595, 230), MyColor.BACKGROUND_GRADIENT_COLOR[5],
                                MyColor.ANTARCTIC_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(595, 240), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.ANTARCTIC_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(500, 250), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(449, 240), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(449, 300), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(500, 320), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(595, 300), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.ANTARCTIC_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(595, 380), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.ANTARCTIC_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(570, 380), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(530, 380), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(490, 380), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(555, 80), MyColor.BREONNE_BLUE,
                                MyColor.VIOLET_INDIGO);
                mainBuffer = floodFill(mainBuffer, new Point(555, 70), MyColor.BREONNE_BLUE,
                                MyColor.VIOLET_INDIGO);
                // หน้าต่างด้านหน้าชั้น2
                drawLine(g, new Point(467, 210), new Point(467, 270), 4, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(571, 195), new Point(571, 255), 2, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(467, 210), new Point(569, 195), 4, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(468, 270), new Point(569, 257), 2, MyColor.SUPERIOR_BLUE);
                // ด้านในหน้าต่างบาน1
                drawLine(g, new Point(475, 220), new Point(475, 260), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(500, 217), new Point(500, 258), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(475, 220), new Point(500, 217), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(475, 260), new Point(500, 257), 4, MyColor.VIOLET_INDIGO);
                // ด้านในหน้าต่างบาน2
                drawLine(g, new Point(510, 216), new Point(510, 255), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(535, 213), new Point(535, 252), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(510, 216), new Point(535, 213), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(510, 255), new Point(535, 252), 4, MyColor.VIOLET_INDIGO);
                // ด้านในหน้าต่างบาน3
                drawLine(g, new Point(545, 210), new Point(545, 250), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(565, 207), new Point(565, 247), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(545, 210), new Point(565, 207), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(545, 250), new Point(565, 247), 4, MyColor.VIOLET_INDIGO);
                // หน้าต่างด้านหน้าชั้น3
                drawLine(g, new Point(466, 130), new Point(466, 180), 4, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(530, 116), new Point(560, 170), 2, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(466, 130), new Point(530, 115), 4, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(467, 182), new Point(560, 170), 2, MyColor.SUPERIOR_BLUE);
                // ด้านในหน้าต่างบาน1
                drawLine(g, new Point(473, 138), new Point(473, 172), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(500, 135), new Point(500, 169), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(473, 138), new Point(500, 133), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(473, 172), new Point(500, 169), 4, MyColor.VIOLET_INDIGO);
                // ด้านในหน้าต่างบาน2
                drawLine(g, new Point(509, 133), new Point(510, 167), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(528, 130), new Point(547, 164), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(510, 133), new Point(526, 129), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(510, 167), new Point(545, 163), 4, MyColor.VIOLET_INDIGO);
                // หน้าต่างด้านหน้าชั้น1
                drawLine(g, new Point(466, 300), new Point(466, 355), 4, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(573, 292), new Point(573, 353), 2, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(466, 300), new Point(570, 290), 4, MyColor.SUPERIOR_BLUE);
                drawLine(g, new Point(466, 357), new Point(572, 353), 2, MyColor.SUPERIOR_BLUE);
                // ด้านในหน้าต่างบาน1
                drawLine(g, new Point(473, 310), new Point(473, 350), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(500, 308), new Point(500, 347), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(473, 310), new Point(500, 307), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(473, 350), new Point(500, 348), 4, MyColor.VIOLET_INDIGO);
                // ด้านในหน้าต่างบาน2
                drawLine(g, new Point(509, 307), new Point(509, 347), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(535, 304), new Point(535, 344), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(509, 307), new Point(535, 304), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(509, 347), new Point(535, 345), 4, MyColor.VIOLET_INDIGO);
                // ด้านในหน้าต่างบาน3
                drawLine(g, new Point(545, 305), new Point(545, 345), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(565, 302), new Point(565, 341), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(545, 305), new Point(565, 302), 4, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(545, 345), new Point(565, 343), 4, MyColor.VIOLET_INDIGO);
                mainBuffer = floodFill(mainBuffer, new Point(490, 160), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(490, 250), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(490, 320), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(490, 340), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(530, 160), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(530, 250), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(530, 320), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(530, 340), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(560, 220), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(560, 320), MyColor.CHINESE_NEW_YEAR,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(590, 129), MyColor.BACKGROUND_GRADIENT_COLOR[3],
                                MyColor.VIOLET_INDIGO);
                mainBuffer = floodFill(mainBuffer, new Point(587, 155), MyColor.BACKGROUND_GRADIENT_COLOR[3],
                                MyColor.BREONNE_BLUE);

                drawLine(g, new Point(477, 42), new Point(477, 63), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(479, 42), new Point(479, 63), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(470, 65), new Point(484, 61), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(470, 65), new Point(470, 75), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(484, 61), new Point(484, 71), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(470, 75), new Point(484, 71), 2, MyColor.ROSE_TURKISH_DELIGHT);
                mainBuffer = floodFill(mainBuffer, new Point(478, 72), MyColor.CHINESE_NEW_YEAR,
                                MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(479, 61), new Point(484, 60), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(486, 60), new Point(486, 71), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(486, 71), new Point(471, 74), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(455, 47), new Point(455, 380), 4, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(458, 47), new Point(458, 380), 2, MyColor.POST_BLUE);
                // ตึก2
                drawLine(g, new Point(445, 80), new Point(445, 430), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(445, 80), new Point(370, 91), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(370, 91), new Point(370, 115), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(370, 115), new Point(285, 126), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(285, 126), new Point(290, 430), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(290, 430), new Point(445, 430), 2, MyColor.PRINCE_CHARMING);
                mainBuffer = floodFill(mainBuffer, new Point(403, 99), MyColor.BACKGROUND_GRADIENT_COLOR[2],
                                MyColor.PRINCE_CHARMING);
                mainBuffer = floodFill(mainBuffer, new Point(407, 146), MyColor.BACKGROUND_GRADIENT_COLOR[3],
                                MyColor.PRINCE_CHARMING);
                mainBuffer = floodFill(mainBuffer, new Point(373, 186), MyColor.BACKGROUND_GRADIENT_COLOR[4],
                                MyColor.PRINCE_CHARMING);
                mainBuffer = floodFill(mainBuffer, new Point(416, 222), MyColor.BACKGROUND_GRADIENT_COLOR[5],
                                MyColor.PRINCE_CHARMING);
                mainBuffer = floodFill(mainBuffer, new Point(347, 270), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.PRINCE_CHARMING);

                int startX = 430;
                int startY = 85;
                int endY = 370;
                int rectWidth = 6;
                int rectHeight = 6;

                for (int x = startX; x <= 440; x += 10) {
                        for (int y = startY; y <= endY; y += 10) {
                                fillRect(g, x, y, rectWidth, rectHeight, MyColor.AMOR);
                        }
                }

                drawLine(g, new Point(404, 22), new Point(404, 84), 4, MyColor.CREAM);
                drawLine(g, new Point(400, 42), new Point(395, 42), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 38), new Point(395, 48), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(391, 38), new Point(391, 48), 4, MyColor.CREAM);
                drawLine(g, new Point(408, 54), new Point(413, 54), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(417, 51), new Point(417, 59), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(421, 51), new Point(421, 59), 4, MyColor.CREAM);
                drawLine(g, new Point(445, 120), new Point(400, 125), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(400, 125), new Point(400, 90), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(398, 125), new Point(398, 90), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(445, 123), new Point(400, 128), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(381, 89), new Point(381, 370), 4, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(385, 90), new Point(385, 370), 3, MyColor.POST_BLUE);

                drawLine(g, new Point(398, 145), new Point(422, 143), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 151), new Point(422, 149), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 151), new Point(401, 170), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 147), new Point(395, 175), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 170), new Point(422, 168), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(422, 145), new Point(422, 173), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 175), new Point(422, 173), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 200), new Point(422, 198), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 200), new Point(401, 220), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 196), new Point(395, 225), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 220), new Point(422, 218), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(422, 196), new Point(422, 224), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 225), new Point(422, 223), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 196), new Point(422, 194), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 250), new Point(422, 248), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 250), new Point(401, 270), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 246), new Point(395, 275), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 270), new Point(422, 268), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(422, 246), new Point(422, 274), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 275), new Point(422, 273), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 246), new Point(422, 244), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 300), new Point(422, 298), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 300), new Point(401, 320), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 296), new Point(395, 325), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 320), new Point(422, 318), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(422, 296), new Point(422, 324), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 325), new Point(422, 323), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 296), new Point(422, 294), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 350), new Point(422, 348), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 350), new Point(401, 370), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 346), new Point(395, 375), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(401, 370), new Point(422, 368), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(422, 346), new Point(422, 374), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 375), new Point(422, 373), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(395, 346), new Point(422, 344), 3, MyColor.POST_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(399, 153), MyColor.PRINCE_CHARMING,
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(412, 161), MyColor.PRINCE_CHARMING,
                                MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(400, 211), MyColor.PRINCE_CHARMING,
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(412, 211), MyColor.PRINCE_CHARMING, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(400, 261), MyColor.PRINCE_CHARMING,
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(412, 261), MyColor.PRINCE_CHARMING, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(400, 311), MyColor.PRINCE_CHARMING,
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(412, 311), MyColor.PRINCE_CHARMING, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(400, 361), MyColor.PRINCE_CHARMING,
                                MyColor.CHINESE_NEW_YEAR);
                mainBuffer = floodFill(mainBuffer, new Point(412, 361), MyColor.PRINCE_CHARMING, MyColor.CREAM);
                drawLine(g, new Point(284, 104), new Point(285, 159), 3, MyColor.AMOR);
                drawLine(g, new Point(284, 104), new Point(368, 96), 3, MyColor.AMOR);
                drawLine(g, new Point(359, 154), new Point(359, 100), 3, MyColor.AMOR);
                drawLine(g, new Point(284, 161), new Point(361, 154), 3, MyColor.BREONNE_BLUE);
                drawLine(g, new Point(361, 99), new Point(369, 99), 3, MyColor.BREONNE_BLUE);
                drawLine(g, new Point(361, 99), new Point(361, 154), 3, MyColor.BREONNE_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(322, 133), MyColor.PRINCE_CHARMING, MyColor.AMOR);
                mainBuffer = floodFill(mainBuffer, new Point(293, 122), MyColor.BACKGROUND_GRADIENT_COLOR[3],
                                MyColor.AMOR);
                mainBuffer = floodFill(mainBuffer, new Point(293, 117), MyColor.BACKGROUND_GRADIENT_COLOR[2],
                                MyColor.AMOR);
                // Japanese
                fillRect(g, 290, 142, 10, 10, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(296, 115), new Point(320, 113), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(296, 115), new Point(296, 120), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(296, 121), new Point(306, 120), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(306, 120), new Point(306, 149), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(306, 149), new Point(311, 149), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(311, 149), new Point(320, 146), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(320, 146), new Point(320, 139), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(320, 139), new Point(315, 139), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(315, 139), new Point(315, 142), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(315, 142), new Point(311, 142), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(311, 142), new Point(311, 120), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(311, 120), new Point(316, 120), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(316, 120), new Point(320, 113), 2, MyColor.STRAWBERRY_FRAPPE);
                mainBuffer = floodFill(mainBuffer, new Point(310, 121), MyColor.AMOR, MyColor.STRAWBERRY_FRAPPE);
                mainBuffer = floodFill(mainBuffer, new Point(367, 110), MyColor.BACKGROUND_GRADIENT_COLOR[2],
                                MyColor.BREONNE_BLUE);
                drawLine(g, new Point(327, 113), new Point(347, 111), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(347, 111), new Point(346, 143), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(346, 143), new Point(335, 149), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(335, 149), new Point(328, 149), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(328, 149), new Point(328, 138), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(328, 138), new Point(334, 138), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(334, 138), new Point(334, 141), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(334, 141), new Point(336, 141), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(336, 141), new Point(341, 139), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(341, 139), new Point(341, 120), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(341, 120), new Point(332, 120), 2, MyColor.STRAWBERRY_FRAPPE);
                drawLine(g, new Point(332, 120), new Point(327, 113), 2, MyColor.STRAWBERRY_FRAPPE);
                mainBuffer = floodFill(mainBuffer, new Point(342, 119), MyColor.AMOR, MyColor.STRAWBERRY_FRAPPE);

                // บันได
                drawLine(g, new Point(286, 185), new Point(315, 185), 1, MyColor.AMOR);
                drawLine(g, new Point(315, 185), new Point(315, 189), 1, MyColor.AMOR);
                drawLine(g, new Point(315, 189), new Point(315, 192), 1, MyColor.AMOR);
                drawLine(g, new Point(315, 192), new Point(319, 192), 1, MyColor.AMOR);
                drawLine(g, new Point(319, 192), new Point(319, 196), 1, MyColor.AMOR);
                drawLine(g, new Point(319, 196), new Point(323, 196), 1, MyColor.AMOR);
                drawLine(g, new Point(323, 196), new Point(323, 200), 1, MyColor.AMOR);
                drawLine(g, new Point(323, 200), new Point(327, 200), 1, MyColor.AMOR);
                drawLine(g, new Point(327, 200), new Point(327, 204), 1, MyColor.AMOR);
                drawLine(g, new Point(327, 204), new Point(331, 204), 1, MyColor.AMOR);
                drawLine(g, new Point(331, 204), new Point(331, 208), 1, MyColor.AMOR);
                drawLine(g, new Point(331, 208), new Point(335, 208), 1, MyColor.AMOR);
                drawLine(g, new Point(335, 208), new Point(335, 212), 1, MyColor.AMOR);
                drawLine(g, new Point(335, 212), new Point(339, 212), 1, MyColor.AMOR);
                drawLine(g, new Point(339, 212), new Point(339, 216), 1, MyColor.AMOR);
                drawLine(g, new Point(339, 216), new Point(343, 216), 1, MyColor.AMOR);

                drawLine(g, new Point(315, 185), new Point(323, 185), 1, MyColor.LIMOGES);
                drawLine(g, new Point(323, 185), new Point(323, 189), 1, MyColor.LIMOGES);
                drawLine(g, new Point(323, 189), new Point(329, 189), 1, MyColor.LIMOGES);
                drawLine(g, new Point(329, 189), new Point(329, 193), 1, MyColor.LIMOGES);
                drawLine(g, new Point(329, 193), new Point(335, 193), 1, MyColor.LIMOGES);
                drawLine(g, new Point(335, 193), new Point(335, 197), 1, MyColor.LIMOGES);
                drawLine(g, new Point(335, 197), new Point(341, 197), 1, MyColor.LIMOGES);
                drawLine(g, new Point(341, 197), new Point(341, 201), 1, MyColor.LIMOGES);
                drawLine(g, new Point(341, 201), new Point(347, 201), 1, MyColor.LIMOGES);
                drawLine(g, new Point(347, 201), new Point(347, 205), 1, MyColor.LIMOGES);
                drawLine(g, new Point(347, 205), new Point(353, 205), 1, MyColor.LIMOGES);
                drawLine(g, new Point(353, 205), new Point(353, 209), 1, MyColor.LIMOGES);
                drawLine(g, new Point(353, 209), new Point(359, 209), 1, MyColor.LIMOGES);

                drawLine(g, new Point(346, 233), new Point(359, 233), 1, MyColor.LIMOGES);
                drawLine(g, new Point(360, 209), new Point(360, 233), 1, MyColor.LIMOGES);

                drawLine(g, new Point(286, 185), new Point(286, 207), 3, MyColor.AMOR);
                drawLine(g, new Point(286, 207), new Point(308, 207), 3, MyColor.LIMOGES);
                drawLine(g, new Point(308, 207), new Point(308, 211), 3, MyColor.LIMOGES);
                drawLine(g, new Point(308, 211), new Point(312, 211), 3, MyColor.LIMOGES);
                drawLine(g, new Point(312, 211), new Point(312, 215), 3, MyColor.LIMOGES);
                drawLine(g, new Point(312, 215), new Point(316, 215), 3, MyColor.LIMOGES);
                drawLine(g, new Point(316, 215), new Point(316, 219), 3, MyColor.LIMOGES);
                drawLine(g, new Point(316, 219), new Point(320, 219), 3, MyColor.LIMOGES);
                drawLine(g, new Point(320, 219), new Point(320, 223), 3, MyColor.LIMOGES);
                drawLine(g, new Point(320, 223), new Point(324, 223), 3, MyColor.LIMOGES);
                drawLine(g, new Point(324, 223), new Point(324, 227), 3, MyColor.LIMOGES);
                drawLine(g, new Point(324, 227), new Point(328, 227), 3, MyColor.LIMOGES);
                drawLine(g, new Point(328, 227), new Point(328, 231), 3, MyColor.LIMOGES);
                drawLine(g, new Point(328, 231), new Point(332, 231), 3, MyColor.LIMOGES);
                drawLine(g, new Point(332, 231), new Point(343, 231), 3, MyColor.LIMOGES);
                drawLine(g, new Point(343, 231), new Point(343, 216), 3, MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(302, 197), MyColor.PRINCE_CHARMING, MyColor.AMOR);
                drawLine(g, new Point(290, 100), new Point(290, 91), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(290, 91), new Point(277, 91), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(277, 87), new Point(277, 95), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(275, 87), new Point(275, 95), 3, MyColor.CREAM);
                drawLine(g, new Point(321, 98), new Point(321, 89), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(321, 89), new Point(309, 89), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(309, 85), new Point(309, 93), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(307, 85), new Point(307, 93), 3, MyColor.CREAM);
                drawLine(g, new Point(353, 95), new Point(353, 88), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(353, 88), new Point(341, 88), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(341, 84), new Point(341, 92), 3, MyColor.POST_BLUE);
                drawLine(g, new Point(339, 84), new Point(339, 92), 3, MyColor.CREAM);
                drawLine(g, new Point(408, 22), new Point(408, 86), 3, MyColor.POST_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(344, 211), MyColor.PRINCE_CHARMING, MyColor.LIMOGES);
                // เงาตึก
                drawLine(g, new Point(363, 270), new Point(370, 270), 2, MyColor.LIMOGES);
                drawLine(g, new Point(370, 270), new Point(370, 265), 2, MyColor.LIMOGES);
                drawLine(g, new Point(370, 265), new Point(379, 265), 2, MyColor.LIMOGES);
                drawLine(g, new Point(379, 265), new Point(379, 280), 2, MyColor.LIMOGES);
                drawLine(g, new Point(379, 280), new Point(373, 280), 2, MyColor.LIMOGES);
                drawLine(g, new Point(373, 280), new Point(373, 284), 2, MyColor.LIMOGES);
                drawLine(g, new Point(373, 284), new Point(369, 284), 2, MyColor.LIMOGES);
                drawLine(g, new Point(369, 284), new Point(369, 288), 2, MyColor.LIMOGES);
                drawLine(g, new Point(369, 288), new Point(363, 288), 2, MyColor.LIMOGES);
                drawLine(g, new Point(363, 270), new Point(363, 288), 2, MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(366, 280), MyColor.PRINCE_CHARMING, MyColor.LIMOGES);
                drawLine(g, new Point(363, 320), new Point(363, 338), 2, MyColor.LIMOGES);
                drawLine(g, new Point(363, 338), new Point(379, 338), 2, MyColor.LIMOGES);
                drawLine(g, new Point(379, 338), new Point(379, 320), 2, MyColor.LIMOGES);
                drawLine(g, new Point(379, 320), new Point(363, 320), 2, MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(366, 330), MyColor.PRINCE_CHARMING, MyColor.LIMOGES);

                drawLine(g, new Point(361, 157), new Point(361, 232), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(361, 157), new Point(375, 156), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(375, 156), new Point(375, 178), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(375, 178), new Point(367, 178), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(367, 178), new Point(367, 217), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(367, 217), new Point(375, 217), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(375, 217), new Point(375, 232), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(375, 232), new Point(361, 232), 2, MyColor.PASSIONATE_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(366, 166), MyColor.PRINCE_CHARMING,
                                MyColor.PASSIONATE_BLUE);

                drawLine(g, new Point(352, 232), new Point(352, 224), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(352, 224), new Point(374, 224), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(372, 224), new Point(372, 232), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(357, 232), new Point(357, 224), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(362, 232), new Point(362, 224), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(367, 232), new Point(367, 224), 2, MyColor.ROSE_TURKISH_DELIGHT);

                drawLine(g, new Point(381, 171), new Point(371, 171), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(381, 221), new Point(371, 221), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(381, 271), new Point(371, 271), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(381, 321), new Point(371, 321), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(381, 174), new Point(371, 174), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(381, 224), new Point(371, 224), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(381, 274), new Point(371, 274), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(381, 324), new Point(371, 324), 2, MyColor.POST_BLUE);

                drawLine(g, new Point(361, 234), new Point(275, 234), 2, MyColor.LIMOGES);
                drawLine(g, new Point(275, 234), new Point(275, 390), 2, MyColor.LIMOGES);
                drawLine(g, new Point(361, 234), new Point(361, 390), 2, MyColor.LIMOGES);
                drawLine(g, new Point(361, 390), new Point(275, 390), 2, MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(295, 275), MyColor.PRINCE_CHARMING, MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(281, 261), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(280, 239), MyColor.BACKGROUND_GRADIENT_COLOR[5],
                                MyColor.LIMOGES);

                drawLine(g, new Point(273, 234), new Point(250, 236), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(273, 234), new Point(273, 390), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(250, 236), new Point(250, 390), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(250, 390), new Point(273, 390), 2, MyColor.PRINCE_CHARMING);

                drawLine(g, new Point(248, 245), new Point(228, 247), 2, MyColor.LIMOGES);
                drawLine(g, new Point(248, 245), new Point(248, 390), 2, MyColor.LIMOGES);
                drawLine(g, new Point(228, 247), new Point(228, 390), 2, MyColor.LIMOGES);
                drawLine(g, new Point(228, 390), new Point(248, 390), 2, MyColor.LIMOGES);

                drawLine(g, new Point(226, 247), new Point(155, 251), 2, MyColor.AMOR);
                drawLine(g, new Point(226, 247), new Point(226, 390), 2, MyColor.AMOR);
                drawLine(g, new Point(155, 251), new Point(155, 390), 2, MyColor.AMOR);
                drawLine(g, new Point(155, 390), new Point(226, 390), 2, MyColor.AMOR);

                mainBuffer = floodFill(mainBuffer, new Point(269, 238), MyColor.BACKGROUND_GRADIENT_COLOR[5],
                                MyColor.PRINCE_CHARMING);
                mainBuffer = floodFill(mainBuffer, new Point(269, 250), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.PRINCE_CHARMING);
                mainBuffer = floodFill(mainBuffer, new Point(238, 262), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(188, 274), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.AMOR);
                // ท่อ
                drawLine(g, new Point(300, 260), new Point(379, 260), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(300, 260), new Point(300, 235), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(303, 258), new Point(379, 258), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(303, 258), new Point(303, 235), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(290, 360), new Point(290, 235), 3, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(292, 360), new Point(292, 235), 2, MyColor.POST_BLUE);

                drawLine(g, new Point(315, 270), new Point(332, 270), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(332, 270), new Point(332, 285), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(334, 270), new Point(334, 285), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(332, 285), new Point(315, 285), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(315, 285), new Point(315, 270), 2, MyColor.ROSE_TURKISH_DELIGHT);
                mainBuffer = floodFill(mainBuffer, new Point(322, 281), MyColor.LIMOGES, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(315, 310), new Point(332, 310), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(332, 310), new Point(332, 325), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(334, 310), new Point(334, 325), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(332, 325), new Point(315, 325), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(315, 325), new Point(315, 310), 2, MyColor.ROSE_TURKISH_DELIGHT);
                mainBuffer = floodFill(mainBuffer, new Point(322, 321), MyColor.LIMOGES, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(315, 350), new Point(332, 350), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(332, 350), new Point(332, 365), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(334, 350), new Point(334, 365), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(332, 365), new Point(315, 365), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(315, 365), new Point(315, 350), 2, MyColor.ROSE_TURKISH_DELIGHT);
                mainBuffer = floodFill(mainBuffer, new Point(322, 361), MyColor.LIMOGES, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(159, 249), new Point(159, 239), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(164, 249), new Point(164, 239), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(169, 249), new Point(169, 239), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(174, 249), new Point(174, 239), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(179, 249), new Point(179, 236), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(159, 239), new Point(179, 239), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(179, 236), new Point(199, 236), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(194, 236), new Point(194, 247), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(189, 236), new Point(189, 247), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(184, 236), new Point(184, 247), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(199, 233), new Point(199, 247), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(199, 233), new Point(219, 233), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(214, 233), new Point(214, 247), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(209, 233), new Point(209, 247), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(204, 233), new Point(204, 247), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(219, 230), new Point(219, 247), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(219, 230), new Point(248, 230), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(243, 230), new Point(243, 244), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(238, 230), new Point(238, 244), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(233, 230), new Point(233, 245), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(228, 230), new Point(228, 245), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(223, 230), new Point(223, 245), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(248, 225), new Point(248, 243), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(248, 225), new Point(284, 225), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(284, 225), new Point(284, 234), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(279, 225), new Point(279, 234), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(274, 225), new Point(274, 234), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(269, 225), new Point(269, 234), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(264, 225), new Point(264, 234), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(259, 225), new Point(259, 234), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(254, 225), new Point(254, 234), 2, MyColor.ROSE_TURKISH_DELIGHT);
                drawLine(g, new Point(155, 280), new Point(161, 280), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(163, 251), new Point(163, 278), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(163, 278), new Point(173, 278), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(175, 250), new Point(175, 276), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(175, 276), new Point(185, 276), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(187, 249), new Point(187, 274), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(187, 274), new Point(197, 274), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(199, 248), new Point(199, 272), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(199, 272), new Point(209, 272), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(211, 247), new Point(211, 270), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(211, 270), new Point(221, 270), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(223, 246), new Point(223, 268), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(223, 268), new Point(248, 268), 2, MyColor.POST_BLUE);

                // หน้าต่างตึกสุดท้าย
                drawLine(g, new Point(155, 291), new Point(170, 291), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(170, 289), new Point(190, 289), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(190, 287), new Point(215, 287), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(215, 285), new Point(248, 285), 4, MyColor.POST_BLUE);
                drawLine(g, new Point(155, 294), new Point(170, 294), 3, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(170, 292), new Point(190, 292), 3, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(190, 290), new Point(215, 290), 3, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(215, 288), new Point(248, 288), 3, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(155, 297), new Point(170, 297), 2, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(170, 295), new Point(190, 295), 2, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(190, 293), new Point(215, 293), 2, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(215, 291), new Point(248, 291), 2, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(155, 299), new Point(170, 299), 1, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(170, 297), new Point(190, 297), 1, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(190, 295), new Point(215, 295), 1, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(215, 293), new Point(248, 293), 1, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(155, 298), new Point(155, 316), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(158, 315), new Point(170, 315), 2, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(170, 313), new Point(190, 313), 2, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(190, 311), new Point(215, 311), 2, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(215, 309), new Point(248, 309), 2, MyColor.VIOLET_INDIGO);
                drawLine(g, new Point(155, 316), new Point(170, 316), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(170, 315), new Point(190, 315), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(190, 313), new Point(215, 313), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(215, 311), new Point(248, 311), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(248, 311), new Point(248, 293), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(155, 319), new Point(170, 319), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(170, 317), new Point(190, 317), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(190, 315), new Point(215, 315), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(215, 313), new Point(248, 313), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(170, 314), new Point(170, 296), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(190, 312), new Point(190, 294), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(215, 310), new Point(215, 292), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(248, 308), new Point(248, 290), 2, MyColor.PRINCE_CHARMING);
                drawLine(g, new Point(248, 293), new Point(248, 315), 2, MyColor.VIOLET_INDIGO);
                mainBuffer = floodFill(mainBuffer, new Point(163, 306), MyColor.AMOR, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(183, 304), MyColor.AMOR, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(208, 302), MyColor.AMOR, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(222, 300), MyColor.AMOR, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(237, 302), MyColor.LIMOGES, MyColor.CREAM);

                drawLine(g, new Point(256, 248), new Point(269, 246), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(257, 258), new Point(269, 256), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(256, 248), new Point(256, 258), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(269, 246), new Point(269, 256), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(256, 278), new Point(269, 276), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(257, 288), new Point(269, 286), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(256, 278), new Point(256, 288), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(269, 276), new Point(269, 286), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(256, 308), new Point(269, 306), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(257, 318), new Point(269, 316), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(256, 308), new Point(256, 318), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(269, 306), new Point(269, 316), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(256, 338), new Point(269, 336), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(257, 348), new Point(269, 346), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(256, 338), new Point(256, 348), 2, MyColor.POST_BLUE);
                drawLine(g, new Point(269, 336), new Point(269, 346), 2, MyColor.POST_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(264, 255), MyColor.PRINCE_CHARMING, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(264, 286), MyColor.PRINCE_CHARMING, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(264, 314), MyColor.PRINCE_CHARMING, MyColor.CREAM);
                mainBuffer = floodFill(mainBuffer, new Point(264, 344), MyColor.PRINCE_CHARMING, MyColor.CREAM);

                drawLine(g, new Point(0, 245), new Point(8, 245), 2, MyColor.LIMOGES);
                drawLine(g, new Point(8, 245), new Point(8, 238), 2, MyColor.LIMOGES);
                drawLine(g, new Point(8, 238), new Point(26, 238), 2, MyColor.LIMOGES);
                drawLine(g, new Point(26, 238), new Point(38, 238), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(40, 238), new Point(40, 245), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(40, 245), new Point(50, 245), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(50, 245), new Point(50, 366), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(50, 366), new Point(0, 366), 2, MyColor.LIMOGES);
                drawLine(g, new Point(0, 366), new Point(0, 245), 2, MyColor.LIMOGES);
                drawLine(g, new Point(25, 238), new Point(25, 366), 2, MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(16, 260), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(33, 263), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(3, 244), new Point(3, 230), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(3, 234), new Point(8, 234), 2, MyColor.PASSIONATE_BLUE);

                drawLine(g, new Point(52, 278 + 10), new Point(56, 278 + 10), 2, MyColor.LIMOGES);
                drawLine(g, new Point(56, 278 + 10), new Point(56, 255 + 10), 2, MyColor.LIMOGES);
                drawLine(g, new Point(56, 255 + 10), new Point(120, 253 + 10), 2, MyColor.LIMOGES);
                drawLine(g, new Point(120, 253 + 10), new Point(120, 366 + 10), 2, MyColor.LIMOGES);
                drawLine(g, new Point(120, 366 + 10), new Point(52, 366 + 10), 2, MyColor.LIMOGES);
                drawLine(g, new Point(52, 366 + 10), new Point(52, 278 + 10), 2, MyColor.LIMOGES);

                drawLine(g, new Point(153, 258), new Point(136, 258), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(153, 258), new Point(153, 366), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(136, 260), new Point(136, 281), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(136, 283), new Point(121, 283), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(121, 283), new Point(121, 366), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(121, 366), new Point(153, 366), 2, MyColor.PASSIONATE_BLUE);
                mainBuffer = floodFill(mainBuffer, new Point(93, 276), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.LIMOGES);
                mainBuffer = floodFill(mainBuffer, new Point(146, 276), MyColor.BACKGROUND_GRADIENT_COLOR[6],
                                MyColor.PASSIONATE_BLUE);

                drawLine(g, new Point(56, 278), new Point(120, 274), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(56, 298), new Point(120, 294), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(56, 318), new Point(120, 314), 2, MyColor.PASSIONATE_BLUE);
                drawLine(g, new Point(56, 338), new Point(120, 334), 2, MyColor.PASSIONATE_BLUE);

                return mainBuffer;
        }

        private void drawStar(Graphics g) {
                fillRect(g, 3, 23, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 22, 8, 2, 2, MyColor.STAR_PURPLE);
                // ดาวใหญ่
                fillRect(g, 47, 32, 3, 3, MyColor.STAR_CREAM);
                fillRect(g, 47, 29, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 47, 25, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 47, 35, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 47, 39, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 43, 32, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 38, 32, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 51, 32, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 56, 32, 3, 3, MyColor.STAR_PURPLE);
                // ดาวเล็ก
                fillRect(g, 79, 23, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 102, 18, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 120, 25, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 139, 10, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 169, 24, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 199, 24, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 220, 18, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 270, 25, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 299, 14, 2, 2, MyColor.STAR_PURPLE);
                // ดาวใหญ่
                fillRect(g, 331, 25 - 10, 3, 3, MyColor.STAR_CREAM);
                fillRect(g, 331, 22 - 10, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 331, 22 - 5 - 10, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 331, 28 - 10, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 331, 28 + 5 - 10, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 326, 25 - 10, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 336, 25 - 10, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 326 - 6, 25 - 10, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 336 + 6, 25 - 10, 3, 3, MyColor.STAR_PURPLE);
                // ดาวเล็ก
                fillRect(g, 369, 18, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 396, 32, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 419, 10, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 466, 29, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 499, 12, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 585, 11, 2, 2, MyColor.STAR_PURPLE);
                // ดาวใหญ่
                fillRect(g, 542, 22, 3, 3, MyColor.STAR_CREAM);
                fillRect(g, 542, 19, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 542, 25, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 542, 19 - 4, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 542, 25 + 4, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 538, 22, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 546, 22, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 538 - 6, 22, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 546 + 6, 22, 3, 3, MyColor.STAR_PURPLE);
                // ดาวเล็ก
                fillRect(g, 18, 74, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 49, 56, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 72, 68, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 114, 61, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 152, 51, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 154, 76, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 188, 60, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 214, 74, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 247, 52, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 280, 64, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 305, 50, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 332, 50, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 353, 62, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 375, 69, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 400, 60, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 435, 47, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 439, 78, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 8, 113, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 38, 91, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 52, 133, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 63, 105, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 89, 89, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 119, 96, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 112, 126, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 145, 99, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 166, 117, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 255, 100, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 278, 109, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 366, 88, 2, 2, MyColor.STAR_PURPLE);
                // ดาวใหญ่
                fillRect(g, 219, 111, 3, 3, MyColor.STAR_CREAM);
                fillRect(g, 219, 108, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 219, 114, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 219, 108 - 4, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 219, 114 + 4, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 215, 111, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 223, 111, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 215 - 6, 111, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 223 + 6, 111, 3, 3, MyColor.STAR_PURPLE);
                // ดาวเล็ก
                fillRect(g, 12, 138, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 33, 152, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 87, 144, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 128, 151, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 153, 139, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 177, 156, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 203, 131, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 228, 170, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 227, 144, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 256, 138, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 276, 158, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 30, 176, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 8, 195, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 39, 223, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 113, 181, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 102, 224, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 125, 251, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 133, 228, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 167, 204, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 121, 183, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 175, 182, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 190, 206, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 184, 230, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 231, 204, 2, 2, MyColor.STAR_PURPLE);
                fillRect(g, 273, 210, 2, 2, MyColor.STAR_PURPLE);
                // ดาวใหญ่
                fillRect(g, 71, 182, 3, 3, MyColor.STAR_CREAM);
                fillRect(g, 71, 179, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 71, 185, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 71, 179 - 4, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 71, 185 + 4, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 67, 182, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 75, 182, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 67 - 6, 182, 3, 3, MyColor.STAR_PURPLE);
                fillRect(g, 75 + 6, 182, 3, 3, MyColor.STAR_PURPLE);

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

        private void drawArc(Graphics g, Point p1, Point p2, Point p3, Point p4, int thickness, Color color,
                        boolean debug) {
                if (debug)
                        markControlPoints(g, p1, p2, p3, p4);
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

        private void drawArc(Graphics g, Point p1, Point p2, Point p3, Point p4, int thickness, Color color) {
                drawArc(g, p1, p2, p3, p4, thickness, color, false);
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

        private void plotDebug(Graphics g, Point p, int size) {
                g.setColor(MyColor.RED);
                g.fillRect(p.x, p.y, size, size);
        }
}