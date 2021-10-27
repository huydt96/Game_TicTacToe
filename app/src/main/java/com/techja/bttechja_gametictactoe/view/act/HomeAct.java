package com.techja.bttechja_gametictactoe.view.act;

import com.techja.bttechja_gametictactoe.databinding.ActHomeBinding;
import com.techja.bttechja_gametictactoe.view.Fragment.M000SplashFrg;
import com.techja.bttechja_gametictactoe.viewmodel.CommonVM;

public class HomeAct extends BaseAct<ActHomeBinding, CommonVM> {
    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }

    @Override
    protected void initViews() {
        showFragment(M000SplashFrg.TAG,null,false);
    }

    @Override
    protected ActHomeBinding initViewBinding() {
        return ActHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void backToPrevious() {
        finish();
    }
}
