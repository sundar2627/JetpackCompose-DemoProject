package com.example.silaprojectdesign.screens.BottomNav

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.screens.Dialog.bottomSheetConnectUI
import com.example.silaprojectdesign.ui.theme.RED
import com.example.silaprojectdesign.ui.theme.cyan
import com.example.silaprojectdesign.ui.theme.textGray
import com.example.silaprojectdesign.ui.theme.titleBlue
import kotlinx.coroutines.launch

data class accountList(val image: Int, val title: String, val arrow: Int)

data class ItemType(
    val image: Int, // resource ID for image
    val title: String,
    val arrow: Int // resource ID for arrow icon
)


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun accountUI(navController: NavHostController) {




        /* Row(
            Modifier
                 .fillMaxWidth()
                 .padding(horizontal = 20.dp, vertical = 30.dp)) {

             Column(
                 Modifier
                     .background(color = bgGrey, shape = RoundedCornerShape(15.dp))
                     .padding(horizontal = 10.dp, vertical = 8.dp),
                 horizontalAlignment = Alignment.End
             ) {
                 Text(
                     text = "Login",
                     fontWeight = FontWeight.W500,
                     color = Color.White, textAlign = TextAlign.End
                 )
             }

         }*/

    Column(modifier = Modifier.background(titleBlue)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val bgColor = listOf(Color(0xFF1B2442), Color(0xFF666666))


            Text(
                text = "MK",
                modifier = Modifier
                    .background(
                        brush = Brush.linearGradient(bgColor),
                        shape = CircleShape
                    )
                    .padding(horizontal = 10.dp, vertical = 12.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color.White
            )


            Text(
                text = "Mahmoud Karim",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 5.dp)
                    .weight(1f),
                fontWeight = FontWeight.W700,
                color = Color.White
            )


            var expanded by remember { mutableStateOf(false) }
            val context = LocalContext.current


            Image(
                painter = painterResource(R.drawable.account_icon),
                contentDescription = "Image",
                Modifier
                    .size(40.dp)
                    .clickable { expanded = !expanded }
            )

            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .wrapContentSize()
            ) {
                // DropdownMenu for the side popup menu
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    // .padding(horizontal = 10.dp)


                    // .border(0.dp, color = Color.White, shape = RoundedCornerShape(15.dp))
                    //.align(Alignment.CenterVertically)
                    ,
                    offset = DpOffset(
                        x = (-40).dp,
                        y = 0.dp
                    ) // Offset to position the menu on the right side

                    //,offset = DpOffset(100.dp, 50.dp) // Align to the end by adjusting as needed
                ) {
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            // Toast.makeText(context, "Option 1 clicked", Toast.LENGTH_SHORT).show()
                        },
                        text = {
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.edit),
                                    contentDescription = "Option 1",
                                    modifier = Modifier.size(20.dp),
                                    //  tint = Color.Gray
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Edit Password")
                            }
                        }
                    )
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            Toast.makeText(context, "Option 2 clicked", Toast.LENGTH_SHORT).show()
                        },
                        text = {
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.key),
                                    contentDescription = "Option 1",
                                    modifier = Modifier.size(20.dp),

                                    )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Change Password")
                            }
                        }
                    )
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            Toast.makeText(context, "Option 3 clicked", Toast.LENGTH_SHORT).show()
                        },
                        text = {
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.delete),
                                    contentDescription = "Option 1",
                                    modifier = Modifier.size(20.dp),
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Delete Profile")
                            }
                        }
                    )
                }
            }
        }
        val sheetState =
            rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        val coroutineScope = rememberCoroutineScope()

        // Wrap the LazyColumn with ModalBottomSheetLayout
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetShape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp
            ), // Apply corner radius to the bottom sheet
            sheetBackgroundColor = Color.White, // Ensure the background is white for the entire sheet
            sheetContent = {
                bottomSheetConnectUI() // Make sure this composable is implemented correctly
            }
        ) {

            Column(
                Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                    )
            ) {

                val item = listOf(
                    accountList(
                        R.drawable.sila_card,
                        "Sila Card",
                        R.drawable.right_arrow
                    ),

                    accountList(
                        R.drawable.sila_card,
                        "Cardsss",
                        R.drawable.right_arrow
                    ),
                )

                Text(
                    text = "Account",
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 15.dp)
                        .clickable {
//                            faqClickeD()
                            navController.navigate("thingsTodo")
                        },
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = cyan
                )

                // Define the bottom sheet state
                // Set up bottom sheet state and coroutine scope

                LazyColumn {

                    itemsIndexed(item) { index, item ->


                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp, vertical = 5.dp)
                                .clickable {
                                    coroutineScope.launch { sheetState.show() }
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(item.image),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .size(40.dp)
                                    .weight(0.3f),
                                alignment = Alignment.TopStart
                            )
                            Text(
                                text = item.title,
                                modifier = Modifier
                                    .padding(vertical = 5.dp)
                                    .weight(1f),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                color = titleBlue
                            )
                            Image(
                                painter = painterResource(item.arrow),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(0.5f),
                                Alignment.TopEnd
                            )

                        }

                    }

                }


                Text(
                    text = "Settings",
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = cyan
                )


                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(R.drawable.sila_card),
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(40.dp)
                            .weight(0.25f),
                        alignment = Alignment.TopStart
                    )
                    Text(
                        text = "Sila Card",
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .weight(1f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = titleBlue
                    )

                    SwitchExample()

                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(R.drawable.sila_card),
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(40.dp)
                            .weight(0.3f),
                        alignment = Alignment.TopStart
                    )
                    Text(
                        text = "Sila Card",
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .weight(1f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = titleBlue
                    )
                    Row(modifier = Modifier.weight(0.5f), horizontalArrangement = Arrangement.End) {
                        Text(text = "English", color = textGray)
                        Image(
                            painter = painterResource(R.drawable.right_arrow),
                            contentDescription = "Image",
                            modifier = Modifier
                                .size(20.dp), Alignment.TopEnd
                        )
                    }

                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(R.drawable.sila_card),
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(40.dp)
                            .weight(0.3f),
                        alignment = Alignment.TopStart
                    )
                    Text(
                        text = "Sila Card",
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .weight(1f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = titleBlue
                    )
                    Row(modifier = Modifier.weight(0.5f), horizontalArrangement = Arrangement.End) {
                        Text(text = "Light", color = textGray)
                        Image(
                            painter = painterResource(R.drawable.right_arrow),
                            contentDescription = "Image",
                            modifier = Modifier
                                .size(20.dp), Alignment.TopEnd
                        )
                    }

                }

                Text(
                    text = "Help",
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = cyan
                )


                /*   MyLazyColumn(items = item) {
                  //     contactUsUI()
                   }*/
                LazyColumn {

                    itemsIndexed(item) { index, item ->

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(item.image),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .size(40.dp)
                                    .weight(0.3f),
                                alignment = Alignment.TopStart
                            )

                            Text(
                                text = item.title,
                                modifier = Modifier
                                    .padding(vertical = 5.dp)
                                    .weight(1f),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                color = titleBlue
                            )
                            Image(
                                painter = painterResource(item.arrow),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(0.5f),
                                Alignment.TopEnd
                            )

                        }

                    }
                }

                //}


                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 5.dp)
                        .clickable {
                            Log.d("AccountScreen", "Logout row clicked")



                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(R.drawable.logout),
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(40.dp)
                            .weight(0.4f),
                        alignment = Alignment.TopStart
                    )
                    Text(
                        text = "Log Out",
                        modifier = Modifier
                            .weight(1.5f)
                            .clickable
                            {
                                Log.d("AccountScreen", "e.message.toString()")
                                try {
                                    navController.navigate("thingsTodo")
                                }catch (e:Exception){
                                    Log.d("AccountScreen", e.message.toString())

                                }
                            },
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        color = RED
                    )
                    Image(
                        painter = painterResource(R.drawable.right_arrow),
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(30.dp)
                            .weight(0.5f),
                        Alignment.TopEnd
                    )
                }

                // Show TermsConditions composable if showTerms is true

            }


        }
    }
}


