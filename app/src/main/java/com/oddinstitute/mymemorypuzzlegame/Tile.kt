package com.oddinstitute.mymemorypuzzlegame

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator


enum class TileStatus
{
    HIDDEN, VISIBLE, MATCHED
}


data class Tile(var myContext: Context,
                val intNumber: Int) : androidx.appcompat.widget.AppCompatTextView(myContext)
{
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        setMeasuredDimension(width, width)
    }


    var tileStatus = TileStatus.HIDDEN

    fun updateThisTile ()
    {
        val anim1 = ObjectAnimator.ofFloat(this,
                                           "scaleX",
                                           1f,
                                           0f)

        val anim2 = ObjectAnimator.ofFloat(this,
                                           "scaleX",
                                           0f,
                                           1f)

        anim1.duration = 300
        anim2.duration = 300
        anim1.interpolator = AccelerateInterpolator()
        anim2.interpolator = DecelerateInterpolator()


        anim1.addListener(object : AnimatorListenerAdapter()
                          {
                              override fun onAnimationEnd(animation: Animator?)
                              {
                                  super.onAnimationEnd(animation)

                                  when (tileStatus)
                                  {
                                      TileStatus.HIDDEN ->
                                      {
                                          this@Tile.text = "?"
                                          this@Tile.setBackgroundColor(Color.LTGRAY)
                                      }
                                      TileStatus.VISIBLE ->
                                      {
                                          this@Tile.text = this@Tile.intNumber.toString()
                                          this@Tile.setBackgroundColor(Color.YELLOW)
                                      }
                                      TileStatus.MATCHED ->
                                      {
                                          this@Tile.text = "🙂"
                                          this@Tile.setBackgroundColor(Color.GREEN)
                                      }
                                  }

                                  anim2.start()
                              }
        })
        anim1.start()



    }

}