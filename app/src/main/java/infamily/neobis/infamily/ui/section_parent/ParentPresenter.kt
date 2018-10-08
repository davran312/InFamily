package infamily.neobis.infamily.ui.section_child

import android.content.Context
import android.content.Intent
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.ui.timeline.TimelineActivity
import infamily.neobis.infamily.utils.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParentPresenter(val view:ParentContract.View) :ParentContract.Presenter{


    override fun getSectionArticles(id: Int) {
        if(isViewAttached()){
            view.showProgress()
        StartApplication.service.getMainMenuCategoryArticles(id).enqueue(
                object : Callback<List<Category>> {
                    override fun onFailure(call: Call<List<Category>>?, t: Throwable?) {
                        if(isViewAttached()){
                            view.hideProgress()
                        }
                        t?.printStackTrace()
                    }

                    override fun onResponse(call: Call<List<Category>>?, response: Response<List<Category>>?) {
                        if(isViewAttached()){
                            if(response!!.isSuccessful  && response.body() != null){
                                view.onSuccessGetSectionArticles(response.body()!!)
                            }
                            else
                                view.onFailure()
                            view!!.hideProgress()
                        }
                    }

                }
        )}
    } fun startActivity(context: Context, position:Int){
        val intent = Intent(context, TimelineActivity::class.java)
        var timelineId:Int = 0
        when(position){
            0 -> timelineId = 7
            1 -> timelineId = 9
            2 -> timelineId = 20

        }
        intent.putExtra(Const.TIMELINE_EXTRA,timelineId)
        context.startActivity(intent)

    }
    fun isViewAttached():Boolean = view!= null

}