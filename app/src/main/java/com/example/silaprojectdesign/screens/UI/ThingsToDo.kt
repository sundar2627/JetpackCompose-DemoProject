package com.example.silaprojectdesign.screens.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.screens.BottomNav.Services
import com.example.silaprojectdesign.ui.theme.cardGrey
import com.example.silaprojectdesign.ui.theme.iconRed
import com.example.silaprojectdesign.ui.theme.textGrey
import com.example.silaprojectdesign.ui.theme.titleBlue
import com.example.silaprojectdesign.ui.theme.titleGray


@Preview
@Composable
fun thingsTodoUI(modifier: Modifier = Modifier) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column {


            Image(
                painter = painterResource(R.drawable.back_arrow_bg),
                contentDescription = "image",
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .size(40.dp)
            )

            Text(
                text = "Thing to do",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp),
                fontWeight = FontWeight.W700,
                color = titleBlue
            )


            Text(
                text = "Explore the major events happening \nin Qatar",
                modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                style = TextStyle(
                    textGrey,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400
                ),
            )


            var selectedIndex by remember { mutableStateOf(0) }


            var titles = listOf("Upcoming", "Sports", "Heritage & Control","Upcoming", "Sports", "Heritage & Control")

            LazyRow(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                itemsIndexed(titles) { index, values ->

                    val isSelected = selectedIndex == index
                    val backgroundColor = if (isSelected) iconRed else titleGray
                    val textColor = if (isSelected) Color.White else Color.Black


                    Box(
                        modifier = Modifier
                            .padding(end = 15.dp, top = 5.dp, bottom = 5.dp)
                            .background(color = backgroundColor, shape = RoundedCornerShape(15.dp))
                            .clickable { selectedIndex = index }
                    ) {
                        Text(
                            text = values,
                            color = textColor,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                        )
                    }

                }
            }

            val exploreLists = listOf(
                listOf(
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
                ),
                listOf(
                    Services(
                        image = R.drawable.card_image,
                        date = "22 Jan 2024 - 22 Jan 2024",
                        title = "Qatar Airways Grand Prix of Qatar 2024!",
                        locationName = "Lusail Boulevard"
                    ), Services(
                        image = R.drawable.card_image,
                        date = "22 Jan 2024 - 22 Jan 2024",
                        title = "Qatar Airways Grand Prix of Qatar 2024!",
                        locationName = "Lusail Boulevard"
                    )
                ),
                listOf(
                    Services(
                        image = R.drawable.card_image,
                        date = "22 Jan 2024 - 22 Jan 2024",
                        title = "Qatar Airways Grand Prix of Qatar 2024!",
                        locationName = "Lusail Boulevard"
                    )
                ),

                        listOf(
                        Services(
                            image = R.drawable.card_image,
                            date = "Hi",
                            title = "Qatar Airways Grand Prix of Qatar 2024!",
                            locationName = "Lusail Boulevard"
                        )
                        )
            )

            val currentList = exploreLists.getOrNull(selectedIndex) ?: emptyList()


            LazyColumn {
                itemsIndexed(currentList) { index,item, ->
                    Column(
                        Modifier
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                            .height(180.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(cardGrey)
                            .offset(10.dp, 5.dp)
                    ) {
                        // Item content remains the same as before
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
                                    .clip(RoundedCornerShape(10.dp))
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

                            Spacer(modifier = Modifier.weight(1f))

                            Image(
                                painter = painterResource(R.drawable.export_btn),
                                contentDescription = "image",
                                modifier = Modifier.size(30.dp),
                                alignment = Alignment.CenterEnd
                            )
                        }
                    }
                }
            }



        }

    }


}