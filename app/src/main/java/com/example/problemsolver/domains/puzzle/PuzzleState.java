package com.example.problemsolver.domains.puzzle;

import com.example.problemsolver.framework.problem.State;
import java.util.Arrays;

/**
 * This class represents states of various tile-moving puzzle problems,
 * including the 8-Puzzle, which involves a 3x3 display area.
 * It can also represent other displays of different dimensions, e.g. 4x4.
 * A puzzle state is represented with a 2D array of integers.
 * @author tcolburn
 */
public class PuzzleState implements State{
    
    /**                                                                                                 
       A 2D integer array represents the tiles.                                                                   
     */
    private final int[][] tiles;

    /**
     * Getter for the underlying 2D array.
     * Most users of this class will not access these representation details.
     * This will be useful when the problem solving framework adds heuristic
     * search to its abilities.
     * @return the underlying 2D array
     */
    public int[][] getTiles() {
        return tiles;
    }
    
    /**
     * A puzzle state constructor that accepts a 2D array of integers.
     * @param tiles a 2d array of integers
     */
    public PuzzleState(int[][] tiles) {
        this.tiles = tiles;
    }
    
    /**
     * A nested class that represents a location within a puzzle state
     * as a row and column pair.
     */
    public static class Location {
        
        /**
         * Creates a new location object.
         * @param row the row index of this location, zero origin
         * @param column the column index of this location, zero origin
         */
        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }

        /**
         * Getter for this location's row index.
         * @return this location's row index
         */
        public int getRow() {
            return row;
        }

        /**
         * Getter for this location's column index.
         * @return this location's column index
         */
        public int getColumn() {
            return column;
        }
        
        /**
         * Creates a string representation of this location object for
         * debugging purposes.
         * @return a string representation of this location object as "(row,column)"
         */
        @Override
        public String toString() {
            return "(" +row+ "," +column+ ")";
        }
        
        /**
         * Tests for equality of this location with another.
         * @param o the other location
         * @return true if this location has same row and column indexes as
         * the other, false otherwise
         */
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o.getClass() != this.getClass()) return false;
            Location other = (Location) o;
            return this.row == other.row && this.column == other.column;
        }
        
        private int row;
        private int column;
    }
    
    /**
     * A puzzle state constructor that creates a new puzzle state from a
     * given puzzle state and two locations.
     * A copy of the given state is created and the contents of the two
     * given locations are swapped.
     * The original puzzle state is not changed.
     * @param state an existing puzzle state
     * @param loc1 a location within the given state
     * @param loc2 another location within the given state
     * @throws ArrayIndexOutOfBoundsException if either location is invalid
     * for this state
     */
    public PuzzleState (PuzzleState state, Location loc1, Location loc2) {
        tiles = copyTiles(state.tiles);
        int temp = tiles[loc1.row][loc1.column];
        tiles[loc1.row][loc1.column] = tiles[loc2.row][loc2.column];
        tiles[loc2.row][loc2.column] = temp;
    }
    
    /**
     * Finds the location of a given tile in this state.
     * @param tile the tile to find
     * @return the location of the tile
     * @throws RuntimeException if the tile is not found in the state
     */
    public Location getLocation(int tile) {
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                if (tiles[r][c] == tile) {
                    return new Location(r,c);
                }
            }
        }
        throw new RuntimeException("Tile " +tile+ " not found in\n" +toString());
    }
    
    /**
     * Tests for equality of this puzzle state with another.
     * @param o the other state
     * @return true if the underlying arrays are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != PuzzleState.class) return false;
        PuzzleState other = (PuzzleState) o;
        if (this == other) return true;
        return Arrays.deepEquals(this.tiles, other.tiles);
    }

    @Override
    public int hashCode() {
       int hash = 7;
       hash = 59 * hash + Arrays.deepHashCode(this.tiles);
       return hash;
   }
    
    /**
     * Creates a string representation of this state, with the tiles laid out
     * in a table with dashes and vertical bars used to separate rows and columns.
     * @return the string representation of this state
     */
    @Override
    public String toString() {
        int width = tiles[0].length;
        StringBuilder builder = new StringBuilder();
        for (int[] row : tiles) {
            builder.append(horizontalDivider(width));
            builder.append("\n");
            builder.append(horizontalRow(row));
            builder.append("\n");
        }
        builder.append(horizontalDivider(width));
        return builder.toString();
    }
    
    
    @Override
    public int getHeuristic(State goal) {
        return tilesOutOfPlace(this, goal);
        //return sumManhattan(this, goal);    
    }
    
    
    public static int tilesOutOfPlace(State current, State goal) {
        int count = 0;
        /* compute the count */
        
        PuzzleState curr = (PuzzleState)current;
        PuzzleState goal2 = (PuzzleState)goal;
        /* Just for Testing Purposes, ignore */
        System.out.println("The middle value in goal is a space: " + goal2.tiles[1][1]);
        
        /* Checking if each tile is equal to the goal state, add to count otherwise */
        if(curr.tiles[0][0] != 1){
            
            count++;
            System.out.println("Value at 0,0: " + curr.tiles[0][0]); //testing print lines
            System.out.println("Tiles out of place: " + count); // just to see if first case works
        }
        if(curr.tiles[0][1] != 2){
            
            count++;
            System.out.println("Tiles out of place: " + count);
        }
        if(curr.tiles[0][2] != 3){

             count++;
             System.out.println("Tiles out of place: " + count);
         }
        if(curr.tiles[1][0] != 8){
            
            count++;
            System.out.println("Tiles out of place: " + count);
        }
        if(curr.tiles[1][2] != 4){
            
            count++;
            System.out.println("Tiles out of place: " + count);
        }
        if(curr.tiles[2][0] != 7){
            
            count++;
            System.out.println("Tiles out of place: " + count);
        }
        if(curr.tiles[2][1] != 6){
            
            count++;
            System.out.println("Tiles out of place: " + count);
        }
        if(curr.tiles[2][2] != 5){
            
            count++;
            System.out.println("Tiles out of place: " + count);
        }
        
    return count; //returns the tiles out of place from the current state
        

    }
    
    public static int sumManhattan(State current, State goal) {
        int sum = 0;
        /* compute the sum */
        PuzzleState curr = (PuzzleState)current;
        PuzzleState goal2 = (PuzzleState)goal;
        for(int count = 0; count < curr.tiles.length ; count++)
        {
            for(int count2 = 0; count2< curr.tiles[count].length; count2++)
            {
                int j = curr.tiles[count][count2];
                int i = goal2.tiles[count][count2];
 
                if(j!=0 && j!=i)
                {
                    sum += (Math.abs(count-goal2.getLocation(j).getRow()) +  
                            Math.abs(count2-goal2.getLocation(j).getColumn()));
                }
            }
        }
        return sum;

    }
    
    /*
    Private helper methods follow.
    */
    
    private static String horizontalDivider(int width) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            builder.append("+---");
        }
        builder.append("+");
        return builder.toString();
    }
    
    private static String horizontalRow(int[] tiles) {
        StringBuilder builder = new StringBuilder();
        for (int tile : tiles) {
            builder.append("|");
            builder.append(tileString(tile));
        }
        builder.append("|");
        return builder.toString();
    }
    
    private static String tileString(int tile) {
        if ( tile == 0 ) return "   ";
        if ( tile/10 == 0 ) return " " + tile + " ";
        return tile + " ";
    }
    
    private static int[][] copyTiles(int[][] source) {
        int rows = source.length;
        int columns = source[0].length;
        int[][] dest = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                dest[r][c] = source[r][c];
            }
        }
        return dest;
    }
}