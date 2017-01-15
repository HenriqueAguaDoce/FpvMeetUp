package pt.ipbeja.pdm2.fpvmeetup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pt.ipbeja.pdm2.fpvmeetup.Fragments.DronePartsFragment;

public class BuildInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_info);

        getSupportActionBar().setTitle("Build Info");

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            DronePartsFragment firstFragment = new DronePartsFragment();
            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

    }
}
