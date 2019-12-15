/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver.domains.puzzle;

import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.State;

/**
 *
 * @author Aaron Cherian
 */
public class PuzzleMover extends Mover {
    
    public PuzzleMover(int rows, int columns) {
    for (int i = 1; i < rows * columns; i++) {
      int j = i;
      addMove("SLIDE TILE " + j, s -> tryMove(j, s));
    } 
  }
  
  private PuzzleState tryMove(int tile, State s) {
    PuzzleState state = (PuzzleState)s;
    PuzzleState.Location tileLocation = state.getLocation(tile);
    PuzzleState.Location blankLocation = state.getLocation(0);
    
    int tileRow = tileLocation.getRow();
    int tileColumn = tileLocation.getColumn();
    int blankRow = blankLocation.getRow();
    int blankColumn = blankLocation.getColumn();

    
    if (tileRow != blankRow && tileColumn != blankColumn) {
      return null;
    }
    
    if (tileRow != blankRow + 1 && 
        tileRow != blankRow - 1 && 
        tileColumn != blankColumn + 1 && 
        tileColumn != blankColumn - 1)
    {
      return null;
    }
    return new PuzzleState(state, tileLocation, blankLocation);
  }

  
  public static void main(String[] args) {
    int[] row1 = { 1, 2, 3 };
    int[] row2 = { 8, 0, 4 };      //final state
    int[] row3 = { 7, 6, 5 };
    
    PuzzleState state1 = new PuzzleState(new int[][] { row1, row2, row3 });
    
    System.out.println(state1);
    
    PuzzleMover mover = new PuzzleMover(3, 3);
    
    for (int tile = 0; tile <= 8; tile++)
      System.out.println("For tile = " + tile + " tryMove = " + mover.tryMove(tile, state1)); 
  }
}
