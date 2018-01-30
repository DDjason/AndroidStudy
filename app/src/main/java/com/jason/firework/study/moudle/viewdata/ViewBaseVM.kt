package com.jason.firework.study.moudle.viewdata

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.jason.firework.study.BR

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 16:21$
 *
 *
 */
class ViewBaseVM : BaseObservable(){
    @get:Bindable
    var title: String? = null
        set(title) {
            field = title
            notifyPropertyChanged(BR.title)
        }
}
