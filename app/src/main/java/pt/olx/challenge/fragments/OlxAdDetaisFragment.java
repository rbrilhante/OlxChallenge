package pt.olx.challenge.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pt.olx.challenge.domain.OlxAd;
import pt.olxchallenge.R;

/**
 * Created by Asus on 18-11-2015.
 */
public class OlxAdDetaisFragment extends Fragment {

    private OlxAd olxAd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.olx_ad_details, container, false);

        TextView textViewTitle = (TextView) rootView.findViewById(R.id.textItemTitle);
        textViewTitle.setText(olxAd.getTitle());

        TextView textViewPrice = (TextView) rootView.findViewById(R.id.textItemPrice);
        textViewPrice.setText(olxAd.getListLabelAd());

        TextView textViewDate = (TextView) rootView.findViewById(R.id.textViewItemDate);
        textViewDate.setText(olxAd.getCreated());

        TextView textViewLocation = (TextView) rootView.findViewById(R.id.textViewItemLocation);
        textViewLocation.setText(olxAd.getCityLabel());

        TextView textDescription = (TextView) rootView.findViewById(R.id.textDescription);
        textDescription.setText(olxAd.getDescription());

        TextView textUser = (TextView) rootView.findViewById(R.id.textUser);
        textUser.setText(olxAd.getUserLabel());

        return rootView;
    }

    public void setOlxAd(OlxAd olxAd){
        this.olxAd = olxAd;
    }

}
