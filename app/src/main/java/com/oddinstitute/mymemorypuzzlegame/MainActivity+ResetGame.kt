package com.oddinstitute.mymemorypuzzlegame

fun MainActivity.resetGame ()
{
    matchedTiles.clear()
    thisIsSecondTile = false
    gameIsActive = true


    supportFragmentManager.findFragmentByTag("myGame")?.let {
        supportFragmentManager
            .beginTransaction()
            .remove(it)
            .commit()
    }

    supportFragmentManager
        .beginTransaction()
        .add(R.id.gameContainer_id,
             GameFragment.instance(grid),
             "myGame")
        .commit()
}
