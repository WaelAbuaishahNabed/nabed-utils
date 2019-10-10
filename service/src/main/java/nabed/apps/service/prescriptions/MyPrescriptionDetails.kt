package nabed.apps.service.prescriptions

import com.google.gson.annotations.SerializedName
import nabed.apps.service.models.Category
import nabed.apps.service.models.Feed
import java.io.Serializable

class MyPrescriptionDetails(
        @SerializedName("category")
        val category: Category? = null,
        @SerializedName("topics")
        val topics: List<Feed> = ArrayList(),
        @SerializedName("content_count")
        val content_count: String?=null,
        @SerializedName("prescription_unread_count")
        val total_unread_count: String?=null,
        @SerializedName("last_updated")
        val last_updated: String?=null
) : Serializable