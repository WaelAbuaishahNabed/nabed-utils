package nabed.apps.nabedutilslibrary.data.db.entity


import com.squareup.moshi.Json

data class Data(
    @Json(name = "id")
    val id: Int,
    @Json(name = "media")
    val media: List<Media>,
    @Json(name = "parent_id")
    val parentId: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "videos")
    val videos: List<Video>
)