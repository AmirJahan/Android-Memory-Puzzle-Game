package com.oddinstitute.mymemorypuzzlegame

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView

// we have the root view, to THAT, we attach a text view
class CardViewHolder(val rootView: SquareFrameLayout) :
    RecyclerView.ViewHolder(rootView)

class GameAdapter(
    val tiles: ArrayList<Tile>,
    val listener: GameFragmentListener
) : RecyclerView.Adapter<CardViewHolder>() {

    lateinit var tileContainer: FrameLayout

    override fun getItemCount(): Int = tiles.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val tileSqF = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.card_layout,
                parent,
                false
            ) as SquareFrameLayout

        val cardVH = CardViewHolder(tileSqF)

        // DOES THIS MAKE SENSE?
        tileContainer = cardVH.itemView.findViewById(R.id.tileContainer_id)

        return cardVH
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        tileContainer.setBackgroundColor(Color.DKGRAY)

        val thisTile = tiles[position] // 0 ---> 15

        val param = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        thisTile.layoutParams = param
        param.setMargins(5)
        thisTile.gravity = Gravity.CENTER
        thisTile.textSize = 24F

        tileContainer.addView(thisTile)

        tileContainer.setOnClickListener {
            listener.tileTapped(thisTile, position)
        }
    }
}
