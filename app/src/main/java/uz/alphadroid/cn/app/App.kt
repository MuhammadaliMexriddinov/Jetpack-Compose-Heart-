package uz.alphadroid.cn.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class App:Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}