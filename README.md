# Android Memory Puzzle Game

A classic tile-matching memory puzzle game for Android where players flip tiles to find matching pairs.

## Overview

Test your memory by finding matching number pairs hidden beneath tiles. Flip two tiles at a time - if they match, they stay revealed. Match all pairs to win!

## Features

- **8x8 Game Grid**: 64 tiles with 32 matching pairs
- **Smooth Flip Animations**: ObjectAnimator-powered card flip effects (600ms duration)
- **Visual Feedback**:
  - Grey tiles with "?" - Hidden state
  - Yellow tiles with numbers - Revealed state
  - Green tiles with smiley face - Matched state
- **Game Controls**: Reset button to shuffle and restart
- **Win Detection**: Automatic victory notification when all pairs matched

## Tech Stack

| Component | Technology |
|-----------|------------|
| Language | Kotlin |
| Min SDK | 29 (Android 10) |
| Target SDK | 32 (Android 12) |
| UI | RecyclerView, GridLayoutManager |
| Architecture | Fragment-based with interface communication |
| Animation | ObjectAnimator (ScaleX) |

## Project Structure

```
app/src/main/java/com/oddinstitute/mymemorypuzzlegame/
├── MainActivity.kt              # Game state management & tile comparison
├── MainActivity+CompareTiles.kt # Tile matching logic extension
├── MainActivity+ResetGame.kt    # Game reset functionality
├── GameFragment.kt              # Game grid UI (RecyclerView)
├── GameAdapter.kt               # RecyclerView adapter for tiles
├── Tile.kt                      # Custom view with flip animation
└── SquareFrameLayout.kt         # Square aspect ratio container
```

## How to Play

1. Launch the app to see an 8x8 grid of hidden tiles
2. Tap any tile to reveal its number
3. Tap another tile to find its match
4. If numbers match, both tiles turn green and stay revealed
5. If numbers don't match, tiles flip back after 500ms
6. Continue until all 32 pairs are matched
7. Tap "Reset" to start a new game

## Building

```bash
# Clone the repository
git clone <repo-url>

# Open in Android Studio and sync Gradle
# Run on emulator or device (Android 10+)

./gradlew assembleDebug
```

## Dependencies

- AndroidX AppCompat 1.4.1
- Material Design 1.6.0
- ConstraintLayout 2.1.3
- RecyclerView (AndroidX)
