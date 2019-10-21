package nabed.apps.nabedutilslibrary.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nabed.apps.nabedutilslibrary.data.db.entity.PrescriptionEntry


@Database(
    entities = [PrescriptionEntry::class], version = 1
)

abstract class PrescriptionDatabase : RoomDatabase(){
    abstract fun prescriptionDao() : PrescriptionsDao

    companion object {
        @Volatile private var instance : PrescriptionDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context :Context) = instance?: synchronized(LOCK) {
            instance ?:  buildDatabase(context).also { instance = it }
        }
        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, PrescriptionDatabase::class.java,
                    "forecast.db").build()
    }
}