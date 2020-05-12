package com.jp.boilerplate.data.entity

data class User constructor(val name: String, val age: Int)

typealias Users = List<User>