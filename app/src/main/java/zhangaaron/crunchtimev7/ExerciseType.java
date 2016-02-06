package zhangaaron.crunchtimev7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 2/4/16.
 */
public class ExerciseType {
    String name;
    boolean isReps;
    double caloriePerUnit;
    int photoID;
    double value;

    ExerciseType(String name, boolean isReps, double caloriePerUnit, int photoID) {
        this.name = name;
        this.isReps = isReps;
        this.caloriePerUnit = caloriePerUnit;
        this.photoID = photoID;
        this.value = 0;
    }
}
//
//class Person {
//    String name;
//    String age;
//    int photoId;
//
//    Person(String name, String age, int photoId) {
//        this.name = name;
//        this.age = age;
//        this.photoId = photoId;
//    }
//}
//
//private List<Person> persons;
//
//    // This method creates an ArrayList that has three Person objects
//// Checkout the project associated with this tutorial on Github if
//// you want to use the same images.
//    private void initializeData(){
//        persons = new ArrayList<>();
//        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
//        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
//        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
//    }