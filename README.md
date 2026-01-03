
# RecipeApp — Android (Kotlin | Jetpack Compose) {apk file available}

A **clean, beginner-to-intermediate Android application** built with **Kotlin** and **Jetpack Compose**, demonstrating **core Android fundamentals** such as API integration, state management, navigation, and modern UI development using **Material 3**.

---

## Project Overview

RecipeApp fetches and displays **recipe categories** from a public REST API and presents them in a responsive grid layout. Users can tap on a category to view its image and detailed description on a separate screen.

The app emphasizes:

* correct use of **Jetpack Compose**
* safe **asynchronous data loading**
* clear **separation of UI and logic**
* predictable **state-driven rendering**

---

## Demo Walkthrough (GIF)

<p align="center">
  <img 
    src="https://github.com/Sourasamanta/ScreenShots/blob/main/RecipeApp/RecipeAppDemo.gif"
    width="280"
    alt="RecipeApp Demo Walkthrough"
  />
</p>

<em>A short walkthrough showing category loading, grid scrolling, and navigation to the detail screen.</em>

---

## Learning Objectives

This project demonstrates my understanding of:

* Jetpack Compose basics and layouts
* ViewModel-based state management
* Coroutine-based networking
* REST API consumption using Retrofit
* Screen-to-screen navigation
* Passing complex data safely between destinations
* Material 3 UI principles

---

## Key Features

* Fetches recipe categories from **TheMealDB API**
* Displays categories in a **2-column grid**
* Handles **loading, success, and error** states
* Navigates to a **detail screen** on item selection
* Displays category image and description
* Uses **Material 3 typography and spacing**
* Supports **edge-to-edge UI**

---

## App Flow

```text
Launch App
   ↓
Fetch Categories (API)
   ↓
Show Loading Indicator
   ↓
Display Category Grid
   ↓
Tap Category
   ↓
Navigate to Detail Screen
```

---

## Architecture Overview

The app follows a **simple MVVM structure**:

```text
UI (Jetpack Compose)
   ↓ observes
ViewModel (UI State)
   ↓ executes
Network Service (Retrofit)
```

### Why MVVM?

* Keeps UI code clean and readable
* Prevents network logic inside composables
* Makes state changes predictable
* Easier to extend and test later

---

## Networking

* Uses **Retrofit** for API communication
* JSON parsing via **Gson**
* API calls executed inside `viewModelScope`
* Errors handled safely and exposed to UI state

**Endpoint Used:**

```text
GET https://www.themealdb.com/api/json/v1/1/categories.php
```

---

## State Management

The UI is driven by a single immutable state object containing:

* `loading` — shows progress indicator
* `list` — list of recipe categories
* `error` — error message if API fails

Compose automatically updates the UI when the state changes.

---

## Navigation

* Implemented using **Navigation Compose**
* Uses `SavedStateHandle` to pass a `Category` object
* Avoids fragile route-based argument passing
* Ensures safe screen transitions

---

## Tech Stack

* **Language:** Kotlin
* **UI:** Jetpack Compose
* **Design:** Material 3
* **Architecture:** MVVM
* **Networking:** Retrofit + Gson
* **Async:** Kotlin Coroutines
* **Navigation:** Navigation Compose
* **Image Loading:** Coil
* **Platform:** Android

---

## Installation

### Requirements

* Android Studio (latest stable)
* Android SDK
* Android Emulator or physical device

### Run Locally

```bash
git clone <repository-url>
cd RecipeApp
./gradlew installDebug
```

Or simply press **Run ▶️** in Android Studio.

---

## Usage

1. Open the app.
2. Wait for categories to load.
3. Scroll through the grid.
4. Tap any category.
5. View category details.
6. Use back navigation to return.

---

## Screenshots

### Category List Screen
<p align="center">
  <img 
    src="https://github.com/Sourasamanta/ScreenShots/blob/main/RecipeApp/RecipeApp1.jpeg"
    width="260"
    alt="RecipeApp Category List Screen"
  />
</p>

### Category Detail Screen
<p align="center">
  <img 
    src="https://github.com/Sourasamanta/ScreenShots/blob/main/RecipeApp/RecipeApp2.jpeg"
    width="260"
    alt="RecipeApp Category Detail Screen"
  />
</p>

---

## What This Project Demonstrates

* Understanding of **modern Android UI**
* Ability to work with **REST APIs**
* Clean and readable **Kotlin code**
* Correct handling of **Compose state**
* Basic architectural thinking (MVVM)
* Safe navigation between screens

---

## Limitations

* Only recipe categories are shown
* No offline caching
* No search or filtering
* No automated tests yet
* No pagination support

---

## Future Improvements

* Add meal list per category
* Add meal detail screen
* Introduce repository layer
* Add Room database for offline support
* Write unit tests for ViewModel
* Improve accessibility support

---

## License

This project is licensed under the **MIT License**.
