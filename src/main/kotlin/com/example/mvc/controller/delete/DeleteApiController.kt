package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController  // 이 Annotation은 REST API Controller 동작을 설정 한다.
@RequestMapping("/api") // rout
class DeleteApiController {
    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam name : String,
        @RequestParam age : Int
    ) : String {
        println(name)
        println(age)
        return "$name $age"
    }

    @DeleteMapping("/delete-mapping/name/{name}/age/{age}")
    fun deleteMappingPath(
        @PathVariable(name="name") _name : String,
        @PathVariable(value="age") _age : Int
    ) : String {
        println(_name)
        println(_age)
        return "$_name $_age"
    }
}