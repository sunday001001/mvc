package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping put"
    }

    @PutMapping("/put-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserResponse {

        // response
        return UserResponse().apply {
            // result
            this.result = Result().apply {
                this.resultCode = "ok"
                this.resultMessage = "success"
            }
        }.apply {
            // description
            this.description = "description"
        }.apply {
            // user mutable list
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name="a"
                this.age=10
                this.email="test1@test.com"
                this.address="seoul"
                this.phoneNumber="01011112222"
            })
            userList.add(UserRequest().apply {
                this.name="b"
                this.age=11
                this.email="test1@test.com"
                this.address="seoul"
                this.phoneNumber="01011112222"
            })

            this.userRequest = userList
        }

    }
}