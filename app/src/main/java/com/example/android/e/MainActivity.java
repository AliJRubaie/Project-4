package com.example.android.e;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends Activity implements View.OnClickListener {
    EditText emailhent;
    Button alredy, request,ihavecode;
    ImageView fbloginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailhent= (EditText) findViewById(R.id.emailID);
        request = (Button) findViewById(R.id.REQ);
        ihavecode= (Button) findViewById(R.id.MEM);
        alredy= (Button) findViewById(R.id.CODE);
        request.setOnClickListener(this);
        ihavecode.setOnClickListener(this);
        alredy.setOnClickListener(this);
        fbloginbtn=(ImageView) findViewById(R.id.fblogin);
        fbloginbtn.setOnClickListener(this);
    }
    //@Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.REQ:
                String inputEmail = emailhent.getText().toString();
                String email = emailhent.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                emailhent.setText("");
                if (email.matches(emailPattern) && (email.length() > 0))
                {
                    Toast.makeText(getApplicationContext(), "-Successfully submitted" +
                            " ,Code will be sent to your email when it is approved  ", Toast.LENGTH_LONG).show();
                    Intent emaile = new Intent(Intent.ACTION_SEND);
                    emaile.putExtra(Intent.EXTRA_EMAIL, new String[]{"taroboro@hotmail.com"});
                    emaile.setType("message/rfc822");
                    startActivity(Intent.createChooser(emaile, "Choose an Email client :"));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid email address ", Toast.LENGTH_LONG).show();
                }
                break;

           case R.id.MEM:
              Intent intentObj=new Intent(MainActivity.this,PageTwo.class);
                startActivity(intentObj);
                break;
           case R.id.CODE:
                Intent intentO1=new Intent(MainActivity.this,Already_a_member.class);
               startActivity(intentO1);
              break;
            case R.id.fblogin:
                Intent i=new Intent(MainActivity.this, FacebookError.class);
                startActivity(i);


        }
    }

}

