package com.example.android.tourguide.activitys;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapter.InfoAdapter;
import com.example.android.tourguide.data.Info;
import com.example.android.tourguide.fragments.CountryFragment;
import com.example.android.tourguide.fragments.InfoFragment;
import com.example.android.tourguide.helper.Config;

import static com.example.android.tourguide.helper.Config.FRAGMENTTAG;


public class MainActivity extends AppCompatActivity implements InfoAdapter.OnInfoItemSelectedListener {

    private DrawerLayout drawerLayout;
    public static String PACKAGE_NAME;

    NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            item.setChecked(true);
            drawerLayout.closeDrawers();

            setSelectedFragment(item.getItemId());
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpNavigation();
        setSelectedFragment(R.id.country); //Set the initial fragment
        PACKAGE_NAME = getApplicationContext().getPackageName();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) drawerLayout.openDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }

    /**
     * Initial setup for navigation
     */
    private void setUpNavigation() {
        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);

        Toolbar actionBar = findViewById(R.id.toolbar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }

    /**
     * Create fragment instance
     *
     * @param itemId selected itemId
     */
    private void setSelectedFragment(int itemId) {

        Fragment fragment = null;
        Bundle arguments = new Bundle();

        if (itemId != R.id.country) fragment = new InfoFragment();

        switch (itemId) {
            case R.id.country:
                fragment = new CountryFragment();
                arguments.putInt(Config.MENUVARIANT, Config.MENUCOUNTRY);
                break;
            case R.id.cities:
                arguments.putInt(Config.MENUVARIANT, Config.MENUCITY);
                break;
            case R.id.river_and_lake:
                arguments.putInt(Config.MENUVARIANT, Config.MENURIVERANDLAKES);
                break;
            case R.id.attractions:
                arguments.putInt(Config.MENUVARIANT, Config.MENUATTRACTIONS);
                break;
            case R.id.parks:
                arguments.putInt(Config.MENUVARIANT, Config.MENUPARKS);
                break;

        }
        fragment.setArguments(arguments);
        setFragment(fragment);
    }

    /**
     * Set the fragment
     *
     * @param fragment
     */
    private void setFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.viewHolder, fragment, FRAGMENTTAG);
            transaction.commit();
        }
    }

    @Override
    public void onInfoSelected(Info info) {
        Toast.makeText(this, "selected", Toast.LENGTH_SHORT).show();
        InfoFragment infoFragment = (InfoFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENTTAG);
        infoFragment.updateInfos(info);
    }

}
