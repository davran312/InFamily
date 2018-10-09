package infamily.neobis.infamily.ui.section_adopt

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import infamily.neobis.infamily.R
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.dialog_server_answer.*
import kotlin.properties.Delegates

@SuppressLint("ValidFragment")
class AdoptDialogFragment(serverStatus:String): DialogFragment(){
    private var status = serverStatus
    private var tvStatus:TextView by Delegates.notNull()
    private var btnOk: Button by Delegates.notNull()

    private lateinit var rootView:View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       rootView= inflater.inflate(R.layout.dialog_server_answer,container)
        init()

        return rootView
    }
    private fun init(){
        tvStatus = rootView.findViewById(R.id.tvStatusText)
        btnOk = rootView.findViewById(R.id.btnOK)
        tvStatus.text= status
        btnOk.setOnClickListener {
            dismiss()
        }



    }
    
}