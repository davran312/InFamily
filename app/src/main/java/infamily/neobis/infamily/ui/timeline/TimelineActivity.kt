package infamily.neobis.infamily.ui.timeline

import android.os.Bundle
import android.support.design.widget.Snackbar
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_adopt.*

class TimelineActivity:BaseActivity(),TimelineContract.View,TimelineAdapter.Listener{


    private lateinit var adapter:TimelineAdapter
    private lateinit var presenter:TimelinePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt)
        init()
    }

    private fun init() {
        presenter = TimelinePresenter(this)
        presenter.getTimelines(intent.getIntExtra(Const.TIMELINE_EXTRA,0))
    }

    override fun onItemSeletedAt(position: Category) {
        presenter.startActivity(this,position)
    }
    override fun onFailure() {
        Snackbar.make(rootView,getString(R.string.no_internet),Snackbar.LENGTH_SHORT).show()
    }

    override fun onSuccess(list: List<Category>) {
        adapter = TimelineAdapter(list,this)
        recyclerView.adapter = adapter
    }

}
