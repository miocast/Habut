package com.example.habut

import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habut.ui.theme.HabutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //данные из базы данных подключать
        setContent {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
                ListItem(name = "Название")
            }
        }
    }
    @Composable
    private  fun ListItem(name: String){
        Card(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 4.dp)
                .clickable {
                    Log.d("MyLog", "Жмакнули")
                },
            shape = RoundedCornerShape(100.dp),
            elevation = 3.dp
        ) {
            Box {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.imn),
                        contentDescription = "imn",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(55.dp)
                            .clip(CircleShape)
                    )
                    Text(text = name, modifier = Modifier.padding(start = 30.dp))
                }
                }
            }
        }
    }




