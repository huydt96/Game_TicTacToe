package com.techja.bttechja_gametictactoe.view.Fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techja.bttechja_gametictactoe.databinding.M001HomeActBinding;
import com.techja.bttechja_gametictactoe.viewmodel.CommonVM;

public class M001HomeFrg extends BaseFrg<M001HomeActBinding, CommonVM> {
    public static final String TAG = M001HomeFrg.class.getName();

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected M001HomeActBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M001HomeActBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        binding.btnPlaygame.setOnClickListener(view -> clickPlayGame());
    }

    private void clickPlayGame() {
        callBack.showFragment(M002UserInforFrg.TAG,null,false);
    }


}