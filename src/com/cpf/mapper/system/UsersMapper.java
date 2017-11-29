package com.cpf.mapper.system;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.Users;

public interface UsersMapper {
   Users login(@Param("account") String account,@Param("password") String password);
   
   Users regester(@Param("account") String account,@Param("password") String password);
    
}