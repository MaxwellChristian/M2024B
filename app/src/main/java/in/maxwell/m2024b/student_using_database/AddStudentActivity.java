package in.maxwell.m2024b.student_using_database;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import in.maxwell.m2024b.R;

public class AddStudentActivity extends AppCompatActivity {

    EditText etStudentID;
    EditText etStudentFirstName;
    EditText etStudentLastName;

    Button btnAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_student);

        etStudentID = findViewById(R.id.etStudentID);
        etStudentFirstName = findViewById(R.id.etStudentFirstName);
        etStudentLastName = findViewById(R.id.etStudentLastName);

        btnAddStudent = findViewById(R.id.btnAddStudentRecord);

        btnAddStudent.setOnClickListener(v -> {
            String studentID = etStudentID.getText().toString();
            String studentFirstName = etStudentFirstName.getText().toString();
            String studentLastName = etStudentLastName.getText().toString();

            Student student = new Student();
            student.setStudentId(studentID);
            student.setStudentFirstName(studentFirstName);
            student.setStudentLastName(studentLastName);

            DBHelper dbHelper = new DBHelper(AddStudentActivity.this);
            if( dbHelper.addStudent(student) != -1 ){
                // records added successfully

                // show a toast message
                // return to the previous activity (which ever it is)
                AddStudentActivity.this.finish();
            }
            else {
                // records not added
            }
        });

    }
}

