package digitallibrary.by.s3302092saikrishnapannela

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class BookDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            if (SelectedBook.subjectSelected == "Digital Arts Databases") {
                BookDetails(bookData = SelectedBook.bookData)
            } else if (SelectedBook.subjectSelected == "Artificial Intelligence E-books") {
                AIBooks()
            }
        }
    }
}

@Composable
fun BookDetails(bookData: BookData) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
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
                contentDescription = "back"
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = SelectedBook.subjectSelected,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }

        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {

            Text(
                modifier = Modifier,
                text = "Name",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = bookData.name,
                fontSize = 14.sp,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = "Description",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = bookData.description,
                fontSize = 14.sp,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = "Can I access this resource?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = bookData.moreInfo,
                fontSize = 14.sp,
                color = Color.Black,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AIP() {
    AIBooksItem(AIBookData())
}

@Composable
fun AIBooks() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
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
                contentDescription = "back"
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Artificial Intelligence E-books",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }
        Spacer(modifier = Modifier.height(12.dp))

        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            AIBooksItem(aiBookData = getAIBooks()[0])
            Spacer(modifier = Modifier.height(8.dp))
            AIBooksItem(aiBookData = getAIBooks()[1])
            Spacer(modifier = Modifier.height(8.dp))
            AIBooksItem(aiBookData = getAIBooks()[2])
        }
    }
}

data class AIBookData(
    var bookImage: Int = 0,
    var bookName: String = "",
    var author: String = "",
    var year: String = "",
    var edition: String = "",
    var url: String = ""
)

@Composable
fun AIBooksItem(aiBookData: AIBookData) {

    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(IntrinsicSize.Min)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier
                .width(80.dp)
                .fillMaxHeight(),
            painter = painterResource(id = aiBookData.bookImage),
            contentDescription = "Book Image"
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                modifier = Modifier,
                text = "Book",
                fontSize = 10.sp,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = aiBookData.bookName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )


            Text(
                modifier = Modifier,
                text = aiBookData.author,
                fontSize = 14.sp,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = aiBookData.year,
                fontSize = 14.sp,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = aiBookData.edition,
                fontSize = 14.sp,
                color = Color.Black,
            )

            Row(
                modifier = Modifier.clickable {
                    openUrl(context = context, aiBookData.url)
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_link_24),
                    contentDescription = "Link"
                )

                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    modifier = Modifier,
                    text = "Available Online",
                    fontSize = 12.sp,
                    color = Color.Gray,
                )
                Spacer(modifier = Modifier.width(6.dp))

                Image(
                    painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                    contentDescription = "Right Arrow"
                )

            }

        }


    }
}


fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        Toast.makeText(context, "No browser found to open the link.", Toast.LENGTH_SHORT).show()
    }
}


fun getAIBooks(): List<AIBookData> {
    return listOf(
        AIBookData(
            bookImage = R.drawable.ai_b1,
            bookName = "Writing AI Prompts for Dummies.",
            author = "Diamond, Stephanie.; Allan, Jeffrey.",
            year = "2024",
            edition = "1st ed.",
            url = "https://tees.primo.exlibrisgroup.com/discovery/fulldisplay?context=L&vid=44TEE_INST:44TEE_INST&search_scope=MyInst_and_CI&tab=Everything&docid=alma991004742407708856"
        ),
        AIBookData(
            bookImage = R.drawable.ai_b2,
            bookName = "The Quick Guide to Prompt Engineering : Generative AI Tips and Tricks for ChatGPT, Bard, Dall-E, and Midjourney.",
            author = "Khan, Ian.",
            year = "2024",
            edition = "1st ed.",
            url = "https://tees.primo.exlibrisgroup.com/discovery/fulldisplay?context=L&vid=44TEE_INST:44TEE_INST&search_scope=MyInst_and_CI&tab=Everything&docid=alma991004734492708856"
        ),
        AIBookData(
            bookImage = R.drawable.ai_b3,
            bookName = "Artificial Intelligence : Ethical, social, and security impacts for the present and the future aArtificial Intelligence : Ethical, social, and security impacts for the present and the future",
            author = "Mehan, Julie E., author.",
            year = "2022",
            edition = "",
            url = "https://tees.primo.exlibrisgroup.com/discovery/fulldisplay?context=L&vid=44TEE_INST:44TEE_INST&search_scope=MyInst_and_CI&tab=Everything&docid=alma991004721318608856"
        )

    )
}


