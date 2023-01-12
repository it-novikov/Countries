package com.itnovikov.countries.presentation.countries_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itnovikov.countries.R
import com.itnovikov.countries.databinding.CountryItemBinding
import com.itnovikov.countries.domain.model.CountryDomain

class CountriesListAdapter
    : ListAdapter<CountryDomain, CountriesListAdapter.CountryViewHolder>(CountriesListDiffCallback()) {

    inner class CountryViewHolder(private val binding: CountryItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(country: CountryDomain) = with(binding) {
            countryName.text = country.countryName

            Glide.with(rootHolder)
                .load(country.flag)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageViewFlag)

            rootHolder.setOnClickListener {
                onItemButtonClick?.invoke(country)
            }
        }
    }

    private var onItemButtonClick: ((CountryDomain) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CountryViewHolder(CountryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) = holder.bind(getItem(position))

    fun setOnItemButtonClick(function: ((CountryDomain) -> Unit)?) {
        onItemButtonClick = function
    }
}