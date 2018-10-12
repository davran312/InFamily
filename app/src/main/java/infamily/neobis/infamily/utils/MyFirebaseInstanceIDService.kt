package infamily.neobis.infamily.utils

import android.content.ContentValues
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import infamily.neobis.infamily.StartApplication

class   MyFirebaseInstanceIDService : FirebaseInstanceIdService(){
    override fun onTokenRefresh() {
        super.onTokenRefresh()
        val refreshedToken = FirebaseInstanceId.getInstance().token
        FileUtils.writeCacheData(this, Const.REFRESHED_TOKEN_FOR_FIREBASE,refreshedToken)
        StartApplication.sharedPreference.edit().putString(Const.FIREBASE_TOKEN,refreshedToken).apply()



    }
}