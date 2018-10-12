package infamily.neobis.infamily.ui.section_specialist.specialist_names

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Specialistest
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_specialist.specialist_article.ProfileActivity
import infamily.neobis.infamily.utils.Const
import infamily.neobis.infamily.utils.Const.EXTRA_SPECIALIST_ID
import kotlinx.android.synthetic.main.activity_adopt.*

class SpecialistNameActivity: BaseActivity() , SpecialistNameAdapter.Listener {

        private lateinit var adapter: SpecialistNameAdapter
        private lateinit var specialistList: Specialistest

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_adopt)
            specialistList = intent.getSerializableExtra(Const.SERIALAIZABLE) as Specialistest
            adapter = SpecialistNameAdapter(specialistList.people, this)
            recyclerView.adapter = adapter
        }
        override fun onItemSelectedAt(position: Int) {
            val intent = Intent(this,ProfileActivity::class.java)
            intent.putExtra(EXTRA_SPECIALIST_ID, specialistList.people[position].id)
            startActivity(intent)

        }

    }



