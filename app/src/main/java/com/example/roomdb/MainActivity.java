package com.example.roomdb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db= (AppDatabase) AppDatabase.getAppDatabase(this);


    //    new addAll().execute(db);
        new getAll().execute(db);

    }

    public void addUser(AppDatabase db){
        User user = new User();
        user.setFirstName("Ajay");
        user.setLastName("Saini");
        user.setAge(25);

        db.userDao().insertAll(user);
    }

    public void getAll(){

    }

    class addAll extends AsyncTask<AppDatabase, Void,Void>{


        @Override
        protected Void doInBackground(AppDatabase... db) {

            User user = new User();
            user.setFirstName("Ajay");
            user.setLastName("Saini");
            user.setAge(25);

            db[0].userDao().insertAll(user);

            return null;
        }
    }


    class getAll extends AsyncTask<AppDatabase, Void,Void>{


        @Override
        protected Void doInBackground(AppDatabase... db) {

             db[0].userDao().getAll();

            return null;
        }
    }

}
