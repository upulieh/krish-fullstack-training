package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        execute_BFS();
        execute_DFS();
    }

    //Bread First
    static void execute_BFS(){
        //BFS is FIFO(First In First Out)
        //So a queue can be used (as it is a FIFO)
        //Rule- start from any vertex, then explore each node it is connected to
        //2 types of BFS- directed graph, undirected graph

        //Sample queue for undirected graph
        //A|B|C|D|E|G|F  - add to the queue is connected
        //A,B,C,D,E,G,F - BFS
        // move on the queue and take out one by one

        System.out.println("_________BFS_________");
        DFS dfs=new DFS();
        dfs.innitialize(6);
        dfs.addNode(0,new ArrayList<Integer>(Arrays.asList(2,3)));
        dfs.addNode(1,new ArrayList<Integer>(Arrays.asList(1,4,5)));
        dfs.addNode(2,new ArrayList<Integer>(Arrays.asList(1,6)));
        dfs.addNode(3,new ArrayList<Integer>(Arrays.asList(2,5)));
        dfs.addNode(4,new ArrayList<Integer>(Arrays.asList(4,2)));
        dfs.addNode(5,new ArrayList<Integer>(Arrays.asList(3)));

        dfs.addToQueue();

        dfs.printQueue();
    }

    //Depth First
    static void execute_DFS(){
        //Don't explore the surrounding vertices
        //Go to the depth.
        //Don't get fooled by the diagram sizes and changes.
        // Be concerned about the connectivity
        //Rule - direction doesn't matter but go to the very depth

        //sample stack (should be drawn vertically)
        //0|3|5|6|2|1|3|7|4
        //0,3,5,6,2,1,7,4 - DFS
        // The path taken makes the answer different


        System.out.println("_________DFS_________");
        DFS dfs=new DFS();
        dfs.innitialize(6);
        dfs.addNode(0,new ArrayList<Integer>(Arrays.asList(2,3)));
        dfs.addNode(1,new ArrayList<Integer>(Arrays.asList(1,4,5)));
        dfs.addNode(2,new ArrayList<Integer>(Arrays.asList(1,6)));
        dfs.addNode(3,new ArrayList<Integer>(Arrays.asList(2,5)));
        dfs.addNode(4,new ArrayList<Integer>(Arrays.asList(4,2)));
        dfs.addNode(5,new ArrayList<Integer>(Arrays.asList(3)));

        dfs.addToQueue();

        dfs.printQueue();
    }
}

class DFS{
    public int nodes; //the number of nodes in the graph
    public ArrayList<ArrayList<Integer>> graph; //where graph is stored
    public Queue<Integer> queue;  //the queue

    public void innitialize(int nodes) //
    {
        nodes = nodes; //assign the value for the node
        graph = new ArrayList<ArrayList<Integer>>();;
        queue = new LinkedList<>();
    }

    public void addNode(int node,ArrayList<Integer> adjacents){
        graph.add(node,adjacents);
    }

    //adds each value to queue in BF order
    public void addToQueue(){
        for (int i=0;i<graph.size();i++) {
            for (Integer value : graph.get(i)) {
//                System.out.print(value+" ");

                queue.add(value);
            }
        }
    }

    //print values on the queue for the output
    public void printQueue(){
        System.out.println(queue);
    }

}
class BFS{
    public int nodes; //the number of nodes in the graph
    public ArrayList<ArrayList<Integer>> graph; //where graph is stored
    public Queue<Integer> queue;  //the queue

    public void innitialize(int nodes) //
    {
        nodes = nodes; //assign the value for the node
        graph = new ArrayList<ArrayList<Integer>>();;
        queue = new LinkedList<>();
    }

    public void addNode(int node,ArrayList<Integer> adjacents){
        graph.add(node,adjacents);
    }

    //adds each value to queue in BF order
    public void addToQueue(){
        for (int i=0;i<graph.size();i++) {
            for (Integer value : graph.get(i)) {
//                System.out.print(value+" ");

                queue.add(value);
            }
        }
    }

    //print values on the queue for the output
    public void printQueue(){
        System.out.println(queue);
    }

}
