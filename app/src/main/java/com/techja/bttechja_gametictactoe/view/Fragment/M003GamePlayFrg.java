package com.techja.bttechja_gametictactoe.view.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.techja.bttechja_gametictactoe.R;
import com.techja.bttechja_gametictactoe.databinding.M003GameplayActBinding;
import com.techja.bttechja_gametictactoe.viewmodel.M003GamePlayVM;

public class M003GamePlayFrg extends BaseFrg<M003GameplayActBinding, M003GamePlayVM> implements View.OnClickListener {
    public static final String TAG = M003GamePlayFrg.class.getName();
    String name, type;

    @Override
    protected Class<M003GamePlayVM> getClassVM() {
        return M003GamePlayVM.class;
    }


    @Override
    protected void initViews() {
        name = ((String[]) mData)[0];
        type = ((String[]) mData)[1];
        viewModel.setType(type);
        viewModel.setTypePlayer(viewModel.getType());
        binding.tvPlayer1.setText(name);

        if (viewModel.getType().equals(M002UserInforFrg.TYPE_X)) {
            binding.ivPlayer1.setImageResource(R.drawable.ic_x);
            binding.ivPlayer2.setImageResource(R.drawable.ic_o);
        } else if (viewModel.getType().equals(M002UserInforFrg.TYPE_O)) {
            binding.ivPlayer1.setImageResource(R.drawable.ic_o);
            binding.ivPlayer2.setImageResource(R.drawable.ic_x);
        }

        binding.iv1.setOnClickListener(this);
        binding.iv2.setOnClickListener(this);
        binding.iv3.setOnClickListener(this);
        binding.iv4.setOnClickListener(this);
        binding.iv5.setOnClickListener(this);
        binding.iv6.setOnClickListener(this);
        binding.iv7.setOnClickListener(this);
        binding.iv8.setOnClickListener(this);
        binding.iv9.setOnClickListener(this);

    }

    @Override
    protected M003GameplayActBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M003GameplayActBinding.inflate(inflater, container, false);
    }

    @Override
    public void onClick(View view) {
        if (view instanceof ImageView) {
            ImageView v = (ImageView) view;

            if (viewModel.getType().equals(M002UserInforFrg.TYPE_X) && v.getDrawable() == null) {
                v.setImageResource(R.drawable.ic_x);
                v.setContentDescription(M002UserInforFrg.TYPE_X);
                viewModel.setType(M002UserInforFrg.TYPE_O);
            } else if (viewModel.getType().equals(M002UserInforFrg.TYPE_O) && v.getDrawable() == null) {
                v.setImageResource(R.drawable.ic_o);
                v.setContentDescription(M002UserInforFrg.TYPE_O);
                viewModel.setType(M002UserInforFrg.TYPE_X);
            }
        }

        String t1 = binding.iv1.getContentDescription().toString();
        String t2 = binding.iv2.getContentDescription().toString();
        String t3 = binding.iv3.getContentDescription().toString();
        String t4 = binding.iv4.getContentDescription().toString();
        String t5 = binding.iv5.getContentDescription().toString();
        String t6 = binding.iv6.getContentDescription().toString();
        String t7 = binding.iv7.getContentDescription().toString();
        String t8 = binding.iv8.getContentDescription().toString();
        String t9 = binding.iv9.getContentDescription().toString();
        viewModel.checkWin(t1, t2, t3, t4, t5, t6, t7, t8, t9);

        viewModel.getIsWin().observe(this, aBoolean -> {
            if (aBoolean)
                win();
        });
    }

    public void win() {
        String[] data = new String[]{viewModel.getRs(), name, type};

        callBack.showFragment(M004GameEndFrg.TAG, data, true);
    }
}