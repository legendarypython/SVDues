package com.sv.rishabhsinha.svdues;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class MemberDetails extends ActionBarActivity implements View.OnClickListener {

    public static String[] sport = {"Badminton", "Cricket"};
    public static String[] renewal = {"30 Days To Renewal", "20 Days To Renwal"};
    public static String[] type = {"Annual", "Quarterly"};
    public static String[] startDate = {"03/09/2015", "29/09/2015"};
    public static String[] endDate = {"30/09/2015", "25/09/2015"};

    ListView active, lv, archived;
    Toolbar toolbar;
    TextView renew, mobile, email, dob;
    DrawerLayout navdrawer;
    CalendarView calendar;
    TabHost tabs;
    Button edit;
    private ActionBarDrawerToggle abdt;
    String[] navigation_drawer={"Home","New Member","New Membership","All Membership","Profile","Change Password","Logout"};
    private static final String tag = "MyCalendarActivity";
    private TextView currentMonth;
    private ImageView prevMonth;
    private ImageView nextMonth;
    private GridView calendarView;
    private GridCellAdapter gadapter;
    private Calendar _calendar;
    @SuppressLint("NewApi")
    private int month, year;
    @SuppressWarnings("unused")
    @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
    private final DateFormat dateFormatter = new DateFormat();
    private static final String dateTemplate = "MMMM yyyy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_member_details);
        edit = (Button)findViewById(R.id.bEditDetails);
        edit.setBackgroundResource(android.R.drawable.btn_default);
        mobile = (TextView)findViewById(R.id.tvMob);
        email = (TextView)findViewById(R.id.tvEmail);
        dob = (TextView)findViewById(R.id.tvDob);
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        lv = (ListView)findViewById(R.id.listView1);
        navdrawer = (DrawerLayout)findViewById(R.id.navdrawer);
        abdt = new ActionBarDrawerToggle(MemberDetails.this,navdrawer,0,0);

        mobile.setText("8127934343");
        email.setText("abc@xyz.com");
        dob.setText("27-02-1997");

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MemberDetails.this, Edit_Personal_Details.class);

                i.putExtra("kMob", mobile.getText().toString());
                i.putExtra("kEmail", email.getText().toString());
                i.putExtra("kDob", dob.getText().toString());
                startActivity(i);
            }
        });
        Intent j = getIntent();
        mobile.setText(j.getStringExtra("kMob"));
        email.setText(j.getStringExtra("kEmail"));
        dob.setText(j.getStringExtra("kDob"));

        if(mobile.getText().toString().equals("")){
            mobile.setText("9845673982");
        }
        if(email.getText().toString().equals("")){
            email.setText("abc@xyz.com");
        }
        if(dob.getText().toString().equals("")){
            dob.setText("02-08-1996");
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,navigation_drawer);
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent a = new Intent(MemberDetails.this, HomePage.class);
                        startActivity(a);

                        break;
                    case 1:
                        Intent b = new Intent(MemberDetails.this, Add_Member.class);
                        startActivity(b);

                        break;
                    case 2:
                        Intent c = new Intent(MemberDetails.this, New_Membership.class);
                        startActivity(c);

                        break;
                    case 3:
                        Intent d = new Intent(MemberDetails.this, All_Members.class);
                        startActivity(d);

                        break;
                    case 4:
                        Intent e = new Intent(MemberDetails.this, User_info.class);
                        startActivity(e);

                        break;
                    case 5:
                        Intent f = new Intent(MemberDetails.this, User_Change_Password.class);
                        startActivity(f);

                        break;
                    case 6:
                        Intent g = new Intent(MemberDetails.this, LoginActivity.class);
                        startActivity(g);
                        finish();

                        break;

                }

            }
        });
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        navdrawer.setDrawerListener(abdt);
        abdt.syncState();


        tabs=(TabHost)findViewById(R.id.TabHost);
        tabs.setup();
        TabHost.TabSpec specs= tabs.newTabSpec("tag1");
        specs.setContent(R.id.tabPersonal);
        specs.setIndicator("Personal details");
        tabs.addTab(specs);
        specs= tabs.newTabSpec("tag2");
        specs.setContent(R.id.tbmembership);
        specs.setIndicator("Membership Details");
        tabs.addTab(specs);
        specs= tabs.newTabSpec("tag3");
        specs.setContent(R.id.tAttendance);
        specs.setIndicator("Attendance");
        tabs.addTab(specs);

        TabHost th = (TabHost)findViewById(R.id.tabHost);
        th.setup();
        TabHost.TabSpec spec = th.newTabSpec("tag1");
        spec.setContent(R.id.tabActive);
        spec.setIndicator("Active");
        th.addTab(spec);
        spec = th.newTabSpec("tag2");
        spec.setContent(R.id.tabArchived);
        spec.setIndicator("Archived");
        th.addTab(spec);



        CustomAdapter adapter=new CustomAdapter(MemberDetails.this,sport,renewal,type,startDate,endDate);

        active=(ListView)findViewById(R.id.lvActive);
        active.setAdapter(adapter);
        //attendance records

        Custom_Adapter3 adapter3 = new Custom_Adapter3(MemberDetails.this,sport,renewal,type,startDate,endDate);

        archived = (ListView)findViewById(R.id.lvArchived);
        archived.setAdapter(adapter3);
        _calendar = Calendar.getInstance(Locale.getDefault());
        month = _calendar.get(Calendar.MONTH) + 1;
        year = _calendar.get(Calendar.YEAR);
        Log.d(tag, "Calendar Instance:= " + "Month: " + month + " " + "Year: "
                + year);

        prevMonth = (ImageView) this.findViewById(R.id.prevMonth);
        prevMonth.setOnClickListener(this);
        currentMonth = (TextView) this.findViewById(R.id.currentMonth);
        currentMonth.setText(DateFormat.format(dateTemplate,
                _calendar.getTime()));
        nextMonth = (ImageView) this.findViewById(R.id.nextMonth);
        nextMonth.setOnClickListener(this);
        calendarView = (GridView) this.findViewById(R.id.calendar);
