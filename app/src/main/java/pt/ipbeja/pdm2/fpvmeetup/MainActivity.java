package pt.ipbeja.pdm2.fpvmeetup;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean checkBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onBackPressed() {

        if (checkBack == false)
        {
            Toast.makeText(MainActivity.this, "Click again to exit", Toast.LENGTH_SHORT).show();
            checkBack = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkBack = false;
                }
            }, 2000);
        }
        else if (checkBack = true)
        {
            System.exit(0);
        }
    }
}
