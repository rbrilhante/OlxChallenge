package pt.olxchallenge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by adminusrlocal on 17-11-2015.
 */
public class OlxPageAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public OlxPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
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
