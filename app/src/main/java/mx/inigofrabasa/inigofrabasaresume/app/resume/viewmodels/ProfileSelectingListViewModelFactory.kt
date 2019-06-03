package mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.ProfileSelectingRepository

class ProfileSelectingListViewModelFactory(
    private val repository: ProfileSelectingRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileSelectingListViewModel(repository) as T
    }
}