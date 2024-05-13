package in.maxwell.m2024b.student_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import in.maxwell.m2024b.R;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private final ArrayList<Student> alstudents;

    public StudentAdapter(ArrayList<Student> alStudents) {
        this.alstudents = alStudents;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {

        holder.tvStudentID.setText(alstudents.get(position).getStudentId());
        holder.tvStudentName.setText(String.format("%s %s", alstudents.get(position).getStudentFirstName(), alstudents.get(position).getStudentLastName()));

    }

    @Override
    public int getItemCount() {
        return alstudents.size();
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
