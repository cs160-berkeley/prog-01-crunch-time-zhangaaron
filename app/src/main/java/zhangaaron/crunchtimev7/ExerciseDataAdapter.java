package zhangaaron.crunchtimev7;

/**
 * Created by aaron on 2/4/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;
import java.sql.Time;
import java.util.List;

public class ExerciseDataAdapter extends RecyclerView.Adapter<ExerciseDataAdapter.ExerciseViewHolder> {
    private static final String TAG = ExerciseDataAdapter.class.getSimpleName();
    List<ExerciseType> exerciseList;
    private boolean onBind;
    Date last_triggered;


    public ExerciseDataAdapter (List<ExerciseType> exerciseList) {
        last_triggered = new Date();
        this.exerciseList = exerciseList;
    }
    public static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView exerciseName;
        TextView exerciseValue;
        ImageView exercisePhoto;

        ExerciseViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            exerciseName = (TextView)itemView.findViewById(R.id.exercise_name);
            exerciseValue= (TextView)itemView.findViewById(R.id.exercise_value);
            exercisePhoto = (ImageView)itemView.findViewById(R.id.exercise_photo);
//          exerciseValue.setOnFocusChangeListener(new CardListener(, this.getAdapterPosition()));


        }
    }

    public class CardListener implements View.OnFocusChangeListener {
        ExerciseDataAdapter e;
        int pos;

        CardListener(ExerciseDataAdapter e, int pos) {
            this.e = e;
            this.pos = pos;
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus && new Date().getTime() - last_triggered.getTime() > 1000) {
                TextView exercise_value = (TextView) v;
                double new_value = 0.0;
                try {
                    new_value = (double) Float.parseFloat(exercise_value.getText().toString()); //this is terrible and I'm sorry
                } catch (NumberFormatException err) {
                    Log.e(TAG, "Could not parse the editText: " + exercise_value.getText().toString());
                }
                e.exerciseList.get(pos).value = new_value;
                Log.e(TAG, "New value is ");
                e.updateAllExercises(pos);
                last_triggered = new Date();

            }
            else {
                Log.e(TAG, "LOSE FOCUS!");
            }
        }
    }

    public class ExerciseValueWatcher implements TextWatcher {

        ExerciseDataAdapter e;
        int pos;

        ExerciseValueWatcher(ExerciseDataAdapter e, int pos) {
            this.e = e;
            this.pos = pos;
        }

        @Override
        public void onTextChanged(CharSequence c, int start, int before, int count) {
            Log.d(TAG, "DO NOTHING");
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d(TAG, "DO something");
            double newVal = Double.parseDouble(s.toString());
            e.exerciseList.get(pos).value = newVal;
            e.updateAllExercises(pos);

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Sauce: http://stackoverflow.com/questions/8063439/android-edittext-finished-typing-event
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        ExerciseViewHolder exercise = new ExerciseViewHolder(v);
        return exercise;
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder exerciseView, int i) {
        exerciseView.exerciseName.setText(exerciseList.get(i).name);
        exerciseView.exerciseValue.setText(new Double(exerciseList.get(i).value).toString());
        exerciseView.exercisePhoto.setImageResource(exerciseList.get(i).photoID);
        Log.e(TAG, String.format("Bind %d as exercise %s", i, exerciseList.get(i).name));
        exerciseView.exerciseValue.setOnFocusChangeListener(new CardListener(this, i));
//        exerciseView.exerciseValue.addTextChangedListener(new ExerciseValueWatcher(this, i));

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    //call update on all exercises to   reflect change in exercise value
    void updateAllExercises(int exerciseIndex) {
        ExerciseType updated_exercise = exerciseList.get(exerciseIndex);
        for (ExerciseType exer : exerciseList) {
            exer.updateExerciseValue(updated_exercise);
        }
        Log.e(TAG, "CALLED NOTIFY DATASET CHANGED ON " + Integer.toString(exerciseIndex));
        if (new Date().getTime() - last_triggered.getTime() > 1000 ) {
            notifyDataSetChanged();
            last_triggered = new Date();
        }
    }
}