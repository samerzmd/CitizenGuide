package com.apps.salta3a.citizenguide.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.apps.salta3a.citizenguide.Fragments.GeneralMessageFragment;
import com.apps.salta3a.citizenguide.R;

public class GeneralMessageActivity extends ActionBarActivity {
    public static String  messageReskEY="MESSAGE_RES_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_message);
        String rawRes =getIntent().getStringExtra(messageReskEY);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, GeneralMessageFragment.newInstance(rawRes,1)).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_general_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
