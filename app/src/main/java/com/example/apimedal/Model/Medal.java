package com.example.apimedal.Model;

import com.google.gson.annotations.SerializedName;

    public class Medal {
        @SerializedName("id")
        private String id;
        @SerializedName("negara")
        private String negara;
        @SerializedName("flag")
        private String flag;
        @SerializedName("gold")
        private int gold;
        @SerializedName("silver")
        private int silver;
        @SerializedName("bronze")
        private int bronze;


        public Medal(){}

        public Medal(String id, String negara, String flag, int gold, int silver, int bronze) {
            this.id = id;
            this.negara = negara;
            this.flag = flag;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNegara() {
            return negara;
        }

        public void setNegara(String negara) {
            this.negara = negara;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getSilver() {
            return silver;
        }

        public void setSilver(int silver) {
            this.silver = silver;
        }

        public int getBronze() {
            return bronze;
        }

        public void setBronze(int bronze) {
            this.bronze = bronze;
        }

        public int getTotal() {
            return bronze+silver+bronze;
        }
    }

