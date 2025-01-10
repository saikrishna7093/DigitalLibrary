package digitallibrary.by.s3302092saikrishnapannela

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LibraryHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LibraryHomeScreen()
        }
    }
}

@Composable
fun LibraryHomeScreen() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6200EE))
    ) {

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
                    modifier = Modifier.align(Alignment.Center)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.baseline_local_library_36), // Replace with your image
                        contentDescription = "Login Image",
                        modifier = Modifier
                            .size(150.dp) // Adjust size as needed
                    )

                    Text(
                        text = "Welcome to Digital Library",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                }

                IconButton(
                    onClick = { context.startActivity(Intent(context, ProfileActivity::class.java)) },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                        .background(Color(0xFFFBC02D), CircleShape) // Yellow background
                        .size(40.dp) // Adjust size as needed
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle, // Use a forward arrow
                        contentDescription = "Arrow",
                        tint = Color.White
                    )
                }
            }

            // Login Form Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(Color.White)
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .padding(top = 12.dp, bottom = 0.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Column(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    context.startActivity(
                                        Intent(
                                            context,
                                            SearchTopicsActivity::class.java
                                        )
                                    )
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.search_topics),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(42.dp)
                                    .width(42.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "Search Topics",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }

                        Column(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    context.startActivity(
                                        Intent(
                                            context,
                                            EbookActivity::class.java
                                        )
                                    )
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.e_book),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(42.dp)
                                    .width(42.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))


                            Text(
                                text = "E-book FAQ's",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }


                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .padding(top = 16.dp, bottom = 0.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Column(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    Selection.pageSelected =1
                                    context.startActivity(
                                        Intent(
                                            context,
                                            DetailsActivity::class.java
                                        )
                                    )
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.contact),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(42.dp)
                                    .width(42.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "Contact Us",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }

                        Column(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    Selection.pageSelected =2
                                    context.startActivity(
                                        Intent(
                                            context,
                                            DetailsActivity::class.java
                                        )
                                    )
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.information),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(42.dp)
                                    .width(42.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))


                            Text(
                                text = "About Us",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
            }
        }
    }
}

object Selection{
    var pageSelected=0
}
