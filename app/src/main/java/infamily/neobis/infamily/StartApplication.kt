package infamily.neobis.infamily

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import infamily.neobis.infamily.repository.Network
import infamily.neobis.infamily.repository.Repository
import infamily.neobis.infamily.utils.Const

class StartApplication :Application(){
    private val BASE_URL = "http://46.101.236.211:5678//api/"
    companion object {

    @Volatile
    lateinit var INSTANCE:StartApplication
    lateinit var servie :Repository
    lateinit var sharedPreference:SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        servie = Network.initService(BASE_URL)
        sharedPreference = getSharedPreferences(Const.SHARED_PREFS, Context.MODE_PRIVATE)
    }

}