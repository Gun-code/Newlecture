class App{
    public static void main(String[] args) {
        
        int kor1;
        int kor2;
        int kor3;
        int total;
        float avg;

        kor1 = 80;
        kor2 = 90;
        kor3 = 99;

        total = kor1 + kor2 + kor3;

        avg = (float) total / 3;
        
        System.out.printf("kor1 is %d\n",kor1);
        System.out.printf("kor2 is %d\n",kor2);
        System.out.printf("kor3 is %d\n",kor3);
        System.out.printf("total is %d\n",total);
        System.out.printf("avg is : %f\n",avg);
        
        
    }
}