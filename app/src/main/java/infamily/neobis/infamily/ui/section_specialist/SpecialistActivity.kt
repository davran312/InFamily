package infamily.neobis.infamily.ui.section_specialist

import android.content.Intent
import android.os.Bundle
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Specialistest
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_specialist.specialist_names.SpecialistNameActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_adopt.*

class SpecialistActivity :BaseActivity(),SpecialistContract.View,SpecialistAdapter.Listener {

    private lateinit var adapter: SpecialistAdapter
    private lateinit var presenter: SpecialistPresenter
    private lateinit var mList: List<Specialistest>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt)
        init()
    }

    private fun init() {
        initPresenter()
    }

    private fun initPresenter() {

        presenter = SpecialistPresenter(this)
        presenter.getSpecialistList()
    }

    override fun onSuccessGetSpecialistList(list: List<Specialistest>) {
        mList = list
        initAdapter(list)
    }

    private fun initAdapter(list:List<Specialistest>) {
        val imageList = getImageList()
        adapter = SpecialistAdapter(list, this,imageList)
        recyclerView.adapter = adapter
    }

    override fun onFailureGetSpecialistList() {
    }

    override fun onItemSelectedAt(position: Int) {
        val intent = Intent(this, SpecialistNameActivity::class.java)
        intent.putExtra(Const.SERIALAIZABLE, mList[position])
        startActivity(intent)

    }
    private fun getImageList(): ArrayList<Int> {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.brainrocess)
        list.add(R.drawable.first_aid_kit)
        list.add(R.drawable.worker)
        list.add(R.drawable.doctor1)

        return list
    }




}