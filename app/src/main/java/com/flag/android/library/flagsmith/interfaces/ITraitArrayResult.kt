package com.flag.android.flagsmith.interfaces

import com.flag.android.flagsmith.response.ResponseFlagElement
import com.flag.android.flagsmith.response.Trait

interface ITraitArrayResult {

    fun success( list: ArrayList<Trait>);
    fun failed(str : String );

}