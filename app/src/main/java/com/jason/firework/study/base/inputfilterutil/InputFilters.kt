package com.jason.firework.study.base.inputfilterutil

import android.text.InputFilter
import android.util.Log
import android.widget.EditText
import java.util.regex.Pattern

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/31$ 10:07$
 * <p/>
 */
object InputFilters {
    /**
     * Filter Emoji表情
     */
    @JvmStatic
    val emojiFilter = InputFilter { source, start, end, dest, dStart, dEnd ->
        var pattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE or Pattern
                .CASE_INSENSITIVE)
        val matcher = pattern.matcher(source)
        if (matcher.find()) {
            Log.d("InputFilter", "不允许输入Emoji表情")
            ""
        }else {
            null
        }
    }

    /** 不允许输入空格  */
    @JvmStatic
    val blankFilter = InputFilter { source, start, end, dest, dStart, dEnd ->
        if (source == " ") {
            ""
        } else {
            null
        }
    }

    /**
     * 添加新的Filter
     */
    @JvmStatic
    fun addFilter(view: EditText, filter: InputFilter) {
        val old = view.filters
        val filters = arrayOfNulls<InputFilter>(old.size + 1)
        var position = 0
        while (position < old.size) {
            filters[position] = old[position]
            position++
        }
        filters[position] = filter
        view.filters = filters
    }

    @JvmStatic fun newBankcardFormat(args: String,split: String) : String {
        var ret : String  = args.replace(" ","").replace(split,"")
        if (Pattern.matches("^\\d{13,}$", ret)) {
            ret =  ret.replace("(\\d{4})(\\d{4})(\\d{4})(\\d*)".toRegex(), "$1"+split+"$2"+split+"$3"+split+"$4")
        }else if(Pattern.matches("^\\d{9,}$", ret)){
            ret =  ret.replace("(\\d{4})(\\d{4})(\\d*)".toRegex(), "$1"+split+"$2"+split+"$3")
        }else if(Pattern.matches("^\\d{5,}$", ret)){
            ret = ret.replace("(\\d{4})(\\d*)".toRegex(), "$1"+split+"$2")
        }else{
            ret =  ret.replace("(\\d*)".toRegex(), "$1")
        }
        return ret
    }
}