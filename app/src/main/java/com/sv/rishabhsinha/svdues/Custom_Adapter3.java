package com.sv.rishabhsinha.svdues;

import android.app.Activity;
import android.content.Intent;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


public class Custom_Adapter3 extends ArrayAdapter<String> {

    String[] sport, renewal, type, startDate, endDate;
    private final Activity context;
    private static LayoutInflater inflater = null;
    public Custom_Adapter3(Activity context, String[] sport, String[] renewal, String[] type, String[] startDate, String[] endDate){

        super(context,R.layout.listitem,sport);
        this.context=context;
        this.sport = sport;
        this.renewal = renewal;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.listitem,null,true);

        final KeyListener KL;

        TextView tvSport = (TextView)rowView.findViewById(R.id.tvSport);
        TextView tvRenewal = (TextView)rowView.findViewById(R.id.tvDTR);
        TextView tvType = (TextView)rowView.findViewById(R.id.tvType);
        TextView tvStartDate = (TextView) rowView.findViewById(R.id.tvStartDate);
        TextView tvEndDate = (TextView) rowView.findViewById(R.id.tvEndDate);
        TextView renew=(TextView)rowView.findViewById(R.id.bRenew);
        final TextView Dues=(TextView)rowView.findViewById(R.id.tvDues);
        final Button edit=(Button)rowView.findViewById(R.id.bEdit);


        renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("com.sv.rishabhsinha.svdues.RENEW_MEMBERSHIP");

                context.startActivity(i);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Dues.setVisibility(View.GONE);
                edues.setVisibility(View.VISIBLE);
                edit.setVisibility(View.GONE);
                Ok.setVisibility(View.VISIBLE);
                edues.setKeyListener(KL);
                edues.requestFocus();
                InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(edues, InputMethodManager.SHOW_IMPLICIT);*/

            }
        });



        tvSport.setText(sport[position]);
        tvRenewal.setText(renewal[position]);
        tvType.setText(type[position]);
        tvStartDate.setText(startDate[position]);
        tvEndDate.setText(endDate[position]);
        return rowView;
    }


}
