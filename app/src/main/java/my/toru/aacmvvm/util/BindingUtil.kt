package my.toru.aacmvvm.util

import android.databinding.BindingAdapter
import android.os.Build
import android.text.Html
import android.widget.TextView

/**
 * Created by toruchoi on 12/12/2017.
 */
class BindingUtil {
    companion object {
        @BindingAdapter("htmlText")
        @JvmStatic
        fun setHTMLText(textView: TextView, textBody:String){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                textView.text = Html.fromHtml(textBody,Html.FROM_HTML_MODE_COMPACT)
            }
            else{
                textView.text = Html.fromHtml(textBody)
            }
        }
    }
}