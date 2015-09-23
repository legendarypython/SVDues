package com.sv.rishabhsinha.svdues;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rishabh sinha on 9/7/2015.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    String[] sport, renewal, type, startDate, endDate;
    private final Activity context;
    private static LayoutInflater inflater = null;
    public CustomAdapter(Activity context, String[] sport, String[] renewal, String[] type, String[] startDate, String[] endDate){

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

        final TextView tvSport = (TextView)rowView.findViewById(R.id.tvSport);
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
                String text = tvSport.getText().toString();
                Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(), Renew_Membership.class);
                i.putExtra("k", text);
                context.startActivity(i);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Access the Textview from holder1 like below
                /*Dues.setVisibility(View.GONE);
                edues.setVisibility(View.VISIBLE);
                edit.setVisibility(View.GONE);
                Ok.setVisibility(View.VISIBLE);
                edues.setKeyListener(KL);
                edues.requestFocus();
                InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(edues, InputMethodManager.SHOW_IMPLICIT);*/
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Dues");
                alertDialog.setMessage("Enter Dues");
                final String pass = "R";
                Dues.setText("red");
                final EditText input = new EditText(getContext());
                //input.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
               /* alertDialog.setIcon(R.drawable.key);*/

                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String dues = input.getText().toString();
                                Dues.setText(dues);
                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
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
