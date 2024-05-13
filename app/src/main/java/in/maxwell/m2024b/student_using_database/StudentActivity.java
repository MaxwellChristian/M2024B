package in.maxwell.m2024b.student_using_database;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.maxwell.m2024b.R;

public class StudentActivity extends AppCompatActivity {

    RecyclerView rvStudentList;

    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("StudentActivity", "onCreate: started.");

        setContentView(R.layout.activity_student);
        Log.d("StudentActivity", "onCreate: content loaded.");

        rvStudentList = findViewById(R.id.rvStudentList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(StudentActivity.this);
        rvStudentList.setLayoutManager(layoutManager);

        DBHelper dbHelper = new DBHelper(StudentActivity.this);

        // add some testing records to the database
//        dbHelper.addStudent(new Student("1", "-Maxwell-", "Christian", 1, "Regina"));
//        dbHelper.addStudent(new Student("2", "-Alex-", "Wang", 1, "Regina"));
//        dbHelper.addStudent(new Student("3", "-Christa-", "Wunsch", 0, "Regina"));

        ArrayList<Student> alStudents = dbHelper.getAllStudents();

        studentAdapter = new StudentAdapter(alStudents);
        rvStudentList.setAdapter(studentAdapter);

    }
}