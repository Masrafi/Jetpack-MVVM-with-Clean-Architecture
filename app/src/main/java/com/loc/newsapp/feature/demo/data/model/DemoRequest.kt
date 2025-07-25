package com.loc.newsapp.feature.demo.data.model

import com.loc.newsapp.feature.demo.domain.entities.Response

data class DemoResponse(
    val errors: List<Error>,
    val response: Response,
    val success: Boolean
)

/// body for api call
data class DemoRequest(
    val name: String,
    val email: String,
    val age: Int
)
