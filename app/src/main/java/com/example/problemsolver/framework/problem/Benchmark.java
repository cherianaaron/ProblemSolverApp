/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver.framework.problem;

/**
 *
 * @author Aaron
 */
public class Benchmark {
    
    public Benchmark(String name, State start, State goal)
    {
        this.name = name;
        this.start = start;
        this.goal = goal;
    }
    public String getName(){
        return name;
    }
    public State getState(){
        return start;
    }
    public State getGoal(){
        return goal; 
    }
    @Override 
    public String toString(){
        return name;
    }
 
    private String name;
    private State start;
    private State goal;
    
}
