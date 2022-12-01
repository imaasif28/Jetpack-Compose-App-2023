package com.aasif.composeAasif

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MainScreen() {
    val context = LocalContext.current
    var imageUri: Any? by remember { mutableStateOf("https://cdn.dribbble.com/userupload/2994051/file/still-33775e7fa88cf1131310740928c52932.png?compress=1&resize=400x300&vertical=top") }
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) {
        if (it != null) {
            Log.d("PhotoPicker", "Selected URI: $it")
            imageUri = it
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }
    val multiplePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(maxItems = 3)
    ) {

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(100.dp))
                .clickable {
                    photoPicker.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                },
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUri)
                .crossfade(enable = true)
                .build(),
            contentDescription = "Avatar Image",
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(24.dp))
        /* Button(onClick = {
             Toast.makeText(
                 context,
                 ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable().toString(),
                 Toast.LENGTH_LONG
             ).show()
         }) {
             Text(text = "isPhotoPickerAvailable")
         }*/
    }
}

@Preview("pv")
@Composable
fun Pv() {
    MainScreen()

}