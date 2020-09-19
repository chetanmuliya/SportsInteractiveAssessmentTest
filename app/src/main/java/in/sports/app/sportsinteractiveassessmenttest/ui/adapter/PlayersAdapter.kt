package `in`.sports.app.sportsinteractiveassessmenttest.ui.adapter

import `in`.sports.app.sportsinteractiveassessmenttest.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.player_row_item.view.*
import sports.app.sportsinteractiveassessmenttest.data.PlayerDetails
import sports.app.sportsinteractiveassessmenttest.data.PlayersA

class PlayersAdapter(var playersA: ArrayList<PlayerDetails>) :
    RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder>() {

    class PlayersViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder {
        return PlayersViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.player_row_item,
                parent,
                false
            )
        )
    }

    fun updateList(newplayerList: ArrayList<PlayerDetails>){
            playersA = newplayerList;
            notifyDataSetChanged();
    }

    override fun getItemCount(): Int {
        return playersA.size
    }

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        holder.itemView.apply {
            val playerDetails = playersA[position]
            if(playerDetails.iskeeper)
               player_name.text = "${playerDetails.nameFull} (wk)"
            else if(playerDetails.iscaptain)
                player_name.text = "${playerDetails.nameFull} (c)"
            else
                player_name.text = playerDetails.nameFull
        }
    }
}