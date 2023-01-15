package com.ershad.quizappassignment7.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ershad.quizappassignment7.R
import com.ershad.quizappassignment7.constants.Constant.PREF_NAME
import com.ershad.quizappassignment7.data.QuizFakeData
import com.ershad.quizappassignment7.database.QuizDB
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initQuizData()
        setContentView(R.layout.activity_main)
    }

    private fun initQuizData() {
        val initialQuestions = QuizFakeData.getQuizQuestions()
        val quizDAO = QuizDB(this).getQuizDAO()

        MainScope().launch(Dispatchers.IO) {
            quizDAO.insertQuizQuestions(initialQuestions)
        }
    }

}