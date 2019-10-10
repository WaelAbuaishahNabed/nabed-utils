package nabedapp.nabed.net.service.store.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Salaheddin on 11/16/2018.
 */
class Country(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("iso")
        val iso: String = "",
        @SerializedName("nicename")
        val name: String = "",
        @SerializedName("phonecode")
        val phoneCode: String = ""
):Serializable{

}