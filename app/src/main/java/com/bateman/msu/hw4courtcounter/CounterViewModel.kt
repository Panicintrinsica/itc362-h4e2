package com.bateman.msu.hw4courtcounter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CounterViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    var scoreTeamA: Int
        get() = savedStateHandle.get<Int>("SCORE_TEAM_A") ?: 0
        set(value) = savedStateHandle.set("SCORE_TEAM_A", value)

    var scoreTeamB: Int
        get() = savedStateHandle.get<Int>("SCORE_TEAM_B") ?: 0
        set(value) = savedStateHandle.set("SCORE_TEAM_B", value)


    fun addScore(team: TEAM, points: Int) {
        when (team) {
            TEAM.A -> scoreTeamA += points
            TEAM.B -> scoreTeamB += points
        }
    }

    fun getScore(team: TEAM): Int {
        return when (team) {
            TEAM.A -> scoreTeamA
            TEAM.B -> scoreTeamB
        }
    }

    fun resetScores() {
        scoreTeamA = 0
        scoreTeamB = 0
    }
}

enum class TEAM {
    A, B
}