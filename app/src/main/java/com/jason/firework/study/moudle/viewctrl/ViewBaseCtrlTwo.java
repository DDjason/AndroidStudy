package com.jason.firework.study.moudle.viewctrl;

import android.app.Activity;
import android.view.View;

import java.util.Random;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 14:14$
 * <p/>
 */
public class ViewBaseCtrlTwo {
        private String param2;
    public ViewBaseCtrlTwo(){

    }
    public ViewBaseCtrlTwo(String args){
        param2 = args;
    }

    private int param;


    private static final String param3 = "param3";

    public static final String param4 = "param4";

    public String getParam22(){
        return "patam2";
    }

    public String doCalculator(){
        Random random = new Random();
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        return x +""+ y;
    }

    public void doCalculator2(){
        Random random = new Random();
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        return ;
    }

    public static Activity getActivityByView(View view){
        Activity activity = (Activity) view.getContext();
        return activity;
    }


}
