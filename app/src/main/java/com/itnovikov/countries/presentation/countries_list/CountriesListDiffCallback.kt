package com.itnovikov.countries.presentation.countries_list

import androidx.recyclerview.widget.DiffUtil
import com.itnovikov.countries.domain.model.CountryDomain

class CountriesListDiffCallback : DiffUtil.ItemCallback<CountryDomain>() {

    override fun areItemsTheSame(oldItem: CountryDomain, newItem: CountryDomain): Boolean {
        return oldItem.countryName == newItem.countryName
    }

    override fun areContentsTheSame(oldItem: CountryDomain, newItem: CountryDomain): Boolean {
        return oldItem == newItem
    }
}