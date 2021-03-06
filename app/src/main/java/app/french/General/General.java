package app.french.General;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import app.french.General.Calender_Time.Calender_Time;
import app.french.General.Geography.Geography;
import app.french.General.Numbers.Numbers;
import app.french.General.Shorthand_Expansions.Shorthand_Expansions;
import app.french.General.Subjects_Professions.Subjects_Professions;
import app.french.R;
import app.french.common_adapters.indexAdapter;
import app.french.common_classes.indexclass;


public class General extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.index);

        //get title to set label in lesson activity
        final String title = getTitle().toString();

        //set index heading
        TextView ttl = (TextView)findViewById(R.id.index_heading);
        ttl.setText(title);

        //set menu list adapter

        final ArrayList<indexclass> list = new ArrayList<indexclass>();

        list.add(new indexclass(R.string.genlt1,1,Geography.class));
        list.add(new indexclass(R.string.genlt2,2));
        list.add(new indexclass(R.string.genlt3,3,Numbers.class));
        list.add(new indexclass(R.string.genlt4,4));
//        list.add(new indexclass(R.string.genlt5,5));
        list.add(new indexclass(R.string.genlt6,5));
        list.add(new indexclass(R.string.genlt7,6));
        list.add(new indexclass(R.string.genlt8,7,Calender_Time.class));
        list.add(new indexclass(R.string.genlt9,8,Subjects_Professions.class));
        list.add(new indexclass(R.string.genlt10,9));
        list.add(new indexclass(R.string.genlt11,10,Shorthand_Expansions.class));

        indexAdapter adapter = new indexAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.menu_list_section);
        section.setAdapter(adapter);

        //opening new activity for every item on menu list

        section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                indexclass w = list.get(position);
                Intent intent = new Intent(getApplicationContext(), w.getmCls());
                intent.putExtra("lname",w.getmLsnName());
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });
    }
}