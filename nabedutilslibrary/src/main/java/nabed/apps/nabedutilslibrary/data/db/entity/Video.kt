package nabed.apps.nabedutilslibrary.data.db.entity


import com.squareup.moshi.Json

data class Video(
    @Json(name = "description")
    val description: String,
    @Json(name = "expired")
    val expired: Boolean,
    @Json(name = "id")
    val id: Int,
    @Json(name = "liked")
    val liked: Boolean,
    @Json(name = "media")
    val media: List<Media>,
    @Json(name = "rate")
    val rate: Any,
    @Json(name = "read")
    val read: Boolean,
    @Json(name = "subscription_expire")
    val subscriptionExpire: String,
    @Json(name = "title")
    val title: String
)