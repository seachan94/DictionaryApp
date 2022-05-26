package com.nocompany.data.mapper


//DB 사용시 필요
interface Mapper<From,To> {
    fun From.mapToDomainModel() : To
    fun To.mapFromDomainModel() : From
}