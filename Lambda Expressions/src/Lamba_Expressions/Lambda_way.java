package Lamba_Expressions;

interface Lambda_A{
    int my_method(int a, int b);
}

class B implements Lambda_A{
    public int my_method(int a, int b) {
        return a*b;
    }
}

public class Lambda_way{
    public static void main(String[] args) {
        //1
        B my_b = new B();
        System.out.println(my_b.my_method(3,5));
    }

}

