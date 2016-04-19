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


public class Renew_Membership extends ActionBarActivity implements View.OnClickListener {

    private EditText et_startdate;
    private DatePicker dpResult;
   Button b_datepicker;
    private int year;
    private int month;
    private int day;
    private AutoCompleteTextView auto_membername;
    String[] all_members = {"Raja", "Prakhar", "Rishabh Sinha", "Rishabh Agarwal"};
    ToggleButton tmo, ttu, twe, tth, tfr, tsa, tsu;
    EditText discount, extra_charges, total_charges;
    Button renew_membership;
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
        setContentView(R.layout.activity_renew__membership);
  initialize();
        setCurrentDateOnView();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, all_members);
        auto_membername.setAdapter(adapter);
        auto_membername.setThreshold(1);


        extra_charges.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int extra = Integer.parseInt(extra_charges.getText().toString());
                int dis_count = Integer.parseInt(discount.getText().toString());
                int to_tal = extra + dis_count;

                total_charges.setText(to_tal);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int extra = Integer.parseInt(extra_charges.getText().toString());
                int dis_count = Integer.parseInt(discount.getText().toString());
                int to_tal = extra + dis_count;

                total_charges.setText(to_tal);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int extra = Integer.parseInt(extra_charges.getText().toString());
                int dis_count = Integer.parseInt(discount.getText().toString());
                int to_tal = extra + dis_count;

                total_charges.setText(to_tal);

            }
        });
        discount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int extra = Integer.parseInt(extra_charges.getText().toString());
                int dis_count = Integer.parseInt(discount.getText().toString());
                int to_tal = extra + dis_count;

                total_charges.setText(to_tal);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int extra = Integer.parseInt(extra_charges.getText().toString());
                int dis_count = Integer.parseInt(discount.getText().toString());
                int to_tal = extra + dis_count;

                total_charges.setText(to_tal);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int extra = Integer.parseInt(extra_charges.getText().toString());
                int dis_count = Integer.parseInt(discount.getText().toString());
                int to_tal = extra + dis_count;

                total_charges.setText(to_tal);

            }
        });


        c_activity.setPrompt("Select Activity");


        lv = (ListView) findViewById(R.id.listView1);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        navdrawer = (DrawerLayout) findViewById(R.id.navdrawer);
        abdt = new ActionBarDrawerToggle(Renew_Membership.this, navdrawer, 0, 0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent a = new Intent(Renew_Membership.this, HomePage.class);
                        startActivity(a);

                        break;
                    case 1:
                        Intent b = new Intent(Renew_Membership.this, Add_Member.class);
                        startActivity(b);

                        break;
                    case 2:
                        Intent c = new Intent(Renew_Membership.this, New_Membership.class);
                        startActivity(c);

                        break;
                    case 3:
                        Intent d = new Intent(Renew_Membership.this, All_Members.class);
                        startActivity(d);

                        break;
                    case 4:
                        Intent e = new Intent(Renew_Membership.this, User_info.class);
                        startActivity(e);

                        break;
                    case 5:
                        Intent g1 = new Intent(Renew_Membership.this, User_Change_Password.class);
                        startActivity(g1);
                        break;
                    case 6:
                        Intent g = new Intent(Renew_Membership.this, LoginActivity.class);
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
        auto_membername = (AutoCompleteTextView) findViewById(R.id.auto_renew_membername);
        c_activity = (Spinner) findViewById(R.id.sp_renew_choose_membership_type);
        c_memebershiptype = (Spinner) findViewById(R.id.sp_renew_choose_activity);
        et_startdate = (EditText) findViewById(R.id.et_renewmembership_startdate);
        extra_charges = (EditText) findViewById(R.id.et_renewmembership_extracharges);
        b_datepicker = (Button) findViewById(R.id.bt_renewmembership_datepicker);
        discount = (EditText) findViewById(R.id.et_renewmembership_discount);
        total_charges = (EditText) findViewById(R.id.et_renewmembership_totalcharge);
        renew_membership = (Button) findViewById(R.id.b_renewmembership_membership);
        tmo = (ToggleButton) findViewById(R.id.tb_renewmembership_mon);
        ttu = (ToggleButton) findViewById(R.id.tb_renewmembership_tue);
        twe = (ToggleButton) findViewById(R.id.tb_renewmembership_wed);
        tth = (ToggleButton) findViewById(R.id.tb_renewmembership_thu);
        tfr = (ToggleButton) findViewById(R.id.tb_renewmembership_fri);
        tsa = (ToggleButton) findViewById(R.id.tb_renewmembership_sat);
        tsu = (ToggleButton) findViewById(R.id.tb_renewmembership_sun);
       b_datepicker.setOnClickListener(this);
        renew_membership.setOnClickListener(this);
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
          case R.id.bt_renewmembership_datepicker:
              showDialog(DATE_DIALOG_ID);
                break;
            case R.id.b_renewmembership_membership:

                if((!auto_membername.getText().toString().equals(""))){
                    Toast.makeText(getBaseContext(), "Please Fill Member Name Field", Toast.LENGTH_LONG).show();
                }

                else {
                    Intent new_membershipintent = new Intent(Renew_Membership.this, All_Members.class);
                    startActivity(new_membershipintent);
                }
                break;
            case R.id.tb_renewmembership_mon: {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }

                break;
            }
            case R.id.tb_renewmembership_tue: {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_renewmembership_wed:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_renewmembership_thu:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_renewmembership_fri:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_renewmembership_sat:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }

            case R.id.tb_renewmembership_sun:

            {
                if (((ToggleButton) view).isChecked()) {
                } else {
                }
                break;
            }


        }    }

    public void setCurrentDateOnView() {

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview

        // Month is 0 based, just add 1
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
        // set current date into datepicker

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


        return super.onOptionsItemSelected(item);
    }

}