package infamily.neobis.infamily.ui.section_adopt.send_application

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import id.zelory.compressor.Compressor
import infamily.neobis.infamily.BuildConfig
import infamily.neobis.infamily.StartApplication
import infamily.neobis.infamily.utils.Const
import infamily.neobis.infamily.utils.FileUtils
import infamily.neobis.infamily.utils.Permissions
import java.io.File

class ApplicationPresenter(val activity:AppCompatActivity,val view:ApplicationContract.View) {
    private var imagePath:String? = null
    private var mPosition:Int = 0
    fun showAlertDialog(position:Int) {
        mPosition = position
        val args = arrayOf("Галерея", "Камера")
        AlertDialog.Builder(activity).setItems(args) { dialog, which ->
            if (which == 1)
                takePhotoFromCamera()
            else
                takePhotoFromGallery()
        }.show()
    }

    fun takePhotoFromCamera() {
        if (Permissions.iPermissionCamera(activity)) {
            val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            val uri = FileUtils.getCaptureImageOutputUri(activity, imagePath)
            if (uri != null) {
                val file = File(uri.path)
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                            FileProvider.getUriForFile(activity,
                                    BuildConfig.APPLICATION_ID + ".provider", file))
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                } else
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
                activity.startActivityForResult(intent, Const.CAMERA)
            }
        }
    }
   fun takePhotoFromGallery(){
        if(Permissions.iPermissionReadStorage(activity)){
            val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            activity.startActivityForResult(intent,Const.GALLERY)
        }
    }
     fun saveCameraPath(data:Intent){
         val uri = FileUtils.getPickImageResultUri(activity.applicationContext,data,imagePath)
         val file = FileUtils.getNormalizedUri(activity,uri)
         val path = Compressor.getDefault(activity).compressToFile(File(file.path)).path
         imagePath = path

         StartApplication.sharedPreference.edit().putString(mPosition.toString(),imagePath).apply()
         view.onSuccessedSavePath()

    }
    fun saveGalleryPath(data:Intent){
        if(data != null){
            imagePath = FileUtils.getImagePathFromInputStreamUri(StartApplication.INSTANCE,data.data)
            StartApplication.sharedPreference.edit().putString(mPosition.toString(),imagePath).apply()
            view.onSuccessedSavePath()

        }
    }
    fun getImagePath():String {
        return imagePath!!
    }

}