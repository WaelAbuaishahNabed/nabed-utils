package nabed.apps.nabedutilslibrary

import android.content.Context
import androidx.appcompat.app.AlertDialog

object ExpiryUtils {

    fun showExpiryDialog(context: Context) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle(context.getString(R.string.sorry))
        builder.setMessage(context.getString(R.string.userExpiredMessage))
        builder.setPositiveButton(context.getString(R.string.ok)){ _, _ ->
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}