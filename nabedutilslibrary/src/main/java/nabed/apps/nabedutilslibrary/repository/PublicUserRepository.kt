package nabed.apps.nabedutilslibrary.repository

import androidx.lifecycle.LiveData
import nabed.apps.nabedutilslibrary.data.db.entity.PrescriptionEntry


interface PublicUserRepository{


    suspend fun getPrescriptionList(userId: String):
            LiveData<out List<PrescriptionEntry>>


}