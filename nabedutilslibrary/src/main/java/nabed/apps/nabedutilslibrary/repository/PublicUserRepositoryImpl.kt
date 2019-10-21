package nabed.apps.nabedutilslibrary.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nabed.apps.nabedutilslibrary.data.response.PrescriptionsResponse
import nabed.apps.nabedutilslibrary.data.response.network.PrescriptionsNetworkDataSource
import nabed.apps.nabedutilslibrary.data.db.PrescriptionsDao
import nabed.apps.nabedutilslibrary.data.db.entity.PrescriptionEntry

class PublicUserRepositoryImpl(
    private val prescriptionsDao: PrescriptionsDao,
    private val prescriptionsNetwordDataSource: PrescriptionsNetworkDataSource)
    : PublicUserRepository, BaseRepository() {


    init {
        prescriptionsNetwordDataSource.apply {
            userPrescription.observeForever { newCurrentWeather ->
                if (newCurrentWeather != null) {
                    persisFetchedCurrentWeather(newCurrentWeather)
                }
            }
        }
    }


    override suspend fun getPrescriptionList(userId: String): LiveData<out List<PrescriptionEntry>> {
        return withContext(Dispatchers.IO){
            initPrescriptionsData(userId)
            return@withContext prescriptionsDao.getAllUserPrescriptions()
        }
    }

    private suspend fun initPrescriptionsData(userId:String) {
        prescriptionsNetwordDataSource.getUserPrescriptions(userId)
    }

    private  fun persisFetchedCurrentWeather(fetchedResponse: PrescriptionsResponse){
        GlobalScope.launch(Dispatchers.IO) {
            prescriptionsDao.insert(fetchedResponse.data)
        }
    }

}