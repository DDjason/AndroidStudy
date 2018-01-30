package com.jason.firework.study.base;

import android.databinding.BindingAdapter;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 16:15$
 * <p/>Description: xml页面 bindingAdapter
 */
public class BindingAdapters {

    @BindingAdapter({"inputFilter"})
    public static void inputFilter(EditText view,int type){
        switch (type){
            case 1:
                Log.i(" @Binding"," @Binding");
                addFilter(view,emojiFilter);
                break;
            default:
                break;
        }
    }


    private static InputFilter emojiFilter = new InputFilter() {
        Pattern pattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern
                .CASE_INSENSITIVE);

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                Log.i("InputFilter","不允许输入Emoji表情");
                return "";
            }
            return null;
        }
    };

    /**
     * 添加新的Filter
     */
    public static void addFilter(EditText view, InputFilter filter) {
        InputFilter[] old      = view.getFilters();
        InputFilter[] filters  = new InputFilter[old.length + 1];
        int           position = 0;
        for (; position < old.length; position++) {
            filters[position] = old[position];
        }
        filters[position] = filter;
        view.setFilters(filters);
    }
}
