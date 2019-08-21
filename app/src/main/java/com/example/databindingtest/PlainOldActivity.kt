package com.example.databindingtest

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databindingtest.databinding.PlainActivityBinding

class PlainOldActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : PlainActivityBinding = DataBindingUtil.setContentView(this, R.layout.plain_activity)

        binding.name = "CHO"
        binding.lastName = "HYUNWOOK"
    }
}