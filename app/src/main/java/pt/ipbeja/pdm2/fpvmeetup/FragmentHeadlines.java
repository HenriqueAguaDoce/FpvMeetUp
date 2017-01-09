package pt.ipbeja.pdm2.fpvmeetup;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHeadlines extends ListFragment  {


    public FragmentHeadlines() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),
                android.R.layout.simple_list_item_1,NewData.Headlines);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if (getActivity().findViewById(R.id.fragment_container) != null){

            FragmentArticle newFragment = new FragmentArticle();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else{
            TextView txtNote = (TextView) getActivity().findViewById(R.id.txtNote);
            txtNote.setText(NewData.Articles[position]);
        }
    }
}
