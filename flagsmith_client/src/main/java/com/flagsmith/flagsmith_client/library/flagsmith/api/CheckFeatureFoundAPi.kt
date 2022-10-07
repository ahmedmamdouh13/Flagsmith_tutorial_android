package com.flag.android.flagsmith.api

//import android.content.Context
import com.flag.android.flagsmith.builder.FlagsmithBuilder
import com.flag.android.flagsmith.interfaces.IFeatureFoundChecker
import com.flag.android.flagsmith.interfaces.IFlagArrayResult
import com.flag.android.flagsmith.interfaces.IFlagSingle
import com.flag.android.flagsmith.response.ResponseFlagElement

class CheckFeatureFoundAPi( builder: FlagsmithBuilder, searchText : String, finish: IFeatureFoundChecker) {

//    var context : Context;
    var builder: FlagsmithBuilder;
    var searchText : String;
    var finish : IFeatureFoundChecker;

    init {
//        this.context = context;
        this.searchText = searchText;
        this.finish = finish;
        this.builder = builder;

        startAPI();
    }


    private fun startAPI() {
        GetFeatureByIdAPi(   builder, searchText, object : IFlagSingle{
            override fun success( m: ResponseFlagElement ) {

                 finish.found()
            }

            override fun failed(str: String) {
                finish.notFound()
            }

        });
    }




}