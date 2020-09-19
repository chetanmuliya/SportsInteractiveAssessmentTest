package `in`.sports.app.sportsinteractiveassessmenttest.ui.adapter

import `in`.sports.app.sportsinteractiveassessmenttest.ui.fragments.TeamAFragment
import `in`.sports.app.sportsinteractiveassessmenttest.ui.fragments.TeamBFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TeamPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TeamAFragment()
            1 -> TeamBFragment()
            else -> TeamAFragment()
        }
    }
}