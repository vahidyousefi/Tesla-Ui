package ir.vy.neumorphism

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.material.snackbar.Snackbar
import ir.vy.neumorphism.databinding.ActivityMain2Binding
import ir.vy.neumorphism.others.alphaAnim
import ir.vy.neumorphism.others.autoMarginSystemBars
import ir.vy.neumorphism.others.snackBar
import soup.neumorphism.NeumorphImageView
import soup.neumorphism.ShapeType

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // set color in navigation > white = false
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.isAppearanceLightNavigationBars = false
        // auto Margin
        binding.appBar.autoMarginSystemBars()
        binding.navigation.autoMarginSystemBars()

//        binding.checkBox1.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                ContextCompat.getColor(this, R.color.blue_light)
//            } else {
//                ContextCompat.getColor(this, R.color.icon_default_color)
//            }
//        }

        binding.cardEngine.setOnClickListener {
            binding.checkBox1.isChecked = !binding.checkBox1.isChecked
        }
        binding.cardClimate.setOnClickListener {
            binding.checkBox2.isChecked = !binding.checkBox2.isChecked

            if (binding.checkBox2.isChecked) {
                alphaAnim(binding.lightCar2, null, false)
                snackBarLights("Lights is ON !")
            } else {
                alphaAnim(binding.lightCar2, null, true)
                binding.lightCar2.visibility = View.INVISIBLE
                snackBarLights("Lights is OFF !")
            }
        }
        binding.cardTires.setOnClickListener {
            binding.checkBox3.isChecked = !binding.checkBox3.isChecked
        }
        binding.cardDirection.setOnClickListener {
            binding.checkBox4.isChecked = !binding.checkBox4.isChecked
        }

        binding.battery.setOnClickListener {
            // change shapeType > Image, cardView, Button ...
//            binding.battery.setShapeType(ShapeType.PRESSED)
//
//            // change color
//            binding.battery.setColorFilter(ContextCompat.getColor(this, R.color.blue_light))
//            // or
//            binding.battery.setColorFilter(ContextCompat.getColor(this, R.color.blue_light),
//                android.graphics.PorterDuff.Mode.SRC_IN)


            // simple code
//            val shapeType = (it as NeumorphImageView).getShapeType()
//            if (shapeType == ShapeType.PRESSED) {
//
////                it.setShapeType(ShapeType.FLAT)
////                it.setColorFilter(
////                    ContextCompat.getColor(this, R.color.icon_default_color),
////                    android.graphics.PorterDuff.Mode.SRC_IN
////                )
//            } else {
//
//                it.setShapeType(ShapeType.PRESSED)
//                it.setColorFilter(
//                    ContextCompat.getColor(this, R.color.blue_light),
//                    android.graphics.PorterDuff.Mode.SRC_IN
//                )
//
//                binding.dry.setShapeType(ShapeType.FLAT)
//                binding.location.setShapeType(ShapeType.FLAT)
//                binding.time.setShapeType(ShapeType.FLAT)
//
//                binding.dry.setColorFilter(
//                    ContextCompat.getColor(this, R.color.icon_default_color),
//                    android.graphics.PorterDuff.Mode.SRC_IN
//                )
//                binding.location.setColorFilter(
//                    ContextCompat.getColor(this, R.color.icon_default_color),
//                    android.graphics.PorterDuff.Mode.SRC_IN
//                )
//                binding.time.setColorFilter(
//                    ContextCompat.getColor(this, R.color.icon_default_color),
//                    android.graphics.PorterDuff.Mode.SRC_IN
//                )
//            }


            // advanced code
            it as NeumorphImageView
            selectIcon(it)
        }
        binding.dry.setOnClickListener {
            selectIcon(binding.dry)
        }
        binding.location.setOnClickListener {
            selectIcon(binding.location)
        }
        binding.time.setOnClickListener {
            selectIcon(binding.time)
        }
    }

    private fun snackBarLights(text: String) {

        snackBar(
            binding.root,
            text,
            null,
            null,
            R.color.blue_light,
            R.color.text_white,
            R.color.blue_light,
            Snackbar.LENGTH_SHORT,
            android.view.Gravity.CENTER,
            112
        )
    }

    @SuppressLint("RestrictedApi")
    private fun selectIcon(selected: NeumorphImageView) {

        // list items
        val allItems = listOf(
            binding.battery,
            binding.dry,
            binding.location,
            binding.time
        )

        // select item
        allItems.forEach { view ->
            if (view == selected) {
                view.setShapeType(ShapeType.PRESSED)
                view.setColorFilter(
                    ContextCompat.getColor(this, R.color.blue_light),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
            }
            // reset other items
            else {
                view.setShapeType(ShapeType.FLAT)
                view.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
            }
        }
    }


}