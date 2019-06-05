package org.sopt24.dshyun0226.soptcomics.api.response

data class GetComicsEpisodeOverviewResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: GetData?
)

data class GetData (
    val liked: Boolean,
    val episode_list: List<GetEpisode>
)

data class GetEpisode (
    val episode_idx: Int, // 만화 index
    val title: String, // 만화 제목
    val thumbnail: String, // 만화 이미지 썸네일
    val hits: Int, // 조회수
    val datetime: String // 작성 시간
)