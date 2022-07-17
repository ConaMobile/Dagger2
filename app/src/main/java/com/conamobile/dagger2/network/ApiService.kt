package com.conamobile.dagger2.network

import com.conamobile.dagger2.models.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers():Response<List<User>>
}