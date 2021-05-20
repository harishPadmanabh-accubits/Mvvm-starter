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

fun View.isVisibile(): Boolean = this.visibility == View.VISIBLE

fun View.isGone(): Boolean = this.visibility == View.GONE

fun View.isInvisible(): Boolean = this.visibility == View.INVISIBLE

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}



