package org.sopt24.dshyun0226.soptcomics.data

import java.util.*

data class WebToonData(
    var webtoon_id: Int,
    var thumbnail_url: String,
    var title: String,
    var view_count: Int,
    var upload_date: Date
)