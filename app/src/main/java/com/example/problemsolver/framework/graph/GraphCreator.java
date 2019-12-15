package com.example.problemsolver.framework.graph;

import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import java.util.Stack;
import com.example.problemsolver.framework.problem.Mover;
import java.util.List;

/**
 * @author Aaron Cherian
 */
public class GraphCreator {
    
    public Graph createGraphFor(Problem problem) {
        graph = new Graph(); //empty graph
        
        Stack<Vertex> stack = new Stack<>(); //empty stack
        
        start = new Vertex(problem.getInitialState()); //vertex(initial state of P)
        stack.push(start); //push(S, start)
        m = problem.getMover(); 
        moves = m.getMoveNames(); //moves = list of move names in P
        
        while(!stack.isEmpty()) //while S is not empty
        {
            Vertex u = stack.pop(); //pop the stack
            for (String move : moves ){ //for each m in moves do
                  next = m.doMove(move, (State)u.getData()); //doMove(m,u)
                  if (next != null){ 
                    v = new Vertex(next); 
                    if (graph.getVertices().containsKey(v)) //v in V(G)
                        v = graph.getVertices().get(v); //reclaim(v)
                    else
                        stack.push(v); //push the v on the stack
                    graph.addEdge(u, v); //add (u,v) to G
                  }
                }
        }
        return graph;
    }
    
    private Graph graph = null;
    
    Vertex start;
    Vertex v;
    State next;
    List<String> moves;
    Mover m;
}