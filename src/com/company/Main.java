package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        Vector l1 = new Vector(new Coordinate(-450, -150), new Coordinate(-150, -160), Color.MAGENTA , "v1");
        Vector l2 = new Vector(new Coordinate(100, 290), new Coordinate(150, 30), Color.green  , "v2");

        Draw draw = new Draw();
        draw.setSize(500, 500);

        draw.register(l1);
        draw.register(Vector.moveToOrigin(l1));
        draw.register(l2);
        draw.register(Vector.moveToVector(Vector.moveToOrigin(l1) , l2));
        draw.register(Vector.addition(l1, l2));


        frame.setTitle("vector");
        frame.add(draw);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
