package sports.app.sportsinteractiveassessmenttest.data


import com.google.gson.annotations.SerializedName

data class ThisOver(
    @SerializedName("T")
    val t: String,
    @SerializedName("B")
    val b: String
)