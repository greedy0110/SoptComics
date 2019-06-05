package org.sopt24.dshyun0226.soptcomics.domain.model

data class ComicsOverviewData(
    var thumnail: String,
    var idx: Int,
    var title: String,
    var likes: Int,
    var name: String,
    var isFinished: Int
)