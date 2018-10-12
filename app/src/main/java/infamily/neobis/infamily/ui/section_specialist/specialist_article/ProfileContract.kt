package infamily.neobis.infamily.ui.section_specialist.specialist_article

import infamily.neobis.infamily.model.SpecialistProfile
import infamily.neobis.infamily.utils.IProgressBar

interface ProfileContract {
    interface View : IProgressBar {
        fun onSuccessGetProfile(specialistArticle: SpecialistProfile)
        fun onFailureGetProfile()
    }
    interface Presenter{
        fun getSpecialistProfileById(id:Int)
    }
}
