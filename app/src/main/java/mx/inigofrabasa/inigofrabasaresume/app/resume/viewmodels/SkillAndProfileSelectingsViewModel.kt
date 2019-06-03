package mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.SkillAndProfileSelectings
import java.text.SimpleDateFormat
import java.util.Locale

class SkillAndProfileSelectingsViewModel(skills: SkillAndProfileSelectings) : ViewModel() {

    private val skill = checkNotNull(skills.skill)
    private val profileSelecting = skills.profileSelectings[0]
    private val dateFormat by lazy { SimpleDateFormat("MMM d, yyyy", Locale.US) }

    val imageUrl = ObservableField<String>(skill.imageUrl)
    val skillName = ObservableField<String>(skill.name)
    val addedDateString = ObservableField<String>(dateFormat.format(profileSelecting.skillDate.time))
}

