package com.wild.swimming.australia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 5/29/2016.
 */
public class Tab4Container extends BaseContainerFragment {
    private static final String TAG = "Tab4Container";
    private boolean IsViewInited;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "Tab4");
        return inflater.inflate(R.layout.fragment_base_container, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!IsViewInited) {
            IsViewInited = true;
            initView();
        }
    }

    private void initView() {
        replaceFragment(new RatingCommentFragment(), false);
    }
}
