package infamily.neobis.infamily.ui.section_adopt

import android.content.Intent
import infamily.neobis.infamily.R
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.model.DocumentStatus
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_adopt.authorization.AuthorizationActivity
import infamily.neobis.infamily.ui.section_adopt.send_application.ApplicationActivity
import infamily.neobis.infamily.ui.section_adopt.test.TestActivity
import infamily.neobis.infamily.utils.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdoptPresenter(val view:AdoptContract.View,activity: AdoptActivity) :AdoptContract.Presenter{
    private val mActivity = activity
    fun startActivity(position:Int) {
            var activity: Class<*>? = null
            when (position) {
                1 -> {
                    if(StartApplication.sharedPreference.getInt(Const.OWNER_STATUS,0) != 0){
                        view.onAlreadyApplicationSend()
                        return
                    }
                    else if (StartApplication.sharedPreference.getBoolean(Const.IS_AUTH, false) == false)
                        activity = AuthorizationActivity::class.java
                    else {
                        activity = ApplicationActivity::class.java
                    }
                }

                2 -> activity = TestActivity::class.java
            }
                mActivity.startActivity(Intent(mActivity, activity))

        }

    override fun checkApplicaitonStatus() {
        if(isViewAttached()){
            val id = StartApplication.sharedPreference.getInt(Const.OWNER_ID,0)
            val device = StartApplication.sharedPreference.getString(Const.USER_PHONE,null)
            StartApplication.service.checkStatus(id,device).enqueue(
                    object: Callback<DocumentStatus> {
                        override fun onFailure(call: Call<DocumentStatus>?, t: Throwable?) {
                            view.hideProgress()
                            view.onFailureConnnectedWithServer()
                        }

                        override fun onResponse(call: Call<DocumentStatus>?, response: Response<DocumentStatus>?) {
                            view.hideProgress()
                            view.onSuccessApplicationStatusChecked(response?.body()!!)
                        }

                    })
        }
    }
    fun determineServerStatus(status:Int):String{
        var serverStatus = ""
        when(status){
            1-> serverStatus = mActivity.getString(R.string.status1)
            2->serverStatus = mActivity.getString(R.string.status1)
            3->serverStatus = mActivity.getString(R.string.status3)
            4->serverStatus = mActivity.getString(R.string.status4)
            5->serverStatus = mActivity.getString(R.string.status5)
        }
        return serverStatus
    }
    fun isViewAttached():Boolean = view != null
}