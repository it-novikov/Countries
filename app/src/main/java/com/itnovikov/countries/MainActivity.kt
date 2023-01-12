package com.itnovikov.countries

import android.view.LayoutInflater
import com.itnovikov.countries.databinding.ActivityMainBinding
import com.itnovikov.countries.core.bases.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
}