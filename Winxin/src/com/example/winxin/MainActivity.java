package com.example.winxin;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jauker.widget.BadgeView;

public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mDatas;
	
	private TextView mChatTextView;
	private TextView mFriendTextView;
	private TextView mContactTextView;
	
	private BadgeView mBadgeView;
	private LinearLayout chatLayout;
	
	private ImageView tabline;
	private int screen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initView();
	}
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mDatas = new ArrayList<Fragment>();
		ChatMainTabFragment tab01 = new ChatMainTabFragment();
		FriendMainTabFragment tab02 = new FriendMainTabFragment();
		ContactMainTabFragment tab03 = new ContactMainTabFragment();
		
		mChatTextView = (TextView) findViewById(R.id.tv_chat);
		mFriendTextView = (TextView) findViewById(R.id.tv_find);

		mContactTextView = (TextView) findViewById(R.id.tv_contact);
		
		chatLayout = (LinearLayout) findViewById(R.id.layout_chat);
		
		tabline = (ImageView) findViewById(R.id.image);
		
		mDatas.add(tab01);
		mDatas.add(tab02);
		mDatas.add(tab03);
		
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				return mDatas.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				return mDatas.get(arg0);
			}
		};
		
		mViewPager.setAdapter(mAdapter);
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				resetTextView();
				switch (position) {
				case 0:
					if(mBadgeView!=null){
						chatLayout.removeView(mBadgeView);
					}
					mBadgeView = new BadgeView(MainActivity.this);
					mBadgeView.setBadgeCount(7);
					chatLayout.addView(mBadgeView);
//					mBadgeView.setTargetView(chatLayout);
					mChatTextView.setTextColor(Color.parseColor("#008000"));
					break;
				case 1:
					mFriendTextView.setTextColor(Color.parseColor("#008000"));
					break;
				case 2:
					mContactTextView.setTextColor(Color.parseColor("#008000"));
					break;

				default:
					break;
				}
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	protected void resetTextView() {
		mChatTextView.setTextColor(Color.BLACK);
		mFriendTextView.setTextColor(Color.BLACK);
		mContactTextView.setTextColor(Color.BLACK);
	}
}
