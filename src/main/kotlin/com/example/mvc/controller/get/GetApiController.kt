package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController  // 이 Annotation은 REST API Controller 동작을 설정 한다.
@RequestMapping("/api") // rout

class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"])
    fun hello(): String {
        return "hello"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // get rout
    fun pathVariable(@PathVariable name : String, @PathVariable age : Int): String {
        println("${name} , ${age}")
        return name+" "+age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // get rout
    fun pathVariable2(@PathVariable(value = "name") _name : String, @PathVariable(name = "age") _age : Int): String {
        println("${_name} , ${_age}")
        return _name+" "+_age
    }

    //쿼리 파라메터 https://localhost:8080/api/page?key1=value1&key2=value2
    @GetMapping("/get-mapping/query-param") // ?name=value
    fun queryParam(
        @RequestParam name: String,
        @RequestParam(value="age") age: Int
    ): String {
        println("${name} , ${age}")
        return name+" "+age
    }

    //Object mapper 형태로 return 하면 JSON 형태로 return 된다.
    //Kotlin에서는 변수명에 - 을 사용할수 없다.
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    //Map 형태로 return 하면 JSON 형태로 return 된다.
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String, Any> {
        println(map)
        return map
    }

}