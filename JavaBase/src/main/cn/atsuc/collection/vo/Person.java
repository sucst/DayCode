package cn.atsuc.collection.vo;

/**
 * @author atsuc
 * @date 2024/6/2 21:30
 * @email s202011105851@163.com
 * @description 实体类
 */
public class Person implements Comparable {
    public String name;
    public int age;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age, String code) {
        this.name = name;
        this.age = age;
        this.code = code;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && code.equals(person.code);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + code.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", code='" + code +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person person = (Person) o;
            int compare = -this.name.compareTo(person.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, person.age);
            }
        } else {
            throw new IllegalArgumentException(" Error in compareTo Type");
        }
    }
}
