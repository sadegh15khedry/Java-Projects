package com.company;


import java.util.ArrayList;

public class Node {
    private String label;
    private Node parent;
    private int d;
    private int f;
    private String color;

    private ArrayList<Node> nightbers = new ArrayList<>();

    public Node(String label) {
        this.label = label;
    }

    public int getD() {
        return d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public ArrayList<Node> getNightbers() {
        return nightbers;
    }

    public void setD(int d) {
        this.d = d;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addNightber(Node node){
        this.nightbers.add(node);
    }
    public void removeChild(Node node){
        this.nightbers.remove(node);
    }
}
