package mx.inigofrabasa.inigofrabasaresume.app.resume.data

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class ProfileSelectingRepository private constructor(
    private val profileSelectingDao: ProfileSelectingDao
) {

    suspend fun createProfileSelecting(skill: String) {
        withContext(IO) {
            val profileSelecting = ProfileSelecting(skill)
            profileSelectingDao.insertProfilesSelecting(profileSelecting)
        }
    }

    suspend fun removeProfileSelecting(profileSelecting: ProfileSelecting) {
        withContext(IO) {
            profileSelectingDao.deleteProfilesSelecting(profileSelecting)
        }
    }

    fun getProfileSelectingForSkill(skillId: String) =
        profileSelectingDao.getProfileSelectingForSkill(skillId)

    fun getProfileSelecting() = profileSelectingDao.getProfileSelectings()

    fun getSkillAndProfileSelectings() = profileSelectingDao.getSkillAndProfileSelectings()

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ProfileSelectingRepository? = null

        fun getInstance(profileSelectingDao: ProfileSelectingDao) =
            instance ?: synchronized(this) {
                instance ?: ProfileSelectingRepository(profileSelectingDao).also { instance = it }
            }
    }
}