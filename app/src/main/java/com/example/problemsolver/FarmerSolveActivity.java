package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import com.example.problemsolver.domains.farmer.FarmerProblem;
import com.example.problemsolver.framework.solution.AStarSolver;
import com.example.problemsolver.framework.solution.Solver;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.List;

public class FarmerSolveActivity extends AppCompatActivity {

    Problem problem = new FarmerProblem();
    Mover mover = problem.getMover();
    List<String> moveNames = mover.getMoveNames();
    private AStarSolver astar = new AStarSolver(problem);
    private Solver solver = astar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_solve);

        /* Set the initial and final states*/
        TextView startView = (TextView) findViewById(R.id.farmer_solve_start);
        TextView finalView = (TextView) findViewById(R.id.farmer_solve_final);

        startView.setText(problem.getCurrentState().toString());
        finalView.setText(problem.getFinalState().toString());

    }

    public void solveButton(View view){
        solver.solve();
        TextView statisticsInfo = (TextView) findViewById(R.id.stats_info);
        statisticsInfo.setText(solver.getStatistics().toString());
        solver.getSolution().next();
    }

    public void nextButton(View view){
        if(solver.getSolution().hasNext())
        {
            TextView movesUpdate = (TextView) findViewById(R.id.move_count_text);
            moveCount = moveCount +1;
            movesUpdate.setText(String.valueOf(moveCount));
            TextView startView = (TextView) findViewById(R.id.farmer_solve_start);
            startView.setText(solver.getSolution().next().toString());
        }
        else
        {
            TextView messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("CONGRATULATIONS!");
        }
    }

    public void resetButton(View view){
        TextView startView = (TextView) findViewById(R.id.farmer_solve_start);
        problem.setCurrentState(problem.getInitialState());
        startView.setText(problem.getCurrentState().toString());
        TextView messageView = (TextView) findViewById(R.id.farmer_message);
        messageView.setText(" ");

        TextView movesUpdate = (TextView) findViewById(R.id.move_count_text);
        moveCount = 0;
        movesUpdate.setText(String.valueOf(moveCount));
    }

    public void goesAloneButton(View view) {
        TextView messageView = (TextView) findViewById(R.id.farmer_message);
        messageView.setText(" ");
        State next = mover.doMove(moveNames.get(0), problem.getCurrentState());
        if (next != null) {
            problem.setCurrentState(next);
            TextView startView = (TextView) findViewById(R.id.farmer_solve_start);
            startView.setText(problem.getCurrentState().toString());
            TextView movesUpdate = (TextView) findViewById(R.id.move_count_text);
            moveCount = moveCount +1;
            movesUpdate.setText(String.valueOf(moveCount));
        }
        else {
            messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("ILLEGAL MOVE, TRY AGAIN");
        }

        if(problem.success())
        {
            messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("CONGRATULATIONS!");
        }
    }

    public void takesGoatButton(View view) {
        TextView messageView = (TextView) findViewById(R.id.farmer_message);
        messageView.setText(" ");

        State next = mover.doMove(moveNames.get(2), problem.getCurrentState());

        if (next != null) {
            TextView movesUpdate = (TextView) findViewById(R.id.move_count_text);
            moveCount = moveCount +1;
            movesUpdate.setText(String.valueOf(moveCount));
            problem.setCurrentState(next);
            TextView startView = (TextView) findViewById(R.id.farmer_solve_start);
            startView.setText(problem.getCurrentState().toString());

        }
        else{
            messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("ILLEGAL MOVE, TRY AGAIN");
        }

        if(problem.success())
        {
            messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("CONGRATULATIONS!");
        }
    }

    public void takesWolfButton(View view) {
        TextView messageView = (TextView) findViewById(R.id.farmer_message);
        messageView.setText(" ");

        State next = mover.doMove(moveNames.get(1), problem.getCurrentState());
        if (next != null) {
            problem.setCurrentState(next);
            TextView startView = (TextView) findViewById(R.id.farmer_solve_start);
            startView.setText(problem.getCurrentState().toString());
            TextView movesUpdate = (TextView) findViewById(R.id.move_count_text);
            moveCount = moveCount +1;
            movesUpdate.setText(String.valueOf(moveCount));
        }
        else{
            messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("ILLEGAL MOVE, TRY AGAIN");
        }

        if(problem.success())
        {
            messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("CONGRATULATIONS!");
        }
    }

    public void takesCabbageButton(View view) {
        TextView messageView = (TextView) findViewById(R.id.farmer_message);
        messageView.setText(" ");

        State next = mover.doMove(moveNames.get(3), problem.getCurrentState());
        if (next != null) {
            problem.setCurrentState(next);
            TextView startView = (TextView) findViewById(R.id.farmer_solve_start);
            startView.setText(problem.getCurrentState().toString());
            TextView movesUpdate = (TextView) findViewById(R.id.move_count_text);
            moveCount = moveCount +1;
            movesUpdate.setText(String.valueOf(moveCount));
        }
        else{
            messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("ILLEGAL MOVE, TRY AGAIN");
        }

        if(problem.success())
        {
            messageView = (TextView) findViewById(R.id.farmer_message);
            messageView.setText("CONGRATULATIONS!");
        }
    }

    int moveCount=0;
}
