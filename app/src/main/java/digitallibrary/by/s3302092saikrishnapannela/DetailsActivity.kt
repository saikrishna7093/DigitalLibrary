package digitallibrary.by.s3302092saikrishnapannela

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailsActivityScreen()
        }
    }
}

@Composable
fun DetailsActivityScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Blue)
                .padding(vertical = 8.dp, horizontal = 12.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        (context as Activity).finish()
                    },
                painter = painterResource(id = R.drawable.baseline_arrow_back_36),
                contentDescription = "goback"
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = if (Selection.pageSelected == 1) "Contact Us" else "About Us",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }

        Column(modifier = Modifier.padding(horizontal = 12.dp)) {

            Spacer(modifier = Modifier.height(12.dp))

            if (Selection.pageSelected == 1) {
                ContactDetails()
            } else {
                ABoutUsDetails()
            }

        }
    }
}


@Composable
fun ABoutUsDetails() {
    Column {

        Text(
            modifier = Modifier,
            text = "This mobile app by Sai Krishna Pannela has been developed to provide online materials to students, offering valuable resources to enhance their studies. It aims to support students by giving them easy access to essential learning materials that are useful for their academic success.",
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ContactDetails() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier,
            text = "Sai Krishna Pannela",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier,
            text = "Student I'd : S3302092",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black,
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier,
            text = "Digital Library by Sai Krishna Pannela",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(6.dp))

        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_email_24),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(
                modifier = Modifier,
                text = "pannelasaikrishna45@gmail.com ",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Blue,
            )
        }
    }
}