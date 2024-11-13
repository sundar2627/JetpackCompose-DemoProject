package com.example.silaprojectdesign.screens.BottomNav


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.ui.theme.lightGrey
import com.example.silaprojectdesign.ui.theme.textGrey
import com.example.silaprojectdesign.ui.theme.titleBlue


data class TabItem(val title: String, val image: Int)

    @Preview
    @Composable
    fun ExploreUI() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        // .padding(horizontal = 0.dp, vertical = 20.dp)
    ) {


        var values by remember {
            mutableStateOf("")
        }

        val tabList = listOf(
            TabItem("Home", R.drawable.home),
            TabItem("Work", R.drawable.briefcase),
            TabItem("Other", R.drawable.other)

        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
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


        /* TextField(value = values,
             onValueChange = { it ->
                 values = it
             },
             Modifier
                 .fillMaxWidth()
                 .padding(20.dp)
                 .border(2.dp, color = titleBlue, shape = RoundedCornerShape(20.dp)),
             colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White)*/



        LazyRow(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            itemsIndexed(tabList) { index, list ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, color = lightGrey, shape = RoundedCornerShape(15.dp))
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Image(
                        painterResource(list.image), contentDescription = "Image",
                        modifier = Modifier.size(20.dp)
                    )

                    Text(
                        text = list.title,
                        modifier = Modifier.padding(start = 5.dp),
                        titleBlue,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500
                    )


                }
            }


        }

        LazyColumn(Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {

            items(5) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 20.dp, vertical = 10.dp)

                ) {

                    Image(
                        painterResource(R.drawable.loc_icon), contentDescription = "Image",
                        modifier = Modifier.size(40.dp)
                    )

                    Column(
                        Modifier
                            .weight(1f)
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Souq Waqif, Doha",
                            modifier = Modifier.padding(3.dp),
                            style = TextStyle(
                                titleBlue,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500
                            )
                        )

                        Text(
                            text = "Parking lot, Ad-Dawah",
                            modifier = Modifier.padding(3.dp),
                            style = TextStyle(
                                textGrey,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400
                            )
                        )
                    }

                    Image(
                        painterResource(R.drawable.arrow), contentDescription = "Image",
                        modifier = Modifier.size(40.dp)
                    )


                }

                HorizontalDivider(
                    Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 10.dp),
                    thickness = 1.dp,
                    color = Color.LightGray
                )

            }


        }

    }


}