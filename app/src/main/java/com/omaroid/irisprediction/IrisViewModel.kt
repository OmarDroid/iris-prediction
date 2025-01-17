package com.omaroid.irisprediction

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class IrisViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(IrisUiState())
    val uiState: StateFlow<IrisUiState> = _uiState

    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.Predict -> {
                val irisModel = IrisModel(event.context)
                val prediction = irisModel.predict(event.features)


                // Transform FloatArray into List<Pair<String, Float>>
                val labeledProbabilities = prediction.probabilities.mapIndexed { index, value ->
                    val label = when (index) {
                        0 -> "Setosa"
                        1 -> "Versicolor"
                        2 -> "Virginica"
                        else -> "Unknown"
                    }
                    label to value
                }

                // Update UI state
                _uiState.value = _uiState.value.copy(
                    features = event.features.toList(),
                    prediction = prediction.label,
                    confidence = prediction.confidence,
                    probabilities = labeledProbabilities
                )


            }
            is UiEvent.UpdateFeature -> {
                val updatedFeatures = _uiState.value.features.toMutableList()
                updatedFeatures[event.index] = event.value
                _uiState.value = _uiState.value.copy(features = updatedFeatures)
            }
        }
    }
}

data class IrisUiState(
    val features: List<Float> = listOf(0f, 0f, 0f, 0f),
    val prediction: String = "",
    val confidence: Float = 0f,
    val probabilities: List<Pair<String, Float>> = emptyList()
)
