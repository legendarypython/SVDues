package com.sv.rishabhsinha.svdues;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.wrapp.floatlabelededittext.FloatLabeledEditText;

import java.io.FileNotFoundException;
import java.util.Calendar;


public class Add_Member extends ActionBarActivity implements  View.OnClickListener {

    ListView lv;
    FloatLabeledEditText parents_float, address_float, school_float, height_float, weight_float;
    private EditText newmember_name, newmember_email, newmember_mobile, newmember_dob, newmember_parentsname, newmember_address,
            newmember_school, newmember_height, newmember_weight, newmember_registrationfee;
    private DatePicker dpResult;
    private Button newmember_datepicker, newmember_photoupload, newmember_documentupload, newmember_confirmupload, newmember_rejectupload, newmember_confirmmember;

    private int year, cur_year, et_year;
    private int month, cur_month, et_month;
    private int day, cur_day, et_day;

    static final int DATE_DIALOG_ID = 999;

    Toolbar toolbar;
    DrawerLayout navdrawer;
    private ActionBarDrawerToggle abdt;
    String[] navigation_drawer = {"Home", "New Member", "New Membership", "All Membership", "Profile", "Change Password", "Logout"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__member);

        initialize();


        newmember_dob.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    int flag = is_eighteen();
                    if (flag == 0) {
                        newmember_parentsname.setVisibility(View.VISIBLE);
                        newmember_school.setVisibility(View.VISIBLE);
                        newmember_address.setVisibility(View.VISIBLE);
                        newmember_height.setVisibility(View.VISIBLE);
                        newmember_weight.setVisibility(View.VISIBLE);
                        parents_float.setVisibility(View.VISIBLE);
                        address_float.setVisibility(View.VISIBLE);
                        weight_float.setVisibility(View.VISIBLE);
                        height_float.setVisibility(View.VISIBLE);
                        school_float.setVisibility(View.VISIBLE);

                    } else {
                        newmember_parentsname.setVisibility(View.GONE);
                        newmember_school.setVisibility(View.GONE);
                        newmember_address.setVisibility(View.GONE);
                        newmember_height.setVisibility(View.GONE);
                        newmember_weight.setVisibility(View.GONE);
                        parents_float.setVisibility(View.GONE);
                        address_float.setVisibility(View.GONE);
                        weight_float.setVisibility(View.GONE);
                        height_float.setVisibility(View.GONE);
                        school_float.setVisibility(View.GONE);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO Auto-generated method stub

                try {
                    int flag = is_eighteen();
                    if (flag == 0) {
                        newmember_parentsname.setVisibility(View.VISIBLE);
                        newmember_school.setVisibility(View.VISIBLE);
                        newmember_address.setVisibility(View.VISIBLE);
                        newmember_height.setVisibility(View.VISIBLE);
                        newmember_weight.setVisibility(View.VISIBLE);
                        parents_float.setVisibility(View.VISIBLE);
                        address_float.setVisibility(View.VISIBLE);
                        weight_float.setVisibility(View.VISIBLE);
                        height_float.setVisibility(View.VISIBLE);
                        school_float.setVisibility(View.VISIBLE);
                    } else {
                        newmember_parentsname.setVisibility(View.GONE);
                        newmember_school.setVisibility(View.GONE);
                        newmember_address.setVisibility(View.GONE);
                        newmember_height.setVisibility(View.GONE);
                        newmember_weight.setVisibility(View.GONE);
                        parents_float.setVisibility(View.GONE);
                        address_float.setVisibility(View.GONE);
                        weight_float.setVisibility(View.GONE);
                        height_float.setVisibility(View.GONE);
                        school_float.setVisibility(View.GONE);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    int flag = is_eighteen();
                    if (flag == 0) {
                        newmember_parentsname.setVisibility(View.VISIBLE);
                        newmember_school.setVisibility(View.VISIBLE);
                        newmember_address.setVisibility(View.VISIBLE);
                        newmember_height.setVisibility(View.VISIBLE);
                        newmember_weight.setVisibility(View.VISIBLE);
                        parents_float.setVisibility(View.VISIBLE);
                        address_float.setVisibility(View.VISIBLE);
                        weight_float.setVisibility(View.VISIBLE);
                        height_float.setVisibility(View.VISIBLE);
                        school_float.setVisibility(View.VISIBLE);
                    } else {
                        newmember_parentsname.setVisibility(View.GONE);
                        newmember_school.setVisibility(View.GONE);
                        newmember_address.setVisibility(View.GONE);
                        newmember_height.setVisibility(View.GONE);
                        newmember_weight.setVisibility(View.GONE);
                        parents_float.setVisibility(View.GONE);
                        address_float.setVisibility(View.GONE);
                        weight_float.setVisibility(View.GONE);
                        height_float.setVisibility(View.GONE);
                        school_float.setVisibility(View.GONE);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        lv = (ListView) findViewById(R.id.listView1);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        navdrawer = (DrawerLayout) findViewById(R.id.navdrawer);
        abdt = new ActionBarDrawerToggle(Add_Member.this, navdrawer, 0, 0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent a = new Intent(Add_Member.this, HomePage.class);
                        startActivity(a);

                        break;
                    case 1:
                        Intent b = new Intent(Add_Member.this, Add_Member.class);
                        startActivity(b);

                        break;
                    case 2:
                        Intent c = new Intent(Add_Member.this, New_Membership.class);
                        startActivity(c);

                        break;
                    case 3:
                        Intent d = new Intent(Add_Member.this, All_Members.class);
                        startActivity(d);

                        break;
                    case 4:
                        Intent e = new Intent(Add_Member.this, User_info.class);
                        startActivity(e);

                        break;
                    case 5:

                        break;
                    case 6:
                        Intent g = new Intent(Add_Member.this, LoginActivity.class);
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
        newmember_dob = (EditText) findViewById(R.id.et_newmemberdob);
        newmember_name = (EditText) findViewById(R.id.etNew_membername);
        newmember_email = (EditText) findViewById(R.id.etNewmember_email);
        newmember_mobile = (EditText) findViewById(R.id.etNew_membermobile);
        newmember_parentsname = (EditText) findViewById(R.id.et_newmember_parentsname);
        newmember_address = (EditText) findViewById(R.id.et_newmember_address);
        newmember_school = (EditText) findViewById(R.id.et_newmember_school);
        newmember_height = (EditText) findViewById(R.id.et_newmember_height);
        newmember_weight = (EditText) findViewById(R.id.et_newmember_weight);
        newmember_registrationfee = (EditText) findViewById(R.id.et_newmember_registrationfee);
        newmember_photoupload = (Button) findViewById(R.id.b_newmember_photoupload);
        newmember_documentupload = (Button) findViewById(R.id.b_newmember_documentupload);
        newmember_confirmupload = (Button) findViewById(R.id.b_newmember_confirmupload);
        newmember_rejectupload = (Button) findViewById(R.id.b_newmember_rejectupload);
        newmember_confirmmember = (Button) findViewById(R.id.b_newmember_confirmmember);
        newmember_datepicker = (Button) findViewById(R.id.b_newmember_datepicker);
        parents_float = (FloatLabeledEditText) findViewById(R.id.et_newmember_parentsname_float);
        school_float = (FloatLabeledEditText) findViewById(R.id.et_newmember_school_float);
        address_float = (FloatLabeledEditText) findViewById(R.id.et_newmember_address_float);
        height_float = (FloatLabeledEditText) findViewById(R.id.et_newmember_height_float);
        weight_float = (FloatLabeledEditText) findViewById(R.id.et_newmember_weight_float);
        newmember_datepicker.setOnClickListener(this);
        newmember_photoupload.setOnClickListener(this);
        newmember_documentupload.setOnClickListener(this);
        newmember_confirmupload.setOnClickListener(this);
        newmember_rejectupload.setOnClickListener(this);
        newmember_confirmmember.setOnClickListener(this);

    }

    // display current date
    public void getCurrentDateOnView() {

        final Calendar c = Calendar.getInstance();
        cur_year = c.get(Calendar.YEAR);
        cur_month = c.get(Calendar.MONTH);
        cur_day = c.get(Calendar.DAY_OF_MONTH);
        // set selected date into textview
        year = cur_year;
        month = cur_month;
        day = cur_day;
        // newmember_dob.setText(new StringBuilder().append(cur_day).append("-").append(cur_month + 1)
        //     .append("-").append(cur_year)
        //   .append(" "));
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
                newmember_dob.setText(new StringBuilder().append("0").append(day).append("-").append("0").append(month + 1)
                        .append("-").append(year)
                        .append(" "));
            } else if (day > 10 && month < 9) {
                newmember_dob.setText(new StringBuilder().append(day).append("-").append("0").append(month + 1)
                        .append("-").append(year)
                        .append(" "));
            } else if (day < 10 && month > 9) {
                newmember_dob.setText(new StringBuilder().append("0").append(day).append("-").append(month + 1)
                        .append("-").append(year)
                        .append(" "));
            } else {
                newmember_dob.setText(new StringBuilder().append(day).append("-").append(month + 1)
                        .append("-").append(year)
                        .append(" "));
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b_newmember_datepicker:
                showDialog(DATE_DIALOG_ID);


                break;
            case R.id.b_newmember_photoupload:
                LayoutInflater factory = LayoutInflater.from(this);
                final View photodialogview = factory.inflate(
                        R.layout.photoupload_dialog, null);
                final AlertDialog photoDialog = new AlertDialog.Builder(this).create();
                photoDialog.setView(photodialogview);
                photodialogview.findViewById(R.id.b_camera).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //your business logic
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, 0);
                        photoDialog.dismiss();
                    }
                });
                photodialogview.findViewById(R.id.b_gallery).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, 1);
                        photoDialog.dismiss();

                    }
                });

                photoDialog.show();


                break;
            case R.id.b_newmember_documentupload: {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);


                break;
            }
            case R.id.b_newmember_confirmupload:

                break;
            case R.id.b_newmember_rejectupload:
                newmember_photoupload.setBackgroundResource(0);
                newmember_photoupload.setText("Photo Upload");
                newmember_documentupload.setBackgroundResource(0);
                newmember_documentupload.setText("Document Upload");

                newmember_documentupload.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
                newmember_photoupload.setBackgroundColor(Color.GRAY);
                newmember_documentupload.setBackgroundColor(Color.GRAY);
                newmember_documentupload.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                newmember_photoupload.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
                newmember_photoupload.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);


                break;
            case R.id.b_newmember_confirmmember:
                if (!((newmember_name.getText().toString()).equals("")) && (!newmember_mobile.getText().toString().equals(""))) {

                    Intent new_membershipintent = new Intent(Add_Member.this, New_Membership.class);
                    startActivity(new_membershipintent);
                } else {
                    if ((!newmember_name.getText().toString().equals("")) && (newmember_mobile.getText().toString().equals(""))) {
                        Toast.makeText(getBaseContext(), "Please fill Contact field", Toast.LENGTH_LONG).show();
                    } else if ((newmember_name.getText().toString().equals("")) && (!newmember_mobile.getText().toString().equals(""))) {
                        Toast.makeText(getBaseContext(), "Please fill Member Name ", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getBaseContext(), "Please fill Member Name & Contact  ", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (requestCode == 0 && resultCode == RESULT_OK) {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    //  newmember_photoupload.setImageBitmap(photo);
                    newmember_photoupload.setBackground(new BitmapDrawable(getResources(), photo));

                    newmember_photoupload.setText("");
                }
                break;
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri targetUri = data.getData();
                    //  textTargetUri.setText(targetUri.toString());
                    Bitmap bitmap;
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                        // BitmapDrawable bdrawable = new BitmapDrawable(context.getResources(),bitmap);
                        newmember_photoupload.setBackground(new BitmapDrawable(getResources(), bitmap));

                        // newmember_photoupload.setBackgroundDrawable(bdrawable);
                        newmember_photoupload.setText("");

                        newmember_photoupload.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                        newmember_photoupload.setMaxWidth(20);
                        newmember_photoupload.setHeight(200);
                        //   targetImage.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                if (resultCode == RESULT_OK) {
                    Uri targetUri = data.getData();
                    //  textTargetUri.setText(targetUri.toString());
                    Bitmap bitmap;
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                        // BitmapDrawable bdrawable = new BitmapDrawable(context.getResources(),bitmap);
                        newmember_documentupload.setBackground(new BitmapDrawable(getResources(), bitmap));

                        // newmember_photoupload.setBackgroundDrawable(bdrawable);
                        newmember_documentupload.setText("");

                        newmember_documentupload.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);


                        newmember_documentupload.setMaxWidth(20);
                        newmember_documentupload.setHeight(200);
                        //   targetImage.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                break;
        }

    }


    private int is_eighteen() {
        getCurrentDateOnView();
        String set_dob = newmember_dob.getText().toString();
        et_day = Integer.parseInt(set_dob.substring(0, 2));
        et_month = Integer.parseInt(set_dob.substring(3, 5));
        et_year = Integer.parseInt(set_dob.substring(6, 10));
        if (year - et_year > 18) {
            return 1;
        } else if (year - et_year < 18) {
            return 0;
        } else {
            if (month - et_month > 0) {
                return 1;
            } else if (month - et_month < 0) {
                return 0;
            } else {
                if (day - et_day >= 0)
                    return 1;
                else
                    return 0;
            }
        }
    }

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
        if (id == R.id.action_search) {

            Intent i = new Intent(Add_Member.this, Search.class);
            startActivity(i);


        }

        return super.onOptionsItemSelected(item);
    }
}

