package com.example.allinone.data.repositories

interface IRepository<T> {

    suspend fun getAll(): Iterable<T>
    fun getOne() : T
    fun getByID(id:Int) : T?
    fun getByName(name:String) : T?
    fun updateOne(entity : T)
    fun updateMultiple(entities : Iterable<T>)
    fun deleteByID(id:Int)
    suspend fun createOne(entity: T)
    fun createMultiple(entities: Iterable<T>)
}