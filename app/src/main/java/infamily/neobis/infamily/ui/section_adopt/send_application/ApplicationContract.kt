package infamily.neobis.infamily.ui.section_adopt.send_application

import infamily.neobis.infamily.utils.IProgressBar

interface ApplicationContract {
    interface View:IProgressBar{
       fun onSuccessApplicationSend()
        fun onSuccessedSavePath()
    }
    interface Presenter{

    }
}