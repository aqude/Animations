package com.example.rotateimage

import android.annotation.SuppressLint
import android.graphics.drawable.Animatable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rotateimage.ui.theme.RotateImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RotateImageTheme {
                ImageRotate()
            }
        }
    }
}

@Composable
fun ImageRotate() {
    var rotation by remember { mutableStateOf(0f) }
    var visible by remember {
        mutableStateOf(true)
    }
//    val animateRotateState = remember {
//        Animatable(Color.DarkGray)
//    }
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(modifier = Modifier.height(300.dp)) {
            androidx.compose.animation.AnimatedVisibility(visible = visible) {
                Image(painterResource(id = R.drawable.img), contentDescription = "icon", modifier = Modifier.rotate(rotation))
            }
        }


            Column(horizontalAlignment = Alignment.CenterHorizontally,) {
                Button(onClick = {
                    visible = !visible
                }, modifier = Modifier
                    .height(50.dp)
                    .padding(bottom = 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
                ) {
                    Text(text = "Visible")
                }

                Row(
//                modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = { rotation -= 90f },
                        modifier = Modifier
                            .height(50.dp)
                            .padding(end = 10.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
                    ) {
                        Text(text = "Rotate -90")
                    }

                    Button(
                        onClick = { rotation += 90f },
                        modifier = Modifier
                            .height(50.dp)
                            .padding(start = 10.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
                    ) {
                        Text(text = "Rotate +90")
                    }
                }
            }



    }

}