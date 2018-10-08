package infamily.neobis.infamily.ui.section_child

import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.utils.IProgressBar

interface ParentContract{
    interface View:IProgressBar{
        fun onSuccessGetSectionArticles(list:List<Category>)
        fun onFailure()
    }
    interface Presenter{
        fun getSectionArticles(id:Int)
    }
}