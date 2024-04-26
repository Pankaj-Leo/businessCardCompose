package me.gentilpinto.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.gentilpinto.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using a light green background
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color(0xFFE0F2F1)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo Section
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Android Logo"
            )
        }

        // Name and Title Section
        Text(
            text = "Pankaj Somkuwar",
            fontSize = 24.sp,
            color = Color.Black
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 20.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(4.dp)
        )

        // Contact Information Section
        Spacer(modifier = Modifier.height(16.dp))
        ContactRow(
            text = "888-000-9999",
            icon = Icons.Rounded.Phone
        )
        ContactRow(
            text = "@AndroidDev", // Assuming Twitter handle for example
            icon = Icons.Rounded.Share
        )
        ContactRow(
            text = "somkuwarp1@montclair.edu",
            icon = Icons.Rounded.Email
        )
    }
}

@Composable
fun ContactRow(
    text: String,
    icon: ImageVector
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3DDC84) // Android green color for the icon
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
