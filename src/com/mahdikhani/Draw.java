package com.mahdikhani;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Draw extends JPanel {
    private final ArrayList<Vector> vectorList;
    private final int step;
    private final int x;
    private final int y;

    public Draw() {
        vectorList = new ArrayList<>();
        step = 100;
        x = 7;
        y = 4;
    }

    public void register(Vector... vectors) {
        vectorList.addAll(Arrays.asList(vectors));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponents(graphics);


        for (int i = 0; i < getWidth(); i++) {
            graphics.setColor(Color.RED);
            graphics.drawLine(i * step, 0, i * step, getHeight());
            graphics.setColor(Color.black);
            graphics.drawString(String.valueOf(i - x), i * step, y * step);
        }

        graphics.setColor(Color.black);
        graphics.drawLine(x * step, 0, x * step, getHeight());

        for (int j = 0; j < getHeight(); j++) {
            graphics.setColor(Color.RED);
            graphics.drawLine(0, j * step, getWidth(), j * step);
            graphics.setColor(Color.black);
            graphics.drawString(String.valueOf(-(j - y)), x * step, j * step);
        }

        graphics.setColor(Color.black);
        graphics.drawLine(0, y * step, getWidth(), y * step);

        for (Vector vector : vectorList) {
            graphics.setColor(vector.getColor());
            Coordinate startPoint = vector.getStartPoint();
            Coordinate endPoint = vector.getEndPoint();
            graphics.drawLine(
                    startPoint.getX() + (x * step),
                    -startPoint.getY() + (y * step),
                    endPoint.getX() + (x * step),
                    -endPoint.getY() + (y * step)
            );

            graphics.drawString(
                    vector.getName(),
                    Vector.middlePoint(vector).getX() + (x * step),
                    -Vector.middlePoint(vector).getY() + (y * step)
            );
        }
    }
}
