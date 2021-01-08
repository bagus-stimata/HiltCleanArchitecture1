package com.example.hiltcleanarchitecture1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.hiltcleanarchitecture1.R
import com.example.hiltcleanarchitecture1.databinding.ActivityMainBinding
import com.example.hiltcleanarchitecture1.presentation.fragment.ListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel : MainViewModel by viewModels()
    
    lateinit var binder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.container_note, ListFragment.newInstance())
            .commit()


//        viewModel.saveNote("Oke Ketiga")


    }
}