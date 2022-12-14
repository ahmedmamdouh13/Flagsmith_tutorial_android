package com.flag.android.flagsmith.builder

//import android.content.Context
import com.flag.android.flagsmith.api.*
import com.flag.android.flagsmith.interfaces.*

//import com.flag.android.flagsmith.response.ResponseFlagAlias


/**
 usage example
 val flagBuilder = FlagsmithBuilder.Builder()
 .tokenApi( Helper.tokenApiKey)
 .environmentId(Helper.environmentDevelopmentKey)
 .identifierUser( Helper.identifierUserKey)
 .build();
 */
class FlagsmithBuilder private constructor(
    val tokenApi: String?,
    val environmentId: String?,
    val identifierUser: String? ) {

    //-------------------------------------------------------- tools

    override fun toString(): String {
        return "tokenApi: " + tokenApi + " /environmentId: " + environmentId + " /identifierUser: " + identifierUser;
    }

    //-------------------------------------------------------- apis

    fun getAllFlag( finish: IFlagArrayResult) {
        GetFlagAllAPi( this, finish);
    }


    fun hasFeatureFlag(  searchText : String, finish: IFeatureFoundChecker) {
        CheckFeatureFoundAPi(   this, searchText, finish)
    }


    fun getAllTrait(  finish: ITraitArrayResult) {
        GetTraitAllAPi(  this, finish)
    }


    fun getFeatureByIdAPi(  searchFeatureId : String, finish: IFlagSingle) {
        GetFeatureByIdAPi(   this, searchFeatureId, finish )
    }


    fun createTrait(  key: String, value: String, finish: ITraitUpdate) {
        CreateTraitAPi(   this, key, value, finish )
    }

    //-------------------------------------------------------- builder

    data class Builder(
        var tokenApi: String? = null,
        var environmentId: String? = null,
        var identifierUser: String? = null ) {

        fun tokenApi(v: String) = apply { this.tokenApi = v }
        fun environmentId(v: String) = apply { this.environmentId = v }
        fun identifierUser(v: String) = apply { this.identifierUser = v }


        fun build(): FlagsmithBuilder {
            return  FlagsmithBuilder(tokenApi, environmentId, identifierUser);
        }

    }
}