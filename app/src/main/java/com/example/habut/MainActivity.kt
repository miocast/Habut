package com.example.habut

import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habut.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //данные из базы данных подключать

        setContent {
            HabutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VerticalGradient()
                }
            }

            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())) {
                Text(text = "Твои привычки",
                    modifier = Modifier.padding(start = 67.dp, top = 106.dp,bottom = 45.dp),
                    fontFamily = comfortaa,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp)

                ListItem(name = "Название")
                ListItem(name = "Название")
            }
        }
    }

    @Composable
    fun VerticalGradient(){
        val gradient = Brush.verticalGradient(
            0.0f to Violet100,
            1.0f to Cosmos100,
            startY = 0.0f,
            endY = 2800.0f
        )
        Box(modifier = Modifier.background(gradient))
    }






    @Composable
    private  fun ListItem(name: String){

        Card(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp, top = 10.dp, bottom = 4.dp)
                .clickable {
                    Log.d("MyLog", "Жмакнули")
                },
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ) {
            Box {
                Row (verticalAlignment = Alignment.CenterVertically){
                    var isExpanded by remember {
                        mutableStateOf(false)
                    }

                    var color = remember {
                        mutableStateOf(Violet200)
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .size(56.dp)
                            .background(color = color.value, shape = CircleShape)
                            .clickable {
                                isExpanded = !isExpanded
                            }
                    ){
                        if(isExpanded) color.value = Violet200 else color.value = Cosmos100
                    }


                    Text(text = name, color = Violet100,fontFamily = comfortaa, modifier = Modifier.padding(start = 30.dp))
                }
            }
        }
    }
}




