package com.example.signupandloginusingjetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class MainActivity() : ComponentActivity() {

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



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = "SignIn", style = TextStyle(fontSize = 20.sp))

        OutlinedTextField(
            value = email_signin,
            singleLine = true,
            onValueChange = { email_signin = it },
            label = { Text("Email") },
        )
        OutlinedTextField(value = password_signin,
            singleLine = true,
            onValueChange = { password_signin = it },
            label = { Text("Password") })

        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                signInWithEmail_Password(
                    FirebaseAuth.getInstance(),email_signin,password_signin
                )
            }
        })
        {
            Text(text = "Sign In")
        }

        Text(text = "Create new account", style = TextStyle(fontSize = 20.sp))

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

        OutlinedTextField(value = password_signup,
            singleLine = true,
            onValueChange = { password_signup = it },
            label = { Text("Password") })


        Button(onClick = {


            CoroutineScope(Dispatchers.IO).launch {
                signUpWithEmailAndPassword(
                    FirebaseAuth.getInstance(), email_signup, password_signup
                )
            }

        }) {
            Text(text = "Create new account ")
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {

            Button(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.fb),
                    contentDescription = "Facebook",
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                )
                
                Text(text = "FB")
            }

            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                )
                Text(text = "Gmail")

            }

            Spacer(modifier = Modifier.width(5.dp))

           Button(onClick = { /*TODO*/ }) {

               Image(
                   painter = painterResource(id = R.drawable.github),
                   contentDescription = "Github",
                   modifier = Modifier
                       .height(25.dp)
                       .width(25.dp)
               )
               Text(text = "Git")

           }
            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = { /*TODO*/ }) {

                Image(
                    painter = painterResource(id = R.drawable.phone),
                    contentDescription = "Phone",
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                )
                Text(text = "Msg")


            }
        }
    }
}




@Composable
fun ButtonSendMassage(action: () -> Unit) {
    Button(onClick = {}) {
        Text(text = "Log in")
    }
}


suspend fun signUpWithEmailAndPassword(
    firebaseAuth: FirebaseAuth, emailId: String, password: String
): AuthResult? {
    return try {
        val result = firebaseAuth.createUserWithEmailAndPassword(emailId, password).await()
        Log.e("AuthResult", "SignUp ${result.user?.email}")
        result

    } catch (e: Exception) {
        Log.e("AuthResult", "${e.message}")
        null
    }
}



suspend fun signInWithEmail_Password(
    firebaseAuth: FirebaseAuth,emailId: String,password: String
):AuthResult?{
    return try{
        val result = firebaseAuth.signInWithEmailAndPassword(emailId,password).await()
        Log.e("AuthResult", "login ${result.user?.email}")
        result
    } catch (e: Exception){
        Log.e("AuthResult", "${e.message}")
        null
    }
}
