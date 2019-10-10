package nabed.apps.service.models

import com.google.gson.annotations.SerializedName
import nabed.apps.service.prescriptions.ReleasedSince
import nabed.apps.service.prescriptions.Subscription
import java.io.Serializable
import kotlin.collections.ArrayList

class Feed(
    @SerializedName("id")
        var id: String? = null,
    @SerializedName("parent_id")
        var parentId: String? = null,
    @SerializedName("type")
        var type: String? = null,
    @SerializedName("title")
        var title: String? = null,
    @SerializedName("data")
        var data: Any? = null,
    @SerializedName("description")
        var description: String? = null,
    @SerializedName("message")
        var message: String? = null,
    @SerializedName("media")
        var media: Media? = null,
    @SerializedName("tags")
        var tags: String? = null,
    @SerializedName("created_at")
        var createdAt: String? = null,
    @SerializedName("is_liked_by_me")
        var isLikedByMe: Boolean = false,
    @SerializedName("is_favored_by_me")
        var isFavoredByMe: Boolean = false,
    @SerializedName("rated_by_me")
        var rated_by_me: String? = null,
    @SerializedName("category_parent_name")
        var categoryParentName: String? = null,
    @SerializedName("category_parent_image")
        var categoryParentImage: String? = null,
    @SerializedName("released_since")
        var releasedSince: ReleasedSince? = null,
    @SerializedName("is_read")
        var isRead: Boolean = false,
    @SerializedName("feed_id")
        var mineId: String? = null,
    @SerializedName("read_count")
        var viewsCount: Int = 0,
    @SerializedName("content_count_all")
        val contentCount: ContentCount? = null,
    @SerializedName("content_count")
        val contentCountValue: Any?=null,
    @SerializedName("category_id")
        var CategoryId: String? = null,
    @SerializedName("category")
        var Category: Feed? = null,
    @SerializedName("children")
        var children: ArrayList<Feed>? = null,
    @SerializedName("subscription")
        var subscription: Subscription? = null,
    @SerializedName("total_views_count")
        var total_views_count: Int = 0,
    @SerializedName("likes_count")
        var likesCount: Int = 0) : Serializable{
    var isChecked:Boolean?=false
    var isUnsubScribed:Boolean=false
    var isLoading:Boolean=false
    var total_unread_count: String?=null
    var content_countCategory: String?=null
    var categoryHealthCenter: Category?=null
    inner class MineInfo:Serializable {
        @SerializedName("mine_id")
        var mineId: Int = 0
        @SerializedName("is_read_")
        var isRead: Int = 0
    }

      val typeInt: Int = TYPE_ARTICLE
        get() = when {
            type.equals("media") -> TYPE_ARTICLE_VIDEO
            type.equals("medium") -> TYPE_ARTICLE_IMAGE
            type.equals("tips") -> TYPE_ARTICLE
            type.equals(null)-> {
                if (media?.type.equals("image")){
                    TYPE_ARTICLE_IMAGE
                }else{
                    TYPE_ARTICLE_VIDEO
                }
            }
            else -> field
        }
    fun getImage(): String {
        if (Category!=null){
            var imageUrl = ""
            val images = Category!!.media!!.images
            if (images != null && images.isNotEmpty()) {
                val imageObject = images[0]
                if (imageObject != null) {
                    imageUrl = imageObject.url!!
                }
            }
            return imageUrl
        }else {
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
    }

    /**
     * @return first video object from the media object
     */
    fun getVideo(): VideoObject? {
        val videos = media?.videos
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
    inner class ContentCount:Serializable {
        @SerializedName("media")
        var media: Int = 0
            internal set
    }

    companion object {
        var TYPE_ARTICLE = 0
        var TYPE_ARTICLE_IMAGE = 1
        var TYPE_ARTICLE_VIDEO = 2
        var TYPE_ARTICLE_NO_ITEM = 3
    }
}