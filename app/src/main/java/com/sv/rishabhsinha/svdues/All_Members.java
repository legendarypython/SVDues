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
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;


public class All_Members extends ActionBarActivity {
    public static String[] members_name_all = {"Prakhar Gupta", "Raja Singh"};
    public static String[] membership_name_all = {"Badminton", "Gym"};
    public static String[] membership_type_all = {"Annual", "Quarterly"};
    public static String[] startDate_all = {"03/09/2015", "29/09/2015"};
    public static String[] remaining_days_all = {"30 days to Go", "45 days to Go"};
    public static String[] members_name_dues = {"Rishabh Sinha", "Raja Singh"};
    public static String[] membership_name_dues = {"Cricket", "Basketball"};
    public static String[] membership_type_dues = {"Monthly", "Quarterly"};
    public static String[] startDate_dues = {"22/10/2015", "02/12/2015"};
    public static String[] remaining_days_dues = {"30 days to Go", "45 days to Go"};
    public static String[] members_name_expired = {"Prakhar Gupta", "Legend"};
    public static String[] membership_name_expired = {"Music", "Gym"};
    public static String[] membership_type_expired = {"Quaterly", "Quarterly"};
    public static String[] startDate_expired = {"03/03/2015", "29/01/2015"};
    public static String[] remaining_days_expired = {"20 days Ago", "60 days Ago"};
    ListView members_list, lv;

    Toolbar toolbar;
    DrawerLayout navdrawer;
    private ActionBarDrawerToggle abdt;
    String[] navigation_drawer={"Home","New Member","New Membership","All Membership","Profile","Change Password","Logout"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.members_list);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        lv = (ListView)findViewById(R.id.listView1);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        navdrawer = (DrawerLayout) findViewById(R.id.navdrawer);
        abdt = new ActionBarDrawerToggle(All_Members.this, navdrawer, 0, 0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent a = new Intent(All_Members.this, HomePage.class);
                        startActivity(a);
                        navdrawer.closeDrawer(lv);

                        break;
                    case 1:
                        Intent b = new Intent(All_Members.this, Add_Member.class);
                        startActivity(b);
                        navdrawer.closeDrawer(lv);

                        break;
                    case 2:
                        Intent c = new Intent(All_Members.this, New_Membership.class);
                        startActivity(c);
                        navdrawer.closeDrawer(lv);

                        break;
                    case 3:
                        Intent d = new Intent(All_Members.this, All_Members.class);
                        startActivity(d);
                        navdrawer.closeDrawer(lv);

                        break;
                    case 4:
                        Intent e = new Intent(All_Members.this, User_info.class);
                        startActivity(e);
                        navdrawer.closeDrawer(lv);

                        break;
                    case 5:
                        Intent g1 = new Intent(All_Members.this, User_Change_Password.class);
                        startActivity(g1);
                        navdrawer.closeDrawer(lv);

                        break;
                    case 6:
                        Intent g = new Intent(All_Members.this, LoginActivity.class);
                        startActivity(g);
                        navdrawer.closeDrawer(lv);

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

        members_list=(ListView)findViewById(R.id.listview_members);

        Custom_Adapter2 adapter_all=new Custom_Adapter2(All_Members.this,members_name_all,membership_name_all,membership_type_all,startDate_all,remaining_days_all);
        members_list.setAdapter(adapter_all);


        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        final FloatingActionButton all = (FloatingActionButton) findViewById(R.id.fab_all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Custom_Adapter2 adapter_all=new Custom_Adapter2(All_Members.this,members_name_all,membership_name_all,membership_type_all,startDate_all,remaining_days_all);
                members_list.setAdapter(adapter_all);

            }
        });
        final FloatingActionButton dues = (FloatingActionButton) findViewById(R.id.fab_dues);
        dues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Custom_Adapter2 adapter_dues=new Custom_Adapter2(All_Members.this,members_name_dues,membership_name_dues,membership_type_dues,startDate_dues,remaining_days_dues);
                members_list.setAdapter(adapter_dues);

            }
        });
        final FloatingActionButton expired= (FloatingActionButton) findViewById(R.id.fab_expired);
        expired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Custom_Adapter2 adapter_expired=new Custom_Adapter2(All_Members.this,members_name_expired,membership_name_expired,membership_type_expired,startDate_expired,remaining_days_expired);
                members_list.setAdapter(adapter_expired);
            }
        });
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
        if(id==R.id.action_search){

            Intent i = new Intent(All_Members.this, Search.class);
            startActivity(i);


    }
        return super.onOptionsItemSelected(item);

}}
