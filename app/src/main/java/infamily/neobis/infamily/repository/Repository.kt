package infamily.neobis.infamily.repository

import infamily.neobis.infamily.model.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Repository{

    @GET("sections/{id}")
    fun getMainMenuCategoryArticles(@Path("id" )id:Int): Call<List<Category>>
    @GET("categories/{id}")
    fun getTimelineList(@Path("id") id: Int): Call<List<Category>>

}