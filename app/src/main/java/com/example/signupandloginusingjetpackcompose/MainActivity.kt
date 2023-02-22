package com.example.signupandloginusingjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.signupandloginusingjetpackcompose.ui.theme.SignUpAndLogInUsingJetpackComposeTheme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EditText()

        }
    }
}

@Composable
fun EditText() {

    var email_signin by remember { mutableStateOf("") }
    var password_signin by remember { mutableStateOf("") }

    var name by remember { mutableStateOf("") }
    var mobile_no by remember { mutableStateOf("") }
    var email_signup by remember { mutableStateOf("") }
    var password_signup by remember { mutableStateOf("") }


    var enabled by remember { mutableStateOf(true) }


    var context = LocalContext.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        Text(text = "SignIn",style = TextStyle(fontSize = 20.sp))

        OutlinedTextField(value = email_signin,
            singleLine = true,
            onValueChange = { email_signin = it },
            label = { Text("Email") },
        )
        OutlinedTextField(value = password_signin,
            singleLine = true,
            onValueChange = { password_signin = it },
            label = { Text("Password") })

        Button(onClick = {



        }) {
            Text(text = "Sign In")
        }

        Text(text = "Create new account",style = TextStyle(fontSize = 20.sp))

        OutlinedTextField(value = name,
            singleLine = true,
            onValueChange = { name = it },
            label = { Text("Name") })


        OutlinedTextField(value = mobile_no,
            singleLine = true,
            onValueChange = { mobile_no = it },
            label = { Text("Mobile") })

        OutlinedTextField(value = email_signup,
            singleLine = true,
            onValueChange = { email_signup = it },
            label = { Text("Email") })

        OutlinedTextField(value = password_signup ,
            singleLine = true,
            onValueChange ={password_signup = it},
            label = { Text("Password")})


        Button(onClick = {



        }) {
            Text(text = "Create new account ")
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
            )

            Spacer(modifier = Modifier.width(50.dp))

            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
            )

            Spacer(modifier = Modifier.width(50.dp))

            Image(
                painter = painterResource(id = R.drawable.github),
                contentDescription = "Github",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
            )
        }
    }
}

@Composable
fun ButtonSendMassage(action: () -> Unit) {
    Button(onClick = {
        action()
    }) {
        Text(text = "Log in")
    }
}
