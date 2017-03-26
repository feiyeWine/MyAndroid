package com.example.testreflistview;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RefListView extends ListView implements OnScrollListener{
	View header;	//顶部布局文件
	int headerHeight;//顶部布局文件高度
	int firstVisibleItem;//当前第一个可见的item位置
	boolean isRemark; //标记，当前是在ListView最顶端
	int startY; //按下时Y值
	int state; //当前的状态
	final int NONE = 0;//正常状态
	final int PULL = 1;//提示下拉状态
	final int RELESE = 2;//提示释放状态
	final int REFLASHING = 3;//刷新状态
	int scrollState;//当前滚动状态
	
	public RefListView(Context context) {
		super(context);
		initListView(context);
	}

	public RefListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initListView(context);
	}

	public RefListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initListView(context);
	}
	private void initListView(Context context){
		LayoutInflater inflater = LayoutInflater.from(context);
		header = inflater.inflate(R.layout.activity_main, null);
		messurView(header);
		headerHeight = header.getMeasuredHeight();
		topPadding(-headerHeight);
		this.addHeaderView(header);
		this.setOnScrollListener(this);
	}
	/**
	 * 设置header布局上边距
	 */
	private void topPadding(int topPadding){
		header.setPadding(header.getPaddingLeft(), topPadding, header.getPaddingRight(), header.getPaddingBottom());
		header.invalidate();
	}
	/**
	 * 通知父布局
	 * @param view
	 */
	private void messurView(View view){
		ViewGroup.LayoutParams p = view.getLayoutParams();
		if(p==null){
			p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		int width = ViewGroup.getChildMeasureSpec(0, 0, p.width);
		int height;
		int tempHeight = p.height;
		if(tempHeight>0){
			height = MeasureSpec.makeMeasureSpec(tempHeight, MeasureSpec.EXACTLY);
		}else{
			height = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
		}
		view.measure(width, height);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		this.scrollState = scrollState;
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		this.firstVisibleItem = firstVisibleItem;
	}
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		
		switch(ev.getAction()){
		case MotionEvent.ACTION_DOWN:
			if(firstVisibleItem==0){
				isRemark = true;
				startY = (int) ev.getY();
			}
			break;
		case MotionEvent.ACTION_MOVE:
			onMove(ev);
			break;
		case MotionEvent.ACTION_UP:
			if(state == RELESE){
				state = REFLASHING;
				//加载最新数据；
				reflashViewByState();
			}else if(state == PULL ){
				 state = NONE;
				 isRemark =false; 
				 reflashViewByState();
			}
			break;
		}
		
		return super.onTouchEvent(ev);
	}
	/**
	 * 判断移动过程中的操作
	 * @param ev
	 */
	private void onMove(MotionEvent ev){
		if(!isRemark){
			return;
		}
		int tempY = (int) ev.getY();
		int space = tempY - startY;
		int topPadding = space - header.getHeight();
		switch (state) {
		case NONE:
			if(space>0){
				state = PULL;
			}
			reflashViewByState();
			break;
		case PULL:
			topPadding(topPadding);
			if(space>headerHeight+30
					&&scrollState == SCROLL_STATE_TOUCH_SCROLL){
				state = RELESE;
				reflashViewByState();
			}	
			
			break;
		case RELESE:
			topPadding(topPadding);
			if(space<headerHeight+30
					&&scrollState == SCROLL_STATE_TOUCH_SCROLL){
				state = PULL;
				reflashViewByState();
			}else if(space <=0){
				state = NONE;
				isRemark = false;
				reflashViewByState();
			}
			break;
		case REFLASHING:
			break;

		default:
			break;
		}
	}
	//根据当前状态，改变界面显示
	private void reflashViewByState(){
		TextView tip = (TextView) header.findViewById(R.id.tip);
		ImageView arrow = (ImageView) header.findViewById(R.id.arrow);
		ProgressBar progress = (ProgressBar) header.findViewById(R.id.progress);
		RotateAnimation anim = new RotateAnimation(0, 180,RotateAnimation.RELATIVE_TO_SELF,0.5f,
				RotateAnimation.RELATIVE_TO_SELF,0.5f);
		anim.setDuration(500);
		anim.setFillAfter(true);
		RotateAnimation anim2 = new RotateAnimation(180, 0,RotateAnimation.RELATIVE_TO_SELF,0.5f,
				RotateAnimation.RELATIVE_TO_SELF,0.5f);
		anim2.setDuration(500);
		anim2.setFillAfter(true);
		switch(state){
		case NONE:
			topPadding(-headerHeight);
			break;
		case PULL:
				arrow.clearAnimation();
				arrow.setVisibility(View.VISIBLE);	
				progress.setVisibility(View.GONE);
				tip.setText("下拉可以刷新!");
				arrow.clearAnimation();
				arrow.setAnimation(anim);
			break;
		case RELESE:
			arrow.setVisibility(View.VISIBLE);	
			progress.setVisibility(View.GONE);
			tip.setText("松开可以刷新!");
			arrow.clearAnimation();
			arrow.setAnimation(anim2);
			break;
		case REFLASHING:
			topPadding(50);
			arrow.setVisibility(View.GONE);	
			progress.setVisibility(View.VISIBLE);
			tip.setText("正在刷新...");
			arrow.clearAnimation();
			break;
		}
	}
	public void reflashComplete(){
		state = NONE;
		isRemark =false;
		reflashViewByState();
		TextView lastupdatetime = (TextView) header.findViewById(R.id.update_time);
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String time = format.format(date);
		lastupdatetime.setText(time);
	}
}
