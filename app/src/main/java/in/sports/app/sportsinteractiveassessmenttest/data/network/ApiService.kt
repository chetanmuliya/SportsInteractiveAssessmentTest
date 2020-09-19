package `in`.sports.app.sportsinteractiveassessmenttest.data.network

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import sports.app.sportsinteractiveassessmenttest.data.MatchDetailResponse

interface ApiService {

    @GET("nzin01312019187360.json")
    suspend fun getMatchDetails():Response<MatchDetailResponse>
}