package leetcode;

public class ParkingSystem {
    public int big;
    public int medium;
    public int small;
    public  ParkingSystem(int big,int medium,int small){
        this.big=big;
        this.medium=medium;
        this.small=small;

    }
    public boolean addCar(int carType){
        if(carType>=1&&carType<=3){
            switch (carType){
                case 1:
                    if (this.big>=1){
                        this.big--;
                        return true;
                    }else{
                        return false;
                    }

                case 2:
                    if (this.medium>=1){
                        this.medium--;
                        return true;
                    }else{
                        return false;
                    }

                case 3:
                    if (this.small>=1){
                        this.small--;
                        return true;
                    }else{
                        return false;
                    }
                default:
                    break;
            }
        }else{
            System.out.println("请输入正确的车辆类型！");
        }
        throw new IllegalArgumentException("");




    }

}
