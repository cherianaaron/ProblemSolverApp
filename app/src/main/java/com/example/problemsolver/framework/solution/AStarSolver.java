package com.example.problemsolver.framework.solution;

/* imports go here */
import com.example.problemsolver.framework.graph.Vertex;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author Your name and section here
 */
public class AStarSolver extends StateSpaceSolver {
    
    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem 
     */
    public AStarSolver(Problem problem) {
        super(problem, false);
        /* you must provide */
        queue = new PriorityQueue(11,getComparator());
        super.setQueue(queue);
        super.getStatistics().setHeader("A* Search"); //statistics for A*
    }
    
    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     */
    @Override
    public void add(Vertex v) {
        /* you must provide */
        queue.add(v); //add vertex to queue
    }
    
    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
    public final Comparator<Vertex> getComparator() {
        /* you must provide */
        return (v1,v2) -> //lamda expression to return comparator Vertex
        {
            State goal = getProblem().getFinalState(); //final state from Problem
            State vOne = (State)v1.getData(); //vertex  1 data
            State vTwo = (State)v2.getData(); //vertex  2 data
            int i = vOne.getHeuristic(goal) + v1.getDistance(); //heuristic + distance for Vertex 1
            int j = vTwo.getHeuristic(goal) + v2.getDistance(); //heuristic + distance for Vertex 2         
        return i -j;
        }; 
    }
    
    
    
    private PriorityQueue queue;
}
