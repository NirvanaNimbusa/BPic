package com.happy.samuelalva.bcykari.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.happy.samuelalva.bcykari.support.Constants;

/**
 * Created by Samuel.Alva on 2015/4/17.
 */
public class BcyIllustTopPostFragment extends BcyAbsTopPostFragment {
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        requestUrl = Constants.ILLUST_TOP_POST_100_API_BCY;
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void doLoad() {
        Toast.makeText(getActivity(), "没有更多了", Toast.LENGTH_SHORT).show();
    }
}
