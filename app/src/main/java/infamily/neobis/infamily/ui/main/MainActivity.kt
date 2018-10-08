package infamily.neobis.infamily.ui.main


import android.content.Intent
import android.os.Bundle
import infamily.neobis.infamily.R
import infamily.neobis.infamily.data.Data
import infamily.neobis.infamily.model.Section
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_adopt.AdoptActivity
import infamily.neobis.infamily.ui.section_child.ChildActivity
import infamily.neobis.infamily.ui.section_parent.ParentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() ,MainActivityAdapter.Listener{


    private lateinit var adapter: MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initClickListeners()

    }

    private fun initClickListeners() {

    }

    private fun initRecyclerView() {
        adapter = MainActivityAdapter(getMainCategoriesList(),this)
        recyclerView.adapter = adapter
    }

    private fun getMainCategoriesList(): List<Section> {
        return   Data.getMainCategories(this)

    }

    override fun onItemSelectedAt(position: Int) {
            var activity:Class<*>? = null
            when(position){
                0 -> activity = AdoptActivity::class.java
                1-> activity = ChildActivity::class.java
                2-> activity = ParentActivity::class.java
            }
            startActivity(Intent(this,activity))
    }
}
