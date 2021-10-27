package com.techja.bttechja_gametictactoe.view.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techja.bttechja_gametictactoe.R;
import com.techja.bttechja_gametictactoe.databinding.M002UserinfoActBinding;
import com.techja.bttechja_gametictactoe.viewmodel.CommonVM;

public class M002UserInforFrg extends BaseFrg<M002UserinfoActBinding, CommonVM> {
    public static final String TAG = M002UserInforFrg.class.getName();
    public static final String TYPE_X = "X";
    public static final String TYPE_O = "O";
    String type, name;

    @Override
    protected Class<CommonVM> getClassVM() {
        return CommonVM.class;
    }


    @Override
    protected void initViews() {
//        Intent intent = getIntent();
//        name = intent.getStringExtra(M002UserInforFrg.NAME);
//        type = intent.getStringExtra(M002UserInforFrg.TYPE);
        if(mData!=null){
            name = ((String[]) mData)[0];
            type = ((String[]) mData)[1];
        }
        binding.edEntername.setText(name);
        if (type != null && type.equals(TYPE_X)) {
            clickX();
        }
        if (type != null && type.equals(TYPE_O)) {
            clickO();
        }

        binding.ivX.setOnClickListener(view -> clickX());
        binding.ivO.setOnClickListener(view -> clickO());
        binding.btnPlaygame.setOnClickListener(view -> clickPlayGame());
    }

    private void clickPlayGame() {
        name = binding.edEntername.getText().toString();
        if (name.isEmpty()) {
            notify("Please enter your name!");
            return;
        }
        if (type == null) {
            notify("Please select your side!");
            return;
        }

//        Intent intent = new Intent(this, M003GamePlayFrg.class);
//        intent.putExtra(NAME, name);
//        intent.putExtra(TYPE, type);
//        startActivity(intent);
//        finish();
        String[] data = new String[]{name,type};
        callBack.showFragment(M003GamePlayFrg.TAG,data,true);
    }

    private void clickO() {
        binding.ivO.setBackgroundResource(R.drawable.bg_xo_click);
        binding.ivX.setBackgroundResource(R.drawable.bg_xo);
        type = TYPE_O;
    }

    private void clickX() {
        binding.ivX.setBackgroundResource(R.drawable.bg_xo_click);
        binding.ivO.setBackgroundResource(R.drawable.bg_xo);
        type = TYPE_X;
    }

    @Override
    protected M002UserinfoActBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M002UserinfoActBinding.inflate(inflater, container, false);
    }
}
