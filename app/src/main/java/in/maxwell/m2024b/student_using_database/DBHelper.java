package in.maxwell.m2024b.student_using_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context) {
        this(context, "dbStudents", null, 1);
        Log.d("DBHelper", "constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create all required tables

        // create the query for the table
        String query = "";
        query = "CREATE TABLE tblStudents " +
                "( " +
                "studentID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "studentFirstName TEXT, " +
                "studentLastName TEXT, " +
                "studentGender INTEGER, " +
                "studentCity TEXT" +
                ")";

        Log.d("DBHelper", "query: " + query);

        // execute the query
        db.execSQL(query);
        Log.d("DBHelper", "table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // drop the existing tables

        // create new tables (using onCreate)

    }

    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> alStudents = new ArrayList<>();

        // create a reference to the database (readable)
        SQLiteDatabase db = getReadableDatabase();

        // fetch all records from the table
        // Cursor resultSet = db.query("tblStudents", null, null, null, null, null, null);
        Cursor resultSet = db.query("tblStudents", new String[]{"studentID", "studentFirstName", "studentLastName"}, null, null, null, null, null);

        // store each records to appropriate object
        while (resultSet.moveToNext()) {
            String studentID = resultSet.getString(0);
            String studentFirstName = resultSet.getString(1);
            String studentLastName = resultSet.getString(2);

            Student student = new Student();
            student.setStudentId(studentID);
            student.setStudentFirstName(studentFirstName);
            student.setStudentLastName(studentLastName);

            // add to the collection
            alStudents.add(student);
        }

        // return the collection of objects

        return alStudents;
    }

    public long addStudent(Student student) {

        // create a reference to the database (writable)
        SQLiteDatabase db = getWritableDatabase();

        // create the key-value pair for the record
        ContentValues values = new ContentValues();
        values.put("studentID", student.getStudentId());
        values.put("studentFirstName", student.getStudentFirstName());
        values.put("studentLastName", student.getStudentLastName());

        // store the key-value pair to the table
        return db.insert("tblStudents", null, values);
    }

    public void removeStudent(Student selectedStudent) {

        String query = "DELETE FROM tblStudents " +
                "WHERE studentID = " + selectedStudent.getStudentId();

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);

    }

    public void editStudent(Student studentToEdit) {

        // have an update query to update the record in the table

    }
}


















