package in.maxwell.m2024b.person_demo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_person);

        rvPersonList = findViewById(R.id.rvPersonList);
        rvPersonList.setLayoutManager(new LinearLayoutManager( PersonActivity.this));
        registerForContextMenu(rvPersonList);

        personList = new ArrayList<>();
        personList.add(new Person("Maxwell", "Christian"));
        personList.add(new Person("Alex", "Wang"));
        personList.add(new Person("Christa", "Wunsch"));

        personAdapter = new PersonAdapter(personList);
        rvPersonList.setAdapter(personAdapter);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.person_record_operations, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if( item.getItemId() == R.id.cmiPersonEdit ){
            // edit the person
            Log.d("Context menu", "Edit selected");
        }

        if( item.getItemId() == R.id.cmiPersonRemove ){
            // remove the person after confirmation
            Log.d("Context menu", "Remove selected");

            confirmRemove();
        }

        return super.onContextItemSelected(item);
    }

    private void confirmRemove() {

        AlertDialog alertDialog = new AlertDialog.Builder(PersonActivity.this).create();

        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("Sure to remove?");

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", (dialog, which) -> {});

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", (dialog, which) -> {
            Person personToRemove = personAdapter.getSelectedPerson();
            Log.d("Remove", "Person to remove: " + personToRemove);

            personAdapter.removePerson(personToRemove);
        });

        alertDialog.show();

    }
}