package com.sv.rishabhsinha.svdues;

/**
 * Created by Prakhar Gupta on 14-Sep-15.
 */

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
import android.widget.ListView;

public class Upcoming_renewal extends ActionBarActivity {
    static String[] members_name = {"Prakhar Gupta", "Raja Singh","Rishabh Agrawal","Ayush Gupta","Arpit Chaudhary","Rishabh Sinha"};
    static String[] membership_name = {"Badminton", "Gym","Cricket","Music","Robotics","Cultural"};
    static String[] membership_type = {"Annualy", "Quarterly","Monthly","Quarterly","Monthly","Annualy"};
    static String[] startDate = {"03/09/2015", "29/09/2015","02/08/2015","26/07/2015","24/08/2015","17/09/2015"};
    static String[] remaining_days = {"5 days to Go", "3 days to Go","6 days to Go","7 days to Go","2 days to Go","14 days to Go"};
    Toolbar toolbar;
    DrawerLayout navdrawer;
    private ActionBarDrawerToggle abdt;
    String[] navigation_drawer = {"Home", "New Member", "New Membership", "All Membership", "Profile", "Change Password", "Logout"};
    ListView members_list,lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_renewal);
        members_list = (ListView)findViewById(R.id.listview_members_upcoming);
        Custom_Adapter2 adapter=new Custom_Adapter2(Upcoming_renewal.this,members_name,membership_name,membership_type,startDate,remaining_days);
        members_list.setAdapter(adapter);
members_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent act= new Intent(Upcoming_renewal.this,MemberDetails.class);
        startActivity(act);
    }
});
        lv = (ListView) findViewById(R.id.listView1);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        navdrawer = (DrawerLayout) findViewById(R.id.navdrawer);
        abdt = new ActionBarDrawerToggle(Upcoming_renewal.this, navdrawer, 0, 0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent a = new Intent(Upcoming_renewal.this, HomePage.class);
                        startActivity(a);

                        break;
                    case 1:
                        Intent b = new Intent(Upcoming_renewal.this, Add_Member.class);
                        startActivity(b);

                        break;
                    case 2:
                        Intent c = new Intent(Upcoming_renewal.this, New_Membership.class);
                        startActivity(c);

                        break;
                    case 3:
                        Intent d = new Intent(Upcoming_renewal.this, All_Members.class);
                        startActivity(d);

                        break;
                    case 4:
                        Intent e = new Intent(Upcoming_renewal.this, User_info.class);
                        startActivity(e);

                        break;
                    case 5:
                        Intent g1 = new Intent(Upcoming_renewal.this, User_Change_Password.class);
                        startActivity(g1);
                        break;
                    case 6:
                        Intent g = new Intent(Upcoming_renewal.this, LoginActivity.class);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.action_search) {

            Intent i = new Intent(Upcoming_renewal.this, Search.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_upcoming_renewal, menu);
        return true;
    }
}






