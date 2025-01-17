package com.omaroid.irisprediction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.omaroid.irisprediction.ui.theme.TensorFlowDemoTheme

class MainActivity : ComponentActivity() {
    private val irisViewModel: IrisViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val uiState by irisViewModel.uiState.collectAsState()
            TensorFlowDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IrisApp(
                        uiState = uiState,
                        onEvent = { event -> irisViewModel.onEvent(event) }
                    )
                }
            }
        }
    }
}