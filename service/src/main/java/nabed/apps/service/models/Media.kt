package nabed.apps.service.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import nabed.apps.service.prescriptions.ReleasedSince
import java.io.Serializable


class Media(
    @SerializedName("image")
        var images: List<ImageObject>? = null,
    @SerializedName("video")
        var videos: List<VideoObject>? = null,
    @SerializedName("title")
        var title: String? = "",
    @SerializedName("id")
        var id: String? = null,
    @SerializedName("type")
        var type: String? = null,
    @SerializedName("thumbnail_url")
        var thumbnailUrl: String? = null,
    @SerializedName("created_at")
        var whenUploaded: String? = null,
    @SerializedName("vimeo_id")
        var vimeoId: String? = null,
    @SerializedName("video_url")
        var video_url: String? = null,
    @SerializedName("video_duration")
        var videoDuration: String? = null,
    @SerializedName("released_since")
        var releasedSince: ReleasedSince? = null,
    @SerializedName("url")
        var url: String? = null,
    @SerializedName("video_code")
        var videoCode: String? = null,
    @Expose
        var isLocalVideo: Boolean = false
): Serializable