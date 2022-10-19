package com.example.counter_mvi.main

import androidx.activity.viewModels
import com.example.counter_mvi.R
import com.example.counter_mvi.base.MviActivity
import com.example.counter_mvi.databinding.ActivityMainBinding

class MainActivity : MviActivity<ActivityMainBinding, MainViewModel>() {
    override val layout: Int = R.layout.activity_main

    override val viewModel: MainViewModel by viewModels()
}