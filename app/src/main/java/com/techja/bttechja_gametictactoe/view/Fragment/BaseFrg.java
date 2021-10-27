package com.techja.bttechja_gametictactoe.view.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.techja.bttechja_gametictactoe.view.OnMainCallBack;

public abstract class BaseFrg<V extends ViewBinding, M extends ViewModel> extends Fragment {
    public static final String TAG = BaseFrg.class.getName();
    protected Object mData;
    protected Context context;
    protected V binding;
    protected M viewModel;
    protected OnMainCallBack callBack;

    public void setCallBack(OnMainCallBack callBack) {
        this.callBack = callBack;
    }

    public void setData(Object mData) {
        this.mData = mData;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBinding(inflater, container);
        viewModel = new ViewModelProvider(this).get(getClassVM());
        initViews();
        return binding.getRoot();
    }

    protected abstract void initViews();

    protected abstract Class<M> getClassVM();


    protected abstract V initViewBinding(LayoutInflater inflater, ViewGroup container);

    public void notify(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void notify(int msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
