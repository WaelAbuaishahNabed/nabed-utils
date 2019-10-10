package nabed.apps.service.prescriptions

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class Subscription() :Serializable{
        @SerializedName("subscribe_id")
        var subscribe_id: Int = 0
        @SerializedName("category_id")
        var category_id: Int = 0
        @SerializedName("user_id")
        var user_id: Int = 0
        @SerializedName("subscription_expire")
        var subscription_expire: String = ""
        @SerializedName("renew")
        var renew: Int = 0
        @SerializedName("poc_id")
        var poc_id: Int = 0
        @SerializedName("created_by")
        var created_by: Int = 0
        @SerializedName("created_at")
        var created_at: String = ""
        @SerializedName("updated_at")
        var updated_at: String = ""
    }