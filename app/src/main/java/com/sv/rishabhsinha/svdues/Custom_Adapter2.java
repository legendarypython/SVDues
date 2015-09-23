package com.sv.rishabhsinha.svdues;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class Custom_Adapter2 extends ArrayAdapter<String> {

    String[] member_name,membership_name,membership_type, startDate,remaining_days;
    private final Activity context;
    private static LayoutInflater inflater = null;
    public Custom_Adapter2(Activity context, String[] member_name, String[] membership_name, String[] membership_type, String[] startDate, String[] remaining_days){

        super(context,R.layout.member_listitem,member_name);
        this.context=context;
        this.member_name = member_name;
        this.membership_name = membership_name;
        this.membership_type = membership_type;
        this.startDate = startDate;
        this.remaining_days = remaining_days;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.member_listitem,null,true);


        TextView tvmembername = (TextView)rowView.findViewById(R.id.tv_membername_list);
        TextView tvmembership_name = (TextView)rowView.findViewById(R.id.tv_membershipname_list);
        TextView tvmembership_type = (TextView)rowView.findViewById(R.id.tv_membershiptype_list);
        TextView tvStartDate = (TextView) rowView.findViewById(R.id.tv_startdate_list);
        TextView tvremaining_days = (TextView) rowView.findViewById(R.id.tv_remainingdays_list);

        tvmembername.setText(member_name[position]);
        tvmembership_name.setText(membership_name[position]);
        tvmembership_type.setText(membership_type[position]);
        tvStartDate.setText(startDate[position]);
        tvremaining_days.setText(remaining_days[position]);
        return rowView;
    }


}
