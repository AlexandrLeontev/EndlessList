package com.example.endlesslists.presenter.main

import androidx.paging.cachedIn
import com.example.endlesslists.domain.AppState
import com.example.endlesslists.domain.repository.Repository
import com.example.endlesslists.presenter.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : BaseViewModel() {
    override fun getData() {
        viewModelCoroutineScope.launch {
            liveData.postValue(
                AppState.Success(
                    repository.getData()
                )
            )
        }
    }



    suspend fun getMore() = repository.getMoreData().cachedIn(viewModelCoroutineScope)

    override fun handleError(throwable: Throwable) {
        liveData.postValue(AppState.Error(throwable))
    }
}