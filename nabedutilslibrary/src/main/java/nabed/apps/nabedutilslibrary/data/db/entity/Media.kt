package nabed.apps.nabedutilslibrary.data.db.entity


import com.squareup.moshi.Json

data class Media(
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String
)