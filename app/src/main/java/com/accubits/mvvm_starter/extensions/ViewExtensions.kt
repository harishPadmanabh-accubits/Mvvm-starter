package com.accubits.mvvm_starter.extensions


import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.*
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide

//Text Watcher for edit text
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

//set default value for live data
fun <T : Any?> MutableLiveData<T>.default(initialValue:T) = apply {
    try {
        setValue(initialValue)
    }catch (e:java.lang.Exception){

    }
}

//TOAST-short
fun Context.showShortToast(message:String?) = message?.let {message->
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

//Toast-long
fun Context.showLongToast(message:String?) = message?.let {message->
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

//load imageView with image url
fun ImageView.loadImageWithUrl(imageUrl : String?){
    try{
        imageUrl?.let{imageUrl->
            if (context!=null){
                Glide.with(context)
                    .load(imageUrl)
                    .into(this)
            }

        }

    }catch (e:Exception){
        e.printStackTrace()
    }


}

//load imageView with image drawable resource
fun ImageView.loadImageWithResId(resID : Int?) = try{

    resID?.let{resID->
        if(context!=null){
            Glide.with(context)
                .load(resID)
                .into(this)
        }
    }

}catch (e:Exception){
    e.printStackTrace()
}

//load imageView with image url  and error
fun ImageView.loadImageWithError(imageUrl: String?, errorResId : Int) = try{

    imageUrl?.let{imageUrl->
        Glide.with(context)
            .load(imageUrl)
            .error(errorResId)
            .into(this)
    }

}catch (e:Exception){
    e.printStackTrace()
}

//load imageView with image url  and @NON-NULL placeholder
fun ImageView.loadImageWithPlaceHolder(imageUrl: String?, placeHolderResId : Int) = try{

    imageUrl?.let{imageUrl->
        Glide.with(context)
            .load(imageUrl)
            .placeholder(placeHolderResId)
            .into(this)
    }

}catch (e:Exception){
    e.printStackTrace()
}

//hide view
fun View.hide() {
    visibility = GONE
}

//show view
fun View.show() {
    visibility = VISIBLE
}

//make view invisible
fun View.invible(){
    visibility = INVISIBLE
}



