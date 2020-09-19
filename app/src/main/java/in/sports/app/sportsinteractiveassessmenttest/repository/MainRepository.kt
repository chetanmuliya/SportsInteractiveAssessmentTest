package `in`.sports.app.sportsinteractiveassessmenttest.repository

import `in`.sports.app.sportsinteractiveassessmenttest.data.network.RetrofitBuilder
import `in`.sports.app.sportsinteractiveassessmenttest.db.PlayersDao
import `in`.sports.app.sportsinteractiveassessmenttest.db.PlayersDatabase
import androidx.room.Delete
import sports.app.sportsinteractiveassessmenttest.data.PlayerDetails


class MainRepository(
    private val db : PlayersDatabase
){
    suspend fun getMatchDetails() = RetrofitBuilder.api.getMatchDetails()

    suspend fun insert(playerDetails: List<PlayerDetails>) = db.getPlayerDao().insertPlayersAInfo(playerDetails)

    fun getSavedPlayerDetails() = db.getPlayerDao().getPlayersInfo()
}