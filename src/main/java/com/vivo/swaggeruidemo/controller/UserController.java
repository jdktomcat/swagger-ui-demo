package com.vivo.swaggeruidemo.controller;

import com.vivo.swaggeruidemo.vo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述：用户控制类
 *
 * @author 汤旗
 * @date 2018-12-21
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    /**
     * 数据存储
     */
    private static Map<Integer, User> USER_DATA = new HashMap<>();

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = {"query"}, method = RequestMethod.GET)
    public List<User> getUserList() {
        return new ArrayList<>(USER_DATA.values());
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        USER_DATA.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        return USER_DATA.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @RequestBody User user) {
        User oldUser = USER_DATA.get(id);
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        USER_DATA.put(id, oldUser);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        USER_DATA.remove(id);
        return "success";
    }
}
