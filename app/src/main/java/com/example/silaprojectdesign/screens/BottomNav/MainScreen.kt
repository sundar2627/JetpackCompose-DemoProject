package com.example.silaprojectdesign.screens.BottomNav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.screens.UI.thingsTodoUI

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

data class Bannerlist(
    val bannerImage: Int,
)

@Composable
fun MainBottomNavScreen() {


    val items = listOf(
        BottomNavigationItem(
            "Home",
            R.drawable.bottomred1,
            R.drawable.bottom1,
            false
        ),
        BottomNavigationItem(
            "Explore",
            R.drawable.bottomred1,
            R.drawable.bottom2,
            false,
            badgeCount = 45
        ),
        BottomNavigationItem(
            "Account",
            R.drawable.bottomred3,
            R.drawable.bottom3,
            true
        ),
        BottomNavigationItem(
            "Notification",
            R.drawable.bottomred4,
            R.drawable.bottom4,
            true
        ),
    )


    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "home") {

        composable("thingsTodo") { thingsTodoUI() }

      composable("home") { HomeScreenPreview(navController) }
        composable("explore") { ExploreUI() }
        composable("account") { accountUI(navController) }
        composable("notification") { notificationUI(navController) }

    }


    /*val navController1 = rememberNavController()

    NavHost(navController = navController1, startDestination = "faq", builder = {

        composable("faq") {
           FAQ()
        }
    })*/


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = Color.White,
                    tonalElevation = 4.dp
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = { selectedItemIndex = index },
                            label = {
                                Text(
                                    item.title,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            alwaysShowLabel = true,
                            icon = {
                                BadgedBox(badge = {
                                    item.badgeCount?.let {
                                        Badge {
                                            Text(
                                                it.toString(),
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    } ?: if (item.hasNews) Badge() else Text("")
                                }) {
                                    Image(
                                        painter = painterResource(id = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon),
                                        contentDescription = item.title,
                                        modifier = Modifier.size(if (selectedItemIndex == index) 30.dp else 24.dp)
                                    )
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color.White,
                                selectedTextColor = Color.Black,
                                unselectedTextColor = Color.Gray,
                                indicatorColor = Color.White
                            )
                        )
                    }
                }
            }
        ) { paddingValues ->
            // Applying padding to content within the Box to respect insets
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(WindowInsets.systemBars.asPaddingValues()) // Status bar padding applied here
                    .padding(paddingValues) // Additional padding from Scaffold
            ) {
                when (selectedItemIndex) {
                    // 0 -> thingsTodoUI()
                    0 -> HomeScreenPreview(navController)
                    1 -> ExploreUI()
                    2 -> accountUI(navController)
                    else -> notificationUI(navController)
                }
            }
        }
    }

}