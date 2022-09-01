package com.mahdikhani;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) (screenSize.getWidth() * 0.8);
        int screenHeight = (int) (screenSize.getHeight() * 0.7);

        Coordinate v1Start = new Coordinate(-450, -150);
        Coordinate v1End = new Coordinate(-150, -160);
        Vector v1 = new Vector(v1Start, v1End, Color.MAGENTA, "v1");

        Coordinate v2Start = new Coordinate(100, 290);
        Coordinate v2End = new Coordinate(150, 30);
        Vector v2 = new Vector(v2Start, v2End, Color.green, "v2");

        Draw draw = new Draw();
        draw.setSize(screenWidth, screenHeight);

        draw.register(
                v1,
                v2,
                Vector.moveToOrigin(v1),
                Vector.moveToVector(Vector.moveToOrigin(v1), v2),
                Vector.addition(v1, v2)
        );

        frame.setTitle("Graphical vector addition");
        frame.add(draw);
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
