package utils;

public class TestArray {

    int ReturnAvg( int [] Array ){

        int size ;
        size = Array.length;
        int sum=0;

        for (int i=0 ; i <size ; i++){
            sum = sum + Array[i];
        }

        return  sum/size ;
    }

}
