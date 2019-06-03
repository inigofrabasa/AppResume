package mx.inigofrabasa.inigofrabasaresume.app.resume.data

import androidx.room.Embedded
import androidx.room.Relation

class SkillAndProfileSelectings {

    @Embedded
    lateinit var skill: Skill

    @Relation(parentColumn = "id", entityColumn = "skill_id")
    var profileSelectings: List<ProfileSelecting> = arrayListOf()
}
