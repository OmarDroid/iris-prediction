package com.omaroid.irisprediction

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun IrisApp(
    uiState: IrisUiState,
    onEvent: (UiEvent) -> Unit
) {
    val featureLabels = listOf(
        "Sepal Length (cm)",
        "Sepal Width (cm)",
        "Petal Length (cm)",
        "Petal Width (cm)"
    )

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter Iris Features", style = MaterialTheme.typography.titleLarge)

        featureLabels.forEachIndexed { index, label ->
            TextField(
                value = uiState.features[index].toString(),
                onValueChange = { newValue ->
                    val floatValue = newValue.toFloatOrNull() ?: 0f
                    onEvent(UiEvent.UpdateFeature(index, floatValue))
                },
                label = { Text(label) }
            )
        }

        // Prediction Button
        Button(
            onClick = {
                onEvent(
                    UiEvent.Predict(
                        context = context,
                        features = uiState.features.toFloatArray()
                    )
                )
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Predict")
        }

        // Prediction Result
        if (uiState.prediction.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Prediction: ${uiState.prediction}", style = MaterialTheme.typography.bodyLarge)
            Text(
                "Confidence: ${(uiState.confidence * 100)}%",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Bar Chart for Probabilities
            if (uiState.probabilities.isNotEmpty()) {
                PredictionChart(uiState.probabilities)
            }
        }
    }
}