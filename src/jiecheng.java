public class jiecheng {
    public int jisuan(int n){
        int i;
        int sum=1;
        for(i=n;i>0;i--){
            sum=sum*i;
        }
        return sum;
    }
    public void main(String[] args){
        int a;
        int b;
        a=jisuan(4);
        b=jisuan(5);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
