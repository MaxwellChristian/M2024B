package in.maxwell.m2024b.person_demo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.maxwell.m2024b.R;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private final ArrayList<Person> personList;

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    private Person selectedPerson;

    public PersonAdapter(ArrayList<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {

        holder.tvFirstLetter.setText(personList.get(position).getFirstName().charAt(0) + "");
        holder.tvFirstName.setText(personList.get(position).getFirstName());
        holder.tvLastName.setText(personList.get(position).getLastName());

        holder.itemView.setOnLongClickListener(v -> {

            Log.d("Person Adapter", "in long click");

            selectedPerson = personList.get(position);

            // MUST return FALSE
            // (to see the context menu)
            return false;
        });

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void removePerson(Person personToRemove) {

        int positionRemoved = personList.indexOf(personToRemove);

        personList.remove(personToRemove);

        // notifyDataSetChanged();
        notifyItemRemoved(positionRemoved);

        Log.d("After remove", "Total persons: " + personList.size());
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView tvFirstLetter;
        TextView tvFirstName;
        TextView tvLastName;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFirstLetter = itemView.findViewById(R.id.tvFristLetter);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
        }
    }
}
