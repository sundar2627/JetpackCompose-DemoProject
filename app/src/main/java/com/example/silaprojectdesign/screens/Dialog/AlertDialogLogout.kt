package com.example.silaprojectdesign.screens.Dialog

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.silaprojectdesign.R

@Composable
fun alertDialogConnect(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current

    // Dialog to make the alert appear centered
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(15.dp))
                .padding(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.new_logo),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Sila. Life Connected.",
                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp,
                    color = Color.Blue
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "We’re excited to have you with us. To unlock all " +
                            "the features and explore our services, log in to your account now!",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Button Click",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Red
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Create an Account",
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Already have an account?",
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp
                    )
                    Text(
                        text = " Sign In",
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        color = Color.Red,
                        modifier = Modifier.clickable { /* Navigate to Sign In */ }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Logout No",
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        modifier = Modifier.clickable { onDismiss() } // Dismiss the dialog
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Logout Yes",
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        color = Color.Red,
                        modifier = Modifier.clickable {
                            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                            onConfirm() // Call confirm action
                        }
                    )
                }
            }
        }
    }
}
