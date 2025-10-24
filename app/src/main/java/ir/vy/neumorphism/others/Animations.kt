package ir.vy.neumorphism.others

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import ir.vy.neumorphism.MainActivity2

// Animation Alpha for lightCar
fun alphaAnim(targetView: View, context: Context?, fillAfter : Boolean) {

    // show view
    targetView.visibility = View.VISIBLE

    val anim = AlphaAnimation(1f, 0f)
    anim.duration = 200
    anim.repeatCount = 3
    anim.fillAfter = fillAfter
    anim.repeatMode = Animation.RESTART

    if (context != null){

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) {
                val intent = Intent(context, MainActivity2::class.java)
                context.startActivity(intent)
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })

    }
    targetView.startAnimation(anim)
}