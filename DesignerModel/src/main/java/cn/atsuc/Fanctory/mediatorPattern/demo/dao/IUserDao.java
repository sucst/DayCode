package cn.atsuc.Fanctory.mediatorPattern.demo.dao;


import cn.atsuc.Fanctory.mediatorPattern.demo.po.User;

public interface IUserDao {

     User queryUserInfoById(Long id);

}
