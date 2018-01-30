package com.jason.firework.study.utils

import android.app.Activity
import android.content.ContextWrapper
import android.util.DisplayMetrics
import android.view.View



/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 15:06$
 * <p/>
 */
class AndroidUtil {
    companion object{
         fun getActivity(view: View) : Activity {
             var context = view.context
             while (context is ContextWrapper) {
                 if (context is Activity) {
                     return context
                 }
                 context = context.baseContext
             }
             return view.context as Activity
        }

        fun getMetrics(activity: Activity): DisplayMetrics {
            val display = activity?.windowManager?.defaultDisplay
            val metrics = DisplayMetrics()
            display?.getMetrics(metrics)
            return metrics
        }
    }
}