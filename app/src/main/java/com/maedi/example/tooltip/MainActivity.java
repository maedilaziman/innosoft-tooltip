package com.maedi.example.tooltip;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.maedi.soft.ino.base.BuildActivity;
import com.maedi.soft.ino.base.func_interface.ActivityListener;
import com.maedi.soft.ino.base.store.MapDataParcelable;
import com.maedi.soft.ino.tooltip.view.Tooltip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BuildActivity<View> implements ActivityListener<Integer> {

    private FragmentActivity f;

    @BindView(R.id.tooltip1)
    Tooltip tooltip1;

    @BindView(R.id.tooltip2)
    Tooltip tooltip2;

    @OnClick(R.id.post1)
    public void openTooltip1() {
        //tooltip1.setVisibility(View.VISIBLE);
        if(!tooltip1.isVisible())tooltip1.showViewWithAnim(tooltip1);
        else tooltip1.hideViewWithAnim(tooltip1);
    }

    @OnClick(R.id.post2)
    public void openTooltip2() {
        //tooltip2.setVisibility(View.VISIBLE);
        if(!tooltip2.isVisible())tooltip2.showViewWithAnim(tooltip2);
        else tooltip2.hideViewWithAnim(tooltip2);
    }

    @Override
    public int setPermission() {
        return 0;
    }

    @Override
    public boolean setAnalytics() {
        return false;
    }

    @Override
    public void onCreateActivity(Bundle savedInstanceState) {
        f = this;
        ButterKnife.bind(this);
    }

    @Override
    public void onBuildActivityCreated() {

    }

    @Override
    public int baseContentView() {
        return R.layout.activity_main;
    }

    @Override
    public ActivityListener createListenerForActivity() {
        return this;
    }

    @Override
    public void onActivityResume() {

    }

    @Override
    public void onActivityPause() {

    }

    @Override
    public void onActivityStop() {

    }

    @Override
    public void onActivityDestroy() {

    }

    @Override
    public void onActivityKeyDown(int keyCode, KeyEvent event) {

    }

    @Override
    public void onActivityFinish() {

    }

    @Override
    public void onActivityRestart() {

    }

    @Override
    public void onActivitySaveInstanceState(Bundle outState) {

    }

    @Override
    public void onActivityRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onActivityRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }

    @Override
    public void onActivityMResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void setAnimationOnOpenActivity(Integer firstAnim, Integer secondAnim) {

    }

    @Override
    public void setAnimationOnCloseActivity(Integer firstAnim, Integer secondAnim) {

    }

    @Override
    public View setViewTreeObserverActivity() {
        return null;
    }

    @Override
    public void getViewTreeObserverActivity() {

    }

    @Override
    public Intent setResultIntent() {
        return null;
    }

    @Override
    public String getTagDataIntentFromActivity() {
        return null;
    }

    @Override
    public void getMapDataIntentFromActivity(MapDataParcelable parcleable) {

    }

    @Override
    public MapDataParcelable setMapDataIntentToNextActivity(MapDataParcelable parcleable) {
        return null;
    }
}
