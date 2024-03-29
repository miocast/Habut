package com.miocast.habut

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.miocast.habut.main_screen.MainScreen
import com.miocast.habut.navigation.MainNavigationGraph
import com.miocast.habut.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


const val AD_ID = "ca-app-pub-3940256099942544/5224354917"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavigationGraph()

        }
    }
}





