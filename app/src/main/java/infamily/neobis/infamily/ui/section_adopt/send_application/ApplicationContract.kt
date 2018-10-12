package infamily.neobis.infamily.ui.section_adopt.send_application

import infamily.neobis.infamily.model.DocumentStatus
import infamily.neobis.infamily.utils.IProgressBar

interface ApplicationContract {
    interface View:IProgressBar{
        fun onSuccessApplicationSend(documentStatus:DocumentStatus)
        fun onSuccessedSavePath()
        fun onSuccessApplicationUpdated()
        fun onFailureConnnectedWithServer()
        fun onFailureApplicationFilled()

    }
    interface Presenter{
        fun sendApplciation()
        fun updateApplcication()

    }
}