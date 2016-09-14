package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.R;

/**
 * Created by my on 2016/9/9.
 */
public class TweenAnimLoadingLayout extends LoadingLayout {

    private AnimationDrawable mAnimDrawable;

    public TweenAnimLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
        // 初始化
        mHeaderImage.setImageResource(R.drawable.loading_animation);
        mAnimDrawable = (AnimationDrawable) mHeaderImage.getDrawable();
    }
    // 默认图片
    @Override
    protected int getDefaultDrawableResId() {
        return R.drawable.big_loading_rocket_1;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {
        // NO-OP
    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {
        // NO-OP
    }
    // 下拉以刷新
    @Override
    protected void pullToRefreshImpl() {
        // NO-OP
    }
    // 正在刷新时回调
    @Override
    protected void refreshingImpl() {
        // 播放帧动画
        mAnimDrawable.start();
    }
    // 释放以刷新
    @Override
    protected void releaseToRefreshImpl() {
        // NO-OP
    }
    // 重新设置
    @Override
    protected void resetImpl() {
        mHeaderImage.setVisibility(View.VISIBLE);
        mHeaderImage.clearAnimation();
    }
}
