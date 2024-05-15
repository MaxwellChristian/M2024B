package in.maxwell.m2024b.student_using_database;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import in.maxwell.m2024b.R;

public class EditStudentActivity extends AppCompatActivity {

    EditText etStudentId;
    EditText etStudentFirstName;
    EditText etStudentLastName;

    Button btnEditStudent;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        Student studentToEdit = (Student) bundle.getSerializable("student_to_edit");

        setContentView(R.layout.activity_edit_student);

        etStudentId = findViewById(R.id.etEditStudentID);
        etStudentFirstName = findViewById(R.id.etEditStudentFirstName);
        etStudentLastName = findViewById(R.id.etEditStudentLastName);

        btnEditStudent = findViewById(R.id.btnEditStudent);

        assert studentToEdit != null;
        etStudentId.setText(String.valueOf(studentToEdit.getStudentId()));
        etStudentFirstName.setText(studentToEdit.getStudentFirstName());
        etStudentLastName.setText(studentToEdit.getStudentLastName());


        btnEditStudent.setOnClickListener(v -> {
            dbHelper = new DBHelper(EditStudentActivity.this);

            Student student = new Student();
            student.setStudentId(String.valueOf(etStudentId.getText()));
            student.setStudentFirstName(String.valueOf(etStudentFirstName.getText()));
            student.setStudentLastName(String.valueOf(etStudentLastName.getText()));
            student.setUpdated(true);

            dbHelper.editStudent(studentToEdit);

            Intent intent = new Intent(EditStudentActivity.this, StudentActivity.class);
            startActivity(intent);
            this.finish();
        });

    }
}