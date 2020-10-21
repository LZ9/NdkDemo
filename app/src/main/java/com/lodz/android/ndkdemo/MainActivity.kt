package com.lodz.android.ndkdemo

import android.os.Bundle
import android.widget.TextView
import com.lodz.android.corekt.anko.bindView
import com.lodz.android.corekt.anko.getColorCompat
import com.lodz.android.pandora.base.activity.BaseActivity

class MainActivity : BaseActivity() {


    /** 提示语 */
    private val nTipsTv by bindView<TextView>(R.id.tips_tv)

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun findViews(savedInstanceState: Bundle?) {
        super.findViews(savedInstanceState)
        getTitleBarLayout().setBackgroundColor(getColorCompat(R.color.purple_700))
        getTitleBarLayout().setTitleName(R.string.app_name)
        getTitleBarLayout().needBackButton(false)
    }

    override fun initData() {
        super.initData()
        nTipsTv.text = stringFromJNI()
        showStatusCompleted()
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