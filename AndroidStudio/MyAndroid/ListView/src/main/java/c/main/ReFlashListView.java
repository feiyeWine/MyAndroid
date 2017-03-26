package c.main;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by YR on 2015/4/22.
 */
public class ReFlashListView extends ListView {
    private View header;
    int headerHeight;//顶部布局文件的高度
    public ReFlashListView(Context context) {
        super(context);
        initViw(context);
    }

    public ReFlashListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViw(context);
    }

    public ReFlashListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViw(context);
    }

    /**
     * 初始化界面，添加顶部布局文件到ListView中
     * @param context
     */
    private void initViw(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        header = inflater.inflate(R.layout.activity_main,null);
        headerHeight = header.getMeasuredHeight();
        Log.i("log","header"+headerHeight);
         topPadding(-headerHeight);
        this.addHeaderView(header);
    }

    /**
     * 通知父布局
     * @param view
     */
    private void measureView(View view){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if(p==null){
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int width = ViewGroup.getChildMeasureSpec(0,0,p.width);
        int height;
        int tempHeight = p.height;
        if(tempHeight>0){
            height = MeasureSpec.makeMeasureSpec(tempHeight,MeasureSpec.EXACTLY);
        }else{
            height = MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED);
        }
        view.measure(width,height);
    }
    /**
     * 设置header布局的上边距
     */
    private void topPadding(int topPadding){
        header.setPadding(header.getPaddingLeft(),topPadding,
            header.getPaddingRight(),header.getPaddingBottom()
        );
        header.invalidate();
    }
}
