package cn.itcast.Josephu;

public class Boy {
    private int num;//编号
    private Boy nextBoy;

    public Boy(int num) {
        this.num = num;
    }
    public Boy() {

    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boy getNextBoy() {
        return nextBoy;
    }

    public void setNextBoy(Boy nextBoy) {
        this.nextBoy = nextBoy;
    }
}
