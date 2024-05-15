package in.maxwell.m2024b.student_using_database;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.maxwell.m2024b.R;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private final ArrayList<Student> alstudents;
    private Student selectedStudent;

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public StudentAdapter(ArrayList<Student> alStudents) {
        this.alstudents = alStudents;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

        holder.tvStudentID.setText(alstudents.get(position).getStudentId());
        holder.tvStudentName.setText(String.format("%s %s", alstudents.get(position).getStudentFirstName(), alstudents.get(position).getStudentLastName()));

        if( alstudents.get(position).isUpdated() ){
            holder.tvStudentID.setTextColor(Color.GREEN);
        }

        holder.itemView.setOnLongClickListener(v -> {

            selectedStudent = alstudents.get(position);

            return false;
        });

    }

    @Override
    public int getItemCount() {
        return alstudents.size();
    }

    public void removeStudent(Student selectedStudent) {
        alstudents.remove(selectedStudent);
        notifyDataSetChanged();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView tvStudentID;
        TextView tvStudentName;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvStudentID = itemView.findViewById(R.id.tvStudentId);
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
        }
    }
}
