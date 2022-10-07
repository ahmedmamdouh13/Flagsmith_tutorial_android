package com.flag.android.flagsmith.interfaces

import com.flag.android.flagsmith.response.ResponseFlagElement

interface IFlagArrayResult {

    fun success( list: ArrayList<ResponseFlagElement>);
    fun failed(str : String );

}