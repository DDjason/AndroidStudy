package com.jason.firework.study.base

import android.databinding.BindingAdapter
import android.util.Log
import android.widget.EditText
import com.jason.firework.study.base.inputfilterutil.InputFilters

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 16:15$
 *
 * Description: xml页面 bindingAdapter
 */
object BindingAdapters {
    @BindingAdapter("inputFilter")
    @JvmStatic fun inputFilter(view: EditText, type: Int) {
        when (type) {
            1 -> {
                Log.i(" @Binding", " @Binding")
                InputFilters.addFilter(view, InputFilters.emojiFilter)
            }
            else -> {
            }
        }
    }
}
