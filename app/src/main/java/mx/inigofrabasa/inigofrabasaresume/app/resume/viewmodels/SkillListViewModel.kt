package mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.Skill
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.SkillRepository

class SkillListViewModel internal constructor(skillRepository: SkillRepository) : ViewModel() {

    private val skillNumber = MutableLiveData<Int>().apply { value = NO_SKILL }

    val skills: LiveData<List<Skill>> = skillNumber.switchMap {
        skillRepository.getSkills()
    }

    companion object {
        private const val NO_SKILL = -1
    }
}