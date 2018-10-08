package infamily.neobis.infamily.ui.timeline

import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.utils.IProgressBar

interface TimelineContract {
    interface View:IProgressBar{
        fun onFailure()
        fun onSuccess(list:List<Category>)
    }
    interface Presenter{
        fun getTimelines(id:Int)
    }
}