package com.oddinstitute.mymemorypuzzlegame

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


interface GameFragmentListener
{
    fun makeTheTiles (): ArrayList<Tile>
    fun tileTapped (tile: Tile, position: Int)
}




class GameFragment (val grid: Int) : Fragment()
{
    lateinit var listener: GameFragmentListener

    companion object
    {
        fun instance (grid: Int) : GameFragment
        {
            return GameFragment(grid)
        }
    }




    override fun onAttach(context: Context)
    {
        super.onAttach(context)

        if (context is GameFragmentListener)
            listener = context
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        val myFragView = inflater.inflate(R.layout.fragment_game,
                                          container,
                                          false)


        val gameRv = myFragView.findViewById<RecyclerView>(R.id.gameRv_id)
        gameRv.layoutManager = GridLayoutManager (activity as Context,
                                                  grid)
        gameRv.adapter = GameAdapter (listener.makeTheTiles(), listener)

        return myFragView
    }
}