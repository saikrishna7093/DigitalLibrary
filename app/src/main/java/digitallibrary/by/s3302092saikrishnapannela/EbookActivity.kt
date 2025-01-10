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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class EbookActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EbookQueries()
        }
    }
}


@Composable
fun EbookQueries() {
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
                text = "E-Book FAQ's",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }

        Column(modifier = Modifier.padding(horizontal = 12.dp)) {

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier,
                text = "What is an E-Book",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))


            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.what_ebook),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier,
                text = "E- books are an electronic version of texts that you can\n" +
                        "access and read online.\n" +
                        "They are usually searchable and may incorporate\n" +
                        "features such as audio, video and hyperlinks.\n" +
                        "We can also usually add your own annotations and\n" +
                        "notes to an E book.",
                fontSize = 14.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier,
                text = "Why E book?",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))


            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.why_ebook),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier,
                text = "1. Those can be accessed 24 hours a day, 7 days a week.\n" +
                        "\n" +
                        "2. There are no fines!\n" +
                        "\n" +
                        "3. As a member of Teesside University, we have access \n" +
                        "to nearly half a million e-books.",
                fontSize = 14.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier,
                text = "How long can I download an e-book for?",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                painter = painterResource(id = R.drawable.d_ebook),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier,
                text = "With some e-books you can choose to download for 1 to 4 days. Once this time expires it will be possible to go back and download the title again. Some collections, such as eBook Central, allow you to download a title for 21 days. You do, however, need to have Adobe Digital Editions installed on your computer.",
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(12.dp))

        }
    }
}