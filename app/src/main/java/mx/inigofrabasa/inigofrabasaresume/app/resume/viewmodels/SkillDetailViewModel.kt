package mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.map
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.ProfileSelectingRepository
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.Skill
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.SkillRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SkillDetailViewModel(
    skillRepository: SkillRepository,
    private val profileSelectingRepository: ProfileSelectingRepository,
    private val skillId: String
) : ViewModel() {

    val isAdded: LiveData<Boolean>
    val skill: LiveData<Skill>

    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    init {
        val profilesSelectingForSkill = profileSelectingRepository.getProfileSelectingForSkill(skillId)
        isAdded = profilesSelectingForSkill.map { it != null }

        skill = skillRepository.getSkill(skillId)
    }

    fun addSkillToProfile() {
        viewModelScope.launch {
            profileSelectingRepository.createProfileSelecting(skillId)
        }
    }
}