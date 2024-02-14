class AddDigitsSingle {
    public int addDigits(int num) {
        do{
            num=addNumbers(num);
        }while(num>=10);
        return num;
    }

    public int addNumbers(int num){
        int total=0;
        while(num>0){
            total=total+(num%10);
            num=num/10;
        }
        return total;
    }
}
