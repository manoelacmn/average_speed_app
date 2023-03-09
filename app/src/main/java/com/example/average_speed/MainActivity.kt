package com.example.average_speed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.average_speed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener { calculateAverageSpeed() }
    }

    fun calculateAverageSpeed()
    {
        var finalSpace = binding.etFinalSpace.text.toString().toDouble();
        var initialSpace = binding.etInitialSpace.text.toString().toDouble()
        var initialSpeed = binding.etInitialSpeed.text.toString().toDouble()
        var finalSpeed = binding.etFinalSpeed.text.toString().toDouble()

        var resultTime =  (finalSpace-initialSpace)/(finalSpeed-initialSpeed)

        val result_display = String.format("%.2f",resultTime)
        binding.tvResult.text = getString(R.string.TimeResult,result_display)
    }
}