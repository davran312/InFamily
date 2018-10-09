package infamily.neobis.infamily.ui.section_adopt.send_application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import infamily.neobis.infamily.R
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.model.DocumentStatus
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
        initListeners()
    }


    private fun initAdapter() {
        adapter = ApplicationAdapter(this,this)
        recyclerView.adapter = adapter
    }
    private fun initListeners() {
        btn_send.setOnClickListener {
            checkBeforeSendingAndSetListener()
        }
    }

    private fun checkBeforeSendingAndSetListener() {
        if(presenter.isFirstSending()){
            presenter.sendApplciation()
        }
        else{
            presenter.checkApplicaitonStatus()
        }
    }

    override fun onItemSelectedAt(positon: Int) {
        presenter.showAlertDialog(positon)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                Const.CAMERA->  presenter.saveCameraPath()
                Const.GALLERY -> presenter.saveGalleryPath(data!!)

            }
        }
    }
    override fun onSuccessApplicationSend(documentStatus: DocumentStatus) {
        presenter.saveOwnerIdAndStatus(documentStatus)
        Snackbar.make(rootview,getString(R.string.success_application),Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.ok),{finish()}).show()


    }
    override fun onSuccessedSavePath() {
        adapter.notifyDataSetChanged()

    }
    override fun onSuccessApplicationUpdated() {
    }


    override fun onFailureConnnectedWithServer() {
        Snackbar.make(rootview,getString(R.string.failure_application),Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.retry),{presenter.sendApplciation()}).show()
    }
    override fun onFailureApplicationFilled() {
        Snackbar.make(rootview,getString(R.string.fill),Snackbar.LENGTH_SHORT).show()
    }
    override fun onSuccessApplicationStatusChecked(documentStatus: DocumentStatus) {


    }



}