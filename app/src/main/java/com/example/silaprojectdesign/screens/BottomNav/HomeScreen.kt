package com.example.silaprojectdesign.screens.BottomNav

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.silaprojectdesign.R


import com.example.silaprojectdesign.ui.theme.bgBlue
import com.example.silaprojectdesign.ui.theme.cardGrey
import com.example.silaprojectdesign.ui.theme.lightGrey
import com.example.silaprojectdesign.ui.theme.textGrey
import com.example.silaprojectdesign.ui.theme.textRed
import com.example.silaprojectdesign.ui.theme.titleBlue

@Composable
@Preview

fun HomeScreenPreview(navController: NavHostController? = null) {


    Box(
        Modifier

            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(8.dp)


    ) {


        Column {
            val bannerImages = listOf(
                Bannerlist(R.drawable.scroll_banner),
                Bannerlist(R.drawable.scroll_banner),
                Bannerlist(R.drawable.scroll_banner)
            )


            val scrollState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            val totalSize = bannerImages.size

            Column(
                Modifier
                    .fillMaxWidth()
                    .background(bgBlue)
            ) {


                LazyRow(
                    state = scrollState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(bannerImages) { _, list ->

                        val configuration = LocalConfiguration.current
                        val screenWidth = configuration.screenWidthDp.dp
                        val itemWidth = screenWidth * 0.8f // 80% of screen width for each item


                        Card(
                            modifier = Modifier
                                .width(itemWidth)
                                .height(screenWidth * 0.5f),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Box(
                                modifier = Modifier.background(bgBlue)
                            ) {
                                Image(
                                    painter = painterResource(list.bannerImage),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                }

                // Page Indicator with filling effect
                val indicatorWidth =
                    if (totalSize > 0 && scrollState.layoutInfo.visibleItemsInfo.isNotEmpty()) {
                        val firstVisibleItemInfo =
                            scrollState.layoutInfo.visibleItemsInfo.firstOrNull()
                        val itemSize = firstVisibleItemInfo?.size?.toFloat() ?: 1f // Avoid null
                        val scrollOffset = scrollState.firstVisibleItemScrollOffset.toFloat()
                        (scrollState.firstVisibleItemIndex + scrollOffset / itemSize) / totalSize
                    } else {
                        0f // No width if there are no items
                    }

                Box(
                    modifier = Modifier
                        .width(100.dp) // Fixed width for the indicator
                        .height(8.dp)
                        .background(Color.White)
                        .padding(horizontal = 16.dp), contentAlignment = Alignment.TopCenter
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(indicatorWidth)
                            .background(Color.Red)
                    )
                }
                /* // Page Indicator below LazyRow
                 val totalItems = bannerImages.size
                 val currentPage =
                     remember { derivedStateOf { scrollState.firstVisibleItemIndex } }


                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(top = 16.dp),
                     horizontalArrangement = Arrangement.Center
                 ) {
                     repeat(totalItems) { index ->
                         Box(
                             modifier = Modifier
                                 .size(if (index == currentPage.value) 10.dp else 8.dp)
                                 .padding(horizontal = 4.dp)
                                 .background(
                                     if (index == currentPage.value) Color.White else Color.Gray,
                                     shape = CircleShape
                                 )
                         )
                     }
                 }

                 // Smooth scroll functionality when item changes
                 LaunchedEffect(currentPage.value) {
                     coroutineScope.launch {
                         scrollState.animateScrollToItem(currentPage.value)
                     }
                 }*/


                /* LazyRow(
                     state = scrollState,
                     modifier = Modifier.fillMaxWidth(),
                     contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                     horizontalArrangement = Arrangement.spacedBy(16.dp) // Space between items
                 ) {
                     itemsIndexed(bannerImages) { i, list ->

                         val configuration = LocalConfiguration.current
                         val screenWidth = configuration.screenWidthDp.dp
                         val itemWidth =
                             screenWidth * 0.8f // Set width to 80% of screen width for each item

                         Card(
                             modifier = Modifier
                                 //   .width(300.dp) // Width slightly less than screen width
                                 //  .height(200.dp), // Adjust height as needed
                                 .width(itemWidth) // Dynamically set width based on screen width
                                 .height(screenWidth * 0.5f), // Example: 50% of screen width for height
                             shape = RoundedCornerShape(15.dp)
                             // elevation = 8.dp // Optional elevation for depth
                         ) {
                             Box(
                                 modifier = Modifier
                                     .background(bgBlue) // Fallback color if image is missing
                             ) {
                                 Image(
                                     painter = painterResource(list.bannerImage),
                                     contentDescription = null,
                                     contentScale = ContentScale.Crop,
                                     modifier = Modifier.fillMaxSize() // Image fills the Card
                                 )
                             }
                         }

                     }

                 }*/


            }



            Column() {

                var values by remember {
                    mutableStateOf("")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        //  .offset(x=0.dp,y=-15.dp)

                        .border(width = 2.dp, color = lightGrey, shape = CircleShape)
                ) {

                    Image(
                        Icons.Filled.KeyboardArrowLeft, contentDescription = "Image",
                        modifier = Modifier
                            .size(25.dp)
                            .offset(15.dp, 20.dp),
                    )
                    TextField(
                        value = values,
                        onValueChange = { it ->
                            values = it
                        },
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                        //   .border(2.dp, color = titleBlue, shape = RoundedCornerShape(20.dp)),
                        ,
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.White
                        )
                    )
                }

                Text(
                    text = "Transport Services",
                    modifier = Modifier.padding(
                        start = 20.dp,
                        bottom = 3.dp,
                        end = 20.dp
                    ),
                    style = TextStyle(titleBlue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )

                Text(
                    text = "your Seamless Transport Solutions",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
                    style = TextStyle(textGrey, fontSize = 14.sp, fontWeight = FontWeight.W500)
                )

                LazyRow(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    val transportServices = listOf("Metro", "Bus", "Tram", "Taxi", "Flight")

                    items(transportServices) { service ->

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Image(

                                painter = painterResource(R.drawable.circle),
                                contentDescription = "Sample Image",
                                modifier = Modifier
                                    .padding(horizontal = 20.dp, vertical = 15.dp)
                                    .size(50.dp)
                                    .clip(CircleShape)
                            )

                            //  Spacer(Modifier.height(5.dp))
                            Text(
                                text = service,
                                style = TextStyle(fontWeight = FontWeight.Normal)
                            )
                        }

                    }

                }
                val context = LocalContext.current
                Text(
                    text = "Services",
                    modifier = Modifier
                        .padding(
                            start = 20.dp,
                            top = 20.dp,
                            bottom = 3.dp,
                            end = 20.dp
                        )
                        .clickable {
                            Toast
                                .makeText(context, "hello", Toast.LENGTH_SHORT)
                                .show()

                        },
                    style = TextStyle(titleBlue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )

                Text(
                    text = "Manage Cards,Tickets and track your claims",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
                    style = TextStyle(textGrey, fontWeight = FontWeight.W500)
                )

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val services = listOf("Sila Card", "Bank Card", "e Card", "Claims")
                    items(services) { serve ->

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painterResource(R.drawable.rec_icon),
                                modifier = Modifier
                                    .padding(20.dp, 15.dp)
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentDescription = "Image",
                            )
                            // Spacer(modifier = Modifier.padding(2.dp))
                            Text(text = serve)

                        }
                    }
                }

                Text(
                    text = "Things to do",
                    modifier = Modifier.padding(
                        start = 20.dp,
                        top = 20.dp,
                        bottom = 3.dp,
                        end = 20.dp
                    ),
                    style = TextStyle(titleBlue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = "Explore the major events happening \nin Qatar",
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
                        style = TextStyle(
                            textGrey,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500
                        )
                    )

                    Text(
                        text = "Explore more",
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                            .align(Alignment.BottomEnd)
                            .clickable {

                                Log.d("112233", "HomeScreenPreview: ")

                                if (navController != null) {
                                    navController.navigate(route = "thingsTodo")
                                }
                            },
                        style = TextStyle(
                            textRed,
                            fontSize = 14.sp,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.W500
                        )
                    )
                }


//Box(){


                val explorePlaces = listOf(
                    Services(
                        image = R.drawable.card_image,
                        date = "22 Jan 2024 - 22 Jan 2024",
                        title = "Qatar Airways Grand Prix of Qatar 2024!",
                        locationName = "Lusail Boulevard"
                    ),
                    Services(
                        image = R.drawable.card_image,
                        date = "22 Jan 2024 - 22 Jan 2024",
                        title = "Qatar Airways Grand Prix of Qatar 2024!",
                        locationName = "Lusail Boulevard"
                    ),
                    Services(
                        image = R.drawable.card_image,
                        date = "22 Jan 2024 - 22 Jan 2024",
                        title = "Qatar Airways Grand Prix of Qatar 2024!",
                        locationName = "Lusail Boulevard"
                    )
                )


                LazyRow(Modifier.fillMaxWidth()) {


                    itemsIndexed(explorePlaces) { index, item ->

                        Column(
                            Modifier
                                .padding(horizontal = 20.dp, vertical = 20.dp)
                                .height(200.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(cardGrey)
                                .offset(10.dp, 5.dp)
                        ) {


                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painterResource(item.image),
                                    contentDescription = "Image",
                                    modifier = Modifier
                                        .padding(start = 20.dp, top = 20.dp)
                                        .size(80.dp)
                                        .clip(
                                            RoundedCornerShape(10.dp)
                                        )
                                )

                                Column(
                                    Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center
                                ) {

                                    Text(
                                        text = item.date,
                                        modifier = Modifier.padding(
                                            horizontal = 20.dp,
                                            vertical = 2.dp
                                        ),
                                        style = TextStyle(
                                            textGrey,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium
                                        )
                                    )

                                    Text(
                                        text = item.title,
                                        modifier = Modifier.padding(
                                            horizontal = 20.dp,
                                            vertical = 2.dp
                                        ),
                                        style = TextStyle(
                                            titleBlue,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.W600
                                        )
                                    )

                                }

                            }

                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 15.dp),
                                thickness = 1.dp,
                                color = Color(0xFF464F5D)
                            )

                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.location),
                                    tint = Color.Gray,
                                    contentDescription = "image",
                                    modifier = Modifier.size(20.dp)
                                )

                                Text(
                                    text = item.locationName,
                                    modifier = Modifier.padding(start = 5.dp),
                                    style = TextStyle(color = textGrey)
                                )

                                Spacer(modifier = Modifier.weight(1f)) // Fills remaining space, pushing Image to the end

                                Image(
                                    painter = painterResource(R.drawable.export_btn),
                                    contentDescription = "image",
                                    modifier = Modifier.size(40.dp), // Only set size here, no fillMaxWidth()
                                    alignment = Alignment.CenterEnd
                                )
                            }


                        }

                    }
                }



                Text(
                    text = "Recommended Places",
                    modifier = Modifier.padding(
                        start = 20.dp,
                        top = 10.dp,
                        bottom = 3.dp,
                        end = 20.dp
                    ),
                    style = TextStyle(titleBlue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )

                Text(
                    text = "Tailored Travel Recommendations",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 2.dp),
                    style = TextStyle(textGrey, fontWeight = FontWeight.W500)
                )


                val backgroundImages = listOf(
                    bgImage(R.drawable.place1),
                    bgImage(R.drawable.place1),
                    bgImage(R.drawable.place1),
                    bgImage(R.drawable.place1), bgImage(R.drawable.place1),
                    bgImage(R.drawable.place1),
                )

                val configuration = LocalConfiguration.current
                val screenWidth = configuration.screenWidthDp.dp
                val itemWidth =
                    screenWidth * 0.8f // Set width to 80% of screen width for each item

                //  MyCardWithDrawableBackground(backgroundImage)
                // MyCardWithBackgroundColor()

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp) // Space between items
                ) {
                    itemsIndexed(backgroundImages) { index, item ->
                        Card(
                            modifier = Modifier
                                //   .width(300.dp) // Width slightly less than screen width
                                //  .height(200.dp), // Adjust height as needed
                                .width(itemWidth) // Dynamically set width based on screen width
                                .height(screenWidth * 0.5f), // Example: 50% of screen width for height
                            shape = RoundedCornerShape(15.dp)
                            // elevation = 8.dp // Optional elevation for depth
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(Color.Red) // Fallback color if image is missing
                            ) {
                                Image(
                                    painter = painterResource(item.image),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize() // Image fills the Card
                                )
                            }
                        }
                    }
                }
            }


        }


    }


}

data class Services(
    var image: Int,
    var date: String,
    var title: String,
    var locationName :String
)


@Composable
fun MyCardWithBackgroundColor() {
    Card(
        shape = RoundedCornerShape(20.dp), // Rounded corners with radius 20.dp
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .height(500.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF51C3C4)) // Set background color here
                .fillMaxSize()
        ) {
            // Content inside the card can go here
            Text(
                text = "Tailored Travel Recommendations",
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 2.dp),
                style = TextStyle(textGrey, fontWeight = FontWeight.W500)
            )
        }
    }
}

@Composable
fun MyCardWithDrawableBackground(bgImage: bgImage) {
    Card(
        shape = RoundedCornerShape(20.dp), // Rounded corners with radius 20.dp
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red) // Fallback color if image is missing
        ) {


            val backgroundImages: Painter = painterResource(id = R.drawable.place1)
            Image(
                painter = backgroundImages,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

data class bgImage(val image: Int)