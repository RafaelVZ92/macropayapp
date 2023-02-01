package com.rafaelvelazquez.macropayapp.data.mapper

interface Mapper<I, O> {

    fun map(input: I): O
}