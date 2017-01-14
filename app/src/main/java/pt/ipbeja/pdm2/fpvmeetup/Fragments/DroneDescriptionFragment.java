package pt.ipbeja.pdm2.fpvmeetup.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pt.ipbeja.pdm2.fpvmeetup.Model.DronesData;
import pt.ipbeja.pdm2.fpvmeetup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DroneDescriptionFragment extends Fragment {
    int currentPosition;

    public DroneDescriptionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {

            currentPosition = args.getInt("position");
            TextView article = (TextView) getActivity().findViewById(R.id.description_text);
            article.setText(DronesData.Description[currentPosition]);
        }
    }


}
