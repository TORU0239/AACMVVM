package my.toru.aacmvvm.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by toruchoi on 11/12/2017.
 */

data class StackOverFlowModel(val items:ArrayList<StackOverFlowItemModel>)
data class StackOverFlowItemModel(@SerializedName("is_answered")    val isAnswered:Boolean,
                              @SerializedName("view_count")     val viewCount:String,
                              val score:String,
                              val link:String,
                              val title:String,
                              val body:String)

data class OwnerModel(val reputaion:String,
                      @SerializedName("user_id")        val userId:String,
                      @SerializedName("user_type")      val userType:String,
                      @SerializedName("accept_rate")    val acceptRate:String,
                      @SerializedName("profile_image")  val profileImageLink:String,
                      @SerializedName("display_name")   val displayName:String,
                      val link:String)