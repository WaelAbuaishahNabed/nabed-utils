package nabed.apps.nabedutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
//import nabed.apps.nabedutilslibrary.views.prescriptions.NabedCategoriesView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkNabedExpiry.setOnClickListener {
//            addNabedScreen()
        }
    }

//    private fun addNabedScreen() {
//        replaceFragment(
//            R.id.nabed_container,
//            NabedCategoriesView.newInstance(),
//            "NabedChapter",
//            "state"
//        )
//    }
//
//    private fun replaceFragment(
//        @IdRes containerViewId: Int,
//        fragment: Fragment,
//        fragmentTag: String,
//        @Nullable backStackStateName: String
//    ) {
//        supportFragmentManager
//            .beginTransaction()
//            .replace(containerViewId, fragment, fragmentTag)
//            .addToBackStack(backStackStateName)
//            .commit()
//    }
}
