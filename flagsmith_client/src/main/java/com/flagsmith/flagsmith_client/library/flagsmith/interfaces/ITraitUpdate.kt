package com.flag.android.flagsmith.interfaces

import com.flag.android.flagsmith.response.ResponseTraitUpdate

interface ITraitUpdate {

    fun success( response:   ResponseTraitUpdate );
    fun failed(str : String );

}