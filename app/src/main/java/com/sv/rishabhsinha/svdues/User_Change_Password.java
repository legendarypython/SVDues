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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Prakhar Gupta on 12-Sep-15.
 */

public class User_Change_Password extends ActionBarActivity implements View.OnClickListener {
    EditText old_pass,new_pass,verify_pass;
    Toolbar toolbar;
    DrawerLayout navdrawer;
    private ActionBarDrawerToggle abdt;
    String[] navigation_drawer = {"Home", "New Member", "New Membership", "All Membership", "Profile", "Change Password", "Logout"};
    ListView lv;

    Button change_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_changepassword);
        initialize();
        abdt = new ActionBarDrawerToggle(User_Change_Password.this,navdrawer,0,0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent a = new Intent(User_Change_Password.this, HomePage.class);
                        startActivity(a);

                        break;
                    case 1:
                        Intent b = new Intent(User_Change_Password.this, Add_Member.class);
                        startActivity(b);

                        break;
                    case 2:
                        Intent c = new Intent(User_Change_Password.this, New_Membership.class);
                        startActivity(c);

                        break;
                    case 3:
                        Intent d = new Intent(User_Change_Password.this, All_Members.class);
                        startActivity(d);

                        break;
                    case 4:
                        Intent e = new Intent(User_Change_Password.this, User_info.class);
                        startActivity(e);

                        break;
                    case 5:

                        break;
                    case 6:
                        Intent g = new Intent(User_Change_Password.this, LoginActivity.class);
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
        old_pass=(EditText)findViewById(R.id.etoldpass);
        new_pass=(EditText)findViewById(R.id.etnewpass);
        verify_pass=(EditText)findViewById(R.id.etverifypass);
        change_password=(Button)findViewById(R.id.bedit_changepass);
        change_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bedit_changepass:
                if(new_pass.getText().toString().equals(verify_pass.getText().toString()) && !(new_pass.getText().toString().equals(""))){
                    Toast.makeText(getBaseContext(),"Password Changed",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(User_Change_Password.this,User_info.class);
                    startActivity(i);
                    finish();
                }
                else{
                    if(new_pass.getText().toString().equals("")){
                        Toast.makeText(getBaseContext(),"Enter New Password",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getBaseContext(),"New password and Verify Password didn't match",Toast.LENGTH_LONG).show();
                        new_pass.setText("");
                        verify_pass.setText("");
                    }}
                break;
        }
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

            Intent i = new Intent(User_Change_Password.this, Search.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }
}
