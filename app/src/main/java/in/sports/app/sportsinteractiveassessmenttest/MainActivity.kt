package `in`.sports.app.sportsinteractiveassessmenttest

import `in`.sports.app.sportsinteractiveassessmenttest.db.PlayersDatabase
import `in`.sports.app.sportsinteractiveassessmenttest.repository.MainRepository
import `in`.sports.app.sportsinteractiveassessmenttest.ui.adapter.TeamPagerAdapter
import `in`.sports.app.sportsinteractiveassessmenttest.ui.viewmodel.MainViewModel
import `in`.sports.app.sportsinteractiveassessmenttest.ui.viewmodel.MainViewModelFactory
import `in`.sports.app.sportsinteractiveassessmenttest.utils.Resource
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager.adapter =
            TeamPagerAdapter(
                this
            )



        val mainRepository = MainRepository(PlayersDatabase(this))
        val viewModelProviderFactory = MainViewModelFactory(mainRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)
        //viewModel.savePlayerDetails()

        viewModel.playerDetails.observe(this, Observer { response ->
            when(response){
                is Resource.Success -> {
                    response.data?.let {
                         val teamA = it.teams.teamA.nameShort
                         val teamB = it.teams.teamB.nameShort
                        setTitleTabTeamName(teamA,teamB)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e("MainActivity", "Error occured : $message ")
                    }
                }
                is Resource.Loading -> {

                }
            }
        })
    }

    fun setTitleTabTeamName(teamA:String,teamB:String){
        TabLayoutMediator(tablayout,viewpager){ tab,pos ->
            when(pos){
                0 -> tab.text = teamA
                1 -> tab.text = teamB
            }
        }.attach()
        who_match.text = "$teamA vs $teamB"
    }
}