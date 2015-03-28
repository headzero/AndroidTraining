package net.zero.trainingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.zero.trainingapp.Ipsum;
import net.zero.trainingapp.R;

/**
 * Created by zero on 2015. 3. 28..
 */
public class ArticleFragment extends Fragment {

    public static final String ARG_POSITION = "ArgPosition";
    private int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_view, container, false);

        if(savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if(args != null){
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1){
            updateArticleView(mCurrentPosition);
        }

    }

    public void updateArticleView(int position) {
        if(getView().findViewById(R.id.article) == null){
            return;
        }
        TextView article = (TextView) getView().findViewById(R.id.article);
        article.setText(Ipsum.Articles[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
