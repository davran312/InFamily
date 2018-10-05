package infamily.neobis.infamily.ui.section_adopt.authorization

import android.text.TextUtils
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.utils.Const

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

}
