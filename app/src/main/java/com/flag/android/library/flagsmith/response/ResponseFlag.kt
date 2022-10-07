package com.flag.android.flagsmith.response

import com.google.gson.annotations.SerializedName


//typealias ResponseFlagAlias = ArrayList<ResponseFlagElement>

data class ResponseFlagElement (
    val id: Long,
    val feature: Feature,
    val featureStateValue: String,
    val environment: Long,
    val identity: Any? = null,
    val featureSegment: Any? = null,
    val enabled: Boolean
)

data class Feature (
    val id: Long,
    val name: String,
    @SerializedName(value="created_date") val createdDate: String,
    val description: String,
    @SerializedName(value="initial_value")  val initialValue: String,
    @SerializedName(value="default_enabled") val defaultEnabled: Boolean,
    val type: String
)

/*
  @SerializedName(value="name1", alternate={"name2", "name3"})
 */

/**
[
{
"id": 156900,
"feature": {
"id": 29637,
"name": "idabdo",
"created_date": "2022-09-22T19:59:44.278732Z",
"description": "decriptionAbdo",
"initial_value": "valueAbdo1",
"default_enabled": false,
"type": "STANDARD"
},
"feature_state_value": "valueAbdo1",
"environment": 19938,
"identity": null,
"feature_segment": null,
"enabled": true
},
{
"id": 156902,
"feature": {
"id": 29638,
"name": "idabdo2",
"created_date": "2022-09-22T20:00:13.434377Z",
"description": "descriptionAbdo2",
"initial_value": "valueAbdo2",
"default_enabled": false,
"type": "STANDARD"
},
"feature_state_value": "valueAbdo2",
"environment": 19938,
"identity": null,
"feature_segment": null,
"enabled": false
}
]
 */