package infamily.neobis.infamily.ui.section_specialist.specialist_article

import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.model.SpecialistProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilePresenter(val view:ProfileContract.View):ProfileContract.Presenter{
    override fun getSpecialistProfileById(id: Int) {
        if(isViewAttached()){
            view.showProgress()
            StartApplication.service.getSpecialistArticle(id).enqueue(object: Callback<SpecialistProfile> {

                override fun onResponse(call: Call<SpecialistProfile>?, response: Response<SpecialistProfile>?) {
                    if(isViewAttached()){
                        if(response!!.isSuccessful && response.body() != null){
                            view.onSuccessGetProfile(response.body()!!)
                        }
                        else{
                            view.onFailureGetProfile()
                        }
                        view.hideProgress()
                    }
                }

                override fun onFailure(call: Call<SpecialistProfile>?, t: Throwable?) {
                    if(isViewAttached()){
                        view.onFailureGetProfile()
                        view.hideProgress()
                    }
                    t?.printStackTrace()
                }
            })
        }

    }
private fun isViewAttached(): Boolean = view != null
}