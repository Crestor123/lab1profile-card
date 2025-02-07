package com.example.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Cyan)
                ) {
                    ProfileCard()
                }
            }
        }
    }
}

@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
    Box(
        //Main container to allow for background color
        modifier = Modifier.background(color = Color(0xFF07393C))
    )
    {
        Column(
            //Display all elements stacked vertically
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            ProfileImage()
            ProfileName()
            Column(
                //Container for biography lines
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color(0xFF2C666E))
                    .padding(8.dp)
            )
            {
                BiographyLine(line = stringResource(R.string.bio_line_1))
                BiographyLine(line = stringResource(R.string.bio_line_2))
            }
        }
    }
}

@Composable
fun ProfileImage(modifier : Modifier = Modifier) {
val profilePic = painterResource(R.drawable.wizard)
Image(
    //Circular profile picture
    painter = profilePic,
    contentDescription = "Profile Picture",
    modifier
        .size(200.dp)
        .clip(CircleShape)
)
}

@Composable
fun ProfileName(modifier : Modifier = Modifier) {
    Text(
        //Large text element for name
        text = stringResource(R.string.Name),
        modifier = Modifier
            .background(color = Color(0xFF2C666E), shape = CircleShape)
            .padding(8.dp),
        fontSize = 36.sp
    )
}

@Composable
fun BiographyLine(modifier : Modifier = Modifier, line : String) {
    Text(
        //Smaller text element for biography
        text = line,
        fontSize = 20.sp
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    ProfileCardTheme {
        ProfileCard()
    }
}