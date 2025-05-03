# Android Memory Puzzle Game

A classic tile-matching memory puzzle game built for Android using Kotlin. Players test their memory by finding matching pairs of tiles on a grid.

## Features

*   **Memory Gameplay**: Flip tiles to reveal hidden numbers and find matching pairs.
*   **Animations**: Smooth flip animations using Android's `ObjectAnimator`.
*   **Visual Feedback**:
    *   **Hidden**: Grey tile with "?"
    *   **Visible**: Yellow tile with revealed number
    *   **Matched**: Green tile with a smiley face "🙂"
*   **Game Logic**:
    *   Validates matches automatically.
    *   Prevents interacting with matched or visible tiles.
    *   Dynamically generates matched pairs for each game.
*   **Reset**: Button to restart the game and shuffle the board.

## Technical Details

*   **Language**: Kotlin
*   **Architecture**: Logic contained primarily within `MainActivity` and custom `Tile` views.
*   **UI Components**:
    *   `FrameLayout` for layout management.
    *   Custom `Tile` class extending `AppCompatTextView`.
    *   `ObjectAnimator` for flip effects (ScaleX).

## How to Run

1.  Clone this repository.
2.  Open the project in **Android Studio**.
3.  Sync Gradle project.
4.  Run the application on an Android Emulator or physical device.