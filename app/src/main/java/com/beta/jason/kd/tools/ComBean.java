package com.beta.jason.kd.tools;

import java.util.List;

/**
 * Created by Jason on 1/4/2016.
 */
public class ComBean {

    /**
     * resultcode : 200
     * reason : 成功的返回
     * result : [{"com":"顺丰","no":"sf"},{"com":"申通","no":"sto"},{"com":"圆通","no":"yt"},{"com":"韵达","no":"yd"},{"com":"天天","no":"tt"},{"com":"EMS","no":"ems"},{"com":"中通","no":"zto"},{"com":"汇通","no":"ht"},{"com":"全峰","no":"qf"},{"com":"德邦","no":"db"}]
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private int error_code;
    /**
     * com : 顺丰
     * no : sf
     */

    private List<ResultEntity> result;

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public String getResultcode() {
        return resultcode;
    }

    public String getReason() {
        return reason;
    }

    public int getError_code() {
        return error_code;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        private String com;
        private String no;

        public void setCom(String com) {
            this.com = com;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getCom() {
            return com;
        }

        public String getNo() {
            return no;
        }
    }
}
