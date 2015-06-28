package com.happy.samuelalva.bcykari.ui.activity;

import com.happy.samuelalva.bcykari.support.Constants;
import com.happy.samuelalva.bcykari.support.adapter.BcyDetailListAdapter;
import com.happy.samuelalva.bcykari.support.adapter.DetailListAdapter;
import com.happy.samuelalva.bcykari.support.http.BcyHttpClient;
import com.happy.samuelalva.bcykari.ui.activity.base.BaseDetailActivity;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel.Alva on 2015/6/15.
 */
public class BcyDetailActivity extends BaseDetailActivity {
    @Override
    protected DetailListAdapter getAdapter() {
        return new BcyDetailListAdapter(this);
    }

    @Override
    protected void doRequest(String url, AsyncHttpResponseHandler handler) {
        BcyHttpClient.get(this, Constants.BASE_API_BCY + url, handler);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BcyHttpClient.cancel(this);
    }

    @Override
    protected void updateData(Document doc) {
        List<String> data = new ArrayList<>();
        Elements elements = doc.getElementsByAttributeValue("class", "detail_std detail_clickable");
        for (Element e : elements) {
            data.add(e.attr("src").replace("/w650", ""));
        }
        mAdapter.addAll(data);
    }
}