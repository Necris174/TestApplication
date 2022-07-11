package com.example.testapplication

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast

class MyApplication: Application() {

    private val sharedPreferences: SharedPreferences by lazy { getSharedPreferences("main", Context.MODE_PRIVATE) }


    override fun onCreate() {
        super.onCreate()
        var count = sharedPreferences.getInt(SESSION_COUNT,0)
        when (count){
          in 0..1 ->  sharedPreferences.edit().putInt(SESSION_COUNT, ++count).apply()
          2 -> { Toast.makeText(this, "This is your $count app launch",Toast.LENGTH_SHORT).show()
                sharedPreferences.edit().putInt(SESSION_COUNT, ++count).apply()  }
        }


    }



    companion object{
        private const val SESSION_COUNT = "session_count"
    }
}