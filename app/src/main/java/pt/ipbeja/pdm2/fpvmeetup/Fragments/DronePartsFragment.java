package pt.ipbeja.pdm2.fpvmeetup.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import pt.ipbeja.pdm2.fpvmeetup.Model.DronesData;
import pt.ipbeja.pdm2.fpvmeetup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DronePartsFragment extends ListFragment {

    public DronePartsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),
                android.R.layout.simple_list_item_1, DronesData.Parts);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if (getActivity().findViewById(R.id.fragment_container) != null){

            DroneDescriptionFragment newFragment = new DroneDescriptionFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
        else{

            ImageView img = (ImageView) getActivity().findViewById(R.id.photos);
            TextView text = (TextView) getActivity().findViewById(R.id.parts);
            TextView art = (TextView) getActivity().findViewById(R.id.description_text);
            text.setText(DronesData.Parts[position]);
            art.setText(DronesData.Description[position]);
            img.setImageResource(DronesData.photos[position]);
        }
    }

}
