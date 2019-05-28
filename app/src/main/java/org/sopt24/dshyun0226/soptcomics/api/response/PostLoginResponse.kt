package org.sopt24.dshyun0226.soptcomics.api.response

data class PostLoginResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: String?
)