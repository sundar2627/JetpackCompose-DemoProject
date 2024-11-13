package com.example.silaprojectdesign.screens.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.ui.theme.textGrey
import com.example.silaprojectdesign.ui.theme.titleBlue

@Preview
@Composable
fun TermsCondition() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(), // Adapts to content height
                shadowElevation = 4.dp, // Adjust elevation as needed
                color = Color.White
            ) {


                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically


                ) {

                    Image(
                        painter = painterResource(R.drawable.back_arrow_bg),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 20.dp, start = 30.dp)
                            .size(30.dp),
                    )

                    Text(
                        text = "Terms of Use",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp),
                        style = TextStyle(titleBlue, fontWeight = FontWeight.W700),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                    )

                }

            }


            Text(
                text = "Introduction",
                modifier = Modifier.padding(start = 30.dp, top = 25.dp),
                fontWeight = FontWeight.W500,
                color = titleBlue,
                fontSize = 15.sp
            )

            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Neque ultricies amet natoque nibh pulvinar. Parturient viverra eu ut erat quis. Vel vel dolor pellentesque ut risus velit habitant. Id amet tristique gravida vitae lectus velit. Amet vestibulum volutpat. \n \n neque tortor parturient at cras metus rhoncus. In purus massa iaculis purus arcu habitasse eget sem. Mattis non consequat risus sit integer lectus vel aliquet. Lacus augue id odio id urna tincidunt sit viverra diam. Consequat diam adipiscing congue euismod lorem et nec pharetra. Dictum ornare aenean consequat auctor sed id faucibus donec nisl. Odio diam risus euismod amet mi auctor nibh lectus malesuada.",
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 5.dp),
                fontWeight = FontWeight.W400,
                color = textGrey,
                fontSize = 13.sp
            )



            Text(
                text = "Information Collection, Use, Sharing and Rectification",
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 25.dp),
                fontWeight = FontWeight.W500,
                color = titleBlue,
                fontSize = 16.sp
            )

            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Neque ultricies amet natoque nibh pulvinar. Parturient viverra eu ut erat quis. Vel vel dolor pellentesque ut risus velit habitant. Id amet tristique gravida vitae lectus velit. Amet vestibulum volutpat. \n \n neque tortor parturient at cras metus rhoncus. In purus massa iaculis purus arcu habitasse eget sem. Mattis non consequat risus sit integer lectus vel aliquet. Lacus augue id odio id urna tincidunt sit viverra diam. Consequat diam adipiscing congue euismod lorem et nec pharetra. Dictum ornare aenean consequat auctor sed id faucibus donec nisl. Odio diam risus euismod amet mi auctor nibh lectus malesuada.",
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 5.dp),
                fontWeight = FontWeight.W400,
                color = textGrey,
                fontSize = 13.sp
            )

        }


    }

}