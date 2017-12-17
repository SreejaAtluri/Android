package com.example.lenovo.testfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    EditText edtNameText, edtIdText,edtPhoneText,edtEmailText;
    Button btnSendDataToServer;
    TextView txtRecieve;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    private String oldTextReceivedData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      edtNameText = (EditText)findViewById(R.id.nameText);
      edtIdText = (EditText)findViewById(R.id.idText);
      edtPhoneText = (EditText)findViewById(R.id.phoneText);
      edtEmailText = (EditText)findViewById(R.id.emailText);

      btnSendDataToServer = (Button)findViewById(R.id.button2);

      txtRecieve = (TextView)findViewById(R.id.textView);

      database = FirebaseDatabase.getInstance();
      databaseReference = database.getReference();

      btnSendDataToServer.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Example example = new Example(edtNameText.getText().toString(),
                                            edtIdText.getText().toString(),
                                            edtPhoneText.getText().toString(),
                                            edtEmailText.getText().toString());
              databaseReference.child(databaseReference.push().getKey()).setValue(example);

              startActivity(new Intent(MainActivity.this,FirstActivity.class));
          }




      });


      /*databaseReference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              for(DataSnapshot child : dataSnapshot.getChildren()){
                  Example example = child.getValue(Example.class);
                  if(oldTextReceivedData == null){
                      oldTextReceivedData = " ";
                  }
                  txtRecieve.setText(oldTextReceivedData + example.getEditText() + "  " + example.getEditText1()+"\n");
                  oldTextReceivedData = txtRecieve.getText().toString();
              }
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });*/



    }
}
