package com.sv.rishabhsinha.svdues;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;


public class New_Membership extends ActionBarActivity implements View.OnClickListener {

    private EditText et_startdate,et_enddate;
    private DatePicker dpResult;
    private Button b_datepicker;
    private int year;
    private int month;
    private int day;
    int z;
    private AutoCompleteTextView auto_membername;
    String[] all_members = {"Raja", "Prakhar", "Rishabh Sinha", "Rishabh Agarwal"};
    ToggleButton tmo, ttu, twe, tth, tfr, tsa, tsu;
    EditText discount, extra_charges, total_charges;
    Button confirm_membership;
    Spinner c_activity, c_memebershiptype;
    static final int DATE_DIALOG_ID = 999;


    ListView lv;

    Toolbar toolbar;
    DrawerLayout navdrawer;
    private ActionBarDrawerToggle abdt;
    String[] navigation_drawer = {"Home", "New Member", "New Membership", "All Membership", "Profile", "Change Password", "Logout"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__membership);
        initialize();
        setCurrentDateOnView();
        c_memebershiptype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = et_startdate.getText().toString();
                int et_day = Integer.parseInt(str.substring(0, 2));
                int et_month = Integer.parseInt(str.substring(3, 5));
                int et_year = Integer.parseInt(str.substring(6, 10));

