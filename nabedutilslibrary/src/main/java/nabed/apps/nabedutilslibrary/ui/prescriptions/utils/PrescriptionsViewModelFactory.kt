package nabed.apps.nabedutilslibrary.ui.prescriptions.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nabed.apps.nabedutilslibrary.repository.PublicUserRepository
import nabed.apps.nabedutilslibrary.ui.prescriptions.NabedCategoriesViewModel


class PrescriptionsViewModelFactory(
private val repository: PublicUserRepository) :
ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NabedCategoriesViewModel(repository) as T
    }
}