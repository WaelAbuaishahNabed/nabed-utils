package nabed.apps.service.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class ImageObject(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("type")
        var type: String? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("url")
        var url: String? = null
): Serializable