package in.maxwell.m2024b.person_demo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.maxwell.m2024b.R;

public class PersonActivity extends AppCompatActivity {

    RecyclerView rvPersonList;

    ArrayList<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_person);

        rvPersonList = findViewById(R.id.rvPersonList);
        rvPersonList.setLayoutManager(new LinearLayoutManager( PersonActivity.this));

        personList = new ArrayList<>();
        personList.add(new Person("Maxwell", "Christian"));
        personList.add(new Person("Alex", "Wang"));
        personList.add(new Person("Christa", "Wunsch"));

        rvPersonList.setAdapter(new PersonAdapter(personList));


    }
}