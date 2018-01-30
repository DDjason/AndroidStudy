package com.jason.firework.study.moudle.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.jason.firework.study.R
import com.jason.firework.study.base.BaseActivity
import com.jason.firework.study.base.RouterURL
import com.jason.firework.study.databinding.ActivityViewBaseBinding
import com.jason.firework.study.moudle.viewctrl.ViewBaseCtrl

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 11:02$
 * <p/>Description: open Class
 */

@Route(path = RouterURL.VIEW_BASE_ACT)
class ViewBaseAct : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityViewBaseBinding>(this, R.layout.activity_view_base)
        binding.viewCtrl = ViewBaseCtrl(binding)
    }
}
