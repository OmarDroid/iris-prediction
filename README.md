# 🌸 Iris Flower Species Predictor App
A beginner-friendly Android app that uses Jetpack Compose, Kotlin, and TensorFlow Lite to predict Iris flower species based on user input.

This project is a hands-on introduction to machine learning in Android apps using clean architecture and MVVM best practices.

## 🚀 What This App Does
The app allows users to enter four features of an Iris flower:

* Sepal Length
* Sepal Width
* Petal Length
* Petal Width

It uses a pre-trained TensorFlow Lite model to predict the species:

* Setosa
* Versicolor
* Virginica

The prediction is made entirely offline on-device — no internet is required.

## 📸 Screenshots
Input Screen	Prediction Output

<img src="https://github.com/OmarDroid/iris-prediction/blob/main/IrisPrediction1.png"  width="260" height="550"> <img src="https://github.com/OmarDroid/iris-prediction/blob/main/IrisPrediction2.png"  width="260" height="550">

## 🧠 Built With

* Kotlin + Jetpack Compose for modern UI
* TensorFlow Lite for machine learning
* MVVM architecture for clean state management
* StateFlow for reactive UI updates
  
## 💡 Who Is This For?
This project is perfect if you're:

* Learning Android development
* Curious about integrating machine learning into mobile apps
* Looking for a clean Jetpack Compose + MVVM example

## 📥 Try It Yourself
* Clone this repo:
```
git clone https://github.com/OmarDroid/iris-prediction
```
* Open in Android Studio Arctic Fox or newer
* Run on device/emulator with minimum SDK 21

### 📦 ML Model Training
The Iris model was trained using Python + TensorFlow.
You can find the full training code in the linked blog post or use the pre-converted iris_model.tflite already included in the project.

## ⭐ Support This Project
If you found this helpful:

👤 Follow [@OmarDroid](https://github.com/OmarDroid) for more projects.

