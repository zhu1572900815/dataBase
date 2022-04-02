package cn.itcast;

public class miGong {
    public static void main(String[] args) {

        //创建数组，模拟迷宫
        int[][] map = new int[8][7];
        //设置阻碍物
        //上下全部设为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部设为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //挡板
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("地图的具体情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        seekRoad(map,1,1);
        System.out.println("地图的具体情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 地图情况
     * @param i   行起始位置
     * @param j   列起始位置
     * @return
     * 规定：小球没有走过的地方记为0，已经走过的地方记为2，挡板为1，思路为3
     */
    public static boolean seekRoad(int[][] map, int i, int j) {
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){ //是0的话，代表这个起始位置没有走过
                map[i][j] = 2; //将起始位置设为2，代表小球已经走过了这个地方
                if(seekRoad(map,i - 1,j)){ //小球往上寻找出路
                    return true;
                }else if(seekRoad(map,i,j + 1)){//小球往右寻找出路
                    return true;
                }else if(seekRoad(map,i + 1,j)){//小球往下寻找出路
                    return true;
                }else if(seekRoad(map,i,j - 1)){//小球往左寻找出路
                    return true;
                }else{ //小球寻找了四个方向都没有找到路，则说明这个位置是死路
                    map[i][j] = 3;
                    return false;
                }
            }else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }

}
