package com.abcode.shoestore.screens

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.abcode.shoestore.R
import com.abcode.shoestore.databinding.SampleShoesCardBinding
import com.abcode.shoestore.models.Shoes

/**
 * View that represents a CardView
 */
class ShoesCard : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: SampleShoesCardBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.sample_shoes_card, this, false)

    fun setShoesInCard(shoe: Shoes) {
        binding.apply { // following IntelliJ suggestion
            addView(this.root)
            modelNameTxt.text = shoe.name
            modelCompanyTxt.text = shoe.company
            sizeTxt.text = "Size: ${shoe.size}"
            descriptionTxt.text = shoe.description
        }
    }
}