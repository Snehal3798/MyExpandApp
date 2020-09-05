package snehal.adhav.myexpandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ExpandableListView expandableListView;
    List<String> listDataHeader;
    MyExpandableListAdapter listAdapter;;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=findViewById(R.id.expand);
        prepareListData();
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        //adding Header data

        listDataHeader.add("Topics");
        listDataHeader.add("Topics Covered");
        listDataHeader.add("Topics Not Covered");

        //adding Child data
        List<String> top250 =new ArrayList<>();
        top250.add("Android");
        top250.add("Android Arch..");
        top250.add("Android SDK");
        top250.add("Android UI");
        top250.add("Android Notification");
        top250.add("Android Maps");
        top250.add("Android Bluetooth");
        top250.add("Android WIFI");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Android");
        nowShowing.add("Android Arch..");
        nowShowing.add("Android SDK");
        nowShowing.add("Android UI");
        nowShowing.add("Android Notification");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Android Maps");
        comingSoon.add("Android Bluetooth");
        comingSoon.add("Android WIFI");

        listDataChild.put(listDataHeader.get(0),top250);
        listDataChild.put(listDataHeader.get(1),nowShowing);
        listDataChild.put(listDataHeader.get(2),comingSoon);

        listAdapter =new MyExpandableListAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(listAdapter);
    }
}