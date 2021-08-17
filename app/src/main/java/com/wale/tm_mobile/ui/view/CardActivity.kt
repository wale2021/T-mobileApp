package com.wale.tm_mobile.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.wale.tm_mobile.adapter.CardAdapter
import com.wale.tm_mobile.databinding.ActivityMainBinding
import com.wale.tm_mobile.ui.viewmodel.CardViewModel
import com.wale.tm_mobile.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewModel.getCards.observe(this@CardActivity) { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        progressBar.isVisible = true
                    }
                    is Resource.Success -> {
                        progressBar.isVisible = false
                        cardRv.adapter = CardAdapter(resource.data)
                    }
                    is Resource.Error -> {
                        progressBar.isVisible = false
                    }

                }
            }
        }
    }
}