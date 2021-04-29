package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class) //snake case 파라메터를 찾아 줌.
data class UserRequest(
    var name:String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,

    //naming convention issue
    //camel case : phone_number
    //snake case : phone_number
    //@JsonProperty("phone_number") //@JsonNaming 을 사용하지 않을 경우 각각 지정해서 사용 가능.
    var phoneNumber:String?=null
)