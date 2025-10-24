package ir.vy.neumorphism

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import ir.vy.neumorphism.databinding.ActivityMainBinding
import ir.vy.neumorphism.others.alphaAnim
import ir.vy.neumorphism.others.autoMarginSystemBars

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // ------ change color Navigation System ------
        // old way
//        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)

        // new way
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        // set color in navigation > white = false
        controller.isAppearanceLightNavigationBars = false
        // ---------------------------------------------
        // auto margin from navigation and statusBar system
        binding.appBar.autoMarginSystemBars()
        binding.btnGoToActivity2.autoMarginSystemBars()

        movingAnim(binding.imgCar1, 0f)
        movingAnim(binding.txtSpeed, 600f)
        movingAnim(binding.txtKm, 700f)
        // anim for tire
        multipleAnim()

        binding.cardSetting.setOnClickListener {
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
        }

        // btn go to and Animation Light
        binding.btnGoToActivity2.setOnClickListener {
            alphaAnim(binding.lightCar1, this, false)
        }
    }

    private fun rotateAnim(): RotateAnimation {

        val animRotate = RotateAnimation(
            360f, 0f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        animRotate.duration = 2500

        binding.tire1.startAnimation(animRotate)
        return animRotate
    }

    // translate animation
    private fun movingAnim(targetView: View, fromYDelta: Float): TranslateAnimation {

        val animTrans = TranslateAnimation(1000f, 0f, fromYDelta, 0f)
        animTrans.duration = 2500
        targetView.startAnimation(animTrans)

        return animTrans
    }

    private fun multipleAnim() {

        val multiAnim = AnimationSet(true)

        multiAnim.addAnimation(rotateAnim())
        multiAnim.addAnimation(movingAnim(binding.tire1, 0f))

        binding.tire1.startAnimation(multiAnim)
    }
}