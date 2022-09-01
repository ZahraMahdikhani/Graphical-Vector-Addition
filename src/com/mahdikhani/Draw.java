package com.mahdikhani;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Draw extends JPanel {
    private ArrayList<Vector> vectors = new ArrayList<>();
    private int step = 100;
    private int x = 7;
    private int y = 4;

    public void register(Vector vector) {
        vectors.add(vector);
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponents(graphics);


        for (int i = 0; i < getWidth(); i++) {
            graphics.setColor(Color.RED);
            graphics.drawLine(i * step, 0, i * step, getHeight());
            graphics.setColor(Color.black);
            graphics.drawString(String.valueOf(i - x), i*step , y*step);
        }

        graphics.setColor(Color.black);
        graphics.drawLine(x * step, 0, x * step, getHeight());


        for (int j = 0; j < getHeight(); j++) {
            graphics.setColor(Color.RED);
            graphics.drawLine(0, j * step, getWidth(), j * step);
            graphics.setColor(Color.black);
            graphics.drawString(String.valueOf(-(j - y)), x*step , j*step);
        }

        graphics.setColor(Color.black);
        graphics.drawLine(0, y * step, getWidth(), y * step);

        for (Vector vector : vectors) {
            graphics.setColor(vector.getColor());
            graphics.drawLine(vector.getStartPoint().getX() + (x * step), -vector.getStartPoint().getY() + (y * step)
                    , vector.getEndPoint().getX() + (x * step), -vector.getEndPoint().getY() + (y * step));

            graphics.drawString(vector.getName(), Vector.middlePoint(vector).getX() + (x * step) , -Vector.middlePoint(vector).getY() + (y * step) );
        }
    }
}
