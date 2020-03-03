package sudo.asim.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner options;
    String[] op = { "Show Countries", "Show Cores", "Show Cites", "Show Student Names", "Show Collages", "Other"};

    List<String> countirs_list = new ArrayList<String>();
    String [] countries = {"Sudan", "India", "Germany", "USA","Others"};

    List<String> cores_list = new ArrayList<String>();
    String [] cores = {"Core 2", "Core i3", "Core i5", "Core i7 ","Corr i9"};

    List<String> cites_list = new ArrayList<String>();
    String [] cities = {"Khartoum", "Bahry", "Tambuol", "Madani","Port sudan"};

    List<String> student_list = new ArrayList<String>();
    String [] students = {"Aasim", "Ali", "Mujahed", "Mohamed","Othman"};

    List<String> collages_list = new ArrayList<String>();
    String [] collages = {"IT", "IS", "CS", "Languages","Others"};
    ListView mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlist = (ListView) findViewById(R.id.my_list);
        options = (Spinner) findViewById(R.id.sp_options);
        options.setOnItemSelectedListener(MainActivity.this);

        countirs_list.addAll(Arrays.asList(countries));
        cores_list.addAll(Arrays.asList(cores));
        cites_list.addAll(Arrays.asList(cities));
        student_list.addAll(Arrays.asList(students));
        collages_list.addAll(Arrays.asList(collages));



       // Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,op);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        options.setAdapter(aa);

        ArrayAdapter<String> lis = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,countirs_list);
        lis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mlist.setAdapter(lis);


    }













    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Your selection is : "+op[i], Toast.LENGTH_LONG).show();

        ArrayAdapter<String> pushed_lid= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) countirs_list);
        switch (i){
            case 0:
                pushed_lid.clear();
                pushed_lid = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) countirs_list);
                mlist.setAdapter( pushed_lid );
                pushed_lid.notifyDataSetChanged();
                break;
            case 1:
                pushed_lid.clear();
                pushed_lid = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) cores_list);
                mlist.setAdapter( pushed_lid );
                pushed_lid.notifyDataSetChanged();
                break;
            case 2:
                pushed_lid.clear();
                pushed_lid = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) cites_list);
                mlist.setAdapter( pushed_lid );
                pushed_lid.notifyDataSetChanged();
                break;
            case 3:
                pushed_lid.clear();
                pushed_lid = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) student_list);
                mlist.setAdapter( pushed_lid );
                pushed_lid.notifyDataSetChanged();
                break;
            case 4:
                pushed_lid.clear();
                pushed_lid = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) collages_list);
                mlist.setAdapter( pushed_lid );
                pushed_lid.notifyDataSetChanged();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
