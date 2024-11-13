package com.example.silaprojectdesign.screens.UI

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.ui.theme.bgGrey

import com.example.silaprojectdesign.ui.theme.textGrey
import com.example.silaprojectdesign.ui.theme.textRed
import com.example.silaprojectdesign.ui.theme.titleBlue

@Preview
@Composable
fun contactUsUI() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column {

            // Top bar with shadow effect
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(), // Adapts to content height
                shadowElevation = 4.dp, // Adjust elevation as needed
                color = Color.White
            ) {


                Row(

                    modifier = Modifier
                        .fillMaxWidth().padding(vertical = 10.dp)
                        ,verticalAlignment = Alignment.CenterVertically
                        

                ) {

                    Image(
                        painter = painterResource(R.drawable.back_arrow_bg),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 20.dp, start = 30.dp)
                            .size(40.dp),
                    )

                    Text(
                        text = "Contact Us",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp),
                        style = TextStyle(titleBlue, fontWeight = FontWeight.W700),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                    )

                }

            }



            Row(Modifier.padding(start = 30.dp, top = 30.dp)) {
                Text(
                    text = "First name",
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.W600,
                    color = textGrey,
                    fontSize = 14.sp
                )
                Text(
                    text = "Last name",
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.W600,
                    color = textGrey,
                    fontSize = 14.sp
                )
            }

            Row(Modifier.padding(horizontal = 30.dp, vertical = 10.dp)) {

                var firstName by remember {
                    mutableStateOf("")
                }

                var lastName by remember {
                    mutableStateOf("")
                }


                TextField(
                    value = firstName,
                    onValueChange = {
                        firstName = it
                    },
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .border(
                            width = 1.dp,
                            color = bgGrey,
                            shape = RoundedCornerShape(15.dp)
                        ), colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White

                    )
                )

                Spacer(modifier = Modifier.width(20.dp))

                TextField(
                    value = lastName, onValueChange = {
                        lastName = it
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .border(
                            1.dp, bgGrey,
                            RoundedCornerShape(15.dp)
                        ), colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.White,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.White
                    )
                )


            }

            var emails by remember {
                mutableStateOf("")
            }

            var phone by remember {
                mutableStateOf("")
            }

            var message by remember {
                mutableStateOf("")
            }

            var query by remember {
                mutableStateOf("")
            }

            Text(
                text = "Email",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp),
                fontWeight = FontWeight.W600,
                color = textGrey,
                fontSize = 14.sp
            )





            TextField(
                value = emails, onValueChange = {
                    emails = it
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .border(
                        1.dp, bgGrey,
                        RoundedCornerShape(15.dp)
                    ), colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    /*    errorPlaceholderColor = Color.Red,
                        errorContainerColor = Color.Black*/


                ), placeholder = { Text("Enter Email") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )
            )

            Text(
                text = "Phone Number",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp),
                fontWeight = FontWeight.W600,
                color = textGrey,
                fontSize = 14.sp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .border(
                        width = 1.dp,
                        color = bgGrey,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically // Optional inner padding for the row
            ) {
                Text(
                    text = "974",
                    modifier = Modifier.padding(end = 8.dp), // Space between the prefix and divider
                    color = Color.Gray // Adjust color if needed
                )

                // Vertical divider line
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(40.dp) // Set height to match TextField height with padding
                        .background(Color.Gray)
                        .padding(vertical = 4.dp) // Add padding to center it with TextField
                )

                // Main TextField
                TextField(
                    value = emails,
                    onValueChange = { emails = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color.White
                    ),
                    placeholder = { Text("Enter Email") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true // Ensures the input stays on one line
                )
            }

            Text(
                text = "Type of Query",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp),
                fontWeight = FontWeight.W600,
                color = textGrey,
                fontSize = 14.sp
            )

            CustomSpinner()

            Text(
                text = "Your Message",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp),
                fontWeight = FontWeight.W600,
                color = textGrey,
                fontSize = 14.sp
            )

            TextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .height(150.dp) // Adjust height as needed for description space
                    .border(
                        width = 1.dp,
                        color = bgGrey,
                        shape = RoundedCornerShape(15.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White
                ),
                placeholder = { Text("Enter your message here...") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                maxLines = 5 // Allows more lines for multi-line input
            )


            val context = LocalContext.current

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 25.dp),
                onClick = {
                    Toast.makeText(
                        context,
                        "Button Click",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                enabled = true,
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = textRed
                ),
                // elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                //  border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Blue)),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 10.dp,
                    end = 20.dp,
                    bottom = 10.dp
                ),
                interactionSource = remember { MutableInteractionSource() }

            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Save",
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
            }


        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSpinner() {
    var expanded by remember { mutableStateOf(false) }
    var selectedValue by remember { mutableStateOf("Select an option") }

    val options = listOf("Option 1", "Option 2", "Option 3")

    // Use ExposedDropdownMenuBox to manage dropdown functionality
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        // TextField for dropdown with trailing dropdown arrow
        TextField(
            value = selectedValue,
            onValueChange = {},
            readOnly = true, // Prevent manual text input
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                )
                .background(Color.White),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            placeholder = { Text("Select an option") }
        )

        // Dropdown menu with options
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White) // Sets dropdown menu background to red
            //.align(Alignment.CenterHorizontally) // Centers dropdown relative to spinner

        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option, color = titleBlue) },
                    onClick = {
                        selectedValue = option
                        expanded = false
                    },
                    Modifier.fillMaxWidth(),
                    enabled = true // Make sure options are clickable
                )
            }
        }
    }
}

/*@Composable
fun CustomSpinner() {
    var expanded by remember { mutableStateOf(false) }
    var selectedValue by remember { mutableStateOf("Select an option") }

    val options = listOf("Option 1", "Option 2", "Option 3")

    Box(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(15.dp)
            )
            .background(Color.White)  // Background color for spinner
    ) {
        TextField(
            value = selectedValue,
            onValueChange = {},
            readOnly = true, // Prevents manual input, so only selection can change value
            modifier = Modifier
                .fillMaxWidth()
               // .clickable { expanded = !expanded }, // Opens dropdown on click
           , colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown Arrow"
                )
            },
            placeholder = { Text("Select an option") }
        )

        // Dropdown menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.White) // Optional, makes menu background distinct
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedValue = option
                        expanded = false
                    },
                    enabled = true // Default to true, so all options are clickable
                )
            }
        }
    }
}*/
