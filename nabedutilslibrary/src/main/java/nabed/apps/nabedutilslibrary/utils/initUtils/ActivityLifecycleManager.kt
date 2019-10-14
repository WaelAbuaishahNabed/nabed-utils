package nabed.apps.nabedutilslibrary.utils.initUtils

import android.annotation.TargetApi
import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.content.Context
import android.os.Build.VERSION
import android.os.Bundle
import java.util.*


class ActivityLifecycleManager(context: Context) {
    private val application: Application = context.applicationContext as Application
    private var callbacksWrapper: ActivityLifecycleCallbacksWrapper? = null

    fun registerCallbacks(callbacks: Callbacks): Boolean {
        return callbacksWrapper != null && callbacksWrapper!!.registerLifecycleCallbacks(
            callbacks
        )
    }

    fun resetCallbacks() {
        if (callbacksWrapper != null) {
            callbacksWrapper!!.clearCallbacks()
        }
    }

    private class ActivityLifecycleCallbacksWrapper internal constructor(private val application: Application) {
        private val registeredCallbacks: HashSet<Any?> =
            HashSet<Any?>()

        @TargetApi(14)
        fun clearCallbacks() {
            val var1: Iterator<*> = registeredCallbacks.iterator()
            while (var1.hasNext()) {
                val callback =
                    var1.next() as ActivityLifecycleCallbacks
                application.unregisterActivityLifecycleCallbacks(callback)
            }
        }

        @TargetApi(14)
        fun registerLifecycleCallbacks(callbacks: Callbacks): Boolean {
            return if (application != null) {
                val callbackWrapper: ActivityLifecycleCallbacks =
                    object : ActivityLifecycleCallbacks {
                        override fun onActivityCreated(
                            activity: Activity,
                            bundle: Bundle
                        ) {
                            callbacks.onActivityCreated(activity, bundle)
                        }

                        override fun onActivityStarted(activity: Activity) {
                            callbacks.onActivityStarted(activity)
                        }

                        override fun onActivityResumed(activity: Activity) {
                            callbacks.onActivityResumed(activity)
                        }

                        override fun onActivityPaused(activity: Activity) {
                            callbacks.onActivityPaused(activity)
                        }

                        override fun onActivityStopped(activity: Activity) {
                            callbacks.onActivityStopped(activity)
                        }

                        override fun onActivitySaveInstanceState(
                            activity: Activity,
                            bundle: Bundle
                        ) {
                            callbacks.onActivitySaveInstanceState(activity, bundle)
                        }

                        override fun onActivityDestroyed(activity: Activity) {
                            callbacks.onActivityDestroyed(activity)
                        }
                    }
                application.registerActivityLifecycleCallbacks(callbackWrapper)
                registeredCallbacks.add(callbackWrapper)
                true
            } else {
                false
            }
        }

    }

    abstract class Callbacks {
        open fun onActivityCreated(
            activity: Activity,
            bundle: Bundle
        ) {
        }

        open fun onActivityStarted(activity: Activity) {}
        open fun onActivityResumed(activity: Activity) {}
        fun onActivityPaused(activity: Activity) {}
        fun onActivityStopped(activity: Activity) {}
        fun onActivitySaveInstanceState(
            activity: Activity,
            bundle: Bundle
        ) {
        }

        fun onActivityDestroyed(activity: Activity) {}
    }

    init {
        if (VERSION.SDK_INT >= 14) {
            callbacksWrapper =
                ActivityLifecycleCallbacksWrapper(application)
        }
    }
}
