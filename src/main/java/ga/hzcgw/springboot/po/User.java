package ga.hzcgw.springboot.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(description = "用户实体类")
public class User implements Serializable {

    @ApiModelProperty(name = "id", value = "用户id")
    private Integer id;
    @ApiModelProperty(name = "userName", value = "用户名称")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(name = "userPwd", value = "用户密码")
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6, max = 10, message = "用户密码长度必须6~10位")
    private String userPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

}
