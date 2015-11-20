package pt.olx.challenge.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import pt.olx.challenge.utils.DomainUtils;
import pt.olxchallenge.R;
import pt.olx.challenge.adapters.OlxAdDetailsAdapter;


public class OlxAdsActivity extends FragmentActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olx_ads_pager);

        String id = null;
        Bundle extras = getIntent().getExtras();
        if(extras != null)
            id = extras.getString("olxAdId");

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new OlxAdDetailsAdapter(getSupportFragmentManager(), DomainUtils.olxAdList);
        mPager.setAdapter(mPagerAdapter);

        if(id != null) {
            int position = DomainUtils.getCurrentAd(id);
            mPager.setCurrentItem(position);
        }

    }
}