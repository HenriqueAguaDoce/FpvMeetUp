package pt.ipbeja.pdm2.fpvmeetup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private DBHelper db = null;
    EditText txtName;
    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.db = new DBHelper(this);
        txtName = (EditText) findViewById(R.id.txtUserName);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        txtName.setText("");
        txtPass.setText("");

    }

    public void btnLogin_onClick(View view) {
        this.checkUsers();
    }

    private void checkUsers() {

        String name = txtName.getText().toString();
        String pass = txtPass.getText().toString();

        boolean res = db.getUserAndPass(name, pass);

        if (name.isEmpty() && pass.isEmpty()){
            res = false;
        }

        if (res == true) {
            Intent i = new Intent(this, MainActivity.class);
            txtName.setText("");
            txtPass.setText("");
            startActivity(i);
        }
        else {
            Toast.makeText(LoginActivity.this, "Password/Username wrong, or inexistent user ", Toast.LENGTH_LONG).show();
        }
    }

    public void txtCreateAccount_onClick(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        txtName.setText("");
        txtPass.setText("");
        startActivity(i);
    }
}
