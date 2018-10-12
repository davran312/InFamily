package infamily.neobis.infamily.ui.main


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import infamily.neobis.infamily.R
import infamily.neobis.infamily.data.Data
import infamily.neobis.infamily.model.Section
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_adopt.AdoptActivity
import infamily.neobis.infamily.ui.section_child.ChildActivity
import infamily.neobis.infamily.ui.section_parent.ParentActivity
import infamily.neobis.infamily.ui.section_specialist.SpecialistActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() ,MainActivityAdapter.Listener{


    private lateinit var adapter: MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initClickListeners()
        setupActionBar()

    }

    private fun setupActionBar() {
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(false);
        getSupportActionBar()?.setDisplayShowHomeEnabled(false);
    }

    private fun initClickListeners() {

    }

    private fun initRecyclerView() {
        adapter = MainActivityAdapter(getMainCategoriesList(),this,this)
        recyclerView.adapter = adapter
    }

    private fun getMainCategoriesList(): List<Section> {
        return   Data.getMainCategories(this)

    }

    override fun onItemSelectedAt(position: Int) {
          adapter.startActivity(position)

    }
}
