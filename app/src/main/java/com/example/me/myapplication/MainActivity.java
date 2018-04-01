package com.example.me.myapplication;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



////    attempt to re-open an already closed object : SQLiteDatabase:/data/user/0/com.examples.me.myapplicationd/databases/Sample-Database




public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";
    private static MyDatabase _db;


    public MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _db = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "Sample-Database").allowMainThreadQueries().build();
    }

   public void InsertData(View view){
       User user = new User();
       TextView displayText = (TextView)findViewById(R.id.editText3);
       try{

           //   Grabs the text box values
           EditText firstName = (EditText)findViewById(R.id.editText);
           EditText lastName = (EditText)findViewById(R.id.editText2);
           //   passes them to the User object
           String uuid = UUID.randomUUID().toString();
           user.uid((uuid));
           user.firstName(firstName.getText().toString());
           user.lastName(lastName.getText().toString());
           //   insert the User Object into the DB
           _db.userDOA().insertAll(user);
           displayText.setText("FirstName: "+ user.firstName() + " LastName: "+ user.lastName());
           firstName.setText("");
           lastName.setText("");
       }catch (Exception ex){
           displayText.setText("Error Data was not Inserted "+ ex.getMessage());
       }
   }

    public List<User> GetAllUsers(){
       List<User> users = new ArrayList<>();
        TextView displayText = (TextView)findViewById(R.id.editText3);
       try{
           users = _db.userDOA().getAll();

       }
       catch(Exception ex){
           displayText.setText("Error GetAllUsers Failed " + ex.getMessage());
       }
        return users;
    }

    public void DisplayData(View view){

        List<User> users = new ArrayList<>();
        TextView displayText = (TextView)findViewById(R.id.editText3);
        try{
            users = GetAllUsers();
            String message ="There are "+ users.size();
            for(Integer i = 0; i< users.size(); i++) {
                message += " User:"+(i+1)+" "+ users.get(i).firstName();
            }
            displayText.setText(message);
        }catch(Exception ex){
            displayText.setText("Error Display Data "+ ex.getMessage());
        }
    }


    //  creates an intent
    public void sendMessage(View view){
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.editText);
        String message =editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void DeleteAll(View view){
        TextView displayText = (TextView)findViewById(R.id.editText3);
        try{
            List<User> users = new ArrayList<>();
            users = GetAllUsers();
            for(Integer i = 0; i<users.size(); i++){
                _db.userDOA().delete(users.get(i));
            }
            displayText.setText("whooo deleted!!!");
        }catch(Exception ex){
            displayText.setText("Error Display Data "+ ex.getMessage());
        }
    }

}
