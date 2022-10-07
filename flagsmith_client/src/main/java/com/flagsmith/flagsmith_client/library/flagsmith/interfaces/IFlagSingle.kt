package com.flag.android.flagsmith.interfaces

import com.flag.android.flagsmith.response.ResponseFlagElement

interface IFlagSingle {

    fun success( flag:   ResponseFlagElement );
    fun failed(str : String );

}