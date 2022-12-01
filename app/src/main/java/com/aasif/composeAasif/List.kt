package com.aasif.composeAasif

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListView(
    list: List<String>,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)) {
        LazyColumn(contentPadding = PaddingValues(12.dp)) {
            list.forEach { listItem ->
                stickyHeader {
                    Text(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(12.dp),

                        text = "Part $listItem")
                }
                items(10) {
                    Text(modifier = Modifier.padding(12.dp),
                        text = "Value $it from $listItem")
                }

            }


        }
        LazyRow(content = {

        })

    }
}