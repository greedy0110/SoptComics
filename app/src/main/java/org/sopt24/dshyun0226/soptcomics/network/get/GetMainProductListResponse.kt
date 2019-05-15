package org.sopt24.dshyun0226.soptcomics.network.get

import org.sopt24.dshyun0226.soptcomics.data.ProductOverviewData

data class GetMainProductListResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<ProductOverviewData>?
)