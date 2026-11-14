package com.depremhazirlik.app.ui

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.depremhazirlik.app.R
import com.depremhazirlik.app.data.QuizData
import com.depremhazirlik.app.databinding.ActivityQuizBinding
import com.google.android.material.button.MaterialButton

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding

    private var index = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnNext.setOnClickListener {
            if (index >= QuizData.total() - 1) {
                showResult()
            } else {
                index++
                renderQuestion()
            }
        }

        binding.btnRestart.setOnClickListener {
            index = 0
            score = 0
            renderQuestion()
        }

        renderQuestion()
    }

    private fun renderQuestion() {
        answered = false

        binding.quizScroll.scrollTo(0, 0)
        binding.questionCard.visibility = View.VISIBLE
        binding.resultCard.visibility = View.GONE
        binding.btnNext.visibility = View.GONE
        binding.explanationText.visibility = View.GONE

        val question = QuizData.questions[index]

        binding.questionCounter.text =
            getString(R.string.quiz_question_counter, index + 1, QuizData.total())
        binding.questionText.text = question.question

        binding.optionContainer.removeAllViews()
        val density = resources.displayMetrics.density

        question.options.forEachIndexed { optionIndex, optionText ->
            val button = MaterialButton(this).apply {
                text = optionText
                isAllCaps = false
                gravity = Gravity.CENTER_VERTICAL or Gravity.START
                setOnClickListener { onAnswer(optionIndex) }
            }

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.topMargin = (8 * density).toInt()
            binding.optionContainer.addView(button, params)
        }
    }

    private fun onAnswer(optionIndex: Int) {
        if (answered) return
        answered = true

        val question = QuizData.questions[index]
        val correctColor = ContextCompat.getColor(this, R.color.success_green)
        val wrongColor = ContextCompat.getColor(this, R.color.quiz_wrong)

        for (i in 0 until binding.optionContainer.childCount) {
            val button = binding.optionContainer.getChildAt(i) as MaterialButton
            button.isClickable = false
            when {
                i == question.correctIndex -> {
                    button.backgroundTintList =
                        android.content.res.ColorStateList.valueOf(correctColor)
                    button.setTextColor(Color.WHITE)
                }
                i == optionIndex -> {
                    button.backgroundTintList =
                        android.content.res.ColorStateList.valueOf(wrongColor)
                    button.setTextColor(Color.WHITE)
                }
            }
        }

        if (optionIndex == question.correctIndex) score++

        binding.explanationText.text = question.explanation
        binding.explanationText.visibility = View.VISIBLE

        binding.btnNext.visibility = View.VISIBLE
        binding.btnNext.setText(
            if (index >= QuizData.total() - 1) R.string.quiz_finish else R.string.quiz_next
        )
    }

    private fun showResult() {
        binding.questionCard.visibility = View.GONE
        binding.btnNext.visibility = View.GONE
        binding.resultCard.visibility = View.VISIBLE

        binding.resultScore.text = getString(R.string.quiz_score, score, QuizData.total())

        val messageRes = when {
            score >= 5 -> R.string.quiz_result_great
            score >= 3 -> R.string.quiz_result_good
            else -> R.string.quiz_result_low
        }
        binding.resultMessage.setText(messageRes)
    }
}
