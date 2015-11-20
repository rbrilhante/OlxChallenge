package pt.olx.challenge.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pt.olx.challenge.activities.OlxAdsActivity;
import pt.olx.challenge.domain.OlxAd;
import pt.olx.challenge.utils.DomainUtils;
import pt.olxchallenge.R;

/**
 * Created by adminusrlocal on 17-11-2015.
 */
public class MapFragment extends Fragment implements GoogleMap.OnMarkerClickListener {
    private SupportMapFragment fragment;
    private GoogleMap map;

    private List<String> markerLocation;
    static final float COORDINATE_OFFSET = 0.00002f;
    private HashMap<Marker, OlxAd> markersAds;

    private int numberOfMarkers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.location_map);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.location_map, fragment).commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map == null) {
            map = fragment.getMap();
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(38.9049241, -9.0428903), 6.0f));
            setInfoWindow();
            this.markerLocation = new ArrayList<String>();
            this.markersAds = new HashMap<Marker, OlxAd>();
            this.numberOfMarkers = (DomainUtils.olxAdList.size());
            addMarkers(DomainUtils.olxAdList);
            map.setOnMarkerClickListener(this);
        }
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return true;
    }

    private void setInfoWindow(){
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            // Use default InfoWindow frame
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            // Defines the contents of the InfoWindow
            @Override
            public View getInfoContents(Marker marker) {

                // Getting view from the layout file info_window_layout
                View v = getActivity().getLayoutInflater().inflate(R.layout.olx_list_ad, null);

                OlxAd olxAd = markersAds.get(marker);

                TextView textViewTitle = (TextView) v.findViewById(R.id.textItemTitle);
                textViewTitle.setText(olxAd.getTitle());

                TextView textViewPrice = (TextView) v.findViewById(R.id.textItemPrice);
                textViewPrice.setText(olxAd.getListLabelAd());

                TextView textViewDate = (TextView) v.findViewById(R.id.textViewItemDate);
                textViewDate.setText(olxAd.getCreated());

                return v;

            }
        });

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                OlxAd olxAd = markersAds.get(marker);

                Intent intent = new Intent(getActivity(), OlxAdsActivity.class);
                intent.putExtra("olxAdId", olxAd.getId());
                startActivity(intent);
            }
        });
    }

    private void addMarkers(List<OlxAd> olxAdList){
        for(OlxAd olxAd : olxAdList){
            Double[] location = coordinateForMarker(olxAd.getMapLat(), olxAd.getMapLon());
            Marker marker = map.addMarker(new MarkerOptions().position(new LatLng(location[0], location[1])));
            markersAds.put(marker, olxAd);
        }

    }

    private boolean mapAlreadyHasMarkerForLocation(String location) {
        return (markerLocation.contains(location));
    }

    private Double[] coordinateForMarker(double latitude, double longitude) {

        Double[] location = new Double[2];

        for (int i = 0; i <= this.numberOfMarkers; i++) {

            if (mapAlreadyHasMarkerForLocation((latitude + i
                    * COORDINATE_OFFSET)
                    + "," + (longitude + i * COORDINATE_OFFSET))) {

                if (i == 0)
                    continue;

                if (mapAlreadyHasMarkerForLocation((latitude - i
                        * COORDINATE_OFFSET)
                        + "," + (longitude - i * COORDINATE_OFFSET))) {

                    continue;

                } else {
                    location[0] = latitude - (i * COORDINATE_OFFSET);
                    location[1] = longitude - (i * COORDINATE_OFFSET);
                    break;
                }

            } else {
                location[0] = latitude + (i * COORDINATE_OFFSET);
                location[1] = longitude + (i * COORDINATE_OFFSET);
                break;
            }
        }

        markerLocation.add(location[0] + "," + location[1]);

        return location;
    }
}
