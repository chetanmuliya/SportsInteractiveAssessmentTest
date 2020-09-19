package `in`.sports.app.sportsinteractiveassessmenttest.db

import androidx.lifecycle.LiveData
import androidx.room.*
import sports.app.sportsinteractiveassessmenttest.data.PlayerDetails

@Dao
interface PlayersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayersAInfo(playersList: List<PlayerDetails>)

    @Delete
    suspend fun deletePlayersInfo(playersInfo: PlayerDetails)

    @Query("SELECT * FROM playerdetails_table")
    fun getPlayersInfo(): LiveData<List<PlayerDetails>>
}