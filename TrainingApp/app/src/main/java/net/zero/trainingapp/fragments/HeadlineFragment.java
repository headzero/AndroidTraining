package net.zero.trainingapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.zero.trainingapp.Ipsum;
import net.zero.trainingapp.R;

/**
 * Created by zero on 2015. 3. 28..
 */
public class HeadlineFragment extends ListFragment {

    private OnHeadlineSelectedListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layout = android.R.layout.simple_list_item_activated_1;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), layout, Ipsum.Headlines);
        setListAdapter(arrayAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        if(getFragmentManager().findFragmentById(R.id.article_fragment) != null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//
//        try{
            mCallback = (OnHeadlineSelectedListener)activity;
//        } catch(ClassCastException e){
//            throw new ClassCastException(activity.toString() + "must implement OnHeadLineSelectedListener");
//        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if(mCallback == null){
            return;
        }

        mCallback.onArticleSelected(position);
        getListView().setItemChecked(position, true);
    }

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }
}
