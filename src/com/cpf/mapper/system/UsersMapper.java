package com.cpf.mapper.system;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.Users;
import com.cpf.mapper.BaseMapper;

public interface UsersMapper extends BaseMapper<Users, String>{
   Users login(@Param("phonenum") String phonenum,@Param("password") String password);
   
   void regester(Users user);
  
   Users  findUserMsg(String userid);
   
   
}