package sports.app.sportsinteractiveassessmenttest.data


import com.google.gson.annotations.SerializedName

data class TeamA(
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Name_Short")
    val nameShort: String,
    @SerializedName("Players")
    val players: PlayersA
)