package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.java.file06.Product;

public class FileMain07 {

    public static void main(String[] args) {
        // edu.java.file06.Product 타입의 객체를 1,000,000개 생성하고 ArrayList에 저장.
        // ArrayList의 내용을 product_list.dat 파일에 write - 시간 측정.
        // product_list.dat 파일에서 데이터를 읽어서 ArrayList 타입으로 변환 - 시간 측정.

        List<Product> list = new ArrayList<>();
        while (true) {
            if (list.size() == 1000000) {
                break;
            }
            list.add(new Product());
        }

        String fileName = "data/product_list.dat";

        try (
                FileOutputStream out = new FileOutputStream(fileName);
                BufferedOutputStream bout = new BufferedOutputStream(out); // RAM을 이용해 속도 부스트업
                ObjectOutputStream oout = new ObjectOutputStream(bout);
                
            ) {
            long startTime = System.currentTimeMillis();

            oout.writeObject(list);
            System.out.println("파일 작성 성공");

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("쓰기 완료 - " + elapsedTime + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (
                FileInputStream in = new FileInputStream(fileName); 
                BufferedInputStream bin = new BufferedInputStream(in); // RAM을 이용해 속도 부스트업
                ObjectInputStream oin = new ObjectInputStream(bin);
        ) {
            long startTime = System.currentTimeMillis();
            Object obj = oin.readObject();

            if (obj instanceof Product) {
                Product p2 = (Product) obj;
                System.out.println(p2);
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("객체화 완료 - " + elapsedTime + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }

}
