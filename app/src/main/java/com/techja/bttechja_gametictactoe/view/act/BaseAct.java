package com.techja.bttechja_gametictactoe.view.act;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.techja.bttechja_gametictactoe.R;
import com.techja.bttechja_gametictactoe.view.Fragment.BaseFrg;
import com.techja.bttechja_gametictactoe.view.OnMainCallBack;

import java.lang.reflect.Constructor;

public abstract class BaseAct<T extends ViewBinding, M extends ViewModel> extends AppCompatActivity
                    implements OnMainCallBack {
    protected T binding;
    protected M viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding();
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(getClassVM());
        initViews();
    }

    protected abstract Class<M> getClassVM();

    protected abstract void initViews();

    protected abstract T initViewBinding();

    public void notify(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void notify(int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFragment(String tag, Object data, boolean isBack) {
        try {
            Class<?> clazz = Class.forName(tag);
            Constructor<?> cons = clazz.getConstructor();
            BaseFrg<?, ?> frg = (BaseFrg<?, ?>) cons.newInstance();
            frg.setData(data);
            frg.setCallBack(this);

            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            if (isBack) {
                trans.addToBackStack(null);
            }
            trans.replace(R.id.ln_main, frg, tag).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
