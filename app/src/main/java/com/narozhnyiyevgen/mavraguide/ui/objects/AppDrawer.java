package com.narozhnyiyevgen.mavraguide.ui.objects;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import com.narozhnyiyevgen.mavraguide.MainActivity;
import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.ui.fragments.AdministratorRightsFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.CraftTeaFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.JobObligationsFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.MilkShakeFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.PitaFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.PizzaFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.SettingsFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.SmoothiesFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.StaffFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.StoresFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.TestsFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.TortillaFragment;
import com.narozhnyiyevgen.mavraguide.ui.fragments.VideoPhotoFragment;

public class AppDrawer {
    private Drawer mDrawer;
    private AccountHeader mHeader;
    private MainActivity activity;
    private Toolbar toolbar;

    public AppDrawer(MainActivity activity, Toolbar toolbar) {
        this.activity = activity;
        this.toolbar = toolbar;
    }

    public void create() {
        createHeader();
        createDrawer();
    }

    private void createDrawer() {
        mDrawer = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withSelectedItem(-1)
                .withAccountHeader(mHeader)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withIdentifier(R.dimen.idDrawerItemMenu)
                                .withName(R.string.myMenu)
                                .withSelectable(false)
                                .withIcon(R.drawable.all_menu_vector)
                                .withSubItems(
                                        new DividerDrawerItem(),

                                        new PrimaryDrawerItem()
                                                .withIdentifier(R.dimen.idDrawerItemEat)
                                                .withName(R.string.eat)
                                                .withSelectable(false)
                                                .withIcon(R.drawable.all_eat_vector)
                                                .withSubItems(
                                                        new PrimaryDrawerItem()
                                                                .withIdentifier(R.dimen.idDrawerItemPizza)
                                                                .withName(R.string.pizza)
                                                                .withSelectable(false)
                                                                .withIcon(R.drawable.all_pizza_vector),

                                                        new PrimaryDrawerItem()
                                                                .withIdentifier(R.dimen.idDrawerItemTortilla)
                                                                .withName(R.string.tortilla)
                                                                .withSelectable(false)
                                                                .withIcon(R.drawable.all_tortila_vector),
                                                        new PrimaryDrawerItem()
                                                                .withIdentifier(R.dimen.idDrawerItemPita)
                                                                .withName(R.string.pita)
                                                                .withSelectable(false)
                                                                .withIcon(R.drawable.all_pita_vector)
                                                ),

                                        new DividerDrawerItem(),

                                        new PrimaryDrawerItem()
                                                .withIdentifier(R.dimen.idDrawerItemDrinks)
                                                .withName(R.string.drinks)
                                                .withSelectable(false)
                                                .withIcon(R.drawable.drinks_vector)
                                                .withSubItems(

                                                        new PrimaryDrawerItem()
                                                                .withIdentifier(R.dimen.idDrawerItemSmoothies)
                                                                .withName(R.string.smoothies)
                                                                .withSelectable(false)
                                                                .withIcon(R.drawable.smuzi_vector),

                                                        new PrimaryDrawerItem()
                                                                .withIdentifier(R.dimen.idDrawerItemMilkShake)
                                                                .withName(R.string.milk_shake)
                                                                .withSelectable(false)
                                                                .withIcon(R.drawable.all_milk_coctail_vector),
                                                        new PrimaryDrawerItem()
                                                                .withIdentifier(R.dimen.idDrawerItemCraftTea)
                                                                .withName(R.string.craft_tea)
                                                                .withSelectable(false)
                                                                .withIcon(R.drawable.all_hot_drinks_vector)
                                                ),

                                        new DividerDrawerItem()
                                ),
                        new PrimaryDrawerItem()
                                .withIdentifier(R.dimen.idDrawerItemJobObligations)
                                .withName(R.string.jobObligations)
                                .withSelectable(false)
                                .withIcon(R.drawable.all_prava),
                        new DividerDrawerItem(),

                        new PrimaryDrawerItem()
                                .withIdentifier(R.dimen.idDrawerItemVideoPhoto)
                                .withName(R.string.video_photo)
                                .withSelectable(false)
                                .withIcon(R.drawable.video_photo_vector),
                        new PrimaryDrawerItem()
                                .withIdentifier(R.dimen.idDrawerItemTests)
                                .withName(R.string.tests)
                                .withSelectable(false)
                                .withIcon(R.drawable.test_vector),

                        new DividerDrawerItem(),

                        new PrimaryDrawerItem()
                                .withIdentifier(R.dimen.idDrawerItemStores)
                                .withName(R.string.stores)
                                .withSelectable(false)
                                .withIcon(R.drawable.store_vector),
                        new PrimaryDrawerItem()
                                .withIdentifier(R.dimen.idDrawerItemStaff)
                                .withName(R.string.staff)
                                .withSelectable(false)
                                .withIcon(R.drawable.all_human_vector),

                        new DividerDrawerItem(),

                        new PrimaryDrawerItem()
                                .withIdentifier(R.dimen.idDrawerItemSettings)
                                .withName(R.string.settings)
                                .withSelectable(false)
                                .withIcon(R.drawable.setings_vector),
                        new PrimaryDrawerItem()
                                .withIdentifier(R.dimen.idDrawerItemAdministratorRights)
                                .withName(R.string.administrator_rights)
                                .withSelectable(false)
                                .withIcon(R.drawable.administrator_vector)
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @SuppressLint("ResourceType")
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switchFragment(view.getId());
                        return false;
                    }
                }).build();
    }


    private void switchFragment(int id) {

        if (id == R.dimen.idDrawerItemPizza) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new PizzaFragment()).commit();
        } else if (id == R.dimen.idDrawerItemTortilla) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new TortillaFragment()).commit();
        } else if (id == R.dimen.idDrawerItemPita) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new PitaFragment()).commit();
        } else if (id == R.dimen.idDrawerItemSmoothies) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new SmoothiesFragment()).commit();
        } else if (id == R.dimen.idDrawerItemMilkShake) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new MilkShakeFragment()).commit();
        } else if (id == R.dimen.idDrawerItemCraftTea) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new CraftTeaFragment()).commit();
        } else if (id == R.dimen.idDrawerItemJobObligations) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new JobObligationsFragment()).commit();
        } else if (id == R.dimen.idDrawerItemVideoPhoto) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new VideoPhotoFragment()).commit();
        } else if (id == R.dimen.idDrawerItemTests) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new TestsFragment()).commit();
        } else if (id == R.dimen.idDrawerItemStores) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new StoresFragment()).commit();
        } else if (id == R.dimen.idDrawerItemStaff) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new StaffFragment()).commit();
        } else if (id == R.dimen.idDrawerItemSettings) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new SettingsFragment()).commit();
        } else if (id == R.dimen.idDrawerItemAdministratorRights) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new AdministratorRightsFragment()).commit();
        }

    }


    private void createHeader() {
        mHeader = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("Evgen")
                                .withEmail("+3800000000")
                ).build();

    }
}
