package br.com.digio_teste.util

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

class Util {

    companion object{

        @JvmStatic
        fun loadingUtil(context: Context) : CircularProgressDrawable{
            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            return circularProgressDrawable
        }
    }
}