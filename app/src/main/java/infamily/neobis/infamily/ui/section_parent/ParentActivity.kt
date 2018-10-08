package infamily.neobis.infamily.ui.section_parent

import android.os.Bundle
import android.support.design.widget.Snackbar
import infamily.neobis.infamily.R
import infamily.neobis.infamily.R.id.rootView
import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_child.ChildAdapter
import infamily.neobis.infamily.ui.section_child.ParentContract
import infamily.neobis.infamily.ui.section_child.ParentPresenter
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_adopt.*

class ParentActivity:BaseActivity(),ParentContract.View,ChildAdapter.Listener{

    override fun onFailure() {
        Snackbar.make(rootView,getString(R.string.no_internet), Snackbar.LENGTH_SHORT).show()
    }


    lateinit var presenter: ParentPresenter
    lateinit var adapter: ChildAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt)
        init()
    }

    private fun init() {
        presenter = ParentPresenter(this)
        presenter.getSectionArticles(Const.SECTION_PARENT_ID)
    }
    override fun onSuccessGetSectionArticles(list: List<Category>) {
        adapter = ChildAdapter(list,this)
        recyclerView.adapter = adapter
    }
    override fun setOnItemClick(position: Int) {
        presenter.startActivity(this,position)
    }

}