//Mobile Development Books

data class MobileBookData(
    var bookImage: Int = 0,
    var bookName: String = "",
    var author: String = "",
    var publishedDate: String = "",
    var edition: String = "",
    var libraryCopies: String = "",
    var alternative: String = ""

)

@Composable
fun MobileAppBooks() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            MobileAppBookItem(aiBookData = getMobileBooks()[0])
            Spacer(modifier = Modifier.height(8.dp))
            MobileAppBookItem(aiBookData = getMobileBooks()[1])
            Spacer(modifier = Modifier.height(8.dp))
            MobileAppBookItem(aiBookData = getMobileBooks()[2])
        }
    }
}


@Composable
fun MobileAppBookItem(aiBookData: MobileBookData) {

    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(IntrinsicSize.Min)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier
                .width(80.dp)
                .fillMaxHeight(),
            painter = painterResource(id = aiBookData.bookImage),
            contentDescription = "Book Image"
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                modifier = Modifier,
                text = "Book",
                fontSize = 10.sp,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = aiBookData.bookName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .height(IntrinsicSize.Min)
            ) {


                Text(
                    modifier = Modifier,
                    text = aiBookData.author,
                    fontSize = 14.sp,
                    color = Color.Black,
                )

                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .padding(horizontal = 3.dp)
                        .fillMaxHeight()
                        .background(Color.LightGray)
                )
                Text(
                    modifier = Modifier,
                    text = aiBookData.publishedDate,
                    fontSize = 14.sp,
                    color = Color.Black,
                )

                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .padding(horizontal = 3.dp)
                        .fillMaxHeight()
                        .background(Color.LightGray)
                )

                Text(
                    modifier = Modifier,
                    text = aiBookData.edition,
                    fontSize = 14.sp,
                    color = Color.Black,
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                modifier = Modifier,
                text = "Library availability",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
            )

            Text(
                modifier = Modifier,
                text = "Available Online",
                fontSize = 12.sp,
                color = Color.Black,
            )

            Text(
                modifier = Modifier,
                text = aiBookData.libraryCopies,
                fontSize = 12.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                modifier = Modifier,
                text = "Alternative availability",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
            )

            Text(
                modifier = Modifier,
                text = aiBookData.alternative,
                fontSize = 12.sp,
                color = Color.Black,
            )


        }


    }
}

fun getMobileBooks(): List<MobileBookData> {
    return listOf(
        MobileBookData(
            bookImage = R.drawable.a1,
            bookName = "Android Programming for beginners",
            author = "by John Horton",
            publishedDate = "2018",
            edition = "Second edition",
            libraryCopies = "4 Copies available at Middlesbrough Campus - Floor 1",
            alternative = "Teesside Advance - £ 28.99"
        ),
        MobileBookData(
            bookImage = R.drawable.a2,
            bookName = "Learn Android Studio 3 : efficient Android app development",
            author = "by Ted Hagos",
            publishedDate = "2018",
            edition = "",
            libraryCopies = "2 Copies available at Middlesbrough Campus - Floor 1 005.3 HAG",
            alternative = "Teesside Advance - UnAvailable"
        ),
        MobileBookData(
            bookImage = R.drawable.a3,
            bookName = "Android 9 development cookbook: over 100 recipes and solutions to solve the most common problems faced by android developers",
            author = "by Rick Boyer",
            publishedDate = "2018",
            edition = "3rd edition",
            libraryCopies = "1 Copies available at Middlesbrough Campus - Floor 1 005.3 BOY",
            alternative = "Teesside Advance - £ 30.99"
        )
    )
}