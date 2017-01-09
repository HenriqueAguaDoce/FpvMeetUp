package pt.ipbeja.pdm2.fpvmeetup;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentArticle extends Fragment {
    int currentPosition;

    public FragmentArticle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    @Override public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            currentPosition = args.getInt("position");
            TextView article = (TextView) getActivity().findViewById(R.id.txtNote);
            article.setText(NewData.Articles[currentPosition]);
        }
    }

}
