package com.jason.firework.study.moudle.viewctrl

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.jason.firework.study.R
import com.jason.firework.study.base.inputfilterutil.InputFilters
import com.jason.firework.study.databinding.ActivityViewBaseBinding
import com.jason.firework.study.moudle.viewdata.ViewBaseVM
import com.jason.firework.study.utils.AndroidUtil
import java.util.*
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit




/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 11:19$
 * Description: [com.jason.firework.study.moudle.ui.ViewBaseAct]
 */
class ViewBaseCtrl {
    var viewModel = ViewBaseVM()


    private var binding: ActivityViewBaseBinding? = null

    init {

    }

    constructor()

    constructor(binding: ActivityViewBaseBinding) {
        this.binding = binding

        val field = InputMethodManager::class.java.getDeclaredField("DEBUG")
//将字段的访问权限设为true：即去除private修饰符的影响
        field.setAccessible(true)





//把字段值设为200
        field.set(null, true)

        binding!!.editBank.addTextChangedListener(object : TextWatcher {
            private var oldString = ""
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (oldString.equals(s.toString())) {
                    oldString = ""
                    return
                } else {
                    oldString = InputFilters.newBankcardFormat(s.toString(), "-")
                    s.replace(0, s.toString().length, oldString)
                }
            }
        })
    }


    //view Post
    fun onClickCeshi(view: View) {
        Log.i("ViewBaseCtr", "ViewBaseCtr.onClickCeshi")
        Toast.makeText(view.context, viewModel.title, Toast.LENGTH_SHORT).show()

        binding?.postView?.visibility = View.VISIBLE
        // post 加载在 UI 队列中
        view.post {
            var gradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT
                    , intArrayOf(AndroidUtil.getActivity(view).resources.getColor(R.color.colorPrimary)
                    , AndroidUtil.getActivity(view).resources.getColor(R.color.colorAccent)))
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

    private fun startTextInAnim(view: View) {
        var random = Random()
        var metrics = AndroidUtil.getMetrics(AndroidUtil.getActivity(view))
        var x = random.nextInt(metrics.widthPixels * 5 / 3)
        var y = random.nextInt(metrics.heightPixels * 5 / 3)
        val s = random.nextFloat() + 4.0f
        val tranY = ObjectAnimator.ofFloat(view, "translationY", y - view.y, 0f)
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

    fun onclickOpen(){
        //val inputMethodManager = AndroidUtil.getActivity(binding!!.root).getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)

        var poolExecutor = ThreadPoolExecutor(3, 5,
                1, TimeUnit.SECONDS, LinkedBlockingDeque<Runnable>(128))



    }

    fun onclickClose(){
        val inputMethodManager = AndroidUtil.getActivity(binding!!.root).getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
                AndroidUtil.getActivity(binding!!.root).getWindow().getDecorView().getWindowToken(), 0)
    }




}
