package Lamba_Expressions;

interface Traditional_A{
    int my_method(int a, int b);
}
public class Traditional_way{
    public static void main(String[] args) {
        //1
        Traditional_A my_a = (a,b) -> a*b;
        System.out.println(my_a.my_method(4,5));
    }
    public static int cal(int x){
        return x*2;
    }
}
