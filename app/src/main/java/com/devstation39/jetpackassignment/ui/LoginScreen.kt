package com.devstation39.jetpackassignment.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.devstation39.jetpackassignment.R
import com.devstation39.jetpackassignment.ui.theme.OpenSensFont



@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_directions_bike_24),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.Start)
        )
        Text(
            text = "Login To Uber",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 40.sp,
            fontFamily = OpenSensFont,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 20.dp)
        )
        val text = buildAnnotatedString {
            append(
                AnnotatedString(
                    text = "If you don't have an account register \n" +
                            "You can ",
                    spanStyle = SpanStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = OpenSensFont,
                        fontWeight = FontWeight.Normal
                    )
                )
            )
            append(
                AnnotatedString(
                    text = "register here as customer!",
                    spanStyle = SpanStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = OpenSensFont,
                        fontWeight = FontWeight.Bold
                    ),
                )
            )
        }

        Text(
            text = text, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clickable {
                    navController.navigate("registration")
                }
        )

        var emailData by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = emailData,
            onValueChange = {
                emailData = it
            },
            placeholder = {
                Text(text = "Email", fontFamily = OpenSensFont, color = Color.Black)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_mail_24),
                    contentDescription = null,
                    Modifier.size(25.dp),
                    tint = Color.Black
                )
            },
            trailingIcon = {
                when {
                    emailData.isNotEmpty() -> IconButton(onClick = {
                        emailData = ""
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            }
        )

        var passwordData by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            value = passwordData,
            onValueChange = {
                passwordData = it
            },
            placeholder = {
                Text(text = "Password", fontFamily = OpenSensFont, color = Color.Black)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    contentDescription = null,
                    Modifier.size(25.dp),
                    tint = Color.Black
                )
            },
            trailingIcon = {
                when {
                    passwordData.isNotEmpty() -> IconButton(onClick = {
                        passwordData = ""
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Checkbox(
                    checked = false,
                    onCheckedChange = {

                    }
                )

                Text(
                    text = "Remember me",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    fontFamily = OpenSensFont,
                    modifier = Modifier
                )
            }

            Text(
                text = "Forget Password ?",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                fontFamily = OpenSensFont,
                modifier = Modifier
            )
        }

        Card(
            backgroundColor = Color.Black,
            shape = RoundedCornerShape(5.dp),
            elevation = 10.dp,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(55.dp)
                .padding(top = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Login Now",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = OpenSensFont,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }

    }
}