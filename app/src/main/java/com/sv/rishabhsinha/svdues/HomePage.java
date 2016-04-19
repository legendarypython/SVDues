package com.sv.rishabhsinha.svdues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class HomePage extends ActionBarActivity {
    String[] s = {"Rishabh", "Prakhar", "Raja", "Pranav"};
    int[] flag = {0, 0, 0, 0};
    Button NewMember,NewMembership,UpcomingRenewals,AllMembership,RenewMemberships, Mark;
    ListView lv;
    AutoCompleteTextView actv ;
    Toolbar toolbar;
    DrawerLayout navdrawer;
    private ActionBarDrawerToggle abdt;
    String[] navigation_drawer = {"Home", "New Member", "New Membership", "All Membership", "Profile", "Change Password", "Logout"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initialize();

        abdt = new ActionBarDrawerToggle(HomePage.this,navdrawer,0,0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent a = new Intent(HomePage.this, HomePage.class);
                        startActivity(a);

                        break;
                    case 1:
                        Intent b = new Intent(HomePage.this, Add_Member.class);
                        startActivity(b);
                     finish();
                        break;
                    case 2:
                        Intent c = new Intent(HomePage.this, New_Membership.class);
                        startActivity(c);

                        break;
                    case 3:
                        Intent d = new Intent(HomePage.this, All_Members.class);
                        startActivity(d);

                        break;
                    case 4:
                        Intent e = new Intent(HomePage.this, User_info.class);
                        startActivity(e);

                        break;
                    case 5:
                        Intent g1 = new Intent(HomePage.this, User_Change_Password.class);
                        startActivity(g1);

                        break;
                    case 6:
                        Intent g = new Intent(HomePage.this, LoginActivity.class);
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


       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, s);
        actv.setAdapter(adapter);
        actv.setThreshold(1);



      Mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = actv.getText().toString();
                int c = 0;
                actv.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0 );

                for(int i = 0; i<4 ; i++){
                    if(name.equals(s[i])){
                        c=1;
                        if(flag[i] == 0){
                            flag[i]++;

                            Toast.makeText(HomePage.this, "Attendance Marked", Toast.LENGTH_SHORT).show();


                        }
                        else{
                            Toast.makeText(HomePage.this, "Attendance Already Marked", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                if(c==0){
                    Toast.makeText(HomePage.this, "Member Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        NewMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this,Add_Member.class);
                startActivity(i);
            }
        });

        RenewMemberships.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this,Renew_Membership.class);
                startActivity(i);
            }
        });

        NewMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this,New_Membership.class);
                startActivity(i);
            }
        });

        UpcomingRenewals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this,Upcoming_renewal.class);
                startActivity(i);
            }
        });

        AllMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this,All_Members.class);
                startActivity(i);
            }
        });
    }

    private void initialize() {
        actv = (AutoCompleteTextView)findViewById(R.id.tvAttendance);
        Mark = (Button)findViewById(R.id.bMark);
        NewMember=(Button)findViewById(R.id.bNew_members);
        NewMembership=(Button)findViewById(R.id.bNew_membership);
        UpcomingRenewals=(Button)findViewById(R.id.bUpcoming_renew);
        AllMembership=(Button)findViewById(R.id.bAll_memberships);
        lv = (ListView)findViewById(R.id.listView1);
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        navdrawer = (DrawerLayout)findViewById(R.id.navdrawer);
        RenewMemberships=(Button)findViewById(R.id.bRenewMembership);
        RenewMemberships.setBackgroundResource(android.R.drawable.btn_default);
       // NewMember.setBackgroundResource(android.R.drawable.btn_default);
    //    NewMembership.setBackgroundResource(android.R.drawable.btn_default);
    //    UpcomingRenewals.setBackgroundResource(android.R.drawable.btn_default);
   //     AllMembership.setBackgroundResource(android.R.drawable.btn_default);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.action_search) {

            Intent i = new Intent(HomePage.this, Search.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }    }