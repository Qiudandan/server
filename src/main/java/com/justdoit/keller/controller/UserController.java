package com.justdoit.keller.controller;

import com.justdoit.keller.entity.UserInfo;
import com.justdoit.keller.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *    使用 @RestController 注解将 UserController 类标注为一个 RESTful 格式的控制层
 * 使用 @RequestMapper 注解声明 UserController 类负责处理请求路径为 "/user" 的所有请求
 */
@RestController
@RequestMapping("/user")
public class UserController {
    // 注入业务层组件 UserService
    @Resource
    private UserService userService;

    // 使用 GetMapping 注解，声明 getAll() 方法负责处理请求路径为 "/user" 的 GET 请求
    @GetMapping
    // ResponseEntity 返回的数据类型为标准格式的 HTTP 应答
    public ResponseEntity getAll(){
        List<UserInfo> list = userService.getAll();
        // 返回的 HTTP 应答码为 200 OK
        return ResponseEntity.ok()
                // 返回的 HTTP 内容类型为 JSON 格式
                .contentType(MediaType.APPLICATION_JSON)
                // 将查询到的用户列表放在 HTTP Body 中返回
                .body(list);
    }
}
