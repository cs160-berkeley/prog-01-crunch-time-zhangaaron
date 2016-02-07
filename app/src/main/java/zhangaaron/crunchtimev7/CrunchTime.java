package zhangaaron.crunchtimev7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class CrunchTime extends AppCompatActivity {
    private static final String TAG = CrunchTime.class.getSimpleName();
    RecyclerView mRecyclerMain;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crunch_time);
        mRecyclerMain = (RecyclerView)findViewById(R.id.recycler_main);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerMain.setHasFixedSize(true);

        //set grid layout manager
        mLayoutManager = new GridLayoutManager(this, 2); // span count 2
        mRecyclerMain.setLayoutManager(mLayoutManager);

        //populate with some exercises and stuff
        //ExerciseType crunches = new ExerciseType("Crunches", false, 1.5, R.mipmap.ic_launcher);
        ExerciseType pushups = new ExerciseType("Pushup", true, 0.285714286, R.mipmap.ic_launcher);
        ExerciseType squats = new ExerciseType("Squat", true, 0.444444444, R.mipmap.ic_launcher);
        ExerciseType leglift = new ExerciseType("Leg-lift", false, 4.0, R.mipmap.ic_launcher );
        ExerciseType plank = new ExerciseType("Plank", false, 4.0, R.mipmap.ic_launcher);
        ExerciseType jumping_jacks = new ExerciseType("Jumping Jacks", false, 10.0, R.mipmap.ic_launcher);
        ExerciseType pullup = new ExerciseType("Pullup", true, 1.0, R.mipmap.ic_launcher);
        ExerciseType cycling = new ExerciseType("Cycling", false, 8.333333333, R.mipmap.ic_launcher);
        ExerciseType walking = new ExerciseType("Walking", false, 5.0, R.mipmap.ic_launcher);
        ExerciseType jogging = new ExerciseType("Jogging", false, 8.333333333, R.mipmap.ic_launcher);
        ExerciseType swimming = new ExerciseType("Swimming", false, 7.692307692, R.mipmap.ic_launcher);
        List<ExerciseType> _list = new ArrayList<>();
        _list.add(pushups);
        _list.add(squats);
        _list.add(leglift);
        _list.add(plank);
        _list.add(jumping_jacks);
        _list.add(pullup);
        _list.add(cycling);
        _list.add(walking);
        _list.add(jogging);
        _list.add(swimming);

        //set adapter
        mAdapter = new ExerciseDataAdapter(_list);
        mRecyclerMain.setAdapter(mAdapter);

    }
}
