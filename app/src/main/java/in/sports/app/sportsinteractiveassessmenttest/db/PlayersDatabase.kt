package `in`.sports.app.sportsinteractiveassessmenttest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import sports.app.sportsinteractiveassessmenttest.data.PlayerDetails
import java.util.concurrent.locks.Lock

@Database(
    entities = [PlayerDetails::class],
    version = 1
)
abstract class PlayersDatabase : RoomDatabase(){

    abstract fun getPlayerDao():PlayersDao

    companion object{
        @Volatile
        private var instance:PlayersDatabase ?= null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock){
            instance ?: createDb(context).also { instance = it }
        }

        private fun createDb(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PlayersDatabase::class.java,
                "player_db.db"
            ).build()


    }

}