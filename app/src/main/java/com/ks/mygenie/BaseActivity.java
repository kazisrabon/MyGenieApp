package com.ks.mygenie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.util.KeyboardUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BaseActivity extends AppCompatActivity {

    private String TAG = "Base";

    private AccountHeader mHeaderResult = null;
    private Drawer mDrawer = null;
    private IProfile mProfile;
    private MiniDrawer mMiniDrawer = null;
    private Drawable mProfileImage;

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    public static final SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

    public static final DateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
    public static final DateFormat longTimeFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean validateLogin(String typedCode, String typedPass) {
        return true;
    }

    public boolean validateConfirmationCode(String typedCode) {
        return true;
    }

    public void setupDrawer(Bundle savedInstanceState, final Activity activity, final Context context, Toolbar toolbar, String name,
                            String pro_pic_url, int selectedItem, int badges){
        setProfile(name, pro_pic_url);
        buildHeader(savedInstanceState, activity);

        mDrawer = new DrawerBuilder()
                .withActivity(activity)
                .withSelectedItem(selectedItem)
                .withAccountHeader(mHeaderResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
//                        0
                        new PrimaryDrawerItem().withName(R.string.drawer_item_1)
                                .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_account_add)
                                        .actionBar()
                                        .paddingDp(5)
                                        .colorRes(R.color.material_drawer_dark_primary_text))
                                .withSelectedIconColor(Color.RED)
                                .withIconTintingEnabled(true)
                                .withIdentifier(0),
//                        1
                        new PrimaryDrawerItem().withName(R.string.drawer_item_2)
                                .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_settings)
                                        .actionBar()
                                        .paddingDp(5)
                                        .colorRes(R.color.material_drawer_dark_primary_text))
                                .withSelectedIconColor(Color.RED)
                                .withIconTintingEnabled(true)
                                .withIdentifier(1),
//                        2
                        new PrimaryDrawerItem().withName(R.string.drawer_item_3)
                                .withIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_qrcode)
                                        .actionBar()
                                        .paddingDp(5)
                                        .colorRes(R.color.material_drawer_dark_primary_text))
                                .withSelectedIconColor(Color.RED)
                                .withIconTintingEnabled(true)
                                .withIdentifier(2),
//                        3
                        new PrimaryDrawerItem().withName(R.string.drawer_item_4)
                                .withIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_sign_out)
                                        .actionBar()
                                        .paddingDp(5)
                                        .colorRes(R.color.material_drawer_dark_primary_text))
                                .withSelectedIconColor(Color.RED)
                                .withIconTintingEnabled(true)
                                .withIdentifier(3),
//                                .withEnabled(false),
//                        4
                        new PrimaryDrawerItem().withName(R.string.drawer_item_5)
                                .withIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_info)
                                        .actionBar()
                                        .paddingDp(5)
                                        .colorRes(R.color.material_drawer_dark_primary_text))
                                .withSelectedIconColor(Color.RED)
                                .withIconTintingEnabled(true)
//                                .withBadge(badges)
//                                .withBadgeStyle(new BadgeStyle(Color.RED, Color.RED))
                                .withIdentifier(4),
//                        5
                        new PrimaryDrawerItem().withName(R.string.drawer_item_6)
                                .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_close)
                                        .actionBar()
                                        .paddingDp(5)
                                        .colorRes(R.color.material_drawer_dark_primary_text))
                                .withSelectedIconColor(Color.RED)
                                .withIconTintingEnabled(true)
                                .withIdentifier(5)
                ) // add the items we want to use with our Drawer
                .withOnDrawerNavigationListener(new Drawer.OnDrawerNavigationListener() {
                    @Override
                    public boolean onNavigationClickListener(View clickedView) {
                        //this method is only called if the Arrow icon is shown. The hamburger is automatically managed by the MaterialDrawer
                        //if the back arrow is shown. close the activity
//                        mActivity.finish();
                        //return true if we have consumed the event
                        return true;
                    }
                })
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
//                        Toast.makeText(MapsActivity.this, "onDrawerOpened", Toast.LENGTH_SHORT).show();
                        KeyboardUtil.hideKeyboard(activity);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
//                        Toast.makeText(MapsActivity.this, "onDrawerClosed", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem instanceof Nameable) {
                            Toast.makeText(context, ((Nameable) drawerItem).getName()
                                    .getText(context), Toast.LENGTH_SHORT).show();
//                            0
                            if (drawerItem.getIdentifier() == 0) {
                                startActivity(new Intent(context, LoginActivity.class));
                            }
//                            1
                            else if (drawerItem.getIdentifier() == 1) {
//                                startActivity(new Intent(mContext, ActivityConsignmentList.class));
                            }
//                            2
                            else if (drawerItem.getIdentifier() == 2) {
//                                startActivity(new Intent(context, GroupChatSettingActivity.class));
                            }
//                            3
                            else if (drawerItem.getIdentifier() == 3) {
//                                startActivity(new Intent(context, ProfileActivity.class));
                            }
//                            4
                            else if (drawerItem.getIdentifier() == 4) {
//                                startActivity(new Intent(context, ChatActivity.class));
                            }
//                            5
                            else if (drawerItem.getIdentifier() == 5) {
//                                startActivity(new Intent(context, GroupChatActivity.class));
                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();
    }

    private void buildHeader(Bundle savedInstanceState, Activity activity) {
        // Create the AccountHeader
        mHeaderResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.drawable.bg_nav_main)
                .addProfiles(mProfile)
//                .withOnAccountHeaderProfileImageListener(new AccountHeader.OnAccountHeaderProfileImageListener() {
//                    @Override
//                    public boolean onProfileImageClick(View view, IProfile profile, boolean current) {
//                        String uName = String.valueOf(profile.getName().getText());
//                        if (!nullCheck(uName))
////                            startActivity(new Intent(mContext, ActivityProfile.class));
//
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onProfileImageLongClick(View view, IProfile profile, boolean current) {
//                        String uName = String.valueOf(profile.getName().getText());
//                        if (!nullCheck(uName)){
////                            if (mProfileImage != null)
//
//                        }
//                        return false;
//                    }
//                })
                .withSavedInstance(savedInstanceState)
                .build();
    }


    public void setProfile(String name, String pro_pic_url) {
        Log.e(TAG, pro_pic_url+" "+name);
//        mProfile = new ProfileDrawerItem().withName(name).withIcon(getResources().getDrawable(R.drawable.ic_default_propic));
        if(nullCheck(pro_pic_url))
            mProfile = new ProfileDrawerItem().withName(name).withIcon(getResources().getDrawable(R.drawable.ic_default_propic));

        else mProfile = new ProfileDrawerItem().withName(name).withIcon(pro_pic_url);
    }

//    return false if not null
    public boolean nullCheck (String s){
        return !(s != null && !s.isEmpty() && !s.equals(""));
    }

    public String getCurrentTime() {

        Date today = Calendar.getInstance().getTime();
        return timeFormat.format(today);
    }

    public String getCurrentDate() {

        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
