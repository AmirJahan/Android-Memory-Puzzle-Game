package com.oddinstitute.mymemorypuzzlegame

import android.os.Handler
import android.widget.Toast

fun MainActivity.compareTiles ()
{
    Handler(mainLooper).postDelayed(
            {
                if (tile1.intNumber == tile2.intNumber)
                {
                    // a Match
                    tile1.tileStatus = TileStatus.MATCHED
                    tile2.tileStatus = TileStatus.MATCHED

                    matchedTiles.add(tile1)
                    matchedTiles.add(tile2)


                    if (matchedTiles.count() == grid * grid)
                    {
                        Toast.makeText(this,
                                       "You WON",
                                       Toast.LENGTH_SHORT).show()
                    }

                }
                else
                {
                    // not a match
                    tile1.tileStatus = TileStatus.HIDDEN
                    tile2.tileStatus = TileStatus.HIDDEN
                }

                tile1.updateThisTile()
                tile2.updateThisTile()

                gameIsActive = true
            }, 500)
}