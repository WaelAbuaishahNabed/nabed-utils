package nabed.apps.service.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class DoctorContent(@SerializedName("poc") val poc: Poc,
                    @SerializedName("follower_count") var followerCount: Any,
                    @SerializedName("video_count") var videoCount: Any,
                    @SerializedName("patient_count") var patientCount: Any,
                    @SerializedName("content_count") var contentCount: Any,
                    @SerializedName("total_unread_count") var totalUnreadCount: String) : Serializable {
    var isSelected: Boolean = false
}
