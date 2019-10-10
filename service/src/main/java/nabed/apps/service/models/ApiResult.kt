package nabed.apps.service.models

import java.io.Serializable

class ApiResult<T>(var result: T?,
                   var error: String?,
                   var isOffline: Boolean,
                   val type: Type):Serializable {

    enum class Type {
        PRESCRIPTION_DETAILS,
        PRESCRIPTION_TOPIC_DETAILS,
        PRESCRIPTION_TOPIC,
        PRESCRIPTION_CATEGORY_DETAILS,
        PRESCRIPTIONS
    }
}