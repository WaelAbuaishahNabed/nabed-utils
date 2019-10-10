package nabedapp.nabed.net.service.store.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class speciality(@SerializedName("id")
                 @Expose
                 var id: String,
                 @SerializedName("created_at")
                 @Expose
                 var createdAt: String,
                 @SerializedName("name")
                 @Expose
                 var name: String,
                 @SerializedName("description")
                 @Expose
                 var description: String):Serializable