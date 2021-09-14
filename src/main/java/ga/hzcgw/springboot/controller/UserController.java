package ga.hzcgw.springboot.controller;

import com.github.pagehelper.PageInfo;
import ga.hzcgw.springboot.po.User;
import ga.hzcgw.springboot.query.UserQuery;
import ga.hzcgw.springboot.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api(tags = "用户模块 UserController")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "增加用户对象", notes = "参数采用JSON方式")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, paramType = "body")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数错误"),
            @ApiResponse(code = 404, message = "请求路径错误"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PostMapping("/user")
    public int addUser(@Valid User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "根据用户id删除用户对象", notes = "用户id不能为空")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数错误"),
            @ApiResponse(code = 404, message = "请求路径错误"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @DeleteMapping("/user/{id}")
    public int deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

    @ApiOperation(value = "根据用户名id修改用户对象", notes = "用户id不能为空")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, paramType = "body")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数错误"),
            @ApiResponse(code = 404, message = "请求路径错误"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @ApiOperation(value = "根据用户名查询用户对象", notes = "用户名不能为空")
    @ApiImplicitParam(name = "userName", value = "用户名称", required = true, paramType = "path")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数错误"),
            @ApiResponse(code = 404, message = "请求路径错误"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("/user/name/{userName}")
    public User queryUserByUserName(@PathVariable String userName)
    {
        return userService.queryUserByUserName(userName);
    }

    @ApiOperation(value = "根据用户Id查询用户对象", notes = "用户Id不能为空")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, paramType = "path")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数错误"),
            @ApiResponse(code = 404, message = "请求路径错误"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("/user/id/{id}")
    public User queryUserById(@PathVariable Integer id) {
        return userService.queryUserById(id);
    }

    @ApiOperation(value = "查询所有用户对象", notes = "无需输入参数")
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径错误"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("/user")
    public List<User> queryUserAll() throws Exception {
        return userService.queryUserAll();
    }

    @ApiOperation(value = "采用分页根据用户名模糊查询用户对象", notes = "用户名模糊查询条件可以为空")
    @ApiImplicitParam(name = "userQuery", value = "用户查询对象", paramType = "path")
    @GetMapping("/user/list")
    public PageInfo<User> queryUserByParams(UserQuery userQuery) {
        return userService.queryUserByParams(userQuery);
    }

}
