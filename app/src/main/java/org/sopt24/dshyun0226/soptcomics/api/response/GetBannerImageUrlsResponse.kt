package org.sopt24.dshyun0226.soptcomics.api.response

data class GetBannerImageUrlsResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<GetBannerData>
)

data class GetBannerData(
    val image_url: String,
    val href: String
)