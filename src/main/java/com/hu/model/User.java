package com.hu.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("sys_user")
public class User {

    /**
     * 用戶id
     */
    @TableId(value = "id")
    private long userid;

    /**
     * 用戶名
     */
    @TableField("user_name")
    private String username;

    @TableField("nick_name")
    private String nickname;

    /**
     * 密碼
     */
    private String password;

}
