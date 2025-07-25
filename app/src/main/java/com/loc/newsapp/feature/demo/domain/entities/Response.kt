package com.loc.newsapp.feature.demo.domain.entities

data class Response(
    val `data`: Data,
    val message: String,
    val pagination: Any
)