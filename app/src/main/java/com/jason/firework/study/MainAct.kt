package com.jason.firework.study

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.alibaba.android.arouter.launcher.ARouter
import com.jason.firework.study.base.RouterURL
import kotlinx.android.synthetic.main.activity_main.*

class MainAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        var button = findViewById<Button>(R.id.gotoid)

        button.setOnClickListener(View.OnClickListener {
            ARouter.getInstance().build(RouterURL.VIEW_BASE_ACT).navigation()
        })
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
