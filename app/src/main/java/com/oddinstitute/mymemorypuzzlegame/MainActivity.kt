package com.oddinstitute.mymemorypuzzlegame

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), GameFragmentListener {

    var thisIsSecondTile: Boolean = false
    lateinit var tile1: Tile
    lateinit var tile2: Tile
    val matchedTiles: ArrayList<Tile> = ArrayList()

    var grid = 8

    var gameIsActive = true

    override fun makeTheTiles(): ArrayList<Tile> {
        val tilesArr: ArrayList<Tile> = ArrayList()

        for (i in 1..grid * grid) {
            var number = i
            if (number > (grid * grid / 2))
                number -= (grid * grid / 2) // 1 2 3 4 5 6 7 8 1 2 3 4 5 6 7 8

            val newTile = Tile(this, number)

//            newTile.tileStatus = TileStatus.VISIBLE

            newTile.updateThisTile()

            tilesArr.add(newTile)
        }

        tilesArr.shuffle()
        return tilesArr
    }

    override fun tileTapped(tile: Tile, position: Int) {
        if (tile.tileStatus != TileStatus.HIDDEN || !gameIsActive)
            return

        tile.tileStatus = TileStatus.VISIBLE
        tile.updateThisTile()

        if (thisIsSecondTile) { // it means, the tile we just cliked,
            // was the second in this cycle
            tile2 = tile

            // here, we should check
            gameIsActive = false
            compareTiles()

            thisIsSecondTile = false
        } else { // this was the first tile
            tile1 = tile
            thisIsSecondTile = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resetGame()

        findViewById<Button>(R.id.resetButton_id).setOnClickListener {
            resetGame()
        }
    }
}
