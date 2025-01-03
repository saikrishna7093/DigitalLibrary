package com.saikrishnapannela.digitallibrary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserProfile()
        }
    }
}

@Composable
fun UserProfile() {
    val context = LocalContext.current

    val userName = StudentLibraryDetails.getStudentName(context)
    val userEmail = StudentLibraryDetails.getStudentMail(context)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6200EE)) // Light background color
    ) {
        // Main Column Layout
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Purple Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(bottomEnd = 32.dp, bottomStart = 32.dp))
                    .background(Color(0xFF6200EE)) // Purple color
            ) {
                // Image and Arrow Button
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.baseline_local_library_36), // Replace with your image
                        contentDescription = "Login Image",
                        modifier = Modifier
                            .size(150.dp) // Adjust size as needed
                    )

                    Text(
                        text = "User Profile",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                }

                IconButton(
                    onClick = { (context as Activity).finish() },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                        .background(Color(0xFFFBC02D), CircleShape) // Yellow background
                        .size(40.dp) // Adjust size as needed
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, // Use a forward arrow
                        contentDescription = "Arrow",
                        tint = Color.White
                    )
                }


            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(Color.White)
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Row {
                        Text(
                            text = "Name",
                            modifier = Modifier.weight(1f)
                        )

                        Text(text = " : ")

                        Text(
                            text = userName,
                            modifier = Modifier.weight(1f)
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row {
                        Text(
                            text = "Email",
                            modifier = Modifier.weight(1f)
                        )

                        Text(text = " : ")

                        Text(
                            text = userEmail,
                            modifier = Modifier.weight(1f)
                        )

                    }

                    Spacer(modifier = Modifier.height(24.dp))


                    Text(text = "Logout",
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color.Blue, shape = RoundedCornerShape(8.dp))
                            .border(
                                width = 1.dp,
                                color = Color.Blue,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(6.dp)
                            .clickable {

                                StudentLibraryDetails.putStudentLS(context, false)
                                val intent = Intent(context, GoInActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                context.startActivity(intent)
                                (context as Activity).finish()
                            })
                }
            }

        }
    }
}