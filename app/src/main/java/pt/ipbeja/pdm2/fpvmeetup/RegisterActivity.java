package pt.ipbeja.pdm2.fpvmeetup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.pdm2.fpvmeetup.Model.Users;

public class RegisterActivity extends AppCompatActivity {
    private Users users;
    private DBHelper db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");

        this.db = new DBHelper(this);
    }

    public Users registerUsers() {
        int id = 0;
        EditText txtName = (EditText) findViewById(R.id.txtRegsName);
        EditText txtEmail = (EditText) findViewById(R.id.txtRegsEmail);
        EditText txtPass = (EditText) findViewById(R.id.txtRegsPassword);

        String name = txtName.getText().toString();
        String email = txtEmail.getText().toString();
        String pass = txtPass.getText().toString();

        Users user = new Users(id, name, pass, email);

        if (this.addAccount(user) == false) {
            return null;
        }

        return user;
    }

    public boolean addAccount(Users user)
    {
        List<String> teste = new ArrayList<>();
        teste = db.getAllUserNames();
        boolean res = teste.contains(user);


        if (res == true)
        {
            return false;
        }
        else
        {
            db.insertUsers(user);
        }
        return true;
    }

    public void btnRegister_onClick(View view) {
        if (this.registerUsers() != null ) {
            this.users = this.registerUsers();
            this.finish();
        }
        else {
            Toast.makeText(this, "User already exists, please choose another name", Toast.LENGTH_SHORT).show();
        }

    }

    public void btnRegsCancel_onClick(View view) {
        this.users = null;
        this.finish();
    }
}
