package infamily.neobis.infamily.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import infamily.neobis.infamily.R
import kotlin.properties.Delegates

@Suppress("DEPRECATION")
open class  BaseActivity: AppCompatActivity(){
    private var progressBar: ProgressDialog? = null
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)

    }


    open fun showProgress(){
        this.runOnUiThread {
            if(progressBar == null && !isFinishing){
                progressBar = ProgressDialog(this)
                progressBar?.setMessage(getString(R.string.loading))
                progressBar?.setCanceledOnTouchOutside(false)
                progressBar?.show()

            }
        }
    }
    open fun hideProgress(){
        this.runOnUiThread {
            if(progressBar != null && progressBar?.isShowing!!){
                progressBar?.dismiss()
                progressBar = null
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        hideProgress()
    }
}