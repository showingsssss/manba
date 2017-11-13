package com.minyou.manba.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.minyou.manba.R;
import com.minyou.manba.bean.ManBaUserInfo;
import com.minyou.manba.fragment.HomeFragment;
import com.minyou.manba.fragment.MineFragment;
import com.minyou.manba.fragment.SociationFragment;
import com.minyou.manba.fragment.StreetFragment;
import com.minyou.manba.util.LogUtil;

public class HomeActivity extends FragmentActivity {

    protected static final String TAG = "HomeActivity";



    //private Unbinder unbinder;
    private Context context;
    //@BindView(R.id.fl_home)
    FrameLayout fl_home;
    //@BindView(R.id.rg_main)
    RadioGroup rg_main;
    //@BindView(R.id.rb_fayan)
    ImageView rb_fayan;

    private int index;
    private long firstTime = 0;

    private ManBaUserInfo mManBaUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        this.context = getApplicationContext();

        fl_home = (FrameLayout)findViewById(R.id.fl_home);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        rb_fayan = (ImageView) findViewById(R.id.rb_fayan);
        rg_main.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        index = 0;
                        LogUtil.d(TAG, "---home");
                        break;
                    case R.id.rb_jiequ:
                        index = 1;
                        LogUtil.d(TAG, "---jiequ");
                        break;
                    case R.id.rb_fayan:
                        // delete
                        LogUtil.d(TAG, "---fayan");
                        break;
                    case R.id.rb_gonghui:
                        index = 2;
                        LogUtil.d(TAG, "---gonghui");
                        break;
                    case R.id.rb_jia:
                        index = 3;
                        LogUtil.d(TAG, "---jia");
                        break;
                }
                Fragment fragment = (Fragment) adapter.instantiateItem(fl_home, index);
                adapter.setPrimaryItem(fl_home, 0, fragment);
                adapter.finishUpdate(fl_home);
            }
        });
        rg_main.check(R.id.rb_home);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
//        ManBaUserInfo manBaUserInfo = intent.getParcelableExtra("user_info");
//        mManBaUserInfo = manBaUserInfo;
        Log.i(TAG, "onNewIntent: ");
        rg_main.check(R.id.rb_jia);

    }

    //    @OnClick(R.id.rb_fayan)
//    public void fayan(){
//        Toast.makeText(this, "发言", Toast.LENGTH_SHORT).show();
//    }

    FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int arg0) {
            Fragment fragment = null;
            switch (arg0) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new StreetFragment();
                    break;
                case 2:
                    fragment = new SociationFragment();
                    break;
                case 3:
                    fragment = new MineFragment();
                    break;
            }
            return fragment;
        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode) {
            case SociationFragment.DETAIL:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(context, "已加入", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    };

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if((currentTime - firstTime) > 2000){
            firstTime = currentTime;
            Toast.makeText(HomeActivity.this, getResources().getString(R.string.back_launcher), Toast.LENGTH_SHORT).show();
        }else{
            finish();
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unbinder.unbind();
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
    }

    public ManBaUserInfo getManBaUserInfo() {
        return mManBaUserInfo;
    }

    public void setManBaUserInfo(ManBaUserInfo manBaUserInfo) {
        this.mManBaUserInfo = manBaUserInfo;
    }
}