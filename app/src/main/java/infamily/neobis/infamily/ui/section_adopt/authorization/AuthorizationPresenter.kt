package infamily.neobis.infamily.ui.section_adopt.authorization

import android.text.TextUtils
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.model.TokenInfo
import infamily.neobis.infamily.utils.Const
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthorizationPresenter(val view:AuthorizationContract.View?):AuthorizationContract.Presenter {


    override fun checkInputFields(name:String,email:String,phone:String) {
            if (TextUtils.isEmpty(name) || name.length < 4)
                view?.onIncorrectName()
            if (TextUtils.isEmpty(email) || !email.contains('@'))
                view?.onIncorrectEmail()
            if (TextUtils.isEmpty(phone) || phone.length < 9)
                view?.onIncorrectPhone()
            else
                view?.onSuccessCheckFields()

        }

    override fun saveUserData(name: String, mail: String, phone: String) {
        StartApplication.sharedPreference.edit().putString(Const.USER_NAME,name)
                .putString(Const.USER_MAIL,mail).putString(Const.USER_PHONE,phone).putBoolean(Const.IS_AUTH,true).apply()
        view?.onSuccessUserDataSaved()
    }
    override fun sendFirebaseToken() {
        val bodyBuilder = getMultipartBody()
        view?.showProgress()
        StartApplication.service.sendToken(bodyBuilder.build()).enqueue(object:
        Callback<TokenInfo>{
            override fun onFailure(call: Call<TokenInfo>?, t: Throwable?) {
                if(isViewAttached())
                    view?.onFailureTokenSending()
                view?.hideProgress()
            }

            override fun onResponse(call: Call<TokenInfo>?, response: Response<TokenInfo>?) {
                if(isViewAttached()){
                    if(response!!.isSuccessful && response.body() != null){
                        view?.hideProgress()
                        view?.onSuccessTokenSending()
                    }
                }
            }

        })


    }

    private fun getMultipartBody(): MultipartBody.Builder {
        val body = MultipartBody.Builder()
        body.addFormDataPart("registration_id",StartApplication.sharedPreference.getString(Const.FIREBASE_TOKEN,"null"))
        body.addFormDataPart("device_id",StartApplication.sharedPreference.getString(Const.USER_PHONE,"null"))
        body.addFormDataPart("type","android")
        body.addFormDataPart("active","true")
        body.setType(MultipartBody.FORM)

        return body


    }
    private fun isViewAttached():Boolean = view != null


}
