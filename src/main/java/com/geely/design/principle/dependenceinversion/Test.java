package com.geely.design.principle.dependenceinversion;

/**
 * Created by JS
 * 在这个案例中，test是高层，geely是其低层，增加时不应该依赖修改geely，而应该依赖其抽象。
 * v1版本中，直接修改geely，新增课程时需要在其中增加代码；
 * v2版本中，将课程进行抽象，新增的课程实现接口，并传给geely，geely中代码不变
 * v3中，增加了可以注入
 */
public class Test {

    //v1
//    public static void main(String[] args) {
//        Geely geely = new Geely();
//        geely.studyJavaCourse();
//        geely.studyFECourse();
//    }

    //v2
//    public static void main(String[] args) {
//        Geely geely = new Geely();
//        geely.studyImoocCourse(new JavaCourse());
//        geely.studyImoocCourse(new FECourse());
//        geely.studyImoocCourse(new PythonCourse());
//    }

    //v3
//    public static void main(String[] args) {
//        Geely geely = new Geely(new JavaCourse());
//        geely.studyImoocCourse();
//    }
    public static void main(String[] args) {
        Geely geely = new Geely();
        geely.setiCourse(new JavaCourse());
        geely.studyImoocCourse();

        geely.setiCourse(new FECourse());
        geely.studyImoocCourse();

    }


}
