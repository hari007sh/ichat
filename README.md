# BharatChat (Android, Jetpack Compose)

A lightweight WhatsApp-style messaging MVP optimized for Indian users. Built with Kotlin and Jetpack Compose.

## Features (MVP)
- Phone-first experience (OTP login placeholder)
- Chat list and chat screen UI
- In-memory repository (swap with Firebase/your backend)
- Localization: English, Hindi, Bengali, Tamil
- Material 3, dark/light theme

## Roadmap
- End-to-end encryption using Signal protocol
- Realtime backend (Firebase/Matrix/self-hosted)
- Push notifications (FCM)
- Media messages, voice notes, status
- Contact sync (with explicit user consent)

## Running
Open the project in Android Studio (Giraffe+), let it download the Gradle wrapper, and run on an emulator or device.

Command-line build requires Android SDK setup:
```
./gradlew assembleDebug
```

## Package
`com.bharatchat.app`

## Notes
This MVP uses an in-memory repository so it runs without credentials. Replace `ChatRepository` with your backend implementation.