package infamily.neobis.infamily.repository

import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.model.DocumentStatus
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface Repository {

    @GET("sections/{id}")
    fun getMainMenuCategoryArticles(@Path("id") id: Int): Call<List<Category>>

    @GET("categories/{id}")
    fun getTimelineList(@Path("id") id: Int): Call<List<Category>>

    @POST("documents/")
    fun sendApplication(@Body file: RequestBody): Call<DocumentStatus>

    @GET("documents/{id}/")
    fun checkStatus(@Path("id") id: Int, @Header("DEVICE") deviceId: String): Call<DocumentStatus>
}