package nabed.apps.service.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class CategoryItemModel(
        @SerializedName("title")
        val title: String? = null ,

        @SerializedName("id")
        val id: String? = null ,

        @SerializedName("description")
        val description: String? = null ,

        @SerializedName("parent_id")
        val parentID: String? = null ,

        @SerializedName("children")
        val childrenCategories: List<CategoryItemModel>? = null ,

        @SerializedName("media")
        val media: Media? = null ,

        @SerializedName("sample_trailer_video_content_id")
        val videoContentId: String? = null ,

        @SerializedName("likes_count")
        val likesCount: Int = 0 ,

        @SerializedName("is_liked_by_me")
        val isLikedByMe: Boolean = false ,

        @SerializedName("is_favored_by_me")
        val isFavoredByMe: Boolean = false ,

        @SerializedName("content_count_all")
        val contentCount: ContentCount? = null
) : Serializable {

    /**
     * @return first imageUrl taken from the Media object.
     */
    fun getImage(): String {

        var imageUrl = ""
        val images = media!!.images
        if (images != null && images.isNotEmpty()) {
            val imageObject = images[0]
            if (imageObject != null) {
                imageUrl = imageObject.url!!
            }
        }
        return imageUrl
    }

    /**
     * @return first video object from the media object
     */
    fun getVideo(): VideoObject? {

        val videos = media!!.videos
        var videoObject: VideoObject? = null
        if (videos != null && videos.isNotEmpty()) {
            videoObject = videos[0]
        }

        return videoObject
    }

    fun getAllVideos(): ArrayList<VideoObject> {
        val videos = ArrayList<VideoObject>()
        if (media != null) {
            media.videos?.let { videos.addAll(it) }
        }
        return videos
    }

    override fun equals(obj: Any?): Boolean {

        return if (obj is CategoryItemModel) {
            this.id == obj.id
        } else super.equals(obj)
    }

    override fun hashCode(): Int {

        return Integer.valueOf(id)
    }

    inner class ContentCount {

        @SerializedName("media")
        var media: Int = 0
            internal set
    }
}