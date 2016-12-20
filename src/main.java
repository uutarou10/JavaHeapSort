
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author uutarou
 */
public class main {

    public static void main(String[] args) {
        Heap myhHeap = new Heap();
        for (int i=0; i < 30; i++) {
            int rand = new Random().nextInt(30);
            System.out.println(rand);
            myhHeap.pushHeap(rand);
        }
        System.out.println(myhHeap);
        System.out.println("----------");
        for (int i=0; i<30; i++){
            System.out.println(myhHeap.deleteMaximum());
        }
    }
}
