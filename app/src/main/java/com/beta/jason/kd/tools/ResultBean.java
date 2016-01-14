package com.beta.jason.kd.tools;

import java.util.List;

/**
 * Created by Jason on 1/4/2016.
 */
public class ResultBean {
    /**
     * resultcode : 200
     * reason : 成功的返回
     * result : {"company":"顺丰","com":"sf","no":"920304146717","status":"1","list":[{"datetime":"2015-12-28 18:32","remark":"顺丰速运 已收取快件","zone":""},{"datetime":"2015-12-28 19:37","remark":"快件离开烟台海阳商贸城营业点,正发往 烟台莱阳集散中心","zone":""},{"datetime":"2015-12-28 21:04","remark":"快件到达 烟台莱阳集散中心","zone":""},{"datetime":"2015-12-28 22:39","remark":"快件离开烟台莱阳集散中心,正发往 潍坊坊子新区集散中心","zone":""},{"datetime":"2015-12-29 01:39","remark":"快件到达 潍坊坊子新区集散中心","zone":""},{"datetime":"2015-12-29 01:41","remark":"快件离开潍坊坊子新区集散中心,正发往 西安雁塔集散中心","zone":""},{"datetime":"2015-12-29 22:35","remark":"快件到达 西安雁塔集散中心","zone":""},{"datetime":"2015-12-30 01:06","remark":"快件离开西安雁塔集散中心,正发往下一站","zone":""},{"datetime":"2015-12-30 07:42","remark":"快件到达 运城空港集散中心","zone":""},{"datetime":"2015-12-30 09:49","remark":"快件离开运城空港集散中心,正发往 运城市闻喜县道北营业点","zone":""},{"datetime":"2015-12-30 14:29","remark":"快件到达 运城市闻喜县道北营业点","zone":""},{"datetime":"2015-12-31 08:27","remark":"快件离开运城市闻喜县道北营业点,正发往 运城市闻喜县河底镇合作点","zone":""},{"datetime":"2015-12-31 08:44","remark":"快件到达 运城市闻喜县河底镇合作点","zone":""},{"datetime":"2015-12-31 08:44","remark":"正在派送途中,请您准备签收(派件人:张家瑞,电话:15035061689)","zone":""},{"datetime":"2015-12-31 09:48","remark":"已签收,感谢使用顺丰,期待再次为您服务","zone":""},{"datetime":"2015-12-31 09:48","remark":"在官网\"运单资料&amp;签收图\",可查看签收人信息","zone":""}]}
     * error_code : 0
     * company : 顺丰
     * com : sf
     * no : 920304146717
     * status : 1
     */
    private String resultcode;
    private String reason;
    private int error_code;
    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }



    public void setError_code(int error_code) {
        this.error_code = error_code;
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


        private String company;
        private String com;
        private String no;
        private String status;
        private List<ListEntity> list;

        public void setCompany(String company) {
            this.company = company;
        }

        public void setCom(String com) {
            this.com = com;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public String getCompany() {
            return company;
        }

        public String getCom() {
            return com;
        }

        public String getNo() {
            return no;
        }

        public String getStatus() {
            return status;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public static class ListEntity {
            private String datetime;
            private String remark;
            private String zone;

            public void setDatetime(String datetime) {
                this.datetime = datetime;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public void setZone(String zone) {
                this.zone = zone;
            }

            public String getDatetime() {
                return datetime;
            }

            public String getRemark() {
                return remark;
            }

            public String getZone() {
                return zone;
            }
        }

}
