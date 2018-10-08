package infamily.neobis.infamily.ui.timeline

import android.content.Context
import android.content.Intent
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimelinePresenter(val view :TimelineContract.View):TimelineContract.Presenter{


    override fun getTimelines(id:Int) {
        if(isViewAttached()){
            view.showProgress()
            StartApplication.service.getTimelineList(id).enqueue(
                    object:Callback<List<Category>>{
                        override fun onFailure(call: Call<List<Category>>?, t: Throwable?) {
                            if(isViewAttached()){
                                view.onFailure()
                            }
                        }

                        override fun onResponse(call: Call<List<Category>>?, response: Response<List<Category>>?) {
                            if(isViewAttached()){
                                if(response!!.isSuccessful && response.body() != null){
                                    view.onSuccess(response.body()!!)
                                }
                                else
                                    view.onFailure()
                                view.hideProgress()
                            }
                        }

                    }
        )}
    }


    fun isViewAttached():Boolean = view != null
}