// Initialised
        gadapter = new GridCellAdapter(getApplicationContext(),
                R.id.calendar_day_gridcell, month, year);
        gadapter.notifyDataSetChanged();
        calendarView.setAdapter(gadapter);

    }

    private void setGridCellAdapterToDate(int month, int year) {
        gadapter = new GridCellAdapter(getApplicationContext(),
                R.id.calendar_day_gridcell, month, year);
        _calendar.set(year, month-1, _calendar.get(Calendar.DAY_OF_MONTH));
        currentMonth.setText(DateFormat.format(dateTemplate,
                _calendar.getTime()));
        gadapter.notifyDataSetChanged();
        calendarView.setAdapter(gadapter);
    }
    @Override
    public void onClick(View v) {
        if (v == prevMonth) {
            if (month <= 1) {
                month = 12;
                year=year-1;
            } else {
                month=month-1;
            }
            Log.d(tag, "Setting Prev Month in GridCellAdapter: " + "Month: "
                    + month + " Year: " + year);
            setGridCellAdapterToDate(month, year);
        }
        if (v == nextMonth) {
            if (month > 11) {
                month = 1;
                year++;
            } else {
                month++;
            }
            Log.d(tag, "Setting Next Month in GridCellAdapter: " + "Month: "
                    + month + " Year: " + year);
            setGridCellAdapterToDate(month, year);
        }
    }
    @Override
    public void onDestroy() {
        Log.d(tag, "Destroying View …");
        super.onDestroy();
    }
    // Inner Class
    public class GridCellAdapter extends BaseAdapter implements View.OnClickListener {
        private static final String tag = "GridCellAdapter";
        private final Context _context;
        private final List<String> list;
        private static final int DAY_OFFSET = 1;
        private final String[] weekdays = new String[] { "Sun", "Mon", "Tue",
                "Wed", "Thu", "Fri", "Sat" };
        private final String[] months = { "January", "February", "March",
                "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        private final int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30,
                31, 30, 31 };
        private int daysInMonth;
        private int currentDayOfMonth;
        private int currentWeekDay;
        private Button gridcell;
        private TextView num_events_per_day;
        private final HashMap<String, Integer> eventsPerMonthMap;
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(
                "dd-MMM-yyyy");
        // Days in Current Month
        public GridCellAdapter(Context context, int textViewResourceId,
                               int month, int year) {
            super();
            this._context = context;
            this.list = new ArrayList<String>();
            Log.d(tag, "==> Passed in Date FOR Month: " + month + " "
                    + "Year: " + year);
            Calendar calendar = Calendar.getInstance();
            setCurrentDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));
            setCurrentWeekDay(calendar.get(Calendar.DAY_OF_WEEK));
            Log.d(tag, "New Calendar:= " + calendar.getTime().toString());
            Log.d(tag, "CurrentDayOfWeek :" + getCurrentWeekDay());
            Log.d(tag, "CurrentDayOfMonth :" + getCurrentDayOfMonth());
