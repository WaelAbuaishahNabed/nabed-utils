package nabed.apps.nabedutilslibrary.data.db.entity


import com.squareup.moshi.Json

data class Parent(
    @Json(name = "id")
    val id: Int,
    @Json(name = "media")
    val media: List<Media>,
    @Json(name = "title")
    val title: String
)