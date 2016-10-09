package com.sinapsis.rizoma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.KeyEvent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import DTO.Load_Content_Page;
import class_project.*;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private static int iContFragment = 0;
    private ArrayList<String> sTitle;
    private FrameLayout frlBlackboard;
    private FrameLayout frg_Info, frg_Info_image;
    private RelativeLayout rly_container_drag, rly_general_screen;
    private Menu_Item_Project menu_item_project;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        General.ACTIVITY = this;
        General.CONTEXT = this;
        General.ROUTE = Environment.getExternalStorageDirectory().getAbsolutePath();
        Bundle extras = null;
        try {

            setContentView(R.layout.activity_main);
            String newString = getIntent().getStringExtra("data");

            if (savedInstanceState == null) {
                Log.i("extra", "Data " + newString);
                extras = getIntent().getExtras();
                if (newString == null) {


                } else {
                    extras.getString("STRING_I_NEED");


                }
            } else {
                newString = (String) savedInstanceState.getSerializable("STRING_I_NEED");

            }
            if(General.SELECT!=0){
                menu_item_project = new Menu_Item_Project(3, 1, false);

                loadSelectionItems();
            }
            loadToolbar();
            loadDrawerLayout();
            loadNavigationView();
            loadView();
        } catch (Exception e) {
            Toast.makeText(this, R.string.message, Toast.LENGTH_LONG).show();
            reloadActivity(this);
        }


    }

    //ToolBar DrawerLayout
    private void loadToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //reinicia una Activity
    public static void reloadActivity(Activity actividad) {
        Intent intent = new Intent();
        intent.setClass(actividad, actividad.getClass());
        //llamamos a la actividad
        actividad.startActivity(intent);
        //finalizamos la actividad actual
        actividad.finish();
    }

    private void loadDrawerLayout() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void loadNavigationView() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void loadView() {


        frlBlackboard = (FrameLayout) findViewById(R.id.container_blackboard);

        frg_Info = (FrameLayout) findViewById(R.id.container_Info);
        frg_Info_image = (FrameLayout) findViewById(R.id.container_InfoImage);

        rly_container_drag = (RelativeLayout) findViewById(R.id.container_drag);
        rly_container_drag.setOnDragListener(new MyDragListener());
        General.RELATIVE_LAYOUT = rly_container_drag;

        rly_general_screen = (RelativeLayout) findViewById(R.id.Container_fragment_general);
        General.RELATIVE_LAYOUT_SCREEN = rly_general_screen;
        sTitle = new ArrayList<>();

    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //Select Items DrawerLayout
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final List<MenuItem> items = new ArrayList<>();
        Menu menu = navigationView.getMenu();


        //Multi view   =0;
        //Video        =1;
        //Image        =2;
        //lista Img    =3;
        //lista video  =4;


        switch (item.getItemId()) {
            case R.id.nav_option0_1:
                menu_item_project = new Menu_Item_Project(0, 0, true);

                break;
            case R.id.nav_option0_2:
                menu_item_project = new Menu_Item_Project(1, 0, true);
                break;
            case R.id.nav_option0_3:
                menu_item_project = new Menu_Item_Project(2, 0, false);
                break;
            case R.id.nav_option0_4:
                menu_item_project = new Menu_Item_Project(3, 1, false);
                break;
            case R.id.nav_option0_5:
                menu_item_project = new Menu_Item_Project(4, 6, false);
                break;
            case R.id.nav_option1_1:
                menu_item_project = new Menu_Item_Project(5, 4, false);
                break;
            case R.id.nav_option1_2:
                menu_item_project = new Menu_Item_Project(6, 3, false);
                break;
            case R.id.nav_option1_3:
                Toast.makeText(this, "Selección disponible próximamente ", Toast.LENGTH_LONG).show();
                return true;
            case R.id.nav_option2_1:
                menu_item_project = new Menu_Item_Project(8, 2, false);
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        General.sTITLE = item.getTitle().toString();
        loadSelectionItems();

        return true;
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    @Override
    public void onClick(View v) {

    }

    private void loadSelectionItems() {
        Intent intent = null;
        Fragment fragment = null;
        if (menu_item_project.bTypeView) {
            intent = menu_item_project.loadViewActivity();
            startActivity(intent);
        } else {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container_view, menu_item_project.loadViewFragment());
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        iContFragment++;
        setTitle(General.sTITLE);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            iContFragment--;
        }
        return super.onKeyDown(keyCode, event);
    }
}
