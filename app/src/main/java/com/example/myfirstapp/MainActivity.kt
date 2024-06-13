package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstapp.ui.theme.MyFirstAppTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayPreview("Hiago", "Bob")
        }
    }
}

@Composable
fun BirthdayMessage(name: String, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {

        Text(
            text = "Happy Birthday $name!",
            modifier = modifier.padding(24.dp),
            fontSize = 35.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = false, name= "GreetingsPreview")
@Composable
fun HappyBirthdayPreview(name: String, from: String) {
    MyFirstAppTheme(true) {
        Scaffold(modifier = Modifier.fillMaxSize(), ) { innerPadding ->
            Column {
                BirthdayMessage(
                    name = name,
                    modifier = Modifier.padding(innerPadding)
                )
                Typography("from $from", modifier = Modifier.padding(innerPadding) )
                GreetingImage(modifier = Modifier.fillMaxSize())
            }

            }

    }
}

@Composable
fun Typography(text: String, modifier: Modifier = Modifier) {
    Text(text = text,  modifier = modifier.fillMaxSize(), textAlign = TextAlign.Center)
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Image(painter = image, contentDescription = "Imagem de fundo", modifier = modifier)
}