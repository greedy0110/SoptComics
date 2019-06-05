package org.sopt24.dshyun0226.soptcomics.api.response


data class GetMainProductListResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<GetMainComicsOverviewData>?
)

data class GetMainComicsOverviewData(
    val comics_idx: Int,
    val title: String,
    val writer: String,
    val likes: Int,
    val thumbnail: String,
    val datetime: String,
    val isfinished: Boolean
)