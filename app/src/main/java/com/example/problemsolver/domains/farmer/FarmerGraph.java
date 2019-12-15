package com.example.problemsolver.domains.farmer;

import com.example.problemsolver.framework.graph.Vertex;
import com.example.problemsolver.framework.graph.Graph;

/**
 * A graph for the FWGC problem.
 * @author Aaron Cherian
 */
public class FarmerGraph extends Graph {
    
    public FarmerGraph() {
        /* you must provide */
         start= new Vertex(new FarmerState("West", "West", "West", "West")); //create the vertices for the graph representation  
         v2= new Vertex(new FarmerState("East", "West", "East", "West"));
         v3= new Vertex(new FarmerState("West", "West", "East", "West"));
         v4= new Vertex(new FarmerState("East", "East", "East", "West"));
         v5= new Vertex(new FarmerState("West", "East", "West", "West")); //same
         v6= new Vertex(new FarmerState("East", "West", "East", "East")); //v7
         v7= new Vertex(new FarmerState("West", "West", "West", "East")); //v8
         v8= new Vertex(new FarmerState("East", "East", "West", "East")); //v9
         v9= new Vertex(new FarmerState("West", "East", "West", "East")); //v10
         end= new Vertex(new FarmerState("East", "East", "East", "East"));
         
         this.addEdge(start,v2); //create edges for the graph representation, make sure to look at ALL POSSIBLE EDGES 
         this.addEdge(v2, start);
         this.addEdge(v2,v3);
         this.addEdge(v3,v2);
         this.addEdge(v3,v4);
         this.addEdge(v4,v3);
         this.addEdge(v4,v5);
         this.addEdge(v5,v4);
         this.addEdge(v5,v8);
         this.addEdge(v8,v5);
         this.addEdge(v8,v7);
         this.addEdge(v7,v8);
         this.addEdge(v7,v6);
         this.addEdge(v6,v7);
         this.addEdge(v6,v3);
         this.addEdge(v3, v6);
         this.addEdge(v8,v9);
         this.addEdge(v9,v8);
         this.addEdge(v9,end);
         this.addEdge(end,v9);
    }
    
    public Vertex getStart() {
        /* you must provide */
        return start;
    }
    
    public Vertex getEnd() {
        /* you must provide */
        return end;
    }
    
    /* private fields and methods follow */
    private final Vertex start;
    private final Vertex v2;
    private final Vertex v3;
    private final Vertex v4;
    private final Vertex v5;
    private final Vertex v6;
    private final Vertex v7;
    private final Vertex v8;
    private final Vertex v9;
    private final Vertex end;
    
}