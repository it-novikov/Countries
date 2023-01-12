package com.itnovikov.countries.core.bases

interface Mapper<T, R> {
    fun map(data : T) : R
}