package com.composedemoapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.CardElevation
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.composedemoapp.ui.theme.ComposeDemoAppTheme
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoAppTheme {
                Greeting(
                    title = "Jetpack Compose"
                )
            }
        }
    }
}

@Composable
fun Greeting(title: String) {
    val context = LocalContext.current
    val imagePainter = painterResource(id = R.drawable.image_jetpack_compose)
    val imageDescription = "Jetpack Compose Banner"
    var currentTime = remember { mutableStateOf(SimpleDateFormat.getTimeInstance().format(Date())) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime.value = SimpleDateFormat.getTimeInstance().format(Date())
            delay(1000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(
                width = 1.dp,
                Color.Black
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        ) {
            Box(modifier = Modifier.height(150.dp)) {
                Image(
                    painter = imagePainter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Red
                                )
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(
                        title,
                        style = TextStyle(
                            color = Color.Green,
                            fontSize = 24.sp,
                        ),
                    )
                }
            }
        }
        Text(
            text = "Time: ${currentTime.value}"
        )
        Text(text = "Click me!", modifier = Modifier.clickable {
            Log.e("TAG", "Greeting: Clicked!")
            Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
        })
        // Git test
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemoAppTheme {
        Greeting("Jetpack Compose")
    }
}