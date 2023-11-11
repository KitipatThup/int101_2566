package work03;

public class MyUtil {
    private MyUtil() {}
        /**
        * This method compute the calculated of BMI.
        * @param weight is the weight as kilogram.
        * @param height is the height as meter.
        * @return 
        */
    public static double calculateBMI(double weight,double height){
        return weight/(height*height);
        }
        /**
        * This method compute the average value of three parameter.
        * @param v1 is a number.
        * @param v2 is a number.
        * @param v3 is a number.
        * @return 
        */
    public static double average(int v1, int v2, int v3) {
        return (v1+v2+v3) / 3;
        }
}
