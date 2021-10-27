package com.techja.bttechja_gametictactoe.view.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.techja.bttechja_gametictactoe.databinding.M000SplashFrgBinding;
import com.techja.bttechja_gametictactoe.viewmodel.CommonVM;


public class M000SplashFrg extends BaseFrg<M000SplashFrgBinding, CommonVM> {
    public static final String TAG = M000SplashFrg.class.getName();

    @Override
    protected void initViews() {
        new Handler().postDelayed(this::gotoMainScreen, 2000);
    }

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    private void gotoMainScreen() {
        callBack.showFragment(M001HomeFrg.TAG,null,false);
    }


    @Override
    protected M000SplashFrgBinding initViewBinding(@NonNull LayoutInflater inflater,
                                                   @Nullable ViewGroup container) {
        return M000SplashFrgBinding.inflate(inflater, container, false);
    }
}
