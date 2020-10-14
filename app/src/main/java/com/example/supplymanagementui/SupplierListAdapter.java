package com.example.supplymanagementui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SupplierListAdapter extends BaseAdapter implements Filterable {


    Context c;
    ArrayList<Supplier> originalArray,tmpArray;
    ///filter
    CustomFilter cs;
    ///filter



    public SupplierListAdapter(Context c, ArrayList<Supplier> originalArray){
        this.c = c;
        this.originalArray = originalArray;
        this.tmpArray = originalArray;
    }


    @Override
    public Object getItem(int position) {
        return originalArray.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.supplier_list,null);

        TextView txtS =row.findViewById(R.id.btnSupplier);


        txtS.setText(originalArray.get(position).getName());
        txtS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(c, SelectASalon.class);
//                intent.putExtra("district", originalArray.get(position).getName());
//                intent.putExtra("type", "CUSTOMER");
//                c.startActivity(intent);
                Toast.makeText(c, originalArray.get(position).getName() + " was clicked", Toast.LENGTH_SHORT).show();
//                ((Activity) c).finish();

            }
        });

        return row;
    }

    @Override
    public int getCount() {
        return originalArray.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    ///Codes for filter
    @Override
    public Filter getFilter() {

        if(cs == null){
            cs = new CustomFilter();
        }

        return cs;
    }

    class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();


                ArrayList<Supplier> filters = new ArrayList<>();

                for (int i = 0; i < tmpArray.size(); i++) {
                    if (tmpArray.get(i).getName().toUpperCase().contains(constraint)) {
                        Supplier singleRow = new Supplier(tmpArray.get(i).getName());

                        filters.add(singleRow);
                    }



                }
                results.count = filters.size();
                results.values = filters;

            }else {
                results.count = tmpArray.size();
                results.values = tmpArray;

            }
            return results;
        }


        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            originalArray  = (ArrayList<Supplier>)results.values;
            notifyDataSetChanged();
        }
    }
    ///Codes for filter
}
