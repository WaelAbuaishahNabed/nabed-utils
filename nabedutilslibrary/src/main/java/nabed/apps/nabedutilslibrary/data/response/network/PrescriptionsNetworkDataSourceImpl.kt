package nabed.apps.nabedutilslibrary.data.response.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import nabed.apps.nabedutilslibrary.data.response.PrescriptionsResponse
import nabed.apps.nabedutilslibrary.internal.NoNetworkException
import nabed.apps.nabedutilslibrary.repository.BaseRepository
import java.net.SocketTimeoutException

class PrescriptionsNetworkDataSourceImpl(
    private val prescriptionsApiService
                                     : PrescriptionsApiService
) : PrescriptionsNetworkDataSource, BaseRepository() {

    private val _prescriptionsResponse= MutableLiveData<PrescriptionsResponse>()


    override val userPrescription: LiveData<PrescriptionsResponse>
        get() = _prescriptionsResponse

    override suspend fun getUserPrescriptions(userId: String) {
        try {
            val futureWeatherResponse = safeApiCall(
                call = {prescriptionsApiService.getUserPrescriptionsAsync(userId).await()},
                errorMessage = "Error fetching prescriptions")
            _prescriptionsResponse.postValue(futureWeatherResponse)
        }
        catch (e: NoNetworkException){
            Log.e("Connectivity_error", "No internet connection", e)
        }
        catch (e : SocketTimeoutException){
            Log.e("Connectivity_error", "Slow Internet Connection", e)
        }
    }
}