package nabed.apps.nabedutilslibrary.data.response


import com.google.gson.annotations.SerializedName
import nabed.apps.nabedutilslibrary.data.db.entity.PrescriptionEntry


data class PrescriptionsResponse(
    @SerializedName("data")
    val data: List<PrescriptionEntry>
)