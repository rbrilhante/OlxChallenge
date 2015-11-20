package pt.olx.challenge.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import pt.olx.challenge.domain.OlxAd;
import pt.olx.challenge.fragments.OlxAdDetaisFragment;

/**
 * Created by Asus on 20-11-2015.
 */

public class OlxAdDetailsAdapter extends FragmentStatePagerAdapter {

    private List<OlxAd> olxAdsList;

    public OlxAdDetailsAdapter(FragmentManager fm, List<OlxAd> olxAdsList) {
        super(fm);
        this.olxAdsList = olxAdsList;
    }

    @Override
    public Fragment getItem(int position) {
        OlxAdDetaisFragment olxAdDetaisFragment = new OlxAdDetaisFragment();
        olxAdDetaisFragment.setOlxAd(olxAdsList.get(position));
        return olxAdDetaisFragment;
    }

    @Override
    public int getCount() {
        return olxAdsList.size();
    }
}
