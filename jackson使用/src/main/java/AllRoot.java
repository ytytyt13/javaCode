/**
 * @author yang
 * 2021年03月25日 20:15:00
 */

/**
 * Copyright 2021 json.cn
 */

import java.util.List;

public class AllRoot {

    private boolean ret;
    private String msg;
    private List<RuleData> data;
    private String errcode;
    public void setRet(boolean ret) {
        this.ret = ret;
    }
    public boolean getRet() {
        return ret;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public boolean isRet() {
        return ret;
    }

    public List<RuleData> getData() {
        return data;
    }

    public void setData(List<RuleData> data) {
        this.data = data;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
    public String getErrcode() {
        return errcode;
    }

}
