package Items;

import Interface.gather;

public class parentClass implements gather
{
    private int grade;
    private int limitGrade;

    public parentClass(int grade, int limitGrade)
    {
        this.grade = grade;
        this.limitGrade = limitGrade;
    }

    public parentClass(){}

    @Override
    public void move() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void grow() {

    }

    @Override
    public void die() {

    }
}
