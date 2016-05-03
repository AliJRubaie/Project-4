package com.example.android.e;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
/**
 * Created by taroboro on 02/08/2015.
 */
public class Already_a_member extends Activity implements View.OnClickListener {
    EditText userName,password;
    Button login;
    String correctUserName="b";
    String correctPassword="1";
    LinearLayout Already_a_member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alreadyamember);
        Already_a_member= (LinearLayout) findViewById(R.id.alreadyamemberid);
        login= (Button) findViewById(R.id.loginBT);
        login.setOnClickListener(this);
        userName= (EditText) findViewById(R.id.EmailID);
        password= (EditText) findViewById(R.id.PasswordId);
    }
    @Override
    public void onClick(View v) {
        String inputUserName=userName.getText().toString();
        String inputPassword=password.getText().toString();
        if(inputPassword.equalsIgnoreCase(correctPassword)
                && inputUserName.equalsIgnoreCase(correctUserName))
        {
           Intent intentObjjj=new Intent(Already_a_member.this,Main2Activity.class);
           startActivity(intentObjjj);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"error ",Toast.LENGTH_LONG).show();
            userName.setText("");
            password.setText("");
        }
    }
}
