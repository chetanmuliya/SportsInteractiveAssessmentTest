package `in`.sports.app.sportsinteractiveassessmenttest.ui.fragments

import `in`.sports.app.sportsinteractiveassessmenttest.MainActivity
import `in`.sports.app.sportsinteractiveassessmenttest.R
import `in`.sports.app.sportsinteractiveassessmenttest.ui.adapter.PlayersAdapter
import `in`.sports.app.sportsinteractiveassessmenttest.ui.viewmodel.MainViewModel
import `in`.sports.app.sportsinteractiveassessmenttest.utils.Resource
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_team_a.*
import sports.app.sportsinteractiveassessmenttest.data.MatchDetailResponse
import sports.app.sportsinteractiveassessmenttest.data.PlayerDetails
import sports.app.sportsinteractiveassessmenttest.data.PlayersA

class TeamAFragment : Fragment() {

    lateinit var viewModel : MainViewModel
    lateinit var playerAdapter : PlayersAdapter
    lateinit var playerAList : ArrayList<PlayerDetails>

    val TAG = "TeamAFragment"
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerAList = ArrayList()
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.playerDetails.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {
                    hideProgressbar()
                    response.data?.let {
                        showUI()
                       initAddPlayerA(it.teams.teamA.players)
                    }
                }
                is Resource.Error -> {
                    hideProgressbar()
                    response.message?.let { message ->
                        Log.e(TAG, "Error occured : $message ")
                    }
                }
                is Resource.Loading -> {
                    showProgressbar()
                }
            }
        })

        viewModel.getPlayerDetails().observe(viewLifecycleOwner, Observer { playerdetails ->
            playerAdapter.updateList(playerAList)
            playerAdapter.notifyDataSetChanged()
        })

    }

    private fun showUI() {
        line.visibility = View.VISIBLE
        player_title_1.visibility = View.VISIBLE
    }

    private fun initAddPlayerA(playerA: PlayersA) {
        playerAList.add(playerA.player1)
        playerAList.add(playerA.player2)
        playerAList.add(playerA.player3)
        playerAList.add(playerA.player4)
        playerAList.add(playerA.player5)
        playerAList.add(playerA.player6)
        playerAList.add(playerA.player7)
        playerAList.add(playerA.player8)
        playerAList.add(playerA.player9)
        playerAList.add(playerA.player10)
        playerAList.add(playerA.player11)

        savePlayerlist()
        playerAdapter.updateList(playerAList)
        playerAdapter.notifyDataSetChanged()
    }

    private fun savePlayerlist() {
     viewModel.savePlayerDetails(playerAList)
    }

    private fun hideProgressbar() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressbar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(){
        playerAdapter = PlayersAdapter(playerAList)
        teamA_recyclerView.apply {
            adapter = playerAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}