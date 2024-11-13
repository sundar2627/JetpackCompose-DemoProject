package com.example.silaprojectdesign.screens.Dialog

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.ui.theme.redColors
import com.example.silaprojectdesign.ui.theme.textGrey
import com.example.silaprojectdesign.ui.theme.textRed
import com.example.silaprojectdesign.ui.theme.titleBlue

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun bottomSheetConnectUI() {

    Box(
        modifier = Modifier.background(Color.White)
          //  .background(Color.White, shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
    ) {
        Column {
            Spacer(modifier = Modifier.height(25.dp))
            Image(
                painter = painterResource(R.drawable.new_logo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .size(40.dp),
                alignment = Alignment.Center
            )

            Text(
                text = "Sila. Life Connected.",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                style = TextStyle(titleBlue, fontWeight = FontWeight.W700),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
            )

            Text(
                text = "We’re excited to have you with us. To unlock all \nthe features and explore our services, log in to \nyour account now!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 2.dp),
                style = TextStyle(textGrey, fontWeight = FontWeight.W500),
                textAlign = TextAlign.Center,
                fontSize = 14.sp
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
                    top = 20.dp,
                    end = 20.dp,
                    bottom = 20.dp
                ),
                interactionSource = remember { MutableInteractionSource() }

            ) {

                Row(/*modifier = Modifier.padding(vertical = 10.dp)*/) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Create a Account",
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp
                    )

                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(20.dp)
                    )

                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Already have an account?",
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp
                )

                Text(
                    text = " Sign In",
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp,
                    color = redColors
                )


            }


        }


    }

}