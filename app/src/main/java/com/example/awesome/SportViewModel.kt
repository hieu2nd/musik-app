package com.example.awesome

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.awesome.data.SportData
import com.example.awesome.model.Sport

class SportViewModel : ViewModel() {
    private var _currentSport: MutableLiveData<Sport> = MutableLiveData()
    val currentSport: LiveData<Sport>
        get() = _currentSport
    private var _sportData: ArrayList<Sport> = ArrayList()
    val sportData: ArrayList<Sport>
        get() = _sportData
    init {
        _sportData = SportData.getSportData()
        _currentSport.value = _sportData[0]
    }
    fun updateCurrentSport (sport: Sport){
        _currentSport.value = sport
    }
}