@Composable
fun SwitchExample() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
        //modifier = Modifier.padding(16.dp)
    ) {
        /* Text(
             text = if (isChecked) "Switch is ON" else "Switch is OFF",
             modifier = Modifier.padding(end = 8.dp),
             fontSize = 16.sp,
             fontWeight = FontWeight.W500
         )*/
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF1B2442), // Custom color for the checked thumb
                uncheckedThumbColor = Color(0xFF1B2442), // Custom color for the unchecked thumb
                checkedTrackColor = Color.Red, // Remove background when checked
                uncheckedTrackColor = Color.Red, // Remove background when unchecked
            ),
            /* colors = SwitchDefaults.colors(
                 checkedThumbColor = Color.Green,
                 uncheckedThumbColor = Color.Red,
                 checkedTrackColor = Color.Transparent,
                 uncheckedTrackColor = Color.Transparent,
                 disabledCheckedTrackColor = Color.Transparent,
                 disabledUncheckedTrackColor = Color.Transparent
             )*/
        )
    }
}

@Composable
fun MyLazyColumn(items: List<accountList>, onContactUsClick: () -> Unit) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(item.image),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(40.dp)
                        .weight(0.3f),
                    alignment = Alignment.TopStart
                )

                Text(
                    text = item.title,
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .weight(1f)
                        .clickable {
                            onContactUsClick() // Call the function on item click
                        },
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Blue // Replace with your titleBlue color
                )

                Image(
                    painter = painterResource(item.arrow),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .size(30.dp)
                        .weight(0.5f),
                    alignment = Alignment.TopEnd
                )
            }
        }
    }


}





