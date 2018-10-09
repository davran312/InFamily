package infamily.neobis.infamily.ui.section_adopt

import android.content.Intent
import android.os.Bundle
import infamily.neobis.infamily.R
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.data.Data
import infamily.neobis.infamily.model.DocumentStatus
import infamily.neobis.infamily.model.Section
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_adopt.authorization.AuthorizationActivity
import infamily.neobis.infamily.ui.section_adopt.send_application.ApplicationActivity
import infamily.neobis.infamily.ui.section_adopt.test.TestActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_adopt.*

class AdoptActivity: BaseActivity(),AdoptAdapter.Listener ,AdoptContract.View{


    private lateinit var adapter :AdoptAdapter
    private lateinit var presenter:AdoptPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt)
        init()
    }

    private fun init(){
        initPresenter()
        initRecyclerView()
        initListeners()
    }
    private fun initPresenter(){
        presenter = AdoptPresenter(this,this)
    }

    private fun initRecyclerView() {
        adapter = AdoptAdapter(getAdoptCategoriesList(),this)
        recyclerView.adapter = adapter
    }

    private fun initListeners() {

    }

    private fun getAdoptCategoriesList(): List<Section> {
        return Data.getAdoptCategories(this)
    }
    override fun onItemSelectedAt(positon: Int) {
        presenter.startActivity(positon)

    }
    override fun onAlreadyApplicationSend() {
        presenter.checkApplicaitonStatus()

    }
    override fun onFailureConnnectedWithServer() {


    }

    override fun onSuccessApplicationStatusChecked(documentStatus: DocumentStatus) {
       val serverStatus =  presenter.determineServerStatus(documentStatus.status)
        showDialogStatus(serverStatus)
    }

    private fun showDialogStatus(serverStatus: String) {
        val ft = supportFragmentManager.beginTransaction()
        AdoptDialogFragment(serverStatus).show(ft,Const.TAG_FOR_SHOW_DIALOG_FRAGMENT)

    }


}