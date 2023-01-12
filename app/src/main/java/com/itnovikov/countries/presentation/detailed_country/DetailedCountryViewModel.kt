package com.itnovikov.countries.presentation.detailed_country

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itnovikov.countries.domain.model.CountryDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailedCountryViewModel @Inject constructor() : ViewModel() {

    private val _currentCountry = MutableLiveData<CountryDomain>()
    val currentCountry : LiveData<CountryDomain> = _currentCountry

    fun saveCurrentCountry(country : CountryDomain) {
        _currentCountry.value = country
    }
}