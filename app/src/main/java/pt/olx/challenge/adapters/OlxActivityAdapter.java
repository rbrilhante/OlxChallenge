package pt.olx.challenge.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import pt.olx.challenge.fragments.MapFragment;
import pt.olx.challenge.fragments.OlxListFragment;

/**
 * Created by adminusrlocal on 17-11-2015.
 */
public class OlxActivityAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public OlxActivityAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                OlxListFragment olxListFragment = new OlxListFragment();
                return olxListFragment;
            case 1:
                MapFragment mapFragment = new MapFragment();
                return mapFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
