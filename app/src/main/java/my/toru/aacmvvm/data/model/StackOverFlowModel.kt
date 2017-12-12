package my.toru.aacmvvm.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by toruchoi on 11/12/2017.
 */

data class StackOverFlowModel(val items: ArrayList<StackOverFlowItemModel>) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(StackOverFlowItemModel.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(items)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<StackOverFlowModel> = object : Parcelable.Creator<StackOverFlowModel> {
            override fun createFromParcel(source: Parcel): StackOverFlowModel = StackOverFlowModel(source)
            override fun newArray(size: Int): Array<StackOverFlowModel?> = arrayOfNulls(size)
        }
    }
}

data class StackOverFlowItemModel(@SerializedName("is_answered") val isAnswered: Boolean,
                                  @SerializedName("view_count") val viewCount: String,
                                  val score: String,
                                  val link: String,
                                  val title: String,
                                  val body: String) : Parcelable {
    constructor(source: Parcel) : this(
            1 == source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt((if (isAnswered) 1 else 0))
        writeString(viewCount)
        writeString(score)
        writeString(link)
        writeString(title)
        writeString(body)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<StackOverFlowItemModel> = object : Parcelable.Creator<StackOverFlowItemModel> {
            override fun createFromParcel(source: Parcel): StackOverFlowItemModel = StackOverFlowItemModel(source)
            override fun newArray(size: Int): Array<StackOverFlowItemModel?> = arrayOfNulls(size)
        }
    }
}

data class OwnerModel(val reputaion:String,
                      @SerializedName("user_id")        val userId:String,
                      @SerializedName("user_type")      val userType:String,
                      @SerializedName("accept_rate")    val acceptRate:String,
                      @SerializedName("profile_image")  val profileImageLink:String,
                      @SerializedName("display_name")   val displayName:String,
                      val link:String)