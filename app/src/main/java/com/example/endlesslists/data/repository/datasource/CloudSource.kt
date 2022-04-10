package com.example.endlesslists.data.repository.datasource

import com.example.endlesslists.domain.models.Data

interface CloudSource {
   suspend fun getData(): Data
   suspend fun getMoreData(after: String): Data
}