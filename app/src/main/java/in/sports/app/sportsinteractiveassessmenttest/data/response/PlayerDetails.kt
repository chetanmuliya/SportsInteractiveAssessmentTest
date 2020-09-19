package sports.app.sportsinteractiveassessmenttest.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "playerdetails_table")
data class PlayerDetails(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @SerializedName("Position")
    val position: String,
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Iscaptain")
    val iscaptain: Boolean,
    @SerializedName("Iskeeper")
    val iskeeper: Boolean
    /*@SerializedName("Batting")
    val batting: Batting,
    @SerializedName("Bowling")
    val bowling: Bowling*/
)