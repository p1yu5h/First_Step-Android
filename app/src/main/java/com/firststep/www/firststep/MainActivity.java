package com.firststep.www.firststep;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener {

    int ima;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ima=0;
       /* if(isNetworkAvailable()){
        for(int x=0;x<10;x++) {
            volleygetImagefunc("http://192.168.43.96:8080/static/image"+x+".jpg");
            Log.d("bhavyammm",""+x);
        }}
*/
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.noti_icon));
        //tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.galary_icon));
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        final PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.logo2);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void openPopUp(String s){
        Intent i =new Intent(this,PopUp2.class);
        i.putExtra("topic",s);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.notifications) {
            viewPager.setCurrentItem(1);
            // Handle the camera action
        } else if (id == R.id.school_programs) {
            openTransparentActivity(0);

        } else if (id == R.id.fee_structure) {
            openTransparentActivity(3);
        } else if (id == R.id.curriculum) {
            openPopUp("Curriculum");

        } else if (id == R.id.school_events) {
            openTransparentActivity(2);

        } else if (id == R.id.gallery) {
            Uri gmm = Uri.parse("https://www.facebook.com/pg/firststepedu.net/photos/");
            Intent i = new Intent(Intent.ACTION_VIEW, gmm);
            startActivity(i);

        }else if (id == R.id.about_us) {
            Intent i =new Intent(this,about_us.class);
            startActivity(i);

        }else if (id == R.id.website) {
            Uri gmm = Uri.parse("http://firststepedu.net/");
            Intent i = new Intent(Intent.ACTION_VIEW, gmm);
            startActivity(i);
        }else if (id == R.id.fb_page) {
            Uri gmm = Uri.parse("https://m.facebook.com/firststepedu.net");
            Intent i = new Intent(Intent.ACTION_VIEW, gmm);
            startActivity(i);


        }else if (id == R.id.contact_us) {
            Intent i =new Intent(this,Contact_Us.class);
            startActivity(i);

        }else if (id == R.id.reach_us) {
            if(isGoogleMapsInstalled()) {
                Uri gmm = Uri.parse("geo:0,0?q=28.604875,77.434840(First Step Pre School and Day Care)");
                Intent i = new Intent(Intent.ACTION_VIEW, gmm);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);
            }else{
                Toast.makeText(this,"Google Maps Not Installed",Toast.LENGTH_LONG).show();
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private String saveToInternalStorage(Bitmap bitmapImage,int i){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        File mypath=new File(directory,"image"+i+".jpg");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            Log.d("bhavyammm",mypath.toString());
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       // Log.d("bhavyammm",directory.getAbsolutePath());
        return directory.getAbsolutePath();
    }
    public void volleygetImagefunc(String url)
    {
        RequestQueue queue = Volley.newRequestQueue(this);

        //Toast.makeText(MainActivity.this,"Inside function",Toast.LENGTH_SHORT).show();

        final ImageRequest imageRequest=new ImageRequest (url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                Log.d("bhavyammm","image"+ima);
                saveToInternalStorage(response,ima++);

            }
        },0,0, ImageView.ScaleType.CENTER_CROP,null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

              //  Toast.makeText(MainActivity.this,"Some Thing Goes Wrong",Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        });
        queue.add(imageRequest);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void openTransparentActivity(int pos)
    {
        Intent i=new Intent(this,transparent_activity.class);
        i.putExtra("position",pos);
        startActivity(i);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public boolean isGoogleMapsInstalled()
    {
        try
        {
            ApplicationInfo info = getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0 );
            return true;
        }
        catch(PackageManager.NameNotFoundException e)
        {
            return false;
        }
    }
    public static boolean isPackageInstalled(Context c, String targetPackage) {
        PackageManager pm = c.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
