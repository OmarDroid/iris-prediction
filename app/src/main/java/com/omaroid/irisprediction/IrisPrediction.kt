package com.omaroid.irisprediction

data class PredictionResult(
    val label: String,
    val confidence: Float,
    val probabilities: FloatArray // Keep this as a FloatArray for easy manipulation
)
