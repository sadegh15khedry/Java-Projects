package com.company;


import java.util.ArrayList;

public class Graph {
    private ArrayList<Node>nodes =new ArrayList<>();
    private ArrayList<Node> g2;
    private ArrayList<Node> g1;

    public Graph(ArrayList<Node> nodes) {
        this.nodes = nodes;
        this.g2 = nodes;
        this.g1 = null;
    }

    public void digestral ( Node r){
        g2.remove(r);
        g1.add(r);
        relaxation(r);
    }


    public void relaxation(Node n){
            for (int i = 0; i <= n.getNeightbers().size(); i++) {
                if (n.getNeightbers().get(i).getW() > n.getW() + n.getDistances().get(i)) {
                    n.getNeightbers().get(i).setW(n.getW() + n.getDistances().get(i));
                    n.getNeightbers().get(i).setParenent(n);
                    n.getNeightbers().get(i).setRelaxed(true);
                }
                for (Node r : n.getNeightbers()){
                    if (!r.isRelaxed()){
                        g2.remove(r);
                        g1.add(r);
                        relaxation(r);
                    }
                }
            }




    }
}
