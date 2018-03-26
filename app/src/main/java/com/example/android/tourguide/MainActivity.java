package com.example.android.tourguide;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

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

        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    /**
     * Create fragment instance
     *
     * @param itemId selected itemId
     */
    private void setSelectedFragment(int itemId) {

        Fragment fragment = null;

        switch (itemId) {

        }

        setFragment(fragment);
    }

    /**
     * Set the fragmen
     *
     * @param fragment
     */
    private void setFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.viewHolder, fragment);
            transaction.commit();
        }
    }
}
