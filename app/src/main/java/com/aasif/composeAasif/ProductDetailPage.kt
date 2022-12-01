package com.aasif.composeAasif

import android.graphics.drawable.GradientDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aasif.composeAasif.ui.theme.ComposeExperimentTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemDetail() {
    ComposeExperimentTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent), verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTextStyle(txt = "Product")
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(400.dp, 500.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)) {
                Text(text = "Shirt for Men",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    modifier = Modifier.weight(4f)
                )
                Text(text = "Rs. 900/-",
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    modifier = Modifier.weight(1f))
            }
//            Text(text = "Summer Fashion",
//                fontSize = MaterialTheme.typography.subtitle2.fontSize,
//                modifier = Modifier.fillMaxWidth())

            ExpandableCard(title = "Description",
                description = "Buy Feed Up Combo of 5 Men's Shirts from Casual Shirts at Amazon.in. 30 days free exchange or return",
                titleFontSize = MaterialTheme.typography.subtitle1.fontSize)
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Buy Now")
                GradientDrawable.RADIAL_GRADIENT
            }
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true, name = "pV")
@Composable
fun ItemDetailPreview() {
    ComposeExperimentTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Transparent), verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTextStyle(txt = "Product")
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Image Holder",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(400.dp, 500.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)) {
                Text(text = "Shirt for Men",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    modifier = Modifier.weight(4f)
                )
                Text(text = "Rs. 900/-",
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    modifier = Modifier.weight(1f))
            }
//            Text(text = "Summer Fashion",
//                fontSize = MaterialTheme.typography.subtitle2.fontSize,
//                modifier = Modifier.fillMaxWidth())

            ExpandableCard(title = "Description",
                description = "Buy Feed Up Combo of 5 Men's Shirts from Casual Shirts at Amazon.in. 30 days free exchange or return",
                titleFontSize = MaterialTheme.typography.subtitle1.fontSize)
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Buy Now")
                GradientDrawable.RADIAL_GRADIENT
            }
        }
    }

}


