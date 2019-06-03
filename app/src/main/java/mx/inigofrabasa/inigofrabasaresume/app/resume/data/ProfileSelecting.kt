package mx.inigofrabasa.inigofrabasaresume.app.resume.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Calendar

@Entity(
    tableName = "profile_selecting",
    foreignKeys = [ForeignKey(entity = Skill::class, parentColumns = ["id"], childColumns = ["skill_id"])],
    indices = [Index("skill_id")]
)
data class ProfileSelecting(
    @ColumnInfo(name = "skill_id") val skillId: String,

    @ColumnInfo(name = "skill_date") val skillDate: Calendar = Calendar.getInstance()
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var profileSelectingId: Long = 0
}