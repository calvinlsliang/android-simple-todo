package com.calvinlsliang.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private final int RESULT_OK = 40;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String item = getIntent().getStringExtra("item");
        pos = getIntent().getIntExtra("pos", 0);
        int id = getIntent().getIntExtra("id", 0);

        EditText etNewItem = (EditText) findViewById(R.id.eiEditText);
        etNewItem.setText(item.toString());
        etNewItem.setSelection(etNewItem.getText().length());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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

    public void onSave(View v) {
        EditText saveText = (EditText) findViewById(R.id.eiEditText);
        Intent data = new Intent();
        data.putExtra("item", saveText.getText().toString());
        data.putExtra("pos", pos);

        setResult(RESULT_OK, data);
        finish();

    }
}