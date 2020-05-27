package com.soulballad.usage.springboot.controller;

import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/27 20:42
 */
@Controller
@Api(tags = "用户管理接口")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    @ApiOperation("查询所有用户")
    @ResponseBody
    public List<UserModel> list() {
        return userService.findAll();
    }

    @GetMapping(value = "/query/{id}")
    @ApiOperation("查询单个用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, example = "1")
    @ResponseBody
    public UserModel query(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/add")
    @ApiOperation("新增用户")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "用户姓名", required = true, defaultValue = "zhangsan"),
        @ApiImplicitParam(name = "age", value = "用户年龄", required = true, defaultValue = "20"),
        @ApiImplicitParam(name = "birthday", value = "用户生日", required = true, defaultValue = "1990-01-01"),
        @ApiImplicitParam(name = "address", value = "用户住址", required = false, defaultValue = "shanghai"),
        @ApiImplicitParam(name = "phone", value = "用户电话", required = true, defaultValue = "13666666666")})
    public UserModel add(UserModel userModel) {
        return userService.add(userModel);
    }

    @PutMapping(value = "/update")
    @ApiOperation("修改用户")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "用户姓名", required = true, defaultValue = "zhangsan"),
        @ApiImplicitParam(name = "id", value = "用户id", required = true, defaultValue = "2"),
        @ApiImplicitParam(name = "age", value = "用户年龄", required = true, defaultValue = "20"),
        @ApiImplicitParam(name = "birthday", value = "用户生日", required = true, defaultValue = "1990-01-01"),
        @ApiImplicitParam(name = "address", value = "用户住址", required = false, defaultValue = "shanghai"),
        @ApiImplicitParam(name = "phone", value = "用户电话", required = true, defaultValue = "13666666666")})
    public UserModel update(UserModel userModel) {
        return userService.update(userModel);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation("删除用户")
    @ResponseBody
    @ApiImplicitParam(name = "id", value = "用户id", required = true, example = "1")
    public UserModel deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}
