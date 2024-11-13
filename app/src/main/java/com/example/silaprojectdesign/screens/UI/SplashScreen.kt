package com.example.silaprojectdesign.screens.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.ui.theme.RED
import com.example.silaprojectdesign.ui.theme.bgBlue
import com.example.silaprojectdesign.ui.theme.splashRed

@Preview
@Composable
fun SplashScreenPreview() {

//    var gradientBg = listOf(Color.Yellow, Color.Red, Color.Magenta)
 //  var gradientBgs = listOf(splashRed.copy(alpha = 0.1f), bgBlue)
  val gradientBg = listOf(
        0.0f to splashRed.copy(alpha = 0.5f),  // Red with reduced opacity at the start
        0.2f to bgBlue                         // Transition to solid blue for the rest
    )
    Box(
        Modifier
            .fillMaxSize()
       .background(brush = Brush.verticalGradient(colorStops = gradientBg.toTypedArray()))
           // .background(brush = Brush.verticalGradient(gradientBgs))
    ) {

        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val screenHeight = configuration.screenHeightDp.dp


        val width25 = screenWidth * 0.25f
        val height60 = screenHeight * 0.6f


       Column {

            Image(
                painter = painterResource(R.drawable.splash_mainlogo),
                modifier = Modifier.fillMaxWidth().height(height60),
                contentDescription = "",
                alignment = Alignment.Center,
            )

            Text(
                text = "Sila Life Connected",
                Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.W700
            )

            Image(
                painter = painterResource(R.drawable.logo),
                modifier = Modifier.fillMaxWidth().padding(top = 30.dp).size(50.dp),
                contentDescription = "",
                alignment = Alignment.Center
            )

            Text(
                text = "Version 1.0",
                Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.W400
            )
        }


    }

}