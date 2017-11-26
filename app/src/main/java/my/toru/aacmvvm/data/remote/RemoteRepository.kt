package my.toru.aacmvvm.data.remote

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
            returnvalue.value = dataList
            return returnvalue
        }

        fun testDataUpdate2(liveData:MutableLiveData<List<String>>){
            Log.w("TORU","testDataUpdate2 Load Start")

            val dataList = ArrayList<String>()
            dataList.add("11")
            dataList.add("21")
            dataList.add("31")
            dataList.add("41")
            dataList.add("51")
            dataList.add("61")
            dataList.add("71")
            dataList.add("81")
            dataList.add("91")
            dataList.add("101")
            dataList.add("181")
            dataList.add("191")
            dataList.add("201")

            liveData.value = dataList

            Log.w("TORU", "datalist size: " + dataList.size)
        }
    }
}