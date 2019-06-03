package mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import mx.inigofrabasa.inigofrabasaresume.app.resume.data.ProfileSelectingRepository
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.SkillRepository

class SkillDetailViewModelFactory(
    private val skillRepository: SkillRepository,
    private val profileSelectingRepository: ProfileSelectingRepository,
    private val skill: String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SkillDetailViewModel(skillRepository, profileSelectingRepository, skill) as T
    }
}