package infamily.neobis.infamily.repository

import com.google.gson.GsonBuilder
import infamily.neobis.infamily.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Network {
    val REQUEST_TIME_MINUTE = 3L

    fun initService(baseUrl:String): Repository{
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(initGson())
                .client(getClient()).build()
                .create(Repository::class.java)
    }

    private fun getClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
                .addInterceptor {
                    chain ->
                    val original = chain.request()
                    val request = original.newBuilder()
                            .method(original.method(),original.body())
                            .build()
                    return@addInterceptor chain.proceed(request)
                }.writeTimeout(REQUEST_TIME_MINUTE,TimeUnit.MINUTES)
                .readTimeout(REQUEST_TIME_MINUTE,TimeUnit.MINUTES)
                .connectTimeout(REQUEST_TIME_MINUTE,TimeUnit.MINUTES)
        if(BuildConfig.DEBUG){
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(interceptor)
        }
        return client.build()
    }

    private fun initGson(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }
}