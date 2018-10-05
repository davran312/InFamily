package infamily.neobis.infamily.ui.section_adopt.authorization

import infamily.neobis.infamily.utils.IProgressBar

interface AuthorizationContract {
    interface View:IProgressBar{
        fun  onSuccessCheckFields()
        fun onIncorrectName()
        fun onIncorrectEmail()
        fun onIncorrectPhone()
        fun onSuccessUserDataSaved()
    }

    interface Presenter{
        fun checkInputFields(name:String,email:String,phone:String)
        fun saveUserData(name:String,mail:String,phone:String)
    }
}