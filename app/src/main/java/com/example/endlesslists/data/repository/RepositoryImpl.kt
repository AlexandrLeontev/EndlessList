package com.example.endlesslists.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.endlesslists.data.repository.datasource.CloudSource
import com.example.endlesslists.data.repository.datasource.CloudSourceImpl
import com.example.endlesslists.data.repository.datasource.api.BackendApi
import com.example.endlesslists.domain.models.Children
import com.example.endlesslists.domain.models.Data
import com.example.endlesslists.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val dataSource: CloudSource,
    private val api: BackendApi
) : Repository {
    override suspend fun getData(): Data = dataSource.getData()
    override suspend fun getMoreData(): Flow<PagingData<Children>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { CloudSourceImpl(api) }
    ).flow
}