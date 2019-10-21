package nabed.apps.nabedutilslibrary.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.os.Bundle
import nabed.apps.nabedutilslibrary.data.response.network.*
import nabed.apps.nabedutilslibrary.data.db.PrescriptionDatabase
import nabed.apps.nabedutilslibrary.utils.initUtils.ActivityLifecycleManager
import nabed.apps.nabedutilslibrary.utils.initUtils.NabedLanguage
import nabed.apps.nabedutilslibrary.ui.prescriptions.utils.PrescriptionsViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import java.lang.ref.WeakReference

class NabedClient(
    var application: Application?,
    var language: NabedLanguage,
    private val appKey: String = "",
    private var userId: String = ""
)  {//: KodeinAware

    private var activityLifecycleManager: ActivityLifecycleManager? = null
    private var activity: WeakReference<Activity?>? = null

//    override val kodein: Kodein
//            = Kodein.lazy {
//        import(androidXModule(application!!))
//        bind() from singleton { PrescriptionDatabase(instance()) }
//        bind() from singleton { instance<PrescriptionDatabase>().prescriptionDao() }
//        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
//        bind() from singleton { PrescriptionsApiService(instance()) }
//        bind<PrescriptionsNetworkDataSource>() with singleton {
//            PrescriptionsNetworkDataSourceImpl(
//                instance()
//            )
//        }
//        bind() from provider { PrescriptionsViewModelFactory(instance()) }
//    }

    fun setUserId(userId: String) {
        this.userId = userId
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        internal var singleton: NabedClient? = null


        fun getInstance(): NabedClient? {
            return singleton
        }


        fun setUserId(userId: String) {
            singleton?.setUserId(userId)
        }


        fun setLanguage(language: NabedLanguage) {
            singleton?.language = language
        }

        fun with(
            application: Application?,
            language: NabedLanguage,
            appKey: String = "",
            userId: String = ""
        ): NabedClient? {
            if (singleton == null) {
                synchronized(NabedClient::class.java) {
                    if (singleton == null) {
                        setNabedClient(NabedClient(application, language, appKey, userId))
                    }
                }
            }
            return singleton
        }


        private fun setNabedClient(nabedClient: NabedClient?) {
            if (nabedClient != null) {
                singleton = nabedClient
                nabedClient.init()
            }
        }
    }


    fun setCurrentActivity(activity: Activity?) {
        this@NabedClient.activity = WeakReference(activity)
    }

    private fun init() {
        handleKodeinInit()
        this.activityLifecycleManager = ActivityLifecycleManager(this.application!!)
//        this.activityLifecycleManager!!.registerCallbacks(object :
//            ActivityLifecycleManager.Callbacks() {
//            override fun onActivityCreated(activity: Activity, bundle: Bundle) {
//                setCurrentActivity(activity)
//            }
//
//            override fun onActivityStarted(activity: Activity) {
//                setCurrentActivity(activity)
//            }
//
//            override fun onActivityResumed(activity: Activity) {
//                setCurrentActivity(activity)
//            }
//        })
    }

    private fun handleKodeinInit() {

    }
}