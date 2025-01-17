package com.omaroid.irisprediction

import android.content.Context
import org.tensorflow.lite.Interpreter
import java.nio.channels.FileChannel

class IrisModel(context: Context) {
    private val interpreter: Interpreter

    init {
        val modelFile = context.assets.openFd("iris_model.tflite").run {
            val inputStream = createInputStream()
            val fileChannel = inputStream.channel
            fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
        }
        interpreter = Interpreter(modelFile)
    }

    fun predict(input: FloatArray): PredictionResult {
        val output = Array(1) { FloatArray(3) }
        interpreter.run(arrayOf(input), output)
        val maxIndex = output[0].indices.maxByOrNull { output[0][it] } ?: -1
        val labels = listOf("Setosa", "Versicolor", "Virginica")
        return PredictionResult(
            label = labels[maxIndex],
            confidence = output[0][maxIndex],
            probabilities = output[0] // Return the raw probabilities as a FloatArray
        )
    }
}