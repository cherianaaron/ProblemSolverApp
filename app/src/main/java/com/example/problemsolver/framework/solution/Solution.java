/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver.framework.solution;

import com.example.problemsolver.framework.graph.Vertex;
import java.util.Stack;

/**
 *
 * @author Aaron Cherian
 */
public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        /* you must provide */
        this.start = start; //initialize start of stack
        this.end = end; //initialize end of stack 
        this.stack = new Stack(); //create a new stack for values 
        stack.push(end); //start with the end of the stack first
        Vertex temp = end.getPredecessor(); //a temporary vertex is used to mark the last state, which is the predecessor for end
        while(temp != null) //while the stack is not empty
        {
            stack.push(temp);//pushing temp variable to stack 
            temp = temp.getPredecessor();//traverse stack to get to whats before     
        }
    }

    /**
     * Gets the length of the solution, that is, the number of moves
     * to get to the end state from the start.
     * @return the solution length
     */
    public int getLength() {
        /* you must provide */
        return stack.size()-1; 
    }
    
    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        /* you must provide */ 
          return !stack.isEmpty(); //if stack is not empty
    }
    
    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() {
        /* you must provide */
        if(stack.isEmpty())
        {
            throw new RuntimeException("There are no more vertices");
        }
        else
        {
             return stack.pop();
        }
    }
    
    /* private instance fields and methods here */
    private final Stack<Vertex> stack;
    private final Vertex start;
    private final Vertex end;
    private int length;
}
