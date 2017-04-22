package com.serverproject.facedetection.localdatausingsharedpre;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    String filename = "nameemployee";
    @BindView(R.id.txtnameuser)
    EditText txtnameuser;
    @BindView(R.id.txtviewdata)
    TextView txtviewdata;

    @OnClick(R.id.btnsave)
    public void setTxtnameuser(){

        //file name
        SharedPreferences sharedPreferences  = getSharedPreferences(filename,MODE_PRIVATE);
        //insert in file , delete update retrieve
        SharedPreferences.Editor editor = sharedPreferences.edit();
      //putstring
        editor.putString("nameemployee",txtnameuser.getText().toString());
        editor.commit();

    }
    @OnClick(R.id.btnload)
    public void setFilename(){
        SharedPreferences sharedPreferences  = getSharedPreferences(filename,MODE_PRIVATE);
     //   SharedPreferences.Editor editor = sharedPreferences.edit();
      String result =  sharedPreferences.getString("nameemployee","data not found");
        txtviewdata.setText(result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

         menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){

            case R.id.setting:
                Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
                        break;
            case R.id.search:
                Toast.makeText(getApplicationContext(),"Search",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
