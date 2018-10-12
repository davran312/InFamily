package infamily.neobis.infamily.ui.section_specialist

import infamily.neobis.infamily.model.Specialistest
import infamily.neobis.infamily.utils.IProgressBar

interface SpecialistContract {
    interface View:IProgressBar{
        fun onSuccessGetSpecialistList(list :List<Specialistest>)
        fun onFailureGetSpecialistList()

    }

    interface Presenter{
        fun getSpecialistList()
    }
}