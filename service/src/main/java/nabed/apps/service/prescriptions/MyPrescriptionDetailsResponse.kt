package nabed.apps.service.prescriptions

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MyPrescriptionDetailsResponse(@SerializedName("result")
                                    @Expose
                                    var content: ArrayList<MyPrescriptionDetails>,
                                    @SerializedName("prescription_unread_count")
                                    @Expose
                                    var prescription_unread_count: Any,
                                    @SerializedName("subscription_count")
                                    @Expose
                                    var subscription_count: Int?=null): Serializable
