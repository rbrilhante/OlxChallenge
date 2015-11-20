package pt.olx.challenge.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import pt.olx.challenge.activities.OlxAdsActivity;
import pt.olx.challenge.domain.OlxAd;
import pt.olx.challenge.utils.DomainUtils;
import pt.olxchallenge.R;
import pt.olx.challenge.adapters.OlxAdsAdapter;

/**
 * Created by Asus on 18-11-2015.
 */
public class OlxListFragment extends ListFragment{

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        OlxAdsAdapter adapter = new OlxAdsAdapter(getActivity(),
                R.layout.olx_list_ad, DomainUtils.olxAdList);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        OlxAd olxAd = DomainUtils.olxAdList.get(position);
        Intent intent = new Intent(getActivity(), OlxAdsActivity.class);
        intent.putExtra("olxAdId", olxAd.getId());
        startActivity(intent);
    }
}
