package infamily.neobis.infamily.ui.section_adopt

import infamily.neobis.infamily.model.DocumentStatus
import infamily.neobis.infamily.utils.IProgressBar

interface AdoptContract {
    interface View:IProgressBar{
        fun onAlreadyApplicationSend()
        fun onFailureConnnectedWithServer()
        fun onSuccessApplicationStatusChecked(documentStatus: DocumentStatus)

    }
    interface Presenter{
        fun checkApplicaitonStatus()
    }
}