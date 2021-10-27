package com.techja.bttechja_gametictactoe.view.Fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techja.bttechja_gametictactoe.databinding.M004GameendActBinding;
import com.techja.bttechja_gametictactoe.viewmodel.CommonVM;

public class M004GameEndFrg extends BaseFrg<M004GameendActBinding, CommonVM> {
    public static final String TAG = M004GameEndFrg.class.getName();
    String name, type;

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }


    @Override
    protected void initViews() {

        String rs = ((String[]) mData)[0];
        name = ((String[]) mData)[1];
        type = ((String[]) mData)[2];

        binding.tvResult.setText(rs);
        binding.btnPlayagain.setOnClickListener(view -> Playagain());
        binding.btnExitgame.setOnClickListener(view -> callBack.backToPrevious());
    }

    private void Playagain() {
        callBack.showFragment(M002UserInforFrg.TAG, new String[]{
                name, type
        }, false);
    }

    @Override
    protected M004GameendActBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M004GameendActBinding.inflate(inflater, container, false);
    }
}