                z = i;
                switch (i) {
                    case 0:

                        break;
                    case 1:
                        et_year = et_year + 1;

                        if (et_day < 10 && et_month < 9) {
                            et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else if (et_day > 10 && et_month < 9) {
                            et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else if (et_day < 10 && et_month > 9) {
                            et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else {
                            et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        }
                        break;
                    case 2:
                        if (et_month <= 11) {
                            et_month++;
                        } else {
                            et_month = 1;
                            et_year++;
                        }
                        if (et_day < 10 && et_month < 9) {
                            et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else if (et_day > 10 && et_month < 9) {
                            et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month )
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else if (et_day < 10 && et_month > 9) {
                            et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month )
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else {
                            et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        }

                        break;
                    case 3:
                        if (et_month <= 8) {
                            et_month += 4;

                        } else {
                            et_month = et_month - 8;
                            et_year++;
                        }
                        if (et_day < 10 && et_month < 9) {
                            et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else if (et_day > 10 && et_month < 9) {
                            et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month )
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else if (et_day < 10 && et_month > 9) {
                            et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        } else {
                            et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                    .append("-").append(et_year)
                                    .append(" "));
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, all_members);
        auto_membername.setAdapter(adapter);
        auto_membername.setThreshold(1);

         et_startdate.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{ String str = et_startdate.getText().toString();
                 int et_day = Integer.parseInt(str.substring(0, 2));
                 int et_month = Integer.parseInt(str.substring(3, 5));
                 int et_year = Integer.parseInt(str.substring(6, 10));

                 switch (z) {
                     case 0:

                         break;
                     case 1:
                         et_year = et_year + 1;

                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         }
                         break;
                     case 2:
                         if (et_month <= 11) {
                             et_month++;
                         } else {
                             et_month = 1;
                             et_year++;
                         }
                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         }

                         break;
                     case 3:
                         if (et_month <= 8) {
                             et_month += 4;

                         } else {
                             et_month = et_month - 8;
                             et_year++;
                         }
                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         }
                         break;
                 }}catch (Exception e){
                    e.printStackTrace();
                }
             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{ String str = et_startdate.getText().toString();
                 int et_day = Integer.parseInt(str.substring(0, 2));
                 int et_month = Integer.parseInt(str.substring(3, 5));
                 int et_year = Integer.parseInt(str.substring(6, 10));

                 switch (z) {
                     case 0:

                         break;
                     case 1:
                         et_year = et_year + 1;
                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         }

                         break;
                     case 2:
                         if (et_month <= 11) {
                             et_month++;
                         } else {
                             et_month = 1;
                             et_year++;
                         }
                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         }

                         break;
                     case 3:
                         if (et_month <= 8) {
                             et_month += 4;

                         } else {
                             et_month = et_month - 8;
                             et_year++;
                         }
                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month )
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         }
                         break;
                 }}catch (Exception e){
                    e.printStackTrace();
                }
             }

             @Override
             public void afterTextChanged(Editable editable) {
            try{    String str = et_startdate.getText().toString();
                 int et_day = Integer.parseInt(str.substring(0, 2));
                 int et_month = Integer.parseInt(str.substring(3, 5));
                 int et_year = Integer.parseInt(str.substring(6, 10));

                 switch (z) {
                     case 0:

                         break;
                     case 1:
                         et_year = et_year + 1;

                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         }
                         break;
                     case 2:
                         if (et_month <= 11) {
                             et_month++;
                         } else {
                             et_month = 1;
                             et_year++;
                         }
                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         }

                         break;
                     case 3:
                         if (et_month <= 8) {
                             et_month += 4;

                         } else {
                             et_month = et_month - 8;
                             et_year++;
                         }
                         if (et_day < 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day > 10 && et_month < 9) {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append("0").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else if (et_day < 10 && et_month > 9) {
                             et_enddate.setText(new StringBuilder().append("0").append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         } else {
                             et_enddate.setText(new StringBuilder().append(et_day).append("-").append(et_month)
                                     .append("-").append(et_year)
                                     .append(" "));
                         }
                         break;
                 }}catch (Exception e){
                e.printStackTrace();
            }
             }
         });

        extra_charges.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               settotal();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            settotal();}

            @Override
            public void afterTextChanged(Editable editable) {
           settotal(); }
        });
        discount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             settotal();}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            settotal();}

            @Override
            public void afterTextChanged(Editable editable) {
  settotal();
            }        });


        c_activity.setPrompt("Select Activity");


        lv = (ListView) findViewById(R.id.listView1);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        navdrawer = (DrawerLayout) findViewById(R.id.navdrawer);
        abdt = new ActionBarDrawerToggle(New_Membership.this, navdrawer, 0, 0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent a = new Intent(New_Membership.this, HomePage.class);
                        startActivity(a);

                        break;
                    case 1:
                        Intent b = new Intent(New_Membership.this, Add_Member.class);
                        startActivity(b);

                        break;
                    case 2:
                        Intent c = new Intent(New_Membership.this, New_Membership.class);
                        startActivity(c);

                        break;
                    case 3:
                        Intent d = new Intent(New_Membership.this, All_Members.class);
                        startActivity(d);

                        break;
                    case 4:
                        Intent e = new Intent(New_Membership.this, User_info.class);
                        startActivity(e);

                        break;
                    case 5:
                        Intent g1 = new Intent(New_Membership.this, User_Change_Password.class);
                        startActivity(g1);
                        break;
                    case 6:
                        Intent g = new Intent(New_Membership.this, LoginActivity.class);
                        startActivity(g);
                        finish();

                        break;

                }

            }
        });
        navdrawer.setDrawerListener(abdt);
        abdt.syncState();
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    private void initialize() {
        auto_membername = (AutoCompleteTextView) findViewById(R.id.auto_membername);
        c_activity = (Spinner) findViewById(R.id.sp_choose_activity);
        c_memebershiptype = (Spinner) findViewById(R.id.sp_choose_membership_type);
        et_startdate = (EditText) findViewById(R.id.et_newmembership_startdate);
        et_enddate  =(EditText)findViewById(R.id.et_newmembership_enddate);
        extra_charges = (EditText) findViewById(R.id.et_newmembership_extracharges);
        b_datepicker = (Button) findViewById(R.id.bt_newmembership_datepicker);
        discount = (EditText) findViewById(R.id.et_newmembership_discount);
        total_charges = (EditText) findViewById(R.id.et_newmembership_totalcharge);
        confirm_membership = (Button) findViewById(R.id.b_newmembership_confirmmembership);
        confirm_membership.setBackgroundResource(android.R.drawable.btn_default);
        tmo = (ToggleButton) findViewById(R.id.tb_newmembership_mon);
        ttu = (ToggleButton) findViewById(R.id.tb_newmembership_tue);
        twe = (ToggleButton) findViewById(R.id.tb_newmembership_wed);
        tth = (ToggleButton) findViewById(R.id.tb_newmembership_thu);
        tfr = (ToggleButton) findViewById(R.id.tb_newmembership_fri);
        tsa = (ToggleButton) findViewById(R.id.tb_newmembership_sat);
        tsu = (ToggleButton) findViewById(R.id.tb_newmembership_sun);
        b_datepicker.setOnClickListener(this);
        confirm_membership.setOnClickListener(this);
        tmo.setOnClickListener(this);
        ttu.setOnClickListener(this);
        twe.setOnClickListener(this);
        tth.setOnClickListener(this);
        tfr.setOnClickListener(this);
        tsa.setOnClickListener(this);
        tsu.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_newmembership_datepicker:
                showDialog(DATE_DIALOG_ID);
                break;
            case R.id.b_newmembership_confirmmembership:

                if((!auto_membername.getText().toString().equals(""))){
                    Toast.makeText(getBaseContext(), "Please Fill Member Name Field", Toast.LENGTH_LONG).show();
                }

                else {
                    Intent new_membershipintent = new Intent(New_Membership.this, All_Members.class);
                    startActivity(new_membershipintent);
                }
                break;
            case R.id.tb_newmembership_mon: {

                break;
            }
            case R.id.tb_newmembership_tue: {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_newmembership_wed:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_newmembership_thu:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_newmembership_fri:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_newmembership_sat:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_newmembership_sun:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }


        }
    }

    public void setCurrentDateOnView() {

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview

        if (day < 10 && month < 9) {
            et_startdate.setText(new StringBuilder().append("0").append(day).append("-").append("0").append(month + 1)
                    .append("-").append(year)
                    .append(" "));
        } else if (day > 10 && month < 9) {
            et_startdate.setText(new StringBuilder().append(day).append("-").append("0").append(month + 1)
                    .append("-").append(year)
                    .append(" "));
        } else if (day < 10 && month > 9) {
            et_startdate.setText(new StringBuilder().append("0").append(day).append("-").append(month + 1)
                    .append("-").append(year)
                    .append(" "));
        } else {
            et_startdate.setText(new StringBuilder().append(day).append("-").append(month + 1)
                    .append("-").append(year)
                    .append(" "));
        }

        // Month is 0 based, just add 1

        // set current date into datepicker

    }
