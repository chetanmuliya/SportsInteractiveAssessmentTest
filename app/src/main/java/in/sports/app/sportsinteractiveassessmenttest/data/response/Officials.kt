package sports.app.sportsinteractiveassessmenttest.data


import com.google.gson.annotations.SerializedName

data class Officials(
    @SerializedName("Umpires")
    val umpires: String,
    @SerializedName("Referee")
    val referee: String
)