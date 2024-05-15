package in.maxwell.m2024b.student_using_database;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import in.maxwell.m2024b.R;

public class StudentActivity extends AppCompatActivity {

    RecyclerView rvStudentList;
    FloatingActionButton fabAddStudent;

    private StudentAdapter studentAdapter;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("StudentActivity", "onCreate: started.");

        setContentView(R.layout.activity_student);
        Log.d("StudentActivity", "onCreate: content loaded.");

        fabAddStudent = findViewById(R.id.fabAddStudent);
        fabAddStudent.setOnClickListener(v -> addStudentRecord());

        rvStudentList = findViewById(R.id.rvStudentList);
        registerForContextMenu(rvStudentList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(StudentActivity.this);
        rvStudentList.setLayoutManager(layoutManager);

        dbHelper = new DBHelper(StudentActivity.this);

        // add some testing records to the database
//        dbHelper.addStudent(new Student("1", "-Maxwell-", "Christian", 1, "Regina"));
//        dbHelper.addStudent(new Student("2", "-Alex-", "Wang", 1, "Regina"));
//        dbHelper.addStudent(new Student("3", "-Christa-", "Wunsch", 0, "Regina"));

        ArrayList<Student> alStudents = dbHelper.getAllStudents();

        studentAdapter = new StudentAdapter(alStudents);
        rvStudentList.setAdapter(studentAdapter);

    }

    private void addStudentRecord() {

        Intent addStudentIntent = new Intent(StudentActivity.this, AddStudentActivity.class);
        startActivity(addStudentIntent);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.person_record_operations, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.cmiPersonEdit) {
            Intent editStudentIntent = new Intent(StudentActivity.this, EditStudentActivity.class);
            editStudentIntent.putExtra("student_to_edit", studentAdapter.getSelectedStudent());
            startActivity(editStudentIntent);
            StudentActivity.this.finish();
        }

        if (item.getItemId() == R.id.cmiPersonRemove) {
            dbHelper.removeStudent(studentAdapter.getSelectedStudent());
            studentAdapter.removeStudent(studentAdapter.getSelectedStudent());
        }

        return super.onContextItemSelected(item);
    }
}