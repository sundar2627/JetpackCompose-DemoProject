package com.example.silaprojectdesign.screens.UI

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.silaprojectdesign.R
import com.example.silaprojectdesign.ui.theme.cyan
import com.example.silaprojectdesign.ui.theme.textGrey
import com.example.silaprojectdesign.ui.theme.titleBlue

@Preview
@Composable
fun FAQ() {
    Log.d("FAQ", "FAQLanded: ")
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
                        .padding(vertical = 10.dp)
                    ,verticalAlignment = Alignment.CenterVertically


                ) {

                    Image(
                        painter = painterResource(R.drawable.back_arrow_bg),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 20.dp, start = 30.dp)
                            .size(30.dp),
                    )

                    Text(
                        text = "FAQs",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp),
                        style = TextStyle(titleBlue, fontWeight = FontWeight.W700),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                    )

                }

            }

            Text(
                text = "About Sila & how it works",
                modifier = Modifier.padding(start = 30.dp, top = 25.dp),
                fontWeight = FontWeight.W500,
                color = cyan,
                fontSize = 16.sp
            )


            MainScreen()

        }



        }

}



// Sample data model for the items
data class Item(
    val title: String,
    val description: String,
    var isExpanded: Boolean = false // Track expanded state
)

@Composable
fun ExpandableLazyColumn(items: List<Item>) {
    var itemList by remember { mutableStateOf(items) } // Hold the list of items with expanded state

    LazyColumn {
        items(itemList) { item ->
            ExpandableItemRow(item) { updatedItem ->
                // Update the expanded state of the clicked item
                itemList = itemList.map {
                    if (it == item) updatedItem.copy(isExpanded = !item.isExpanded) else it
                }
            }
        }
    }
}

@Composable
fun ExpandableItemRow(item: Item, onToggleExpand: (Item) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //  .animateContentSize() //animations added
                .padding(horizontal = 30.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.title,
                fontSize = 16.sp,
                color = titleBlue,
                fontWeight = FontWeight.W500,
                modifier = Modifier.weight(1f)
            )

            Image(
                painter = painterResource (if (item.isExpanded) R.drawable.minus else R.drawable.add),
                contentDescription = if (item.isExpanded) "Collapse" else "Expand",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { onToggleExpand(item) }
            )


            // Animated visibility for description with fade in/out effect
           /* AnimatedVisibility(
                visible = item.isExpanded,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    text = item.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }*/
        }

        if (item.isExpanded) {
            (Text(
                text = item.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 4.dp),
                fontSize = 14.sp,
                color = textGrey,
                fontWeight = FontWeight.W400
            ))
        }
    }
}

// Usage
@Composable
fun MainScreen() {
    val items = listOf(
        Item("What is Sila", "The journey planner is applicable to Doha Metro, Karwa bus, Karwa Taxi, MetroLink, Msheireb Tram and Education City Tram as well as planning your journey by car or on foot. The Sila app gives step by step navigation on how to get to your destination."),
        Item("Item 2", "This is the description for item 2."),
        Item("Item 3", "This is the description for item 3.")
    )

    ExpandableLazyColumn(items = items)
}
