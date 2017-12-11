package my.toru.aacmvvm.data.remote

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by toruchoi on 29/10/2017.
 */
class RemoteRepository {
    companion object {
        fun initRetrofit(baseUrl:String): Retrofit {
            // Retrofit doesn't allowed to input whitespace as its baseUrl.
            baseUrl.map {
                baseUrl != ""}.first()
            fun initOkhttp():OkHttpClient{
                val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                return OkHttpClient.Builder()
                        .readTimeout(5000, TimeUnit.MILLISECONDS)
                        .writeTimeout(5000, TimeUnit.MILLISECONDS)
                        .connectTimeout(5000, TimeUnit.MILLISECONDS)
                        .addInterceptor(interceptor)
                        .build()
            }

            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(initOkhttp())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }
}