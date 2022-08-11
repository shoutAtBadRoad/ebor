package com.hu.model;

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
@TableName("iuser")
public class User {

    /**
     * 用戶id
     */
    @TableId(value = "id")
    private long userid;

    /**
     * 用戶名
     */
    private String username;

    /**
     * 密碼
     */
    private String password;

}
