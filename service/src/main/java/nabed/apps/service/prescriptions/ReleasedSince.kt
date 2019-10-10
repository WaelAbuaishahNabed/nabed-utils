package nabed.apps.service.prescriptions

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ReleasedSince :Serializable {

    @SerializedName("years")
    var years: Int = 0
    @SerializedName("months")
    var months: Int = 0
    @SerializedName("days")
    var days: Int = 0
    @SerializedName("hours")
    var hours: Int = 0
    @SerializedName("minutes")
    var minutes: Int = 0
    @SerializedName("seconds")
    var seconds: Int = 0

    public constructor(years: Int , months: Int , days: Int , hours: Int , minutes: Int , seconds: Int) {
        this.years = years
        this.months = months
        this.days = days
        this.hours = hours
        this.minutes = minutes
        this.seconds = seconds
    }
}