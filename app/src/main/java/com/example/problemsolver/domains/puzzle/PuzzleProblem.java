/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver.domains.puzzle;

import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.Benchmark;

/**
 *
 * @author Aaron Cherian
 */
public class PuzzleProblem extends Problem {
    
     private PuzzleState finalState;

    public PuzzleProblem() {
        super();
        finalState = new PuzzleState(
                new int[][]{new int[]{1, 2, 3},
                new int[]{8, 0, 4},
                new int[]{7, 6, 5}});
        super.setName("8-Puzzle");
        super.setIntroduction(INTRO + finalState.toString());
        super.setMover(new PuzzleMover(3,3));
        super.setInitialState(new PuzzleState(
                new int[][]{new int[]{2, 8, 3},
                new int[]{1, 6, 4},
                new int[]{7, 0, 5}}));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(finalState);
        
       b1 = new Benchmark("Mark 1: 5 Moves", super.getInitialState(),super.getFinalState());
       
       b2 = new Benchmark("Mark 2: 10 Moves", new PuzzleState(new int[][]{new int[]{3,6,4},
                                                                new int[]{1,0,2},
                                                                new int[]{8,7,5}}),super.getFinalState());
       b3 = new Benchmark("Mark 3: 13 Moves", new PuzzleState(new int[][]{new int[]{3,0,4},
                                                                new int[]{1,6,5},
                                                                new int[]{8,2,7}}),super.getFinalState());
       b4 = new Benchmark("Mark 4: 18 Moves", new PuzzleState(new int[][]{new int[]{2,1,3},
                                                                new int[]{8,0,4},
                                                                new int[]{6,7,5}}),super.getFinalState());
       b5 = new Benchmark("Mark 5: 20 Moves", new PuzzleState(new int[][]{new int[]{4,2,0},
                                                                new int[]{8,3,6},
                                                                new int[]{7,5,1}}),super.getFinalState());
       b6 = new Benchmark("Mark 6: 24 Moves", new PuzzleState(new int[][]{new int[]{1,6,3},
                                                                new int[]{4,0,8},
                                                                new int[]{7,2,5}}),super.getFinalState());
       b7 = new Benchmark("Mark 7: 30 Moves", new PuzzleState(new int[][]{new int[]{5,2,7},
                                                                new int[]{8,0,4},
                                                                new int[]{3,6,1}}),super.getFinalState());
       b8 = new Benchmark("Mark 8: 30 Moves", new PuzzleState(new int[][]{new int[]{5,6,7},
                                                                new int[]{4,0,8},
                                                                new int[]{3,2,1}}),super.getFinalState());                                                                                                     
       addToBench(b1);
       addToBench(b2);
       addToBench(b3);
       addToBench(b4);
       addToBench(b5);
       addToBench(b6);
       addToBench(b7);
       addToBench(b8);
    }

    private static final String INTRO = "You are given a board in which numbered"
            + " tiles can slide around. There is one blank space that holds no "
            + "tile.  A legal move consists of sliding a tile into the blank "
            + "space if the tile is adjacent to it. The goal is to move tiles "
            + "around until the board looks like the final state below.\n\n";
    
    private Benchmark b1;
    private Benchmark b2;
    private Benchmark b3;
    private Benchmark b4;
    private Benchmark b5;
    private Benchmark b6;
    private Benchmark b7;
    private Benchmark b8;
}
