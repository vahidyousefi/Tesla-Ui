package ir.vy.neumorphism.others

import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams

fun View.autoMarginSystemBars() {

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        // return margin from navigation and statusBar
        val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        // convert view with margin
        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = systemBarsInsets.top
            bottomMargin = systemBarsInsets.bottom
        }
        insets
    }
}