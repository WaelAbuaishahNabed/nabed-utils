package nabed.apps.nabedutilslibrary.data.response.network

import nabed.apps.nabedutilslibrary.data.response.PrescriptionsResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "Bearer dc797221541909111cd2617b3b8e34c73782789f"
interface PrescriptionsApiService {


    @GET("/v1/prescription/mm")
    fun getUserPrescriptionsAsync(
        @Query("userId")userId: String
    ) : Deferred<Response<PrescriptionsResponse>>

    companion object {
        operator fun invoke() : PrescriptionsApiService {
            val requestInterceptor =
                Interceptor{
                val url = it.request()
                    .url
                    .newBuilder()
                    .build()
                val request = it.request()
                    .newBuilder().url(url)
                    .addHeader("Content-type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer d34fbfeef6f64dbacee4b5e76464484bdefb25a3")
                    .addHeader("Accept-Language", "en")
                    .build()
                return@Interceptor it.proceed(request)
            }

            val okHttpClient =
                OkHttpClient
                    .Builder()
                    .addInterceptor(requestInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://publicapi.nabed.xyz")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(PrescriptionsApiService::class.java)
        }
    }
}