package com.example.counter_mvi.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import com.example.counter_mvi.BR

abstract class MviActivity<B : ViewDataBinding, VM : MviViewModel<out UiIntent, out UiState>> :
    AppCompatActivity() {

    protected abstract val viewModel: VM
    protected abstract val layout: Int

    private var _binding: B? = null

    protected val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = setContentView(this, layout)
        setupBinding()
    }

    private fun setupBinding() {
        binding.apply {
            lifecycleOwner = this@MviActivity
            setVariable(BR.viewModel, viewModel)
        }
    }
}
