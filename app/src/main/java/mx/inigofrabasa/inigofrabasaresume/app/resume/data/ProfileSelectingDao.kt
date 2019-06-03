package mx.inigofrabasa.inigofrabasaresume.app.resume.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

/**
 * The Data Access Object for the [ProfileSelecting] class.
 */
@Dao
interface ProfileSelectingDao {
    @Query("SELECT * FROM profile_selecting")
    fun getProfileSelectings(): LiveData<List<ProfileSelecting>>

    @Query("SELECT * FROM profile_selecting WHERE id = :profileSelectingId")
    fun getProfileSelecting(profileSelectingId: Long): LiveData<ProfileSelecting>

    @Query("SELECT * FROM profile_selecting WHERE skill_id = :skillId")
    fun getProfileSelectingForSkill(skillId: String): LiveData<ProfileSelecting>

    @Transaction
    @Query("SELECT * FROM skills")
    fun getSkillAndProfileSelectings(): LiveData<List<SkillAndProfileSelectings>>

    @Insert
    fun insertProfilesSelecting(profileSelecting: ProfileSelecting): Long

    @Delete
    fun deleteProfilesSelecting(profileSelecting: ProfileSelecting)
}