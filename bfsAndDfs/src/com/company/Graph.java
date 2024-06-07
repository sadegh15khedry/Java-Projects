package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<>();
    private Node root;
    private int timer;

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void bfs(Node root){
        for(Node node : this.getNodes()){
            node.setParent(null);
            node.setD(Integer.MAX_VALUE);
            node.setColor("white");
        }

        Queue<Node> queue = new LinkedList<Node>();
        System.out.println(root.getLabel());
        root.setColor("gray");
        root.setD(0);
        queue.add(root);

        while (!queue.isEmpty()){
            Node node = queue.remove();
            for (Node v : node.getNightbers()){
                if (v.getColor().equals("white")){
                    System.out.println(v.getLabel());
                    v.setColor("gray");
                    v.setParent(node);
                    v.setD(node.getD()+1);
                    queue.add(v);
                }
            }
            node.setColor("black");
        }
    }




    public void dfs(Node root){
        for (Node node : this.getNodes()){
            node.setColor("white");
            node.setParent(null);
            node.setD(0);
            node.setF(0);
        }
        this.timer=0;
        for (Node node : this.getNodes()){
            dfsVist(node);
        }
    }

    public void dfsVist(Node node){
        System.out.println(node.getLabel());
        timer++;
        node.setColor("gray");
        node.setD(timer);
        for (Node v :node.getNightbers()){
            if (v.getColor().equals("white")){
                v.setParent(node);
                dfsVist(v);
            }
        }
        timer++;
        node.setColor("black");
        node.setF(timer);

    }


}
