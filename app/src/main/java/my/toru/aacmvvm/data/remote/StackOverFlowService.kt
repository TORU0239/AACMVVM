package my.toru.aacmvvm.data.remote

import io.reactivex.Observable
import my.toru.aacmvvm.data.model.StackOverFlowModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by toruchoi on 11/12/2017.
 */
interface StackOverFlowService {
    @GET("/2.2/questions?order=desc&sort=votes&site=stackoverflow&tagged=android&filter=withbody")
    fun getQuestion():Observable<StackOverFlowModel>

    @GET("/2.2/questions/{id}/answers?order=desc&sort=votes&site=stackoverflow")
    fun getAnswersForQuestion(@Path("id") id:String):Observable<String>
}