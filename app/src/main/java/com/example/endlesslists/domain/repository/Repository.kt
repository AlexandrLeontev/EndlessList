package com.example.endlesslists.domain.repository

import androidx.paging.PagingData
import com.example.endlesslists.domain.models.Children
import com.example.endlesslists.domain.models.Data
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData(): Data
    suspend fun getMoreData(): Flow<PagingData<Children>>
}