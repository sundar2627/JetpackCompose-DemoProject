package com.example.silaprojectdesign.screens.Dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.silaprojectdesign.ui.theme.titleBlue

@Composable
fun settingsUI(){

    Box(
        modifier = Modifier.background(Color.White)
        //  .background(Color.White, shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
    ) {
        Column {
            Spacer(modifier = Modifier.height(25.dp))


            val mCheckedState = remember{ mutableStateOf(false)}


            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Text(
                    text = "Sila Card",
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = titleBlue
                )

               // CustomSwitchExample()
                Switch(checked = mCheckedState.value, onCheckedChange = {mCheckedState.value = it})


            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Text(
                    text = "Sila Card",
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = titleBlue
                )
                Switch(checked = mCheckedState.value, onCheckedChange = {mCheckedState.value = it})

                //  CustomSwitchExample()

            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Text(
                    text = "Sila Card",
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = titleBlue
                )
                Switch(checked = mCheckedState.value, onCheckedChange = {mCheckedState.value = it})

                // CustomSwitchExample()

            }
        }
    }


}



@Composable
fun CustomSwitchExample(){
    var isEnable by remember{ mutableStateOf(false)}
    Switch(checked = isEnable,
        onCheckedChange = {
            isEnable = it
        })
}


@Composable
fun CustomSwitchExamples() {
    var isChecked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .width(50.dp) // Custom width for the switch
            .height(30.dp) // Custom height for the switch
            .background(
                color = if (isChecked) Color.Red else Color.Gray,
                shape = RoundedCornerShape(15.dp) // Rounded corners
            )
            .border(
                width = 2.dp,
                color = if (isChecked) Color.Transparent else Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable { isChecked = !isChecked }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (isChecked) Arrangement.End else Arrangement.Start,
            modifier = Modifier.fillMaxSize().padding(4.dp) // Add padding for the thumb
        ) {
            Box(
                modifier = Modifier
                    .size(22.dp) // Size of the thumb
                    .background(Color(0xFF1B2442), CircleShape) // Thumb color
            )
        }
    }
}


/*@Composable
fun SwitchExamples() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
        //modifier = Modifier.padding(16.dp)
    ) {
        *//* Text(
             text = if (isChecked) "Switch is ON" else "Switch is OFF",
             modifier = Modifier.padding(end = 8.dp),
             fontSize = 16.sp,
             fontWeight = FontWeight.W500
         )*//*
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF1B2442), // Custom color for the checked thumb
                uncheckedThumbColor = Color(0xFF1B2442), // Custom color for the unchecked thumb
                checkedTrackColor = Color.Red, // Remove background when checked
                uncheckedTrackColor = Color.Red, // Remove background when unchecked
            ),
            *//* colors = SwitchDefaults.colors(
                 checkedThumbColor = Color.Green,
                 uncheckedThumbColor = Color.Red,
                 checkedTrackColor = Color.Transparent,
                 uncheckedTrackColor = Color.Transparent,
                 disabledCheckedTrackColor = Color.Transparent,
                 disabledUncheckedTrackColor = Color.Transparent
             )*//*
        )
    }
}*/


