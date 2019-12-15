/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver.domains.farmer;

import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.State;

/**
 *
 * @author Aaron
 */
public class FarmerMover extends Mover{
    
    public static final String GOES_ALONE = "Farmer Goes Alone";
    public static final String TAKES_WOLF = "Farmer Takes Wolf";
    public static final String TAKES_GOAT = "Farmer Takes Goat";
    public static final String TAKES_CABBAGE = "Farmer Takes Cabbage";

    public FarmerMover() {
        super.addMove(GOES_ALONE, s -> goesAlone(s));
        super.addMove(TAKES_WOLF, s -> takesWolf(s));
        super.addMove(TAKES_GOAT, s -> takesGoat(s));
        super.addMove(TAKES_CABBAGE, s -> takesCabbage(s));
    }

    private State goesAlone(State state) {
        String[] pos = getPreviousPositions(state);
        FarmerState fs = new FarmerState(move(pos[0]), pos[1], pos[2], pos[3]);
        if (isIllegal(fs)) {
            return null;
        }
        return fs;
    }

    private State takesWolf(State state) {
        String[] pos = getPreviousPositions(state);
        FarmerState fs = new FarmerState(move(pos[0]), move(pos[1]), pos[2], pos[3]);
        if (isIllegal(fs)) {
            return null;
        }
        return fs;
    }

    private State takesGoat(State state) {
        String[] pos = getPreviousPositions(state);
        FarmerState fs = new FarmerState(move(pos[0]), pos[1], move(pos[2]), pos[3]);
        if (isIllegal(fs)) {
            return null;
        }
        return fs;
    }

    private State takesCabbage(State state) {
        String[] pos = getPreviousPositions(state);
        FarmerState fs = new FarmerState(move(pos[0]), pos[1], pos[2], move(pos[3]));
        if (isIllegal(fs)) {
            return null;
        }
        return fs;
    }

    private boolean isIllegal(State state) {
        String[] pos = getPreviousPositions(state);
        boolean illegal = (pos[1] == pos[2] && pos[1] != pos[0]) || (pos[2] == pos[3] && pos[2] != pos[0]);

        return illegal;
    }

    private String move(String s) {
        if (s == "West") {
            return "East";
        } else if (s == "East") {
            return "West";
        }
        return "";
    }

    private String[] getPreviousPositions(State state) {
        FarmerState fs = (FarmerState) state;
        return fs.getPositions();
    }
}
