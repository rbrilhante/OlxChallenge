package pt.olxchallenge;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by adminusrlocal on 17-11-2015.
 */
public class MapFragment extends Fragment implements GoogleMap.OnCameraChangeListener, GoogleMap.OnMarkerClickListener {
    private SupportMapFragment fragment;
    private GoogleMap map;

    private Marker mMarker;
    private PopupWindow mPopupWindow;
    private int mWidth;
    private int mHeight;

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
            map.setOnCameraChangeListener(this);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(38.9049241, -9.0428903), 6.0f));
            map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                // Use default InfoWindow frame
                @Override
                public View getInfoWindow(Marker arg0) {
                    return null;
                }

                // Defines the contents of the InfoWindow
                @Override
                public View getInfoContents(Marker arg0) {

                    // Getting view from the layout file info_window_layout
                    View v = getActivity().getLayoutInflater().inflate(R.layout.windowlayout, null);

                    // Getting the position from the marker
                    LatLng latLng = arg0.getPosition();

                    // Getting reference to the TextView to set latitude
                    TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);

                    // Getting reference to the TextView to set longitude
                    TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);

                    // Setting the latitude
                    tvLat.setText("Latitude:" + latLng.latitude);

                    // Setting the longitude
                    tvLng.setText("Longitude:" + latLng.longitude);

                    // Returning the view containing InfoWindow contents
                    return v;

                }
            });

            map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Intent intent = new Intent(getActivity(), OlxItemsActivity.class);
                    startActivity(intent);
                }
            });

                Marker badjoras = map.addMarker(new MarkerOptions().position(new LatLng(38.9049241, -9.0428903)));
                badjoras.showInfoWindow();

                //map.setOnMarkerClickListener(this);
            }
        }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        updatePopup();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }

        View popupView = getActivity().getLayoutInflater().inflate(R.layout.default_marker_info_window, null);
        ViewFlipper markerInfoContainer = (ViewFlipper)popupView.findViewById(R.id.markerInfoContainer);
        View viewContainer = getActivity(). getLayoutInflater().inflate(R.layout.default_marker_info_layout, null);
        TextView tvTitulo = (TextView) viewContainer.findViewById(R.id.tvTitulo);
        TextView tvCuerpo = (TextView) viewContainer.findViewById(R.id.tvCuerpo);
        tvTitulo.setText(marker.getTitle());
        tvCuerpo.setVisibility(View.GONE);

        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        popupView.measure(size.x, size.y);

        mWidth = popupView.getMeasuredWidth();
        mHeight = popupView.getMeasuredHeight();
        mMarker = marker;
        mPopupWindow = popupWindow;

        updatePopup();

        return true;
    }

    private void updatePopup() {
        if (mMarker != null && mPopupWindow != null) {
            // marker is visible
            if (map.getProjection().getVisibleRegion().latLngBounds.contains(mMarker.getPosition())) {
                if (!mPopupWindow.isShowing()) {
                    mPopupWindow.showAtLocation(getView(), Gravity.NO_GRAVITY, 0, 0);
                }
                Point p = map.getProjection().toScreenLocation(mMarker.getPosition());
                mPopupWindow.update(p.x - mWidth / 2, p.y - mHeight + 100, -1, -1);
            } else { // marker outside screen
                mPopupWindow.dismiss();
            }
        }
    }
}
