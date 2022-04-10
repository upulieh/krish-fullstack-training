package com.company;

public class Main {

    public static void main(String[] args) {




        BFS();
        DFS();
    }

    //Bread First
    static void BFS(){
        //BFS is FIFO(First In First Out)
        //So a queue can be used (as it is a FIFO)
        //Rule- start from any vertex, then explore each node it is connected to
        //2 types of BFS- directed graph, undirected graph

        //Sample queue for undirected graph
        //A|B|C|D|E|G|F  - add to the queue is connected
        //A,B,C,D,E,G,F - BFS
        // move on the queue and take out one by one

        System.out.println("BFS");

    }

    //Depth First
    static void DFS(){
        //Don't explore the surrounding vertices
        //Go to the depth.
        //Don't get fooled by the diagram sizes and changes.
        // Be concerned about the connectivity
        //Rule - direction doesn't matter but go to the very depth

        //sample stack (should be drawn vertically)
        //0|3|5|6|2|1|3|7|4
        //0,3,5,6,2,1,7,4 - DFS
        // The path taken makes the answer different


        System.out.println("DFS");
    }
}
