package com.example.problemsolver.framework.solution;

/* imports go here */
import com.example.problemsolver.framework.graph.Vertex;
import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Aaron Cherian
 */
public class StateSpaceSolver extends Solver {
    
    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        /* you must provide */
        header = new Statistics();
        header.setHeader("Statistics"); //set header 
        this.bfs = bfs;
        if(bfs){
            super.getStatistics().setHeader("Breadth-First Search"); //called getter since statistics is private in solver
        }
        else
        {
            super.getStatistics().setHeader("Depth-First Search"); //same as above comment
        }
        this.problem = problem;
        deque = new ArrayDeque<Vertex>();
        super.setQueue(deque);
    }
    
    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v 
     */
    @Override
    public void add(Vertex v) {
	/* you must provide */
        if(bfs)
        {
            deque.addLast(v);
        }
        else
        {
            deque.addFirst(v);
        }
    }
    
    /**
     * This method implements the expand operation required by the 
     * state space search algorithm:

       Expand(u)
          children = {}
          for each name ∈ moveNames do
             child = mover.doMove(name, u)
             if child ≠ null and not OccursOnPath(child, u)
                then d[child] = d[u] + 1
                     pred[child] = u
                     add child to children
          return children

     * @param u the vertex being expanded
     * @return 
     */
    @Override
    public List<Vertex> expand(Vertex u) {
	/* you must provide */
        List <Vertex> children = new ArrayList<Vertex>();
         Mover count = problem.getMover();
         for(String a:problem.getMover().getMoveNames())
         {
               State child = count.doMove(a,(State)u.getData());
               Vertex child2 = new Vertex(child);
               if(child!= null && !occursOnPath(child2,u))
               {
                   child2.setDistance(u.getDistance() + 1);
                   child2.setPredecessor(u);
                   children.add(child2);
                   
               }
         }
        return children;
    }

    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
	/* you must provide */
        Boolean found = false;
        while(!found && ancestor != null)
        {
            if(v.equals(ancestor) == true)
            {
                found = true;
            }    
            ancestor = ancestor.getPredecessor();
            
        }
        return found;
    }
    
    /* private instance fields here */
    private Problem problem;
    private Statistics header;
    private Boolean bfs;
    private ArrayDeque<Vertex> deque;
}