// Print Month
            printMonth(month, year);
// Find Number of Events
            eventsPerMonthMap = findNumberOfEventsPerMonth(year, month);
        }
        private String getMonthAsString(int i) {
            return months[i];
        }
        private String getWeekDayAsString(int i) {
            return weekdays[i];
        }
        private int getNumberOfDaysOfMonth(int i) {
            return daysOfMonth[i];
        }
        public String getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
        /**
         * Prints Month
         *
         * @param mm
         * @param yy
         */
        private void printMonth(int mm, int yy) {
            int[] flag={1,0,1,0,1,1,0};

            Log.d(tag, "==> printMonth: mm: " + mm + " " + "yy: " + yy);
            int trailingSpaces = 0;
            int daysInPrevMonth = 0;
            int prevMonth = 0;
            int prevYear = 0;
            int nextMonth = 0;
            int nextYear = 0;
            int currentMonth =mm-1;
            String currentMonthName = getMonthAsString(currentMonth);
            daysInMonth = getNumberOfDaysOfMonth(currentMonth);
            Log.d(tag, "Current Month: " + " " + currentMonthName + " having "
                    + daysInMonth + " days.");
            GregorianCalendar cal = new GregorianCalendar(yy, currentMonth, 1);
            Log.d(tag, "Gregorian Calendar:= " + cal.getTime().toString());
            if (currentMonth == 11) {
                prevMonth = currentMonth-1;
                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                nextMonth = 0;
                prevYear = yy;
                nextYear = yy + 1;
                Log.d(tag, "*->PrevYear: " + prevYear + " PrevMonth:"
                        + prevMonth + " NextMonth: " + nextMonth
                        + " NextYear: " + nextYear);
            } else if (currentMonth == 0) {
                prevMonth = 11;
                prevYear =yy-1;
                nextYear = yy;
                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                nextMonth = 1;
                Log.d(tag, "**–> PrevYear: " + prevYear + " PrevMonth:"
                        + prevMonth + " NextMonth: " + nextMonth
                        + " NextYear: " + nextYear);
            } else {
                prevMonth = currentMonth-1;
                nextMonth = currentMonth + 1;
                nextYear = yy;
                prevYear = yy;
                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                Log.d(tag, "***—> PrevYear: " + prevYear + " PrevMonth:"
                        + prevMonth + " NextMonth: " + nextMonth
                        + " NextYear: " + nextYear);
            }
            int currentWeekDay = cal.get(Calendar.DAY_OF_WEEK)-1;
            trailingSpaces = currentWeekDay;
            Log.d(tag, "Week Day:" + currentWeekDay + " is "
                    + getWeekDayAsString(currentWeekDay));
            Log.d(tag, "No. Trailing space to Add: " + trailingSpaces);
            Log.d(tag, "No. of Days in Previous Month: " + daysInPrevMonth);
            if (cal.isLeapYear(cal.get(Calendar.YEAR)))
                if (mm == 2)
                    ++daysInMonth;
                else if (mm == 3)
                    ++daysInPrevMonth;
// Trailing Month days
            for (int i = 0; i < trailingSpaces; i++) {

                Log.d(tag,
                        "PREV MONTH:= "
                                + prevMonth
                                + " => "
                                + getMonthAsString(prevMonth)
                                + " "
                                + String.valueOf((daysInPrevMonth-trailingSpaces + DAY_OFFSET)

                                + i));
                list.add(String
                        .valueOf((daysInPrevMonth-trailingSpaces + DAY_OFFSET)
                                + i)
                        + "-GREY"
                        + "-"
                        + getMonthAsString(prevMonth)
                        + "-"
                        + prevYear);
            }
// Current Month Days
            for (int i = 1; i <= daysInMonth; i++) {

                Date d = new Date();
                d.setDate(i);
                d.setMonth(currentMonth);
                d.setYear(yy);

                Calendar c = Calendar.getInstance();
                c.setTime(d);
                int dow = c.get(Calendar.DAY_OF_WEEK)-1;

                Log.d(currentMonthName, String.valueOf(i) + " "
                        + getMonthAsString(currentMonth) + " " + yy);
                if(flag[dow]==1){
                    list.add(String.valueOf(i) + "-BLUE" + "-" + getMonthAsString(currentMonth) + "-" +yy);
                }

                else {
                    list.add(String.valueOf(i) + "-WHITE" + "-"
                            + getMonthAsString(currentMonth) + "-" + yy);
                }
            }
// Leading Month days
            for (int i = 0; i < list.size() % 7; i++) {
                Log.d(tag, "NEXT MONTH:= " + getMonthAsString(nextMonth));
                list.add(String.valueOf(i + 1) + "-GREY" + "-"
                        + getMonthAsString(nextMonth) + "-" + nextYear);
            }
        }
        /**
         * NOTE: YOU NEED TO IMPLEMENT THIS PART Given the YEAR, MONTH, retrieve
         * ALL entries from a SQLite database for that month. Iterate over the
         * List of All entries, and get the dateCreated, which is converted into
         * day.
         *
         * @param year
         * @param month
         * @return
         */
        private HashMap<String, Integer> findNumberOfEventsPerMonth(int year,
                                                                    int month) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            return map;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) _context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.screen_gridcell, parent, false);
            }
