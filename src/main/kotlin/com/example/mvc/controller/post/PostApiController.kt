package com.example.mvc.controller.post

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController  // 이 Annotation은 REST API Controller 동작을 설정 한다.
@RequestMapping("/api") // rout
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    //request-mapping 주소를 사용해도 메소드가 달라서 충돌이 발생 하지 않음.
    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }
}