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
import infamily.neobis.infamily.utils.Permissions
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
        if(presenter.isFirstSending())
            btn_send.setOnClickListener {
                presenter.sendApplciation()
            }
        else{
            btn_send.setOnClickListener {
                presenter.updateApplcication()
            }
            btn_send.text = getString(R.string.update)
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

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(Permissions.iPermissionCamera(this))
            presenter.takePhotoFromCamera()
        if(Permissions.iPermissionReadStorage(this))
            presenter.takePhotoFromGallery()
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
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
        Snackbar.make(rootview,getString(R.string.success_application),Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.success_update),{finish()}).show()
    }


    override fun onFailureConnnectedWithServer() {
        Snackbar.make(rootview,getString(R.string.failure_application),Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.retry),{presenter.sendApplciation()}).show()
    }
    override fun onFailureApplicationFilled() {
        Snackbar.make(rootview,getString(R.string.fill),Snackbar.LENGTH_SHORT).show()
    }



}