package com.example.silaprojectdesign.screens.BottomNav

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.screens.Dialog.alertDialogConnect
import com.example.silaprojectdesign.screens.Dialog.settingsUI
import com.example.silaprojectdesign.ui.theme.cyan
import com.example.silaprojectdesign.ui.theme.greyLine
import com.example.silaprojectdesign.ui.theme.lightGrey
import com.example.silaprojectdesign.ui.theme.textGrey
import com.example.silaprojectdesign.ui.theme.titleBlue
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.launch


data class NotificationList(val image: Int, val title: String, val desc: String)


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun notificationUI(navController:NavController) {
    ProvideWindowInsets {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = White)
                .statusBarsPadding() // Adds padding for status and navigation bars
        ) {


            // Declaring a boolean value in MutableState for storing & get triggered


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
                    settingsUI() // Make sure this composable is implemented correctly
                }
            ) {

                Column {
                    var expanded by remember { mutableStateOf(false) }
                    val context = LocalContext.current


                    BackHandler {
                        navController.popBackStack() // Navigate back to the previous screen
                    }


                    // State to control the visibility of the AlertDialog
                    var showDialog by remember { mutableStateOf(false) }

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(), // Adapts to content height
                        shadowElevation = 2.dp, // Adjust elevation as needed
                        color = Color.White
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(R.drawable.back_arrow_bg),
                                contentDescription = "image",
                                modifier = Modifier.size(40.dp).clickable {

                                    navController.popBackStack()

                                }
                            )
                            Text(
                                text = "Notifications",
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .padding(horizontal = 15.dp, vertical = 15.dp)
                                    .weight(1f),
                                fontWeight = FontWeight.W700,
                                color = titleBlue
                            )
                            Box(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .clickable { expanded = true }
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.menu_icon),
                                    contentDescription = "menu icon",
                                    modifier = Modifier.size(30.dp)
                                )

                                // DropdownMenu for the side popup menu
                                DropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false }
                                    //,offset = DpOffset(100.dp, 50.dp) // Align to the end by adjusting as needed
                                ) {
                                    DropdownMenuItem(
                                        onClick = {
                                            expanded = false
                                            Toast.makeText(
                                                context,
                                                "Option 1 clicked",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        },
                                        text = { Text("Clear All") }
                                    )
                                    DropdownMenuItem(
                                        onClick = {
                                            expanded = false
                                            Toast.makeText(
                                                context,
                                                "Option 2 clicked",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        },
                                        text = { Text("Mark all as Read") }
                                    )
                                    DropdownMenuItem(
                                        onClick = {
                                            expanded = false


                                                    coroutineScope.launch { sheetState.show() }

                                            /*Toast.makeText(
                                                context,
                                                "Option 3 clicked",
                                                Toast.LENGTH_SHORT
                                            ).show()*/
                                        },
                                        text = { Text("Settings") }
                                    )
                                }
                            }
                        }
                    }


                    val item = listOf(
                        NotificationList(
                            R.drawable.vehicle_icon,
                            "Service Update for Route T609....",
                            "Kindly note that Bus Stop 32603 for..."
                        ),

                        NotificationList(
                            R.drawable.vehicle_icon,
                            "Service Update for Route T609....",
                            "Kindly note that Bus Stop 32603 for..."
                        )
                    )


                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                            .border(
                                width = 2.dp,
                                color = lightGrey,
                                shape = RoundedCornerShape(25.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var searchContent by remember {
                            mutableStateOf("")
                        }


                        TextField(
                            value = searchContent,
                            onValueChange = { its -> searchContent = its },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(horizontal = 20.dp),
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = White,
                                focusedContainerColor = White,
                                focusedIndicatorColor = Transparent,
                                unfocusedIndicatorColor = Transparent
                            )
                        )

                        VerticalDivider(
                            thickness = 1.dp,
                            color = greyLine,
                            modifier = Modifier
                                .height(30.dp)
                                .offset(x = -30.dp)
                        )

                        Image(
                            painter = painterResource(R.drawable.filter),
                            contentDescription = "",
                            modifier = Modifier
                                .size(30.dp)
                                .offset(x = -20.dp)
                        )


                    }





                    LazyColumn {

                        itemsIndexed(item) { index, list ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 10.dp).clickable {
                                        showDialog = true // Show the dialog on click
                                    }
                            ) {
                                Image(
                                    painter = painterResource(list.image),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(20.dp)
                                )

                                Column(Modifier.weight(1f)) {
                                    Text(
                                        text = list.title,
                                        fontSize = 13.sp,
                                        modifier = Modifier
                                            .padding(start = 10.dp, bottom = 5.dp),
                                        fontWeight = FontWeight.W600,
                                        color = titleBlue
                                    )

                                    Text(
                                        text = list.desc,
                                        fontSize = 13.sp,
                                        modifier = Modifier
                                            .padding(start = 10.dp, bottom = 5.dp),
                                        fontWeight = FontWeight.W400,
                                        color = textGrey
                                    )

                                }

                                Text(
                                    text = "11 min",
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 10.dp, bottom = 5.dp),
                                    fontWeight = FontWeight.W500,
                                    color = cyan
                                )
                            }

                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                thickness = 1.dp,
                                color = Color.LightGray
                            )

                        }

                        // AlertDialog for logout confirmation


                    }

                    if (showDialog) {
                        alertDialogConnect(
                            onConfirm = {
                                showDialog = false
                                // Add logout logic here
                            },
                            onDismiss = {
                                showDialog = false
                            }
                        )
                    }

                }
            }
        }
    }
}






