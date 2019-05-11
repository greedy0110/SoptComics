package org.sopt24.dshyun0226.androidseminar.network.get

import org.sopt24.dshyun0226.androidseminar.data.ProductOverviewData

data class GetMainProductListResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<ProductOverviewData>?
)