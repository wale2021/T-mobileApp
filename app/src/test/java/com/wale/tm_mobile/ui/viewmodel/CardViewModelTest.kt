package com.wale.tm_mobile.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wale.tm_mobile.data.model.Card
import com.wale.tm_mobile.data.model.CardWrapper
import com.wale.tm_mobile.data.repository.CardRepository
import com.wale.tm_mobile.utils.CardType
import com.wale.tm_mobile.utils.Resource
import com.wale.tm_mobile.utils.getOrAwaitValue
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CardViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var cardRepo: CardRepository

    private lateinit var viewModel: CardViewModel

    private val cardList = listOf(
        CardWrapper(
            CardType.IMAGE_TITLE_DESCRIPTION,
            Card("", null, null, null, null)
        )
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.IO)
    }

    @Test
    fun `getCard() emits success`() {
        coEvery { cardRepo.fetchCardData() } returns flow { emit(Resource.Success(cardList)) }
        viewModel = CardViewModel(cardRepo)

        val resource = viewModel.getCards.getOrAwaitValue()

        assert(resource is Resource.Success)
        assert(resource == Resource.Success(cardList))
    }

    @Test
    fun `getCard emits error when empty`() {
        coEvery { cardRepo.fetchCardData() } returns flow { emit(Resource.Error("")) }
        viewModel = CardViewModel(cardRepo)

        val resource = viewModel.getCards.getOrAwaitValue()

        assert(resource is Resource.Error)
        assert(resource == Resource.Error(""))
    }
}