package nabedapp.nabed.net.service.store.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PocType(@SerializedName("id")
              @Expose
              var id: String?=null,
              @SerializedName("created_at")
              @Expose
              var createdAt: String?=null,
              @SerializedName("name")
              @Expose
              var name: String?=null) :Serializable{

}