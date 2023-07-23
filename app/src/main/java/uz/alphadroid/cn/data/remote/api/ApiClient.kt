package uz.alphadroid.cn.data.remote.api

import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.alphadroid.cn.app.App
import java.util.concurrent.TimeUnit

object ApiClient {

    val myClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(App.context!!))
        .build()



    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://195.158.16.43:6788/")
        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val retrofitInternal: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.100.12:6788/")
        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getExternal(): Api = retrofit.create(Api::class.java) //Tashqi
    fun getInternal(): Api = retrofitInternal.create(Api::class.java) //Ichki
}