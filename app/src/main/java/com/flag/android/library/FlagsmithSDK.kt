package com.flag.android.library

//object FlagsmithSDK {
//
//
//}

/**
val tokenApi: String?,
val environmentId: String?,
val identifierUser: String?
 */
object FlagsmithSDK   {

    var tokenApi: String? = ""
//    var environmentId: String? = ""
//    var identifierUser: String? = ""
//
////    private constructor();

   data class Builder (
       var tokenApi: String
           ){
//        var parent: FlagsmithSDK;
//
//        init {
//            parent = FlagsmithSDK( this )
//        }

        fun setAPIKey( v: String) {
            tokenApi = v;
        }
        // builder code
    }
}