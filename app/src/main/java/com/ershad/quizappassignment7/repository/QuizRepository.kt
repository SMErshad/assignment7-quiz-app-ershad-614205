package com.ershad.quizappassignment7.repository

import com.ershad.quizappassignment7.data.Quiz

interface QuizRepository {
    suspend fun insertQuizQuestions(quizList : MutableList<Quiz>)
    suspend fun insertQuiz(quiz: Quiz)
    suspend fun getQuizList(): MutableList<Quiz>
    suspend fun resetQuestionSet()
}