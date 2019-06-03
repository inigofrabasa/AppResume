package mx.inigofrabasa.inigofrabasaresume.app.resume.data

class SkillRepository private constructor(private val skillDao: SkillDao) {

    fun getSkills() = skillDao.getSkills()

    fun getSkill(plantId: String) = skillDao.getSkill(plantId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: SkillRepository? = null

        fun getInstance(skillDao: SkillDao) =
            instance ?: synchronized(this) {
                instance ?: SkillRepository(skillDao).also { instance = it }
            }
    }
}