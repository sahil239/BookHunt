# 📚 BookHunt - Multiplatform Book Search App

BookHunt is a comprehensive Compose Multiplatform application that allows users to search for books via the Open Library API. Users can browse detailed book information, mark favorites, and store favorite selections locally using Room Database. The app demonstrates effective use of Kotlin Multiplatform and Compose to build cross-platform applications targeting Android, iOS, and Desktop.

## 🌟 Features

* **Book Searching**: Quickly search and retrieve books using the Open Library API.
* **Detailed View**: View detailed information about selected books, including ratings, page counts, languages, and descriptions.
* **Favorites Management**: Mark books as favorites and access them easily through a dedicated favorites tab.
* **Local Database**: Persistently store favorite books locally using Room for Kotlin Multiplatform.
* **Multiplatform Support**: Seamless support for Android, iOS, and Desktop (Windows/MacOS).
* **Rich UI**: Engaging UI with animations, smooth transitions, and responsive design.

## ⚙️ Tech Stack

* **Kotlin Multiplatform**: Shared logic across Android, iOS, and Desktop.
* **Jetpack Compose Multiplatform**: Unified UI across all platforms.
* **Room Database**: Local database for storing favorites.
* **Ktor 3.0**: Network requests to fetch book data from Open Library API.
* **Coil 3**: Image loading and caching for book covers.
* **Coroutines & Flow**: Asynchronous programming and state management.
* **Koin**: Dependency Injection.

## 🛠️ Architecture

The app follows a clean architecture approach using three layers:

* **Domain**: Core business logic and domain models (pure Kotlin, no dependencies).
* **Data**: Repository, API clients, database interactions (Room, Ktor).
* **Presentation**: UI logic, composable functions, ViewModels.

Features are structured into self-contained packages following the MVVM/MVI pattern, making the project highly scalable and maintainable.

## 🚀 Getting Started

### Prerequisites

* Android Studio Flamingo or newer
* Kotlin 1.9.10 or newer

### Installation

Clone this repository:

```bash
git clone https://github.com/sahil239/BookHunt
```

Open the project in Android Studio, and sync the Gradle project to fetch all dependencies.

### Running the App

* **Android**: Select the Android run configuration and start the emulator or connect your physical device.
* **iOS**: Requires macOS with Xcode installed. Open project in Xcode and run the iOS App.
* **Desktop**: Use the Desktop run configuration directly from Android Studio.

## 📖 API

The application uses the free [Open Library API](https://openlibrary.org/dev/docs/api/books) for book searching and retrieval.

## ✅ Next Steps

Feel free to extend the app with additional features such as:

* User reviews and ratings.
* Social sharing capabilities.
* More sophisticated animations and UI elements.

## 🤝 Contributing

Contributions, issues, and feature requests are welcome. Feel free to check the [issues page](https://github.com/yourusername/bookpedia/issues).

## 📜 License

This project is licensed under the MIT License.

## 🎬 Course Video

Course by 
[Philipp Lackner](https://www.youtube.com/watch?v=WT9-4DXUqsM&t=40s)
---

Enjoy exploring BookHunt and mastering Kotlin Multiplatform! 🚀📖✨

