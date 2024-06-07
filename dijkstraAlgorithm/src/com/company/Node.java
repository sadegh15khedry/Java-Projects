package com.company;


import java.util.ArrayList;

public class Node {
    private String label;
    private int w = Integer.MAX_VALUE;
    private ArrayList<Node> neightbers;
    private ArrayList<Integer> distances;
    private Node parenent;
    private boolean relaxed ;


    public Node(String label) {
        this.label = label;
        relaxed= false;
    }

    public boolean isRelaxed() {
        return relaxed;
    }

    public void setRelaxed(boolean relaxed) {
        this.relaxed = relaxed;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getW() {
        return w;
    }

    public Node getParenent() {
        return parenent;
    }

    public void setParenent(Node parenent) {
        this.parenent = parenent;
    }

    public void setW(int w) {
        this.w = w;
    }

    public ArrayList<Node> getNeightbers() {
        return neightbers;
    }

    public void setNeightbers(ArrayList<Node> neightbers) {
        this.neightbers = neightbers;
    }

    public ArrayList<Integer> getDistances() {
        return distances;
    }

    public void setDistances(ArrayList<Integer> distances) {
        this.distances = distances;
    }

    public void addDistance (int n){
        this.distances.add(n);
    }

    public void addNeightber(Node n){
        this.neightbers.add(n);
    }



}
