package pt.olx.challenge.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

import pt.olx.challenge.domain.OlxAd;
import pt.olxchallenge.R;

/**
 * Created by Asus on 14-04-2015.
 */
public class OlxAdsAdapter extends ArrayAdapter<OlxAd> {

    private List<OlxAd> olxAds;
    private Context context;


    public OlxAdsAdapter(Context context, int textViewResourceId, List<OlxAd> olxAds) {

        super(context, textViewResourceId, olxAds);
        this.context = context;
        this.olxAds = olxAds;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.olx_list_ad, parent, false); //TODO remove xlarge

        OlxAd olxAd = olxAds.get(position);

        TextView textViewTitle = (TextView) convertView.findViewById(R.id.textItemTitle);
        textViewTitle.setText(olxAd.getTitle());

        TextView textViewPrice = (TextView) convertView.findViewById(R.id.textItemPrice);
        textViewPrice.setText(olxAd.getListLabelAd());

        TextView textViewDate = (TextView) convertView.findViewById(R.id.textViewItemDate);
        textViewDate.setText(olxAd.getCreated());

        TextView textViewLocation = (TextView) convertView.findViewById(R.id.textViewItemLocation);
        textViewLocation.setText(olxAd.getCityLabel());

        return convertView;
    }
}