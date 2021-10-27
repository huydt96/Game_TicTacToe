package com.techja.bttechja_gametictactoe.view;

public interface OnMainCallBack {
    void showFragment(String tag, Object data, boolean isBack);

    void backToPrevious();
}
