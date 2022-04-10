package com.example.endlesslists.domain

sealed class AppState{
    data class Success(val data: Any) : AppState()
    data class Error(val error_ : Throwable) : AppState()
    object Loading: AppState()
}
