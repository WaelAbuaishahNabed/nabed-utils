package nabed.apps.service.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import nabedapp.nabed.net.service.store.models.Country
import nabedapp.nabed.net.service.store.models.speciality
import java.io.Serializable


class Poc(
    @SerializedName("id")
        @Expose
        var id: String,

    @SerializedName("created_at")
        @Expose
        var createdAt: String,

    @SerializedName("name")
        @Expose
        var name: String,

    @SerializedName("specialities")
        @Expose
        var specialities: ArrayList<speciality>,

    @SerializedName("subscription_count")
        @Expose
        var subscription_count: Int? = null,

    @SerializedName("self_enrollment_count")
        @Expose
        var self_enrollment_count: Int? = null,

    @SerializedName("media")
        @Expose
        var image: ImageObject,
    @SerializedName("country")
        @Expose
        var country: Country?

) : Serializable