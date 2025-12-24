# Android With Java Course Project

This repository contains the project I completed as part of my Android development course using Java. It serves as a practical demonstration of various Android components, APIs, and development concepts, including a complete user authentication system powered by Firebase.

## About This Project

This application is a collection of several mini-apps, each designed to explore a specific feature of the Android framework. It showcases my ability to build a multi-activity application and integrate different functionalities—from local utilities to cloud-based services—into a single, cohesive user experience.

## How to Install and Test the App (APK)

For easy testing, a pre-built APK file is available. Follow these steps to install it on your Android device:

1.  **Download the APK:**
    *   Navigate to the **[Releases](https://github.com/YourUsername/AndroidWithJavaCourse/releases)** section of this GitHub repository.
    *   Download the latest `.apk` file (e.g., `app-release.apk`).

2.  **Enable Installation from Unknown Sources:**
    *   On your Android device, go to **Settings** > **Security** (or a similar path).
    *   Find and enable the **Install unknown apps** permission for your browser or file manager.

3.  **Install the APK:**
    *   Open your device's **File Manager**, go to your **Downloads** folder, and tap on the downloaded `.apk` file.
    *   Confirm the installation when prompted.

4.  **Run the App:**
    *   Once installed, find the app's icon in your app drawer and open it.

## Features Implemented

This project includes the following features and mini-apps:

*   **✨ Splash Screen:** A timed splash screen that provides a professional entry point into the app.
*   **🔒 User Authentication Flow:**
    *   **User Login:** Secure sign-in with email and password using Firebase Authentication.
    *   **User Registration:** A complete registration screen for new users to create an account.
    *   **Forgot Password UI:** A screen for password recovery is implemented. *(Note: This currently shows a confirmation and returns to the login screen; the Firebase email sending logic is not yet connected).*
    *   **Remember Me:** Saves user credentials locally using `SharedPreferences` for a faster login experience.
    *   **Session Management:** Automatically navigates to the home screen if the user is already logged in.
*   **🧮 Calculator:** A simple, functional calculator for basic arithmetic operations.
*   **🏔️ Random Mountain:** A fun app that displays a random high mountain.
*   **🍔 Restaurant Menu:** A simple UI to display a restaurant menu.
*   **❓ Quiz App:** A "Dog or Cat" quiz that showcases handling user choices and results.
*   **🌐 Web View:** An activity that loads and displays a live website using Android's `WebView`.
*   **📄 PDF Viewer:** Integration of a PDF viewing library to open and display local PDF documents.
*   **🌡️ Temperature Converter:** A utility to convert temperatures between Celsius and Fahrenheit.
*   **🎵 Media Player:** A basic media player to play and control audio files.
*   **🕹️ Tic-Tac-Toe Game:** A simple implementation of the classic XO game.
*   **🗺️ Google Maps:** An activity that integrates Google Maps to display a location.
*   **☁️ Fake API Client:** An activity designed to interact with a sample REST API.

## Technologies and Concepts Learned

*   **Core Components:** `Activity`, `Intent`, `View`, `Button`, `SharedPreferences`.
*   **User Interface:** XML Layouts (`ConstraintLayout`), `AlertDialog`, `ViewCompat`, `EdgeToEdge` UI.
*   **Event Handling:** `OnClickListener` and event-driven programming.
*   **Cloud Services:**
    *   **Firebase Authentication:** For managing user sign-up and sign-in.
*   **Third-Party Libraries:**
    *   Google Play Services for Maps
    *   Retrofit for networking
    *   ExoPlayer for media
*   **Version Control:** All project history is managed with Git and hosted on GitHub.

## How To Build From Source

These instructions are for developers who want to build the project themselves.

1.  **Clone the repository:**
2.  **Firebase Setup:**
    *   This project requires a `google-services.json` file from a Firebase project to run.
    *   Create your own project on the [Firebase Console](https://console.firebase.google.com/).
    *   In the Firebase project, enable **Email/Password** sign-in method in the **Authentication** section.
    *   Add an Android app to your Firebase project with the package name from this app (`com.example.yanfaacourse`).
    *   Download the generated `google-services.json` file and place it in the `app/` directory of your project.

3.  **Open in Android Studio:** Open the project in Android Studio.

4.  **Sync Dependencies:** Let Gradle sync the project.

5.  **Run the app** on an emulator or a physical device.