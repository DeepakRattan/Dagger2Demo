package com.example.dagger2demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dagger2demo.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private MyComponent myComponent;
    private String name, password;
    private SharedPreferences.Editor editor;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Code to bind Dagger into our app
        // Dagger keyword is prepended on the Component class name.
        // If the component class name was MyComponent, the result would have been
        // DaggerMyComponent.
        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        // The SharedPreferences dependency object is available to use after this:
        // We are able to operate upon our SharedPreferences, without the need to
        // initialize it within the Activity.
        myComponent.inject(this);
    }

    public void save(View view) {
        name = binding.edtName.getText().toString().trim();
        password = binding.edtPasswd.getText().toString().trim();
        editor = sharedPreferences.edit();
        editor.putString(Const.NAME, name);
        editor.putString(Const.PASSWORD, password);
        editor.apply();
        Toast.makeText(this, "Data saved Successfully", Toast.LENGTH_SHORT).show();
    }

    public void view(View view) {
        binding.txtName.setText(sharedPreferences.getString(Const.NAME, null));
        binding.txtPasswd.setText(sharedPreferences.getString(Const.PASSWORD, null));
    }
}
