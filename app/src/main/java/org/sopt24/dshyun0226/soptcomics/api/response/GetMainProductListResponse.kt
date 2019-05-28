package org.sopt24.dshyun0226.soptcomics.api.response

import org.sopt24.dshyun0226.soptcomics.domain.model.ProductOverviewData

data class GetMainProductListResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<ProductOverviewData>?
)