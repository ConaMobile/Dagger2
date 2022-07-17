package com.conamobile.dagger2.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.conamobile.dagger2.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(userEntity: UserEntity)

    @Query("select * from userentity")
    suspend fun getUser(): List<UserEntity>

    @Insert
    suspend fun addAll(list: List<UserEntity>)
}