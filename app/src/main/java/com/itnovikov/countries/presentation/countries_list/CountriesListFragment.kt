package com.itnovikov.countries.presentation.countries_list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.itnovikov.countries.R
import com.itnovikov.countries.core.bases.BaseFragment
import com.itnovikov.countries.databinding.FragmentCountriesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesListFragment :
    BaseFragment<FragmentCountriesListBinding, CountriesListViewModel>(FragmentCountriesListBinding::inflate) {

    companion object {
        const val CURRENT_COUNTRY = "current_country"
    }

    override val viewModel: CountriesListViewModel by viewModels()

    private val adapter = CountriesListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initCallbacks()
        initObservers()
    }

    private fun initObservers() = with(viewModel) {
        countries.observe { listData -> adapter.submitList(listData) }

        error.observe { errorMessage ->
            if (errorMessage != null) showSnackbar(errorMessage)
        }
    }

    private fun initViews() = with(binding) {
        rvCountries.adapter = adapter
        buttonUpdate.setOnClickListener { viewModel.updateCountries() }
    }

    private fun initCallbacks() {
        adapter.setOnItemButtonClick {
            navigateTo(
                R.id.action_countriesListFragment_to_detailedCountryFragment,
                bundleOf(CURRENT_COUNTRY to it)
            )
        }
    }
}