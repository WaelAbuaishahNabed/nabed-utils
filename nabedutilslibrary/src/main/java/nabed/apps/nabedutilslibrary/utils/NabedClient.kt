package nabed.apps.nabedutilslibrary.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import nabed.apps.nabedutilslibrary.utils.initUtils.ActivityLifecycleManager
import nabed.apps.nabedutilslibrary.utils.initUtils.NabedLanguage

import java.lang.ref.WeakReference

class NabedClient(
    private val context: Context?,
    private var language: NabedLanguage ,
    private val appKey: String = "",
    private var userId: String = ""
) {
    private var activityLifecycleManager: ActivityLifecycleManager? = null
    private var activity: WeakReference<Activity?>? = null

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


        fun setLanguage(language : NabedLanguage) {
            singleton?.language = language
        }

        fun with(
            context: Context?,
            language: NabedLanguage,
            appKey: String = "",
            userId: String = ""
        ): NabedClient? {
            if (singleton == null) {
                synchronized(NabedClient::class.java) {
                    if (singleton == null) {
                        setNabedClient(NabedClient(context,language, appKey, userId))
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
        this.activityLifecycleManager = ActivityLifecycleManager(this.context!!)
        this.activityLifecycleManager!!.registerCallbacks(object :
            ActivityLifecycleManager.Callbacks() {
            override fun onActivityCreated(activity: Activity, bundle: Bundle) {
                setCurrentActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                setCurrentActivity(activity)
            }

            override fun onActivityResumed(activity: Activity) {
                setCurrentActivity(activity)
            }
        })
    }
}