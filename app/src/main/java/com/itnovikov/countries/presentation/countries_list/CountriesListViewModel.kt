package com.itnovikov.countries.presentation.countries_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itnovikov.countries.R
import com.itnovikov.countries.core.bases.BaseResult
import com.itnovikov.countries.core.bases.ResourceProvider
import com.itnovikov.countries.domain.model.CountryDomain
import com.itnovikov.countries.domain.usecases.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val resourceProvider: ResourceProvider,
) : ViewModel() {

    private val _countries = MutableLiveData<List<CountryDomain>?>()
    val countries: LiveData<List<CountryDomain>?> = _countries

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        updateCountries()
    }

    fun updateCountries() {
        viewModelScope.launch {
            when (val result = getCountriesUseCase.getCountries()) {
                is BaseResult.Error -> {
                    if (result.err.code == 0)
                        _error.postValue(resourceProvider.string(R.string.internet_exception))
                    else
                        _error.postValue(resourceProvider.string(R.string.request_exception))
                }
                is BaseResult.Success -> {
                    _countries.postValue(result.data)
                    _error.postValue(null)
                }
            }
        }
    }
}