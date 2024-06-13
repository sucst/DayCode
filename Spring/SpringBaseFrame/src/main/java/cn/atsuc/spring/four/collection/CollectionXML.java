package cn.atsuc.spring.four.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author csuporg
 * @data 2024/5/7 22:49
 * @email s202011105851@163.com
 * @description
 */
public class CollectionXML {

    private String[] str;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> sets;

    // course
    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    public void setStr(String[] str) {
        this.str = str;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void testOut() {
        System.out.println("str: " + Arrays.toString(str));
        System.out.println("list: " + list);
        System.out.println("map: " + map);
        System.out.println("sets: " + sets);
        System.out.println("courseList: " + courseList);
    }
}
