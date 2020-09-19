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
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_team_b.*
import sports.app.sportsinteractiveassessmenttest.data.PlayerDetails
import sports.app.sportsinteractiveassessmenttest.data.PlayersB

class TeamBFragment : Fragment() {

    lateinit var viewModel : MainViewModel
    lateinit var playerAdapter : PlayersAdapter
    lateinit var playerBList : ArrayList<PlayerDetails>

    val TAG = "TeamBFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerBList = ArrayList()
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.playerDetails.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {
                    hideProgressbar()
                    showUI()
                    response.data?.let {
                        initAddPlayerB(it.teams.teamB.players)
                    }
                }
                is Resource.Error -> {
                    hideProgressbar()
                    hideUI()
                    response.message?.let { message ->
                        Log.e(TAG, "Error occured : $message ")
                    }
                }
                is Resource.Loading -> {
                    showProgressbar()
                }
            }
        })


    }

    private fun showUI() {
        line.visibility = View.VISIBLE
        player_title.visibility = View.VISIBLE
    }

    private fun hideUI() {
        line.visibility = View.INVISIBLE
        player_title.visibility = View.INVISIBLE
    }

    private fun initAddPlayerB(playerB: PlayersB) {
        playerBList.add(playerB.player1)
        playerBList.add(playerB.player2)
        playerBList.add(playerB.player3)
        playerBList.add(playerB.player4)
        playerBList.add(playerB.player5)
        playerBList.add(playerB.player6)
        playerBList.add(playerB.player7)
        playerBList.add(playerB.player8)
        playerBList.add(playerB.player9)
        playerBList.add(playerB.player10)
        playerBList.add(playerB.player11)


        savePlayerlist()
        playerAdapter.updateList(playerBList)
        playerAdapter.notifyDataSetChanged()
    }

    private fun savePlayerlist() {
        viewModel.savePlayerDetails(playerBList)
    }

    private fun hideProgressbar() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressbar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(){
        playerAdapter = PlayersAdapter(playerBList)
        recyclerView_b.apply {
            adapter = playerAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}