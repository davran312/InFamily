package infamily.neobis.infamily.ui.section_adopt

import android.content.Intent
import android.os.Bundle
import infamily.neobis.infamily.R
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.data.Data
import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_adopt.authorization.AuthorizationActivity
import infamily.neobis.infamily.ui.section_adopt.send_application.ApplicationActivity
import infamily.neobis.infamily.ui.section_adopt.test.TestActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_adopt.*

class AdoptActivity: BaseActivity(),AdoptAdapter.Listener {


    private lateinit var adapter :AdoptAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt)
        initRecyclerView()
        initListeners()
    }

    private fun initListeners() {
        backArrow.setOnClickListener {
            onBackPressed()

        }

    }

    private fun initRecyclerView() {
        adapter = AdoptAdapter(getAdoptCategoriesList(),this)
        recyclerView.adapter = adapter
    }

    private fun getAdoptCategoriesList(): List<Category> {
        return Data.getAdoptCategories(this)
    }
    override fun onItemSelectedAt(positon: Int) {
        var activity:Class<*>? = null
        when(positon){

            1-> if(StartApplication.sharedPreference.getBoolean(Const.IS_AUTH,false) == false)
                    activity = AuthorizationActivity::class.java
                else
                    activity = ApplicationActivity::class.java
            2-> activity = TestActivity::class.java
        }
        startActivity(Intent(this,activity))

    }

}