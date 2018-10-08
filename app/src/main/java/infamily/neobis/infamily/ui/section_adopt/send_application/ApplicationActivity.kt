package infamily.neobis.infamily.ui.section_adopt.send_application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import infamily.neobis.infamily.R
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_adopt.ApplicationAdapter
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_application.*

class ApplicationActivity :BaseActivity() ,ApplicationAdapter.Listener,ApplicationContract.View{
    lateinit var presenter:ApplicationPresenter
    private lateinit var adapter:ApplicationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)

        init()
    }

    private fun init() {
        presenter = ApplicationPresenter(this,this)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = ApplicationAdapter(this,this)
        recyclerView.adapter = adapter
    }
    override fun onItemSelectedAt(positon: Int) {
        presenter.showAlertDialog(positon)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                Const.CAMERA->  if(data == null)    presenter.saveCameraPath(data!!)
                Const.GALLERY -> presenter.saveGalleryPath(data!!)

            }
        }
    }
    override fun onSuccessApplicationSend() {

    }
    override fun onSuccessedSavePath() {
        adapter.notifyDataSetChanged()

    }
}