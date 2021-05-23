package jakmot.com.doggoparadise.domain

import java.io.Serializable

data class Dog(
    val imageUrl: String,
    val name: String,
    val shortDescription: String,
    val longDescription: String,
) : Serializable
