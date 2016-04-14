package com.skvarnan.dynamic.grid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.felipecsl.asymmetricgridview.library.Utils;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;
import com.skvarnan.dynamic.grid.widget.DefaultListAdapter;
import com.skvarnan.dynamic.grid.widget.DemoAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AsymmetricGridView listView;
    private DemoAdapter adapter;
    private final DemoUtils demoUtils = new DemoUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (AsymmetricGridView) findViewById(R.id.listView);

        adapter = new DefaultListAdapter(this, demoUtils.moarItems(50));

        listView.setRequestedColumnCount(3);
        listView.setRequestedHorizontalSpacing(Utils.dpToPx(this, 3));
        listView.setAdapter(getNewAdapter());
        listView.setOnItemClickListener(this);
        listView.setAllowReordering(true);
    }

    private AsymmetricGridViewAdapter getNewAdapter() {
        return new AsymmetricGridViewAdapter(this, listView, adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item " + position + " clicked", Toast.LENGTH_SHORT).show();
    }
}
