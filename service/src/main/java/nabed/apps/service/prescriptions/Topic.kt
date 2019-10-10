package nabed.apps.service.prescriptions

import com.google.gson.annotations.SerializedName
import nabed.apps.service.models.CategoryItemModel
import nabed.apps.service.models.Media
import nabed.apps.service.models.VideoObject
import java.io.Serializable


data class Topic(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("parent_id")
    var parentId: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("message")
    var message: String? = null,
    @SerializedName("media")
    var media: Media? = null,
    @SerializedName("data")
    var data: String? = null,
    @SerializedName("category_parents")
    var tags: ArrayList<Tag> = ArrayList(),
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("is_liked_by_me")
    var isLikedByMe: Boolean = false,
    @SerializedName("is_favored_by_me")
    var isFavoredByMe: Boolean = false,
    @SerializedName("released_since")
    var releasedSince: ReleasedSince? = null,
    @SerializedName("is_read")
    var isRead: Boolean = false,
    @SerializedName("read_count")
    var viewsCount: Int = 0,
    @SerializedName("content_count_all")
    val contentCount: ContentCount? = null,
    @SerializedName("rated_by_me")
    var rated_by_me: String? = null,
    @SerializedName("likes_count")
    var likesCount: Int = 0
) : Serializable {


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

    fun getAllVideos(): java.util.ArrayList<VideoObject> {

        val videos = java.util.ArrayList<VideoObject>()
        if (media != null) {
            media?.videos?.let { videos.addAll(it) }
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

    inner class ContentCount : Serializable {

        @SerializedName("media")
        var media: Int = 0
            internal set
    }
}


