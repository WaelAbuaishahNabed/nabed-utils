package nabed.apps.service.prescriptions

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tag(@SerializedName("id")
                   @Expose
                   var id : String,
          @SerializedName("title")
                   @Expose
                   var title : String):Serializable