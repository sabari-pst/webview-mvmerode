package web.school.mvmerode;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class CustomWebView extends WebView{

    private OnScrollChangedCallback mOnScrollChangedCallback;

    public CustomWebView(final Context context)
    {
        super(context);
    }

    public CustomWebView(final Context context, final AttributeSet attrs)
    {
        super(context, attrs);
    }

    public CustomWebView(final Context context, final AttributeSet attrs, final int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(final int l, final int t, final int oldl, final int oldt)
    {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mOnScrollChangedCallback != null) mOnScrollChangedCallback.onScroll(l, t);
    }

    public OnScrollChangedCallback getOnScrollChangedCallback()
    {
        return mOnScrollChangedCallback;
    }

    public void setOnScrollChangedCallback(final OnScrollChangedCallback onScrollChangedCallback)
    {
        mOnScrollChangedCallback = onScrollChangedCallback;
    }

    /**
     * Impliment in the activity/fragment/view that you want to listen to the webview
     */
    public static interface OnScrollChangedCallback
    {
        public void onScroll(int horizontal, int vertical);
    }}