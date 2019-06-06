package org.sopt24.dshyun0226.soptcomics.api.response

data class GetEpisodeCommentResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<GetEpisodeCommentData>
)

data class GetEpisodeCommentData(
    val comments_idx: Int,
    val name: String,
    val content: String,
    val writetime: String,
    val image_url_list: List<String>,
    val episode_idx: Int,
    val user_idx: Int
)