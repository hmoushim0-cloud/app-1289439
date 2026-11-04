package sa.factory.qootsurplusfood128.data.remote

import sa.factory.qootsurplusfood128.model.QootSurplusItem
import sa.factory.qootsurplusfood128.model.QootSurplusOrder

interface QootSurplusApiService {
    suspend fun fetchCatalog(): List<QootSurplusItem>
    suspend fun submitOrder(order: QootSurplusOrder): Boolean
}
