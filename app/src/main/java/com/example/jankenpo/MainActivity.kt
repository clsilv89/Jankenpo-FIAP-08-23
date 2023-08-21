package com.example.jankenpo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jankenpo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val options: List<String> = listOf("Papel", "Pedra", "Tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.papelImageView.setOnClickListener {
            optionSelected(0)
        }
        binding.pedraImageView.setOnClickListener {
            optionSelected(1)
        }
        binding.tesouraImageView.setOnClickListener {
            optionSelected(2)
        }
    }

    private fun optionSelected(choice: Int) {
        println("Você escolheu ${options[choice]}")

        when (Random.nextInt(3)) {
            0 -> {
                binding.appChoiceImageView.setImageDrawable(getDrawable(R.drawable.papel))
                when (choice) {
                    0 -> binding.resultTextView.text =
                            getString(R.string.result_draw, options[choice])

                    1 -> binding.resultTextView.text =
                        getString(R.string.result_app_wins, options[0])

                    2 -> binding.resultTextView.text =
                        getString(R.string.result_app_loses, options[choice])
                }
            }

            1 -> {
                binding.appChoiceImageView.setImageDrawable(getDrawable(R.drawable.pedra))
                when (choice) {
                    0 -> binding.resultTextView.text =
                        getString(R.string.result_app_loses, options[choice])

                    1 -> binding.resultTextView.text =
                        getString(R.string.result_draw, options[choice])

                    2 -> binding.resultTextView.text =
                        getString(R.string.result_app_wins, options[1])
                }
            }

            2 -> {
                binding.appChoiceImageView.setImageDrawable(getDrawable(R.drawable.tesoura))
                when (choice) {
                    0 -> binding.resultTextView.text =
                        getString(R.string.result_app_wins, options[2])

                    1 -> binding.resultTextView.text =
                        getString(R.string.result_app_loses, options[choice])

                    2 -> binding.resultTextView.text =
                        getString(R.string.result_draw, options[choice])
                }
            }
        }
    }
}
