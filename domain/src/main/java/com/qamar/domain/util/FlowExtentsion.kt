package com.qamar.domain.util

import kotlinx.coroutines.flow.MutableStateFlow

fun <E> handleSuccess(data: E?, message: String? = ""): MutableStateFlow<Resource<E>> {
    return MutableStateFlow(
        Resource.Success(
            data,
            message = message
        )
    )
}