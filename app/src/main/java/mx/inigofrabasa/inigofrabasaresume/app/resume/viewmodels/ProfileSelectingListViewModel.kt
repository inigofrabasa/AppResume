package mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.ProfileSelectingRepository
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.SkillAndProfileSelectings

class ProfileSelectingListViewModel internal constructor(
    profileSelectingRepository: ProfileSelectingRepository
) : ViewModel() {

    val profileSelecting = profileSelectingRepository.getProfileSelecting()

    val skillAndProfileSelectings: LiveData<List<SkillAndProfileSelectings>> =
        profileSelectingRepository.getSkillAndProfileSelectings().map { skilling ->
            skilling.filter { it.profileSelectings.isNotEmpty() }
        }
}