package com.itnovikov.countries.presentation.detailed_country

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.itnovikov.countries.R
import com.itnovikov.countries.core.bases.BaseFragment
import com.itnovikov.countries.databinding.FragmentDetailedCountryBinding
import com.itnovikov.countries.domain.model.CountryDomain
import com.itnovikov.countries.presentation.countries_list.CountriesListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailedCountryFragment
    : BaseFragment<FragmentDetailedCountryBinding, DetailedCountryViewModel>(FragmentDetailedCountryBinding::inflate) {

    override val viewModel: DetailedCountryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readArguments()
        initObservers()
        configureButtons()
    }

    private fun initObservers() {
        viewModel.currentCountry.observe { country ->
            updateUi(country)
        }
    }

    private fun updateUi(country: CountryDomain) = with(binding) {
        Glide.with(requireActivity())
            .load(country.flag)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageViewFlagOnDetailed)

        textViewName.text = country.countryName
        textViewRegion.text = country.region
        textViewCapital.text = country.capital

        val currencyNames = country.currenciesName?.joinToString(", ")
        textViewCurrency.text = currencyNames

        val timezoneNames = country.listTimeZone?.joinToString(", ")
        textViewTimeZones.text = timezoneNames
    }

    private fun readArguments() {
        if (arguments?.get(CountriesListFragment.CURRENT_COUNTRY) != null) {
            val country =
                arguments?.getParcelable<CountryDomain>(CountriesListFragment.CURRENT_COUNTRY)
            country?.let { viewModel.saveCurrentCountry(it) }
        }
    }

    private fun configureButtons() {
        binding.buttonBack.setOnClickListener { navigateUp() }
    }
}