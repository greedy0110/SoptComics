package org.sopt24.dshyun0226.soptcomics.api.response

data class GetEpisodeResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: GetEpisodeData
)

data class GetEpisodeData(
    val episode_idx: Int,
    val title: String,
    val thumbnail: String,
    val hits: Int,
    val datetime: String,
    val image_url: String
)

