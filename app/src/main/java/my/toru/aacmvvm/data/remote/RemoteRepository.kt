package my.toru.aacmvvm.data.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
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
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        fun testDataUpdate(): MutableLiveData<List<String>> {
            Log.w("TORU","testDataUpdate Load Start")

            val dataList = ArrayList<String>()
            dataList.add("1")
            dataList.add("2")
            dataList.add("3")
            dataList.add("4")
            dataList.add("5")
            dataList.add("6")
            dataList.add("7")
            dataList.add("8")
            dataList.add("9")
            dataList.add("10")

            Log.w("TORU", "datalist size: " + dataList.size)

            val returnvalue = MutableLiveData<List<String>>()
            returnvalue.postValue(dataList)
            return returnvalue
        }
    }
}