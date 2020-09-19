package `in`.sports.app.sportsinteractiveassessmenttest.ui.viewmodel

import `in`.sports.app.sportsinteractiveassessmenttest.repository.MainRepository
import `in`.sports.app.sportsinteractiveassessmenttest.utils.Resource
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import sports.app.sportsinteractiveassessmenttest.data.MatchDetailResponse
import sports.app.sportsinteractiveassessmenttest.data.PlayerDetails

class MainViewModel(val repository: MainRepository) : ViewModel() {



   //var matchDetailResponse : MatchDetailResponse ?= null

    var matchDetailResponse: MatchDetailResponse ?= null
    val playerDetails : MutableLiveData<Resource<MatchDetailResponse>> = MutableLiveData()



    init {
        getMatchDetails()
    }

    fun getMatchDetails() = viewModelScope.launch {
        playerDetails.postValue(Resource.Loading())
        val response = repository.getMatchDetails()
        playerDetails.postValue(handleResponse(response))
    }

    private fun handleResponse(response : Response<MatchDetailResponse>) : Resource<MatchDetailResponse>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse ->
                if(matchDetailResponse == null){
                    matchDetailResponse = resultResponse
                }
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun savePlayerDetails(playerDetails: List<PlayerDetails>) = viewModelScope.launch {
        repository.insert(playerDetails)
    }

    fun getPlayerDetails() = repository.getSavedPlayerDetails()

}