package com.sv.rishabhsinha.svdues;

/**
 * Created by Prakhar Gupta on 14-Sep-15.
 */
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Upcoming_renewal extends ListActivity {
    static String[] members_name = {"Prakhar Gupta", "Raja Singh","Rishabh Agrawal","Ayush Gupta","Arpit Chaudhary","Rishabh Sinha"};
    static String[] membership_name = {"Badminton", "Gym","Cricket","Music","Robotics","Cultural"};
    static String[] membership_type = {"Annualy", "Quarterly","Monthly","Quarterly","Monthly","Annualy"};
    static String[] startDate = {"03/09/2015", "29/09/2015","02/08/2015","26/07/2015","24/08/2015","17/09/2015"};
    static String[] remaining_days = {"5 days to Go", "3 days to Go","6 days to Go","7 days to Go","2 days to Go","14 days to Go"};

    ListView members_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.members_list);
        members_list = (ListView)findViewById(R.id.listview_members);
        Custom_Adapter2 adapter=new Custom_Adapter2(Upcoming_renewal.this,members_name,membership_name,membership_type,startDate,remaining_days);
        members_list.setAdapter(adapter);

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        Intent act= new Intent(Upcoming_renewal.this,MemberDetails.class);
        startActivity(act);
    }

}

