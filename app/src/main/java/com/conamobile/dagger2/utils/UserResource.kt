package com.conamobile.dagger2.utils

import com.conamobile.dagger2.database.entity.UserEntity

sealed class UserResource {

    object Loading : UserResource()

    data class Success(val list: List<UserEntity>) : UserResource()

    data class Error(val message: String) : UserResource()
}