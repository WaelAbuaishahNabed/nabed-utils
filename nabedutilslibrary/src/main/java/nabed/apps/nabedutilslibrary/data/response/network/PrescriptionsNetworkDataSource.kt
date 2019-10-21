package nabed.apps.nabedutilslibrary.data.response.network

import androidx.lifecycle.LiveData
import nabed.apps.nabedutilslibrary.data.response.PrescriptionsResponse

interface PrescriptionsNetworkDataSource {
    val userPrescription: LiveData<PrescriptionsResponse>
    suspend fun getUserPrescriptions(userId:String)
}