package shishirappstudio.com.searchviewinactionbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shishir on 11/07/2018.
 */

public class StudentAdapter extends BaseAdapter implements Filterable {

    private Context context;
    private ArrayList<Student> studentArrayList;
    private ArrayList<Student> mStudentList;
    private LayoutInflater inflater;
    private ValueFilter valueFilter;

    public StudentAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
        this.mStudentList = studentArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    static class ViewHolder {
        private TextView studentNameTv, studentAddressTv;

        public ViewHolder(View view) {
            studentNameTv = view.findViewById(R.id.studentNameTv);
            studentAddressTv = view.findViewById(R.id.studentAddressTv);
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.student_row, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.studentNameTv.setText(studentArrayList.get(position).getName());
        holder.studentAddressTv.setText(studentArrayList.get(position).getAddress());

        return view;
    }

    class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if (charSequence != null && charSequence.length() > 0) {
                ArrayList<Student> filteredStudentList = new ArrayList<>();

                for (int i = 0; i < mStudentList.size(); i++) {
                    if ((mStudentList.get(i).getName().toLowerCase()).contains(charSequence.toString().toLowerCase()) ||
                            mStudentList.get(i).getAddress().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredStudentList.add(mStudentList.get(i));
                    }
                }
                results.count = filteredStudentList.size();
                results.values = filteredStudentList;
            } else {
                synchronized (this) {
                    results.count = mStudentList.size();
                    results.values = mStudentList;
                }
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            studentArrayList = (ArrayList<Student>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
