package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController  // 이 Annotation은 REST API Controller 동작을 설정 한다.
@RequestMapping("/api") // rout
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    //request-mapping 주소를 사용해도 Method가 달라서 충돌이 발생 하지 않음.
    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    //object mapper
    //json to object
    //object to json
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }
}