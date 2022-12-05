package com.aasif.composeAasif

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Toast(msg: String) {
    Toast.makeText(
        LocalContext.current,
        msg,
        Toast.LENGTH_LONG
    ).show()
}