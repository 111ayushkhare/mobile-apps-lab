package com.example.scorekeeper;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final long START_TIME_IN_MILLIS = 60000;
    private final long HALF_TIME_IN_MILLIS = START_TIME_IN_MILLIS / 2;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private final int POINTS_FOR_GOAL = 5;
    private final int POINTS_FOR_FOUL = -1;
    private final int POINTS_FOR_PENALTY = -3;

    private int mTotalScoreTeamA = 0;
    private int mTotalScoreTeamB = 0;

    private int mScoreTeamA = 0;
    private int mScoreTeamB = 0;

    private int mGoalCountTeamA = 0;
    private int mFoulCountTeamA = 0;
    private int mPenaltyCountTeamA = 0;

    private int mGoalCountTeamB = 0;
    private int mFoulCountTeamB = 0;
    private int mPenaltyCountTeamB = 0;

    private TextView mInfoView;
    private TextView mTimerView;
    private TextView mScoreCurrentA;
    private TextView mScoreCurrentB;

    private TextView mScoreFirstHalfTeamA;
    private TextView mScoreSecondHalfTeamA;
    private TextView mScoreFirstHalfTeamB;
    private TextView mScoreSecondHalfTeamB;

    private TextView mGoalCountFirstHalfTeamA;
    private TextView mFoulCountFirstHalfTeamA;
    private TextView mPenaltyCountFirstHalfTeamA;
    private TextView mGoalCountSecondHalfTeamA;
    private TextView mFoulCountSecondHalfTeamA;
    private TextView mPenaltyCountSecondHalfTeamA;

    private TextView mGoalCountFirstHalfTeamB;
    private TextView mFoulCountFirstHalfTeamB;
    private TextView mPenaltyCountFirstHalfTeamB;
    private TextView mGoalCountSecondHalfTeamB;
    private TextView mFoulCountSecondHalfTeamB;
    private TextView mPenaltyCountSecondHalfTeamB;

    private Button mPlay;
    private Button mPause;
    private Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfoView = (TextView) findViewById(R.id.half_current);
        mTimerView = (TextView) findViewById(R.id.timer);
        mScoreCurrentA = (TextView) findViewById(R.id.score_current_a);
        mScoreCurrentB = (TextView) findViewById(R.id.score_current_b);

        mScoreFirstHalfTeamA = (TextView) findViewById(R.id.score_a_first_half);
        mScoreSecondHalfTeamA = (TextView) findViewById(R.id.score_a_second_half);
        mScoreFirstHalfTeamB = (TextView) findViewById(R.id.score_b_first_half);
        mScoreSecondHalfTeamB = (TextView) findViewById(R.id.score_b_second_half);

        mGoalCountFirstHalfTeamA = (TextView) findViewById(R.id.goals_a_first_half);
        mFoulCountFirstHalfTeamA = (TextView) findViewById(R.id.fouls_a_first_half);
        mPenaltyCountFirstHalfTeamA = (TextView) findViewById(R.id.penalties_a_first_half);
        mGoalCountSecondHalfTeamA = (TextView) findViewById(R.id.goals_a_second_half);
        mFoulCountSecondHalfTeamA = (TextView) findViewById(R.id.fouls_a_second_half);
        mPenaltyCountSecondHalfTeamA = (TextView) findViewById(R.id.penalties_a_second_half);

        mGoalCountFirstHalfTeamB = (TextView) findViewById(R.id.goals_b_first_half);
        mFoulCountFirstHalfTeamB = (TextView) findViewById(R.id.fouls_b_first_half);
        mPenaltyCountFirstHalfTeamB = (TextView) findViewById(R.id.penalties_b_first_half);
        mGoalCountSecondHalfTeamB = (TextView) findViewById(R.id.goals_b_second_half);
        mFoulCountSecondHalfTeamB = (TextView) findViewById(R.id.fouls_b_second_half);
        mPenaltyCountSecondHalfTeamB = (TextView) findViewById(R.id.penalties_b_second_half);

        mPlay = (Button) findViewById(R.id.control_time_button_play);
        mPause = (Button) findViewById(R.id.control_time_button_pause);
        mResetButton = (Button) findViewById(R.id.control_button);
    }

    /* Start the game */
    public void playGame(View view) {
        if (!mTimerRunning) {
            startTimer();
            mPlay.setVisibility(View.INVISIBLE);
            mPause.setVisibility(View.VISIBLE);
            mResetButton.setVisibility(View.VISIBLE);
        }
    }

    /* Pause the game */
    public void pauseGame(View view) {
        pauseTimer();
    }

    /* Start the timer */
    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                if (mTimeLeftInMillis > HALF_TIME_IN_MILLIS) {
                    mInfoView.setText(R.string.half_current_first);
                } else if (mTimeLeftInMillis > 0 && mTimeLeftInMillis < HALF_TIME_IN_MILLIS) {
                    mInfoView.setText(R.string.half_current_second);
                }
                updateTimerText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mInfoView.setText(R.string.time_over);
                mPause.setVisibility(View.INVISIBLE);
                mPlay.setVisibility(View.INVISIBLE);
                mResetButton.setText(R.string.control_button_2);
                updateTimerText();
            }
        }.start();

        mTimerRunning = true;
    }

    /* Pause the timer */
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mPause.setVisibility(View.INVISIBLE);
        mPlay.setVisibility(View.VISIBLE);
    }

    /* Reset the timer */
    private void resetTimer() {
        mCountDownTimer.cancel();
        mTimeLeftInMillis = 0;

        mTotalScoreTeamA = 0;
        mScoreTeamA = 0;
        mGoalCountTeamA = 0;
        mFoulCountTeamA = 0;
        mPenaltyCountTeamA = 0;
        displayForTeamA();

        mTotalScoreTeamB = 0;
        mScoreTeamB = 0;
        mGoalCountTeamB = 0;
        mFoulCountTeamB = 0;
        mPenaltyCountTeamB = 0;
        displayForTeamB();

        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        mTimerRunning = false;
        updateTimerText();

        mInfoView.setText(R.string.half_current);
        mResetButton.setText(R.string.control_button);
    }

    /* Reset scores of both the teams */
    public void resetScores(View view) {
        mPlay.setVisibility(View.VISIBLE);
        mPause.setVisibility(View.INVISIBLE);
        mResetButton.setVisibility(View.INVISIBLE);
        resetTimer();
    }

    /* Updating the timer text */
    private void updateTimerText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        if (seconds == ((HALF_TIME_IN_MILLIS / 1000) % 60) && minutes == (HALF_TIME_IN_MILLIS / 1000) / 60) {
            pauseTimer();
            mInfoView.setText(R.string.half_current_break);
            mScoreTeamA = 0;
            mScoreTeamB = 0;

            mGoalCountTeamA = 0;
            mFoulCountTeamA = 0;
            mPenaltyCountTeamA = 0;
            mGoalCountTeamB = 0;
            mFoulCountTeamB = 0;
            mPenaltyCountTeamB = 0;

            mTimeLeftInMillis = HALF_TIME_IN_MILLIS;
        }
        mTimerView.setText(timeLeft);
    }

    // TEAM A
    /* Increment number of goals, modify team A score accordingly */
    public void addGoalPointsForTeamA(View view) {
        if (mTimerRunning) {
            mTotalScoreTeamA += POINTS_FOR_GOAL;
            mScoreTeamA += POINTS_FOR_GOAL;
            if (mScoreTeamA < 0) {
                mScoreTeamA = 0;
            }
            if (mTotalScoreTeamA < 0) {
                mTotalScoreTeamA = 0;
            }
            mGoalCountTeamA++;
            displayForTeamA();
        }
    }

    /* Increment number of fouls, modify team A score accordingly */
    public void addFoulPointsForTeamA(View view) {
        if (mTimerRunning) {
            mTotalScoreTeamA += POINTS_FOR_FOUL;
            mScoreTeamA += POINTS_FOR_FOUL;
            if (mScoreTeamA < 0) {
                mScoreTeamA = 0;
            }
            if (mTotalScoreTeamA < 0) {
                mTotalScoreTeamA = 0;
            }
            mFoulCountTeamA++;
            displayForTeamA();
        }
    }

    /* Increment number of penalties, modify team A score accordingly */
    public void addPenaltyPointsForTeamA(View view) {
        if (mTimerRunning) {
            mTotalScoreTeamA += POINTS_FOR_PENALTY;
            mScoreTeamA += POINTS_FOR_PENALTY;
            if (mScoreTeamA < 0) {
                mScoreTeamA = 0;
            }
            if (mTotalScoreTeamA < 0) {
                mTotalScoreTeamA = 0;
            }
            mPenaltyCountTeamA++;
            displayForTeamA();
        }
    }

    /* Display each score related entity for team B */
    private void displayForTeamA() {
        mScoreCurrentA.setText(String.valueOf(mTotalScoreTeamA));
        if (mTimeLeftInMillis > HALF_TIME_IN_MILLIS) {
            mScoreFirstHalfTeamA.setText(String.valueOf(mScoreTeamA));
            mGoalCountFirstHalfTeamA.setText(String.valueOf(mGoalCountTeamA));
            mFoulCountFirstHalfTeamA.setText(String.valueOf(mFoulCountTeamA));
            mPenaltyCountFirstHalfTeamA.setText(String.valueOf(mPenaltyCountTeamA));
        } else if (mTimeLeftInMillis > 0 && mTimeLeftInMillis < HALF_TIME_IN_MILLIS) {
            mScoreSecondHalfTeamA.setText(String.valueOf(mScoreTeamA));
            mGoalCountSecondHalfTeamA.setText(String.valueOf(mGoalCountTeamA));
            mFoulCountSecondHalfTeamA.setText(String.valueOf(mFoulCountTeamA));
            mPenaltyCountSecondHalfTeamA.setText(String.valueOf(mPenaltyCountTeamA));
        } else if (mTimeLeftInMillis == 0){
            mScoreFirstHalfTeamA.setText(String.valueOf(mScoreTeamA));
            mGoalCountFirstHalfTeamA.setText(String.valueOf(mGoalCountTeamA));
            mFoulCountFirstHalfTeamA.setText(String.valueOf(mFoulCountTeamA));
            mPenaltyCountFirstHalfTeamA.setText(String.valueOf(mPenaltyCountTeamA));

            mScoreSecondHalfTeamA.setText(String.valueOf(mScoreTeamA));
            mGoalCountSecondHalfTeamA.setText(String.valueOf(mGoalCountTeamA));
            mFoulCountSecondHalfTeamA.setText(String.valueOf(mFoulCountTeamA));
            mPenaltyCountSecondHalfTeamA.setText(String.valueOf(mPenaltyCountTeamA));
        }
    }

    // TEAM B
    /* Increment number of goals, modify team B score accordingly */
    public void addGoalPointsForTeamB(View view) {
        if (mTimerRunning) {
            mTotalScoreTeamB += POINTS_FOR_GOAL;
            mScoreTeamB += POINTS_FOR_GOAL;
            if (mScoreTeamB < 0) {
                mScoreTeamB = 0;
            }
            if (mTotalScoreTeamB < 0) {
                mTotalScoreTeamB = 0;
            }
            mGoalCountTeamB++;
            displayForTeamB();
        }
    }

    /* Increment number of fouls, modify team B score accordingly */
    public void addFoulPointsForTeamB(View view) {
        if (mTimerRunning) {
            mTotalScoreTeamB += POINTS_FOR_FOUL;
            mScoreTeamB += POINTS_FOR_FOUL;
            if (mScoreTeamB < 0) {
                mScoreTeamB = 0;
            }
            if (mTotalScoreTeamB < 0) {
                mTotalScoreTeamB = 0;
            }
            mFoulCountTeamB++;
            displayForTeamB();
        }
    }

    /* Increment number of penalties, modify team B score accordingly */
    public void addPenaltyPointsForTeamB(View view) {
        if (mTimerRunning) {
            mTotalScoreTeamB += POINTS_FOR_PENALTY;
            mScoreTeamB += POINTS_FOR_PENALTY;
            if (mScoreTeamB < 0) {
                mScoreTeamB = 0;
            }
            if (mTotalScoreTeamB < 0) {
                mTotalScoreTeamB = 0;
            }
            mPenaltyCountTeamB++;
            displayForTeamB();
        }
    }

    /* Display each score related entity for team B */
    public void displayForTeamB() {
        mScoreCurrentB.setText(String.valueOf(mTotalScoreTeamB));
        if (mTimeLeftInMillis > HALF_TIME_IN_MILLIS) {
            mScoreFirstHalfTeamB.setText(String.valueOf(mScoreTeamB));
            mGoalCountFirstHalfTeamB.setText(String.valueOf(mGoalCountTeamB));
            mFoulCountFirstHalfTeamB.setText(String.valueOf(mFoulCountTeamB));
            mPenaltyCountFirstHalfTeamB.setText(String.valueOf(mPenaltyCountTeamB));
        } else if (mTimeLeftInMillis > 0 && mTimeLeftInMillis < HALF_TIME_IN_MILLIS) {
            mScoreSecondHalfTeamB.setText(String.valueOf(mScoreTeamB));
            mGoalCountSecondHalfTeamB.setText(String.valueOf(mGoalCountTeamB));
            mFoulCountSecondHalfTeamB.setText(String.valueOf(mFoulCountTeamB));
            mPenaltyCountSecondHalfTeamB.setText(String.valueOf(mPenaltyCountTeamB));
        } else if (mTimeLeftInMillis == 0){
            mScoreFirstHalfTeamB.setText(String.valueOf(mScoreTeamB));
            mGoalCountFirstHalfTeamB.setText(String.valueOf(mGoalCountTeamB));
            mFoulCountFirstHalfTeamB.setText(String.valueOf(mFoulCountTeamB));
            mPenaltyCountFirstHalfTeamB.setText(String.valueOf(mPenaltyCountTeamB));

            mScoreSecondHalfTeamB.setText(String.valueOf(mScoreTeamB));
            mGoalCountSecondHalfTeamB.setText(String.valueOf(mGoalCountTeamB));
            mFoulCountSecondHalfTeamB.setText(String.valueOf(mFoulCountTeamB));
            mPenaltyCountSecondHalfTeamB.setText(String.valueOf(mPenaltyCountTeamB));
        }
    }

}