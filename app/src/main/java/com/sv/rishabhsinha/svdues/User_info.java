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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class User_info extends ActionBarActivity {
    ListView lv;
    Toolbar toolbar;
    DrawerLayout navdrawer;
    private ActionBarDrawerToggle abdt;
    String[] navigation_drawer={"Home","New Member","New Membership","All Membership","Profile","Change Password","Logout"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        lv = (ListView)findViewById(R.id.listView1);
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        navdrawer = (DrawerLayout)findViewById(R.id.navdrawer);
        abdt = new ActionBarDrawerToggle(User_info.this,navdrawer,0,0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent a = new Intent(User_info.this, HomePage.class);
                        startActivity(a);

                        break;
                    case 1:
                        Intent b = new Intent(User_info.this, Add_Member.class);
                        startActivity(b);

                        break;
                    case 2:
                        Intent c = new Intent(User_info.this, New_Membership.class);
                        startActivity(c);

                        break;
                    case 3:
                        Intent d = new Intent(User_info.this, All_Members.class);
                        startActivity(d);

                        break;
                    case 4:
                        Intent e = new Intent(User_info.this, User_info.class);
                        startActivity(e);

                        break;
                    case 5:
                        Intent f = new Intent(User_info.this, User_Change_Password.class);
                        startActivity(f);

                        break;
                    case 6:
                        Intent g = new Intent(User_info.this, LoginActivity.class);
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

        Button edit = (Button) findViewById(R.id.bEdit_owner_details);
        edit.setBackgroundResource(android.R.drawable.btn_default);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(User_info.this, Edit_Userinfo.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_info, menu);
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

            Intent i = new Intent(User_info.this, Search.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }
}