// Get a reference to the Day gridcell
            gridcell = (Button) row.findViewById(R.id.calendar_day_gridcell);
            gridcell.setOnClickListener(this);
// ACCOUNT FOR SPACING
            Log.d(tag, "Current Day: " + getCurrentDayOfMonth());
            String[] day_color = list.get(position).split("-");
            String theday = day_color[0];
            String themonth = day_color[2];
            String theyear = day_color[3];
            if ((!eventsPerMonthMap.isEmpty()) && (eventsPerMonthMap != null)) {
                if (eventsPerMonthMap.containsKey(theday)) {
                    num_events_per_day = (TextView) row
                            .findViewById(R.id.num_events_per_day);
                    Integer numEvents = (Integer) eventsPerMonthMap.get(theday);
                    num_events_per_day.setText(numEvents.toString());
                }
            }
// Set the Day GridCell
            gridcell.setText(theday);
            gridcell.setTag(theday + "-" + themonth + "-" + theyear);
            Log.d(tag, "Setting GridCell " + theday + "-" + themonth + "-"
                    + theyear);
            if (day_color[1].equals("GREY")) {
                gridcell.setTextColor(getResources()
                        .getColor(R.color.lightgray));
            }
            if (day_color[1].equals("WHITE")) {
                gridcell.setTextColor(getResources().getColor(
                        R.color.lightgray02));
            }
            if (day_color[1].equals("BLUE")) {
                gridcell.setBackgroundColor(getResources().getColor(R.color.sky));
            }
            return row;
        }
        @Override
        public void onClick(View view) {

        }
        public int getCurrentDayOfMonth() {
            return currentDayOfMonth;
        }
        private void setCurrentDayOfMonth(int currentDayOfMonth) {
            this.currentDayOfMonth = currentDayOfMonth;
        }
        public void setCurrentWeekDay(int currentWeekDay) {
            this.currentWeekDay = currentWeekDay;
        }
        public int getCurrentWeekDay() {
            return currentWeekDay;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_member_details, menu);
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

            Intent i = new Intent(MemberDetails.this, Search.class);
            startActivity(i);

        }



        return super.onOptionsItemSelected(item);
    }
}
