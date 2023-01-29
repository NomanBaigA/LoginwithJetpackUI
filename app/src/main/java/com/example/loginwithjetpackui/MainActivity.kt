package com.example.loginwithjetpackui

import android.content.Context
import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginwithjetpackui.ui.theme.LoginWithJetpackUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginWithJetpackUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Login(applicationContext)
                }
            }
        }
    }
}

@Composable
fun Login(context: Context) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Page",
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Left,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "Enter User Name") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "User Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Enter Your Password") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        OutlinedButton(
            onClick = { logged(userName, password, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        ) {

            Text(
                text = "Login",
                textAlign = TextAlign.Center
            )
        }
    }
}

fun logged(userName: String, password: String, context: Context) {

    if (userName == "NomanBaig" && password == "12345") {
        Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
    } else {
        Toast.makeText(context, "Login FAILED!", Toast.LENGTH_LONG).show()
    }
}
