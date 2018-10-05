package infamily.neobis.infamily.ui.section_adopt.send_application

import android.os.Bundle
import infamily.neobis.infamily.R
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_adopt.ApplicationAdapter
import kotlinx.android.synthetic.main.activity_application.*

class ApplicationActivity :BaseActivity() {

    private lateinit var adapter:ApplicationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)

        init()
    }

    private fun init() {
        initAdapter()
    }

    private fun initAdapter() {
        adapter = ApplicationAdapter(this)
        recyclerView.adapter = adapter
    }
}