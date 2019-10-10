package nabed.apps.service.models

import com.google.gson.annotations.SerializedName
import nabed.apps.service.prescriptions.ReleasedSince
import nabed.apps.service.prescriptions.Subscription
import java.io.Serializable


class Category(
    @SerializedName("id")
        var id: String? = null,
    @SerializedName("parent_id")
        var parentId: String? = null,
    @SerializedName("title")
        var title: String? = null,
    @SerializedName("media")
        var media: Media? = null,
    @SerializedName("description")
        var description: String? = null,
    @SerializedName("sample_trailer_video_release_since")
        var videoTrailerReleasedSince: ReleasedSince? = null,
    @SerializedName("content_count_all")
        val contentCount: CategoryItemModel.ContentCount? = null,
    @SerializedName("created_at")
        val created_at: String? = null,
    @SerializedName("updated_at")
        val updated_at: String? = null,
    @SerializedName("children")
        var children: ArrayList<Category>? = null,
    @SerializedName("subscription")
        var subscription: Subscription? = null,
    @SerializedName("is_selected")
        var is_selected: Any? = null,
    @SerializedName("sample_trailer_video_content_id")
        var trailerVideoId: String? = null) : Serializable {
    var isChecked: Boolean = false
    var isLoading: Boolean = false
    var isInterest: Boolean = false
    fun getSelected(): Boolean {
        val isSelected = is_selected
        when {
            is_selected is String -> return is_selected!=null&&is_selected!="0"
            isSelected is Boolean -> return is_selected as Boolean
            else -> false
        }
        return false
    }
}