package digitallibrary.by.s3302092saikrishnapannela

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SearchTopicsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchTopicsScreen()
        }
    }
}

@Composable
fun SearchTopicsScreen() {

    val context = LocalContext.current

    var showDialog by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select topic") }


    Column(
        modifier = Modifier.fillMaxWidth()
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
                text = "Search Topics",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }

//        SelectionBoxWithDialog()

        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .border(
                        width = 2.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = selectedOption,
                    modifier = Modifier,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(text = "Select",
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
                            showDialog = true
                        })
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text(text = "Select Category") },
                    text = {
                        Column {
                            RadioButtonOption(
                                options = listOf(
                                    "Digital Arts Databases",
                                    "Artificial Intelligence E-books",
                                    "Mobile App Development E-books"
                                ),
                                selectedOption = selectedOption,
                                onOptionSelected = { option ->
                                    selectedOption = option
                                    SelectedBook.subjectSelected = option
                                    showDialog = false
                                }
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = { showDialog = false }
                        ) {
                            Text(text = "Search")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { showDialog = false }) {
                            Text(text = "Cancel")
                        }
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            if (selectedOption == "Digital Arts Databases") {
                SelectedBook.subjectSelected = "Digital Arts Databases"
                ShowDigitalArtsBooks()
            } else if (SelectedBook.subjectSelected == "Artificial Intelligence E-books") {
                ShowAIBooks()
            }else if (SelectedBook.subjectSelected == "Mobile App Development E-books"){
                MobileAppBooks()
            }

//            TopicItem(
//                topicImage = R.drawable.artificial_intelligence_foundation,
//                topicName = "Artificial Intelligence Foundations"
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//

        }
    }

}

@Composable
fun ShowDigitalArtsBooks() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        TopicItem(getDigitalArtBooks()[0])
        Spacer(modifier = Modifier.height(8.dp))
        TopicItem(getDigitalArtBooks()[1])
        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Composable
fun ShowAIBooks() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().weight(1f),
            painter = painterResource(id = R.drawable.ai_thumbnail),
            contentDescription = "AI Books",
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier
                .background(color = Color.Black, shape = RoundedCornerShape(8.dp))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 8.dp, vertical = 6.dp)
                .align(Alignment.CenterHorizontally)
                .clickable {
                    context.startActivity(Intent(context, BookDetailsActivity::class.java))
                },
            text = "View More Reading Material",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(12.dp))

    }
}


@Composable
fun TopicItem(bookData: BookData) {

    val context = LocalContext.current as Activity

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 12.dp)
            .clickable {
            }

    ) {
        Image(
            painter = painterResource(id = bookData.bookImage),
            contentDescription = "Topic Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(8.dp)
        ) {

            Column(modifier = Modifier) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = bookData.description,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                    color = Color.White,

                    )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier
                        .background(color = Color.Black, shape = RoundedCornerShape(8.dp))
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            SelectedBook.bookData = bookData
                            context.startActivity(Intent(context, BookDetailsActivity::class.java))
                        },
                    text = "View More",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )


            }
        }
    }
}


@Composable
fun RadioButtonOption(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { onOptionSelected(option) }
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { onOptionSelected(option) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

data class BookData(
    var bookImage: Int = 0,
    var name: String = "",
    var description: String = "",
    var moreInfo: String = ""
)

object SelectedBook {
    var bookData = BookData()
    var subjectSelected = ""
}


fun getDigitalArtBooks(): List<BookData> {
    return listOf(
        BookData(
            R.drawable.digital_arts,
            " Art and Architecture Archive",
            "A full-text archive of magazines comprising key research material in the fields of art and architecture, dating from the late-nineteenth century to the twenty-first. Subjects covered include fine art, decorative arts, architecture, interior design, industrial",
            "To access Art and Architecture Archive you must be either:\n" +
                    "1. A Teesside University undergraduate or postgraduate\n" +
                    "2. A member of Teesside University staff\n" +
                    "3. A TUCP student or member of teaching staff at a TUCP College\n" +
                    "If you are not a member of any of these groups, then unfortunately our licence does not allow access to the resource."
        ),
        BookData(
            R.drawable.digital_arts,
            "Art Bibliographies Modern",
            "ARTbibliographies Modern (ABM) provides full abstracts of journal articles, books, essays, exhibition catalogs, PhD dissertations, and exhibition reviews on all forms of modern and contemporary art, with more than 13,000 new entries being added each year",
            "To access ProQuest databases you must be either:\n" +
                    "1. A Teesside University undergraduate or postgraduate\n" +
                    "2. A member of Teesside University staff\n" +
                    "3. A TUCP student\n" +
                    "If you are not a member of any of these groups then unfortunately our licence does not allow access to the resource."
        )
    )
}