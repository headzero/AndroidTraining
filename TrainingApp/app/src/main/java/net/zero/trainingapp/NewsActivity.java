package net.zero.trainingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import net.zero.trainingapp.fragments.ArticleFragment;
import net.zero.trainingapp.fragments.HeadlineFragment;

/**
 * Created by zero on 2015. 3. 28..
 */
public class NewsActivity extends FragmentActivity implements
        HeadlineFragment.OnHeadlineSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        if (findViewById(R.id.fragment_container) != null){

            HeadlineFragment headlineFragment = new HeadlineFragment();
            headlineFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, headlineFragment).commit();
        }
    }

    @Override
    public void onArticleSelected(int position) {
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if(articleFragment != null){
            articleFragment.updateArticleView(position);
        } else {
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();

        }
    }
}
