package com.bateman.msu.hw4courtcounter

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bateman.msu.hw4courtcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val counterViewModel: CounterViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayForTeamA(counterViewModel.getScore(TEAM.A))
        displayForTeamB(counterViewModel.getScore(TEAM.B))
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    fun addOneForTeamA(v: View?) {
        counterViewModel.addScore(TEAM.A, 1)
        displayForTeamA(counterViewModel.getScore(TEAM.A))
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    fun addTwoForTeamA(v: View?) {
        counterViewModel.addScore(TEAM.A, 2)
        displayForTeamA(counterViewModel.getScore(TEAM.A))
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    fun addThreeForTeamA(v: View?) {
        counterViewModel.addScore(TEAM.A, 3)
        displayForTeamA(counterViewModel.getScore(TEAM.A))
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    fun addOneForTeamB(v: View?) {
        counterViewModel.addScore(TEAM.B, 1)
        displayForTeamB(counterViewModel.getScore(TEAM.B))
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    fun addTwoForTeamB(v: View?) {
        counterViewModel.addScore(TEAM.B, 2)
        displayForTeamB(counterViewModel.getScore(TEAM.B))
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    fun addThreeForTeamB(v: View?) {
        counterViewModel.addScore(TEAM.B, 3)
        displayForTeamB(counterViewModel.getScore(TEAM.B))
    }

    /**
     * Resets the score for both teams back to 0.
     */
    fun resetScore(v: View?) {
        counterViewModel.resetScores()
        displayForTeamA(counterViewModel.getScore(TEAM.A))
        displayForTeamB(counterViewModel.getScore(TEAM.B))
    }

    /**
     * Displays the given score for Team A.
     */
    fun displayForTeamA(score: Int) {
        val scoreView = binding.teamAScore
        scoreView.text = score.toString()
    }

    /**
     * Displays the given score for Team B.
     */
    fun displayForTeamB(score: Int) {
        val scoreView = binding.teamBScore
        scoreView.text = score.toString()
    }
}

