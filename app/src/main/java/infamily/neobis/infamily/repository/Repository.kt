package infamily.neobis.infamily.repository

import infamily.neobis.infamily.model.*
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

    @GET("people/")
    fun getSpecialistList():Call<List<Specialistest>>

    @GET("people/{id}")
    fun getSpecialistArticle(@Path("id") id:Int): Call<SpecialistProfile>

    @PATCH("documents/{id}/")
    fun updateDocumentStatus(@Body file:RequestBody, @Path("id") id: Int, @Header("DEVICE") deviceId:String): Call<DocumentStatus>

    @POST("devices/")
    fun sendToken(@Body file: RequestBody): Call<TokenInfo>
}