package com.example.databindingfinalupdated;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.databindingfinalupdated.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //binding the layout file with the binder
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //String Toolbar
        setSupportActionBar(binding.toolbar);

        //Creating User Object
        user = new User();

        //initialising values to the groups
        user.setName("Abhishek");
        user.setEmail("Yabhishek9575@gmail.com");
        user.setProfileImage("https://th.bing.com/th/id/OIP.VQrY1iAxv2DrrKDWb97RUQHaLG?pid=ImgDet&rs=1");

        //passing user to the bindingObject
        binding.setUser(user);

        //to link the click handlers with the binding class
        binding.setHandlers(new MyClickHandlers(this));

    }

    public class MyClickHandlers {

        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onFabClicked(View view) {
            user.setEmail("fabClicked.com");
            Toast.makeText(getApplicationContext(), "FAB clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClick(View view) {
            Toast.makeText(getApplicationContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClickWithParam(View view, User user) {
            Toast.makeText(getApplicationContext(), "Button clicked! \nName: " + user.name + " \nEmail: " + user.email, Toast.LENGTH_SHORT).show();
        }

        public boolean onButtonLongPressed(View view) {
            Toast.makeText(getApplicationContext(), "Button long pressed!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}