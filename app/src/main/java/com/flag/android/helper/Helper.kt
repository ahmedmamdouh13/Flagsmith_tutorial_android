package com.flag.android.helper

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager


object Helper {

    var tokenApiKey: String = "b97c6f022fe7b736f7bcf6d99019337a7ff2f7d3"
    var environmentDevelopmentKey = "NaeCHAMjZtSmNudzhV9TWy"
    var identifierUserKey: String = "development_user_123456";



    fun keyboardHidden(mActivity: Activity) {
        try {
            val inputManager: InputMethodManager =
                mActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                mActivity.currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        } catch (e: Exception) {
        }
        try {
            mActivity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        } catch (e: Exception) {
        }
    }


    fun callViewInsideThread( activity :Activity, myUnit : ( )-> Unit  ){

        //run UI inside thread
        val h = Handler( activity.mainLooper)
        h.post {
            myUnit()
        }
    }





}