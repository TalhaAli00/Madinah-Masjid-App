package com.example.madinahmasjid;

import java.util.Locale;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements TabListener
{
	private SectionsPageAdapter mySectionsPageAdapter;
	private ViewPager myViewPager;
	private ActionBar actionbar;
	private int NUM_OF_TABS = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initialize();

		myViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{

			@Override
			public void onPageSelected(int arg0)
			{
				actionbar.setSelectedNavigationItem(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
			}

			@Override
			public void onPageScrollStateChanged(int arg0)
			{
			}
		});

		for (int i = 0; i < mySectionsPageAdapter.getCount(); i++)
		{
			TextView view = new TextView(this);
			if (mySectionsPageAdapter.getPageTitle(i).length() > 10)
			{
				view.setPadding(20, 5, 0, 0);
			}
			else
			{
				view.setPadding(5, 15, 5, 0);
			}
			view.setText(mySectionsPageAdapter.getPageTitle(i));
			view.setTextColor(getResources().getColor(android.R.color.white));
			actionbar.addTab(actionbar.newTab().setCustomView(view).setTabListener(this));
		}
	}

	private void initialize()
	{
		actionbar = getActionBar();
		myViewPager = (ViewPager) findViewById(R.id.pager);
		mySectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

		myViewPager.setAdapter(mySectionsPageAdapter);
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft)
	{
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft)
	{
		myViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft)
	{
	}

	public class SectionsPageAdapter extends FragmentPagerAdapter
	{

		public SectionsPageAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0)
		{
			Fragment fragment;

			switch (arg0)
			{
				case 0:
					fragment = new HomeFragment();
					return fragment;
					
				case 1:
					fragment = new ActivitesFragment();
					return fragment;
					
				case 2:
					fragment = new PrayerTimingFragment();
					return fragment;
					
				case 3:
					fragment = new AnnouncementsFragment();
					return fragment;

			}
			return null;
		}

		@Override
		public int getCount()
		{
			return NUM_OF_TABS;
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			Locale l = Locale.getDefault();

			switch (position)
			{
				case 0:
					return getString(R.string.home).toUpperCase(l);
					
				case 1:
					return getString(R.string.activites).toUpperCase(l);
					
				case 2:
					return getString(R.string.prayer_timings).toUpperCase(l);
					
				case 3:
					return getString(R.string.announcements).toUpperCase(l);
			}

			return "";
		}
	}
}
