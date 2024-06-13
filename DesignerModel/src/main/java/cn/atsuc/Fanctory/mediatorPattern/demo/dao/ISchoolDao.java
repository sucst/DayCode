package cn.atsuc.Fanctory.mediatorPattern.demo.dao;


import cn.atsuc.Fanctory.mediatorPattern.demo.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