public void settotal(){
    try{ String discount1="",extra1="";
        if(extra_charges.getText().toString().equals("")&& !discount.getText().toString().equals("")){
            int extra=0;
            int dis_count=0;
             int to_tal = extra -dis_count;

            Log.d("LOOOK HERERE", "red" + to_tal);
            total_charges.setText(""+to_tal);
        }else if(!extra_charges.getText().toString().equals("")&& !discount.getText().toString().equals("")){
            int extra=0;
            extra= Integer.parseInt(extra_charges.getText().toString());
            int dis_count=0;
            dis_count= Integer.parseInt(discount.getText().toString());

            int to_tal = extra -dis_count;

            Log.d("LOOOK HERERE","red"+ to_tal);
            total_charges.setText(""+to_tal);
        }else if(extra_charges.getText().toString().equals("")&& discount.getText().toString().equals("")){
            int extra=0;
            int dis_count=0;

            int to_tal = extra -dis_count;

            Log.d("LOOOK HERERE","red"+ to_tal);
            total_charges.setText(""+to_tal);
        }else if(!extra_charges.getText().toString().equals("")&& discount.getText().toString().equals("")){

            int extra=0;
            extra= Integer.parseInt(extra_charges.getText().toString());
            int dis_count=0;
            int to_tal = extra -dis_count;

            Log.d("LOOOK HERERE","red"+ to_tal);
            total_charges.setText(""+to_tal);}

        int extra=0;
        extra= Integer.parseInt(extra_charges.getText().toString());
        int dis_count=0;
        dis_count= Integer.parseInt(discount.getText().toString());
        int to_tal = extra -dis_count;

        Log.d("LOOOK HERERE","red"+ to_tal);
        total_charges.setText(""+to_tal);}
    catch(Exception e){ e.printStackTrace();}
}

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            if (day < 10 && month < 9) {
                et_startdate.setText(new StringBuilder().append("0").append(day).append("-").append("0").append(month + 1)
                        .append("-").append(year)
                        .append(" "));
            } else if (day > 10 && month < 9) {
                et_startdate.setText(new StringBuilder().append(day).append("-").append("0").append(month + 1)
                        .append("-").append(year)
                        .append(" "));
            } else if (day < 10 && month > 9) {
                et_startdate.setText(new StringBuilder().append("0").append(day).append("-").append(month + 1)
                        .append("-").append(year)
                        .append(" "));
            } else {
                et_startdate.setText(new StringBuilder().append(day).append("-").append(month + 1)
                        .append("-").append(year)
                        .append(" "));
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all__members, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.action_search) {

            Intent i = new Intent(New_Membership.this, Search.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}