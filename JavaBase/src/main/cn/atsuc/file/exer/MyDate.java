package cn.atsuc.file.exer;

/**
 * @author atsuc
 * @date 2024/6/9 19:42
 * @email s202011105851@163.com
 * @description
 */
public class MyDate implements Comparable<MyDate>{

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        // compare yeas
        int minusYear = this.getYear() - o.getYear();
        if (minusYear != 0) {
            return minusYear;
        }
        // compare month
        int minusMonth = this.getMonth() - o.getMonth();
        if (minusMonth != 0) {
            return minusMonth;
        }
        return this.getDay() - o.getDay();
    }
}
