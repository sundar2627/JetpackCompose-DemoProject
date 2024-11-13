package com.example.silaprojectdesign.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.silaprojectdesign.screens.BottomNav.MainBottomNavScreen
import com.example.silaprojectdesign.screens.UI.FAQ
import com.example.silaprojectdesign.screens.UI.SplashScreenPreview
import com.example.silaprojectdesign.ui.theme.SilaProjectDesignTheme
import com.google.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var showSplash by remember { mutableStateOf(true) }

            if (showSplash) {

                SplashScreenPreview()

                LaunchedEffect(Unit) {   // Start a coroutine to hide the splash screen after a delay
                    delay(3000) // 3-second splash screen delay
                    showSplash = false
                }

            } else {

                SilaProjectDesignTheme {
                    ProvideWindowInsets {


                        MainBottomNavScreen()
                    }
                }
            }


        }
    }
}










