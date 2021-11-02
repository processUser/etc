package org.iptime.mypj;

public class StudentGroupInfoVO {
    private int idx;
    private int sidx;
    private String nm;
    private int gidx;
    private int gp;
    private String tdy;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getSidx() {
        return sidx;
    }

    public void setSidx(int sidx) {
        this.sidx = sidx;
    }

    public int getGidx() {
        return gidx;
    }

    public void setGidx(int gidx) {
        this.gidx = gidx;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public String getTdy() {
        return tdy;
    }

    public void setTdy(String tdy) {
        this.tdy = tdy;
    }
}
