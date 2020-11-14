package com.zut.springCloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*json的封装实体*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
  private Integer code;
  private String message;
  private T data; //便于信息在前端页面展示

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
