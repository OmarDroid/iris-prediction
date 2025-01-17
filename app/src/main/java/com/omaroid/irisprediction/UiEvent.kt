package com.omaroid.irisprediction

import android.content.Context

sealed class UiEvent {
    data class Predict(val context: Context, val features: FloatArray) : UiEvent()
    data class UpdateFeature(val index: Int, val value: Float) : UiEvent()
}