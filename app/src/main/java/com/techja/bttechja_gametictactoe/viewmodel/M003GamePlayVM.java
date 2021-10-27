package com.techja.bttechja_gametictactoe.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class M003GamePlayVM extends ViewModel {
    public static final String RESULT = "RESULT";
    private final MutableLiveData<Boolean> isWin = new MutableLiveData<>(false);
    private String typePlayer;
    private String type;
    private String rs;

    public void setTypePlayer(String typePlayer) {
        this.typePlayer = typePlayer;
    }

    public MutableLiveData<Boolean> getIsWin() {
        return isWin;
    }

    public String getRs() {
        return rs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void checkWin(String t1, String t2, String t3, String t4, String t5, String t6, String t7, String t8, String t9) {

        if (t1.equals(t2) && t1.equals(t3) && !t1.equals("null")) {
            win(t1);
        } else if (t4.equals(t5) && t4.equals(t6) && !t4.equals("null")) {
            win(t4);
        } else if (t7.equals(t8) && t7.equals(t9) && !t7.equals("null")) {
            win(t7);
        } else if (t1.equals(t4) && t1.equals(t7) && !t1.equals("null")) {
            win(t1);
        } else if (t2.equals(t5) && t2.equals(t8) && !t2.equals("null")) {
            win(t2);
        } else if (t3.equals(t6) && t3.equals(t9) && !t3.equals("null")) {
            win(t3);
        } else if (t1.equals(t5) && t1.equals(t9) && !t1.equals("null")) {
            win(t1);
        } else if (t3.equals(t5) && t3.equals(t7) && !t3.equals("null")) {
            win(t3);
        } else if (!t1.equals("null") &&
                !t2.equals("null") &&
                !t3.equals("null") &&
                !t4.equals("null") &&
                !t5.equals("null") &&
                !t6.equals("null") &&
                !t7.equals("null") &&
                !t8.equals("null") &&
                !t9.equals("null")) {
            win("draw");
        }
    }

    public void win(String t1) {
        if (t1.equals(typePlayer)) {
            //Người chơi thắng
            rs = "YOU WIN";
        } else if (t1.equals("draw")) {
            rs = "DRAW";
        } else {
            //Máy thắng
            rs = "YOU LOST";
        }
        isWin.postValue(true);
    }


}
