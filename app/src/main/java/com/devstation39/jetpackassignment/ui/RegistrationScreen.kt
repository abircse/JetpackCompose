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
fun RegistrationScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_directions_bike_24),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Start)
                .size(150.dp)
        )

        Text(
            text = "Register To Uber",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = OpenSensFont,
            fontSize = 40.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 20.dp)
        )

        val appendText = buildAnnotatedString {
            append(
                AnnotatedString(
                    text = "If you already have an account ",
                    spanStyle = SpanStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = OpenSensFont
                    )
                )
            )
            append(
                AnnotatedString(
                    text = "Login Here!",
                    spanStyle = SpanStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = OpenSensFont
                    )
                )
            )
        }

        Text(
            text = appendText, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clickable {
                    navController.navigate("login")
                }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            var firstName by remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(top = 30.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                value = firstName,
                onValueChange = {
                    firstName = it
                },
                placeholder = {
                    Text(text = "First Name", fontFamily = OpenSensFont, color = Color.Black)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_person_24),
                        contentDescription = null,
                        Modifier.size(25.dp),
                        tint = Color.Black
                    )
                }
            )

            Spacer(modifier = Modifier.weight(0.02f))

            var lastName by remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(top = 30.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                value = lastName,
                onValueChange = {
                    lastName = it
                },
                placeholder = {
                    Text(text = "Last Name", fontFamily = OpenSensFont, color = Color.Black)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_person_24),
                        contentDescription = null,
                        Modifier.size(25.dp),
                        tint = Color.Black
                    )
                }
            )

        }

        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = email,
            onValueChange = {
                email = it
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
                    email.isNotEmpty() -> IconButton(onClick = {
                        email = ""
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            }
        )

        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            value = password,
            onValueChange = {
                password = it
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
                    password.isNotEmpty() -> IconButton(onClick = {
                        password = ""
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

        var phone by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            value = phone,
            onValueChange = {
                phone = it
            },
            placeholder = {
                Text(text = "Phone", fontFamily = OpenSensFont, color = Color.Black)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_call_24),
                    contentDescription = null,
                    Modifier.size(25.dp),
                    tint = Color.Black
                )
            },
            trailingIcon = {
                when {
                    phone.isNotEmpty() -> IconButton(onClick = {
                        phone = ""
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            }
        )

        var address by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = address,
            onValueChange = {
                address = it
            },
            placeholder = {
                Text(text = "Address", fontFamily = OpenSensFont, color = Color.Black)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
                    contentDescription = null,
                    Modifier.size(25.dp),
                    tint = Color.Black
                )
            },
            trailingIcon = {
                when {
                    address.isNotEmpty() -> IconButton(onClick = {
                        address = ""
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            }
        )

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
                    text = "Register Now!",
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