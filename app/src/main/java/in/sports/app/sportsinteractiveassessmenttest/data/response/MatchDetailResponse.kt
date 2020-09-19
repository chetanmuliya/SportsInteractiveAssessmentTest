package sports.app.sportsinteractiveassessmenttest.data


import com.google.gson.annotations.SerializedName

data class MatchDetailResponse(
    @SerializedName("Matchdetail")
    val matchdetail: Matchdetail,
    @SerializedName("Nuggets")
    val nuggets: List<String>,
    @SerializedName("Innings")
    val innings: List<Inning>,
    @SerializedName("Teams")
    val teams: Teams,
    @SerializedName("Notes")
    val notes: Notes
)