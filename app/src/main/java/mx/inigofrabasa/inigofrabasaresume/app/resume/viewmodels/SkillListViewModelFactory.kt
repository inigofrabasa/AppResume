package mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import mx.inigofrabasa.inigofrabasaresume.app.resume.data.SkillRepository

class SkillListViewModelFactory(
    private val repository: SkillRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = SkillListViewModel(repository) as T
}
