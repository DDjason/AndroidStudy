package com.jason.firework.study.moudle.viewctrl

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import com.jason.firework.study.R
import com.jason.firework.study.databinding.ActivityViewBaseBinding
import com.jason.firework.study.moudle.viewdata.ViewBaseVM
import com.jason.firework.study.utils.AndroidUtil
import java.util.*

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 11:19$
 * Description: [com.jason.firework.study.moudle.ui.ViewBaseAct]
 */
class ViewBaseCtrl  {
    var viewModel = ViewBaseVM()


    private var binding : ActivityViewBaseBinding ?= null

    init {
    }

    constructor()

    constructor(binding: ActivityViewBaseBinding){
        this.binding = binding
    }


    //view Post
    fun onClickCeshi(view: View) {
        Log.i("ViewBaseCtr", "ViewBaseCtr.onClickCeshi")
        Toast.makeText(view.context,viewModel.title,Toast.LENGTH_SHORT).show()

        binding?.postView?.visibility = View.VISIBLE
        // post 加载在 UI 队列中
        view.post {
            var gradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT
                    ,intArrayOf(AndroidUtil.getActivity(view).resources.getColor(R.color.colorPrimary)
                            ,AndroidUtil.getActivity(view).resources.getColor(R.color.colorAccent)))
            binding?.postView?.background = gradientDrawable
        }
        //延迟加载到UI队列中
//        view.postDelayed({
//            binding?.postView?.setBackgroundColor(R.color.colorPrimary)
//        },1000)
//        view.postOnAnimationDelayed({
            //动画添加
//            startTextInAnim(view)
//        },1000)
    }

    private fun startTextInAnim(view: View){
        var random = Random()
        var metrics = AndroidUtil.getMetrics(AndroidUtil.getActivity(view))
        var x = random.nextInt(metrics.widthPixels*5/3)
        var y = random.nextInt(metrics.heightPixels*5/3)
        val s = random.nextFloat() + 4.0f
        val tranY = ObjectAnimator.ofFloat(view,"translationY",y-view.y,0f)
        val tranX = ObjectAnimator.ofFloat(view, "translationX", x - view.getX(), 0f)
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", s, 1.0f)
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", s, 1.0f)
        val alpha = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f)
        val set = AnimatorSet()
        set.duration = 1800
        set.interpolator = AccelerateDecelerateInterpolator()
        set.play(tranX).with(tranY).with(scaleX).with(scaleY).with(alpha)

        set.start()
    }


}
