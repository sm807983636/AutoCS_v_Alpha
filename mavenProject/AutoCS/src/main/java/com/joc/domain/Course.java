package com.joc.domain;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    protected int couId;

    @Column(name = "coursename")
    protected String courseName;

    @Column(name = "coursegrade")
    protected int courseGrade;

    @Column(name = "coursemajor")
    protected String courseMajor;

    @Column(name = "coursepeople")
    protected int coursePeople;

    @Column(name = "coursescore")
    protected float courseScore;

    @Column(name = "coursehour")
    protected int courseHour;

    @Column(name = "testhour")
    protected int testHour;     //实验学时

    @Column(name = "practicehour")
    protected int practiceHour;     //上机学时

    @Column(name = "periodid")
    protected int periodId;

    public int getCouId() {
        return couId;
    }

    public void setCouId(int couId) {
        this.couId = couId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getCourseMajor() {
        return courseMajor;
    }

    public void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor;
    }

    public int getCoursePeople() {
        return coursePeople;
    }

    public void setCoursePeople(int coursePeople) {
        this.coursePeople = coursePeople;
    }

    public float getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(float courseScore) {
        this.courseScore = courseScore;
    }

    public int getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(int courseHour) {
        this.courseHour = courseHour;
    }

    public int getTestHour() {
        return testHour;
    }

    public void setTestHour(int testHour) {
        this.testHour = testHour;
    }

    public int getPracticeHour() {
        return practiceHour;
    }

    public void setPracticeHour(int practiceHour) {
        this.practiceHour = practiceHour;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

}
