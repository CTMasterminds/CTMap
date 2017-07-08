package com.example.shekharsuman.map_activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Arrays;
import java.util.List;

public class Gmap_activity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnPolygonClickListener, GoogleMap.OnPolylineClickListener {

    private GoogleMap mMap;
    private static final int PATTERN_GAP_LENGTH_PX = 20;
    private static final PatternItem DOT = new Dot();
    private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);
    private static final List<PatternItem> PATTERN_POLYLINE_DOTTED = Arrays.asList(GAP, DOT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmap_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /*
            LatLng india = new LatLng(30.375321, 69.345116);
            mMap.addMarker(new MarkerOptions().position(india).title("marker in pakistan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(india));
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.defaultMar*//*ker(BitmapDescriptorFactory.HUE_RED)));*/

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LatLng jalandhar = new LatLng(31.236375, 75.554506);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jalandhar, 17));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(27), 2000, null);

        MarkerOptions ct = new MarkerOptions().position(new LatLng(31.236375, 75.554506)).title("ct group");
        MarkerOptions ctGate = new MarkerOptions().position(new LatLng(31.238034, 75.554488)).title("CT MAIN GATE");
        MarkerOptions frontPark = new MarkerOptions().position(new LatLng(31.237472, 75.553959)).title("CT FRONT PARK");
        MarkerOptions pnb = new MarkerOptions().position(new LatLng(31.238091, 75.554828)).title("CT PNB BANK");
        MarkerOptions busStand = new MarkerOptions().position(new LatLng(31.238029, 75.555499)).title("CT BUS STAND");
        MarkerOptions ctpc = new MarkerOptions().position(new LatLng(31.237373, 75.555263)).title("POLYTECHNIC BLOCK");
        MarkerOptions ctPharmacy = new MarkerOptions().position(new LatLng(31.236827, 75.555435)).title("PHARMACY BLOCK");
        MarkerOptions engBlock = new MarkerOptions().position(new LatLng(31.236958, 75.554037)).title("CTIEMT ENGINEERING BLOCK");
        MarkerOptions managementBlock = new MarkerOptions().position(new LatLng(31.236236, 75.553943)).title("MANAGEMENT BLOCK");
        MarkerOptions hangout = new MarkerOptions().position(new LatLng(31.236216, 75.554788)).title("HANGOUT CANTEEN");
        MarkerOptions bookstore = new MarkerOptions().position(new LatLng(31.236030, 75.554963)).title("TUCK SHOP");
        MarkerOptions audi = new MarkerOptions().position(new LatLng(31.235653, 75.554668)).title("MANJEET KAUR AUDITORIUM");
        MarkerOptions ground = new MarkerOptions().position(new LatLng(31.234989, 75.553204)).title("CT PLAY GROUND");
        // mMap.addMarker(jalandhar1).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(ct).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mMap.addMarker(ctGate).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mMap.addMarker(frontPark).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(pnb).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mMap.addMarker(busStand).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        mMap.addMarker(ctpc).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        mMap.addMarker(ctPharmacy).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mMap.addMarker(engBlock).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mMap.addMarker(managementBlock).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        mMap.addMarker(hangout).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mMap.addMarker(bookstore).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        mMap.addMarker(audi).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mMap.addMarker(ground).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        mMap.getCameraPosition();
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.setTrafficEnabled(true);
        mMap.getFocusedBuilding();
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Polyline polyline = mMap.addPolyline((new PolylineOptions())
                .clickable(true)
                .add(new LatLng(31.308383, 75.578210),
                        new LatLng(31.308393, 75.578209),
                        new LatLng(31.308373, 75.578201),
                        new LatLng(31.308363, 75.578207),
                        new LatLng(31.308333, 75.5782004),
                        new LatLng(31.3083843, 75.578205)));
        googleMap.setOnPolylineClickListener(this);
        googleMap.setOnPolygonClickListener(this);

    }

    @Override
    public void onPolygonClick(Polygon polygon) {


    }

    @Override
    public void onPolylineClick(Polyline polyline) {
        if ((polyline.getPattern() == null) || (!polyline.getPattern().contains(DOT))) {
            polyline.setPattern(PATTERN_POLYLINE_DOTTED);
        } else {
            polyline.setPattern(null);
        }
        Toast.makeText(this, "Route type " + polyline.getTag().toString(),
                Toast.LENGTH_SHORT).show();
    }
}
