package com.example.databindingtest

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.databindingtest.data.SimpleViewModel
import com.example.databindingtest.databinding.PlainActivityBinding

class PlainOldActivity: AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(SimpleViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : PlainActivityBinding = DataBindingUtil.setContentView(this, R.layout.plain_activity)

        binding.lifecycleOwner = this

        binding.viewmodel = viewModel
    }
}