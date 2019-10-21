package nabed.apps.nabedutils

import android.app.Application
import nabed.apps.nabedutilslibrary.data.db.PrescriptionDatabase
import nabed.apps.nabedutilslibrary.data.response.network.*
import nabed.apps.nabedutilslibrary.repository.PublicUserRepository
import nabed.apps.nabedutilslibrary.repository.PublicUserRepositoryImpl
import nabed.apps.nabedutilslibrary.ui.prescriptions.utils.PrescriptionsViewModelFactory
import nabed.apps.nabedutilslibrary.utils.NabedClient
import nabed.apps.nabedutilslibrary.utils.initUtils.NabedLanguage
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class TestApp : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@TestApp))
        bind() from singleton { PrescriptionDatabase(instance()) }
        bind() from singleton { instance<PrescriptionDatabase>().prescriptionDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { PrescriptionsApiService() }
        bind<PublicUserRepository>() with singleton {
            PublicUserRepositoryImpl(
                instance(),
                instance()
            )
        }

        bind<PrescriptionsNetworkDataSource>() with singleton {
            PrescriptionsNetworkDataSourceImpl(
                instance()
            )
        }
        bind() from provider { PrescriptionsViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        NabedClient.with(
            this@TestApp,
            NabedLanguage.English,
            appKey = "324werbfhegbeahrfbijr3uirjn34",
            userId = "mm"
        )
    }

//    Supertypes of the following classes cannot be resolved. Please make sure you have the required dependencies in the classpath:
//    class nabed.apps.nabedutilslibrary.ui.prescriptions.NabedCategoriesView, unresolved supertypes: org.kodein.di.KodeinAware
//    class nabed.apps.nabedutilslibrary.ui.base.ScopedFragment, unresolved supertypes: kotlinx.coroutines.CoroutineScope

//    Supertypes of the following classes cannot be resolved. Please make sure you have the required dependencies in the classpath:
//    class nabed.apps.nabedutilslibrary.ui.prescriptions.NabedCategoriesView, unresolved supertypes: org.kodein.di.KodeinAware
//    class nabed.apps.nabedutilslibrary.ui.base.ScopedFragment, unresolved supertypes: kotlinx.coroutines.CoroutineScope

//    Supertypes of the following classes cannot be resolved. Please make sure you have the required dependencies in the classpath:
//    class nabed.apps.nabedutilslibrary.ui.prescriptions.NabedCategoriesView, unresolved supertypes: org.kodein.di.KodeinAware
//    class nabed.apps.nabedutilslibrary.ui.base.ScopedFragment, unresolved supertypes: kotlinx.coroutines.CoroutineScope
}