package pt.olx.challenge.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

import pt.olx.challenge.adapters.OlxActivityAdapter;
import pt.olx.challenge.domain.OlxAd;
import pt.olx.challenge.http.HttpCall;
import pt.olx.challenge.interfaces.IOlxAds;
import pt.olx.challenge.utils.DatabaseUtils;
import pt.olx.challenge.utils.DomainUtils;
import pt.olxchallenge.R;


public class OlxActivity extends FragmentActivity implements IOlxAds {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olx_activity);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_list)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_map)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager = (ViewPager) findViewById(R.id.pager);

        DatabaseUtils.initDatabase(this);
        DatabaseUtils.getDatabaseOlxAds();

        if(DomainUtils.olxAdList.size() == 0)
            new HttpCall(this).execute();
        else
            initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void getOlxAdsCalback(List<OlxAd> olxAdList) {
        DomainUtils.olxAdList = olxAdList;
        for(OlxAd olxAd : olxAdList)
            DatabaseUtils.saveOlxAd(olxAd);
        initView();
    }

    private void initView(){

        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        final OlxActivityAdapter adapter = new OlxActivityAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}