package cn.atsuc.Fanctory.Builder;


// 各种套餐组合 MealBuilder.java**（指挥官，核心类）**

public class MealBuilder {
    //套餐一：素食汉堡加可乐
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
    //套餐二：鸡肉汉堡加雪碧
    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
