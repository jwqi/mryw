package com.jwqi.mryw.bo;

public class TemplateMessageBO {
//    {
//            "touser": "oxP4B5SD5br5YIfRtRa7bBneBVcc",
//            "template_id": "cT4L02cREfczGqo3LeuhAExlpuiPh18r2HeSHROM9E8",
//            "page": "pages/list/list",
//            "data": {
//                "thing1": {
//                    "value": "每日阅读"
//                },
//                "thing2": {
//                    "value": "散文"
//                },
//                "time3": {
//                    "value": "2019-11-6 22:38"
//                } ,
//                "thing4": {
//                    "value": "请阅读散文"
//                }
//           }
//    }

    private String touser;
    private String template_id;
    private String page;
    private Data data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        private thing1 thing1;
        public class thing1 {
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        private thing2 thing2;
        public class thing2 {
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        private time3 time3;
        public class time3 {
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        private thing4 thing4;
        public class thing4 {
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public Data.thing1 getThing1() {
            return thing1;
        }

        public void setThing1(Data.thing1 thing1) {
            this.thing1 = thing1;
        }

        public Data.thing2 getThing2() {
            return thing2;
        }

        public void setThing2(Data.thing2 thing2) {
            this.thing2 = thing2;
        }

        public Data.time3 getTime3() {
            return time3;
        }

        public void setTime3(Data.time3 time3) {
            this.time3 = time3;
        }

        public Data.thing4 getThing4() {
            return thing4;
        }

        public void setThing4(Data.thing4 thing4) {
            this.thing4 = thing4;
        }
    }
}
