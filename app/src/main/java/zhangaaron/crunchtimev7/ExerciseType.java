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
    // update the value of this ExerciseType to reflect the new calories burned for the entire thing
    void updateExerciseValue(ExerciseType other) {
        double cal = other.value * other.caloriePerUnit;
        this.value = cal / caloriePerUnit;
    }
}