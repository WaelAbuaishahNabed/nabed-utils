package nabed.apps.nabedutilslibrary.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import nabed.apps.nabedutilslibrary.data.db.entity.PrescriptionEntry
import nabed.apps.nabedutilslibrary.data.db.prescriptions.PrescriptionEntity

@Dao
interface PrescriptionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(futureWeatherEntries: List<PrescriptionEntry>)

    @Query("select * from prescriptions")
    fun getAllUserPrescriptions(): LiveData<List<PrescriptionEntry>>

    @Query("delete from prescriptions")
    fun deleteOldEntries()

}