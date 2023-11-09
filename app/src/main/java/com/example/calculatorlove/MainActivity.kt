package com.example.calculatorlove

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorlove.databinding.ActivityMainBinding
import com.example.calculatorlove.model.LoveApi
import com.example.calculatorlove.model.LoveModel
import com.example.calculatorlove.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    lateinit var binding: ActivityMainBinding
    val presenter = MainPresenter(provideApi())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding){
            calcBtn.setOnClickListener {
                presenter.getData(firstEt.text.toString(), secondEt.text.toString())
            }
        }
    }

    override fun changeScreen(loveModel: LoveModel) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("key", loveModel)
        startActivity(intent)
    }

    override fun MainPresenter(loveApi: LoveApi): MainPresenter {

    }
}