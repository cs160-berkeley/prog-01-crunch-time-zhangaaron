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
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ExerciseDataAdapter extends RecyclerView.Adapter<ExerciseDataAdapter.ExerciseViewHolder> {
    List<ExerciseType> exerciseList;
    public ExerciseDataAdapter (List<ExerciseType> exerciseList) {
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
        }
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        ExerciseViewHolder exercise = new ExerciseViewHolder(v);
        return exercise;
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder exerciseView, int i) {
        exerciseView.exerciseName.setText(exerciseList.get(i).name);
        exerciseView.exerciseValue.setText( new Double(exerciseList.get(i).value).toString());
        exerciseView.exercisePhoto.setImageResource(exerciseList.get(i).photoID);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}