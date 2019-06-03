package mx.inigofrabasa.inigofrabasaresume.app.resume.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SkillDao {
    @Query("SELECT * FROM skills ORDER BY name")
    fun getSkills(): LiveData<List<Skill>>

    @Query("SELECT * FROM skills WHERE id = :skillId")
    fun getSkill(skillId: String): LiveData<Skill>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(skills: List<Skill>)
}