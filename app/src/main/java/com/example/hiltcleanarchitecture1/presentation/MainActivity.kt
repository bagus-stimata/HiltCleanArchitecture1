package com.example.hiltcleanarchitecture1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.hiltcleanarchitecture1.R
import com.example.hiltcleanarchitecture1.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    val viewModel : MainViewModel by viewModels()
    
//    lateinit var binder: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

//        binder = MainActivityBinding.inflate(layoutInflater)
//        setContentView(binder.root)



//        val fragmentManager = supportFragmentManager
//        fragmentManager
//            .beginTransaction()
//            .replace(R.id.nav_fragment, ListFragment())
//            .commit()


//        setSupportActionBar(binder.toolbar)
//        val navController = findNavController(R.id.nav_fragment)
//        NavigationUI.setupWithNavController(binder.toolbar, navController)

    }
}