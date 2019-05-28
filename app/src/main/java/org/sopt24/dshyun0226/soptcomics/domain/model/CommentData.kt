package org.sopt24.dshyun0226.soptcomics.domain.model

import java.util.*

data class CommentData(
    var comment_id: Int,
    var thumbnail_url: String,
    var nickname: String,
    var write_date: Date,
    var content: String
)