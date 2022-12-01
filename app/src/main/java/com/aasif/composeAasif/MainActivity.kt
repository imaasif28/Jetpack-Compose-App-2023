package com.aasif.composeAasif

import android.os.Bundle
import android.text.LoginFilter.UsernameFilterGMail
import android.view.ActionProvider.VisibilityListener
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.aasif.composeAasif.ui.theme.ComposeExperimentTheme
import kotlinx.coroutines.delay
import java.util.jar.Attributes.Name

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExperimentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                    ) {
                        MyTextStyle(txt = getString(R.string.signUp))
                        Spacer(modifier = Modifier.height(24.dp))
                        MainScreen()
//                        ItemDetail()
                        /*  ListView(
                              list = listOf("Arctic Fox", "Bumble Bee", "Canary", "Dolphin", "Eel")
                          )*/
                        MyTextField(
                            label = "Name",
                            hint = "Username",
                            value = "",
                            inputType = KeyboardType.Text,
                            iconVector = Icons.Filled.AccountBox,
                            endIconVisible = false,
                            visibilityToggle = true
                        )
                        MyTextField(
                            "Number",
                            "9898989898",
                            "",
                            KeyboardType.Phone,
                            iconVector = Icons.Filled.Phone,
                            endIconVisible = false,
                            visibilityToggle = true
                        )
                        MyTextField(
                            "Email",
                            "abc@xyz.com",
                            "",
                            KeyboardType.Email,
                            iconVector = Icons.Filled.Email,
                            endIconVisible = false,
                            visibilityToggle = true
                        )
                        MyTextField(
                            "Password",
                            "******",
                            "",
                            KeyboardType.Password,
                            iconVector = Icons.Filled.Star,
                            endIconVisible = true
                        )
                        MyTextField(
                            "Confirm Password",
                            "******",
                            "",
                            KeyboardType.Password,
                            iconVector = Icons.Filled.Create, true
                        )
//                        GoogleButton { }

                        var clicked: Boolean by remember{ mutableStateOf(false)}
                        Button(
                            onClick = { clicked = !clicked },
                            modifier = Modifier.padding(10.dp),
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primaryVariant),
                        ) {
                            Text(text = "Submit")
                            if (clicked) {
                                Toast.makeText(
                                    LocalContext.current,
                                    "Profile data submitted.",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                        ExpandableCard(
                            title = "Description and Consent",
                            description = getString(R.string.tnc),
                            padding = (40.dp)
                        )
                        ImageURL("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiv3CjuEunEpPuvrsKEV0f7R_OSPonuZnDUi97Hrz68T9xKpsUHRoFaivipPxNQ6QT3BIHVxtSH85xurEqxSnC1S7rQklKL8vKj40E2xgFWE9ylhjZDHbWoie3Evgl_WjnG2nQ1UxFVs9lg3IAMIv_CHCsuesUuCW_BMddUXU4JErFXLn9Twcy2tKKfHA/s1600/Android-JetpackCompose1.2-Header.png")

                    }
                }
            }
        }
    }
}

@Composable
fun MyTextStyle(txt: String) {
    Column {
        Text(
            text = txt,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(12.dp),
        )
    }
}


@Composable
fun MyTextField(
    label: String,
    hint: String,
    value: String,
    inputType: KeyboardType,
    iconVector: ImageVector,
    endIconVisible: Boolean,
    visibilityToggle: Boolean = false
) {
    var text by remember { mutableStateOf(value) }
    var passwordVisibility by remember { mutableStateOf(visibilityToggle) }
    val icon = if (passwordVisibility) painterResource(id = R.drawable.ic_password_visibility)
    else painterResource(id = R.drawable.ic_password_visibility_off)
    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        modifier = Modifier.padding(12.dp),
        placeholder = {
            Text(text = hint, color = Color.LightGray)
        },
        label = {
            Text(text = label, color = MaterialTheme.colors.primary)
        },
        leadingIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = iconVector,
                    contentDescription = "Icon"
                )
            }
        },
        trailingIcon = {
            if (endIconVisible) {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Icon"
                    )
                }
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation(),
        enabled = true,
        singleLine = true,
//        shape = MaterialTheme.shapes.large,
        keyboardOptions = KeyboardOptions(
            keyboardType = inputType,
            imeAction = ImeAction.Default
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                println("Recorded")
            }
        )
    )
}

@Composable
fun ImageURL(
    url: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(100.dp)),
        contentAlignment = Alignment.Center
    ) {
//        val painter = rememberAsyncImagePainter(model = url)
//        Image(painter = painter, contentDescription = "Image")
        /*AsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),

            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image")*/
        SubcomposeAsyncImage(
            model = url,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = "Image"
        )
    }

}


@Preview(showBackground = true, name = "pV")
@Composable
fun DefaultPreview() {
    ComposeExperimentTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            MyTextStyle(txt = "Sign Up")
            GoogleButton {}
//            ListView(list = listOf("A", "B", "C", "D", "E", "F"))
//            ImageURL(url = "https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Ym9va3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=400&q=60")
//            ItemDetail()
        }
    }
}

