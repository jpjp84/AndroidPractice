package com.jp.boilerplate.data.repository

interface UserRepository {
    fun getName(): String

    fun getAge(): Int

    fun isAdult(): Boolean
}