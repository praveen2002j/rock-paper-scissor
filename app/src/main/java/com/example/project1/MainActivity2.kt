package com.example.project1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.project1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val back : Button = findViewById(R.id.backbutton)
        back.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent) }

// Retrieve the number of player wins and computer wins from SharedPreferences
        val playerWins = getWinsFromSharedPreferences("playerWins")
        val computerWins = getWinsFromSharedPreferences("computerWins")

        // Display the number of player wins and computer wins
        //Display the number of player wins and computer wins
        binding.textView1.text = "Player Wins: $playerWins"
        binding.textView2.text = "Computer Wins: $computerWins"
    }

    private fun getWinsFromSharedPreferences(key: String): Int {
        // Get SharedPreferences instance
        val sharedPref = getSharedPreferences("com.example.project1.PREFS_NAME", Context.MODE_PRIVATE)

        // Retrieve the number of wins based on the given key, defaulting to 0 if not found
        return sharedPref.getInt(key, 0)
    }
}
