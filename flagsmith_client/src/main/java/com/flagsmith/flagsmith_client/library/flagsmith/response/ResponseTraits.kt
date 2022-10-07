package com.flag.android.flagsmith.response

data class ResponseTraits (
//    val flags: List<Flag>,
    val traits: ArrayList<Trait>
)

//data class Flag (
//    val id: Long,
//    val feature: Feature,
//    val featureStateValue: String,
//    val environment: Long,
//    val identity: Any? = null,
//    val featureSegment: Any? = null,
//    val enabled: Boolean
//)
//
//data class Feature (
//    val id: Long,
//    val name: String,
//    val createdDate: String,
//    val description: String,
//    val initialValue: String,
//    val defaultEnabled: Boolean,
//    val type: String
//)

data class Trait (
    val id: Long,
    val trait_key: String,
    val trait_value: String
)

/**
"traits": [
{
"id": 70489069,
"trait_key": "tempor_laboris",
"trait_value": "id sit aliquip vo"
}
]
 */