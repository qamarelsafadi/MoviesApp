package com.qamar.data.utils

import com.qamar.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow

fun <E> handleSuccess(data: E?, message: String? = ""): MutableStateFlow<Resource<E>> {
    return MutableStateFlow(
        Resource.Success(
            data,
            message = message
        )
    )
}