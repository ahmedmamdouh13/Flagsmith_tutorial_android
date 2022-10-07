package com.flag.android.flagsmith.response

data class ResponseTraitUpdate (
    val identity: Identity,
    val traitValue: String,
    val traitKey: String
)

data class Identity (
    val identifier: String
)
