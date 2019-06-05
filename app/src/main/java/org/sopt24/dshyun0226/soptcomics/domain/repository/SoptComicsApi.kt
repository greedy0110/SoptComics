package org.sopt24.dshyun0226.soptcomics.domain.repository

import io.reactivex.Observable
import org.sopt24.dshyun0226.soptcomics.api.response.PostSignupResponse
import org.sopt24.dshyun0226.soptcomics.domain.model.ComicsEpisodeOverviewData
import org.sopt24.dshyun0226.soptcomics.domain.model.ComicsOverviewData

// TODO 기본적으로 Response를 파싱해서 필요한 데이터만 반환하는 형태로 구성하자.
interface SoptComicsApi {
    fun requestToken(id: String, pw: String): Observable<Int>
    fun requestSignup(name: String, id:String, pw:String): Observable<PostSignupResponse>
    fun requestComicsOverviewList(kind: String): Observable<List<ComicsOverviewData>>
    fun requestComicsEpisodeOverviewList(comicsIndex: Int): Observable<Pair<Boolean, List<ComicsEpisodeOverviewData>>>
}