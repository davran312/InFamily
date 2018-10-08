package infamily.neobis.infamily.ui.section_child

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.timeline.TimelineActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_adopt.*

class ChildActivity: BaseActivity(),ParentContract.View,ChildAdapter.Listener{


    override fun onFailure() {
        Snackbar.make(rootView,getString(R.string.no_internet),Snackbar.LENGTH_SHORT).show()
    }


    lateinit var presenter:ChildPresenter
    lateinit var adapter:ChildAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt)
        init()
    }

    private fun init() {
        presenter = ChildPresenter(this)
        presenter.getSectionArticles(Const.SECTION_CHILD_ID)
    }
    override fun onSuccessGetSectionArticles(list: List<Category>) {
        adapter = ChildAdapter(list,this)
        recyclerView.adapter = adapter
    }
    override fun setOnItemClick(position: Int) {
       presenter.startActivity(this,position)

    }
}