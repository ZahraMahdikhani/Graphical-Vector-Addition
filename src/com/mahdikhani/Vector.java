package com.mahdikhani;

import java.awt.*;

public class Vector {
    private Coordinate startPoint;
    private Coordinate endPoint;
    private Color color;
    private String name;

    public Vector(Coordinate startPoint, Coordinate endPoint, Color color, String name) {
        this.setStartPoint(startPoint);
        this.setEndPoint(endPoint);
        this.setColor(color);
        this.setName(name);
    }


    public Coordinate getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Coordinate startPoint) {
        this.startPoint = startPoint;
    }

    public Coordinate getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Coordinate endPoint) {
        this.endPoint = endPoint;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Vector addition(Vector v1, Vector v2) {
        int newX = (v1.getEndPoint().getX() - v1.getStartPoint().getX()) + (v2.getEndPoint().getX() - v2.getStartPoint().getX());
        int newY = (v1.getEndPoint().getY() - v1.getStartPoint().getY()) + (v2.getEndPoint().getY() - v2.getStartPoint().getY());

        return new Vector(new Coordinate(), new Coordinate(newX, newY), Color.BLUE, v1.getName() + "+" + v2.getName());
    }

    public static Vector moveToOrigin(Vector v) {
        int newX = (v.getEndPoint().getX() - v.getStartPoint().getX());
        int newY = (v.getEndPoint().getY() - v.getStartPoint().getY());

        return new Vector(new Coordinate(), new Coordinate(newX, newY), v.getColor(), v.getName() + "'");
    }

    public static Vector moveToVector(Vector v1, Vector v2) {
        int newX = v1.getEndPoint().getX() + (v2.getEndPoint().getX() - v2.getStartPoint().getX());
        int newY = v1.getEndPoint().getY() + (v2.getEndPoint().getY() - v2.getStartPoint().getY());

        return new Vector(v1.getEndPoint(), new Coordinate(newX, newY), v2.getColor(), v2.getName() + "'");
    }

    public static Coordinate middlePoint(Vector v) {
        int newX = (v.getStartPoint().getX() + v.getEndPoint().getX()) / 2;
        int newY = (v.getStartPoint().getY() + v.getEndPoint().getY()) / 2;
        return new Coordinate(newX, newY);
    }
}
