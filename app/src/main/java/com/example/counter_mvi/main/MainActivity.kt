package com.example.counter_mvi.main

import androidx.activity.viewModels
import com.example.counter_mvi.R
import com.example.counter_mvi.base.MviActivity
import com.example.counter_mvi.databinding.ActivityMainBinding


class MainActivity : MviActivity<ActivityMainBinding, MainViewModel>() {
    override val layout: Int = R.layout.activity_main

    override val viewModel: MainViewModel by viewModels()


    /***
     * These ClickListeners are not necessary, if we are using Data Binding
     * With viewModel.sendIntent we send an Intent from View to our ViewModel
     **/

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clickListeners()
    }

    private fun clickListeners() {
        binding.startButton.setOnClickListener {
            viewModel.sendIntent(StartClicked)
        }
        binding.plusButton.setOnClickListener {
            viewModel.sendIntent(PlusClicked)
        }
        binding.minusButton.setOnClickListener {
            viewModel.sendIntent(MinusClicked)
        }
    }
     */
}