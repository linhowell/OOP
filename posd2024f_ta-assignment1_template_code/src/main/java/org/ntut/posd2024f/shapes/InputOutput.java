package org.ntut.posd2024f.shapes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Collections;
public class InputOutput {
    public InputOutput() {
    }

    public ArrayList<Shape> handleInput(String inputFileName) throws NumberFormatException, Exception {
        FileReader fr = null;
        fr = new FileReader(inputFileName);
        Scanner inf = new Scanner(fr);
        ArrayList<Shape> arr =new ArrayList<>();
        while (inf.hasNextLine()) {
            try{
                arr.add(ConstructShape(inf.nextLine()));
            }
            catch(Exception e){
                inf.close();
                throw new ArithmeticException();
            }
        }
        inf.close();
        fr.close();
        return arr;
    }

    public ArrayList<Shape> handleSort(ArrayList<Shape> Shapes, String compare, String order) {
        
        for(int i = 0;i < Shapes.size();i++){
            for(int j = i+1;j < Shapes.size();j++){
                if(compare == "area"){
                    if(order == "dec"){
                        Collections.sort(Shapes,Sort.BY_AREA_DESCENDING);
                    }
                    else{
                        Collections.sort(Shapes,Sort.BY_AREA_ASCENDING);
                    }
                }
                if(compare == "perimeter"){
                    if(order == "dec"){
                        Collections.sort(Shapes,Sort.BY_PERIMETER_DESCENDING);
                    }
                    else{
                        Collections.sort(Shapes,Sort.BY_PERIMETER_ASCENDING);
                    }
                }
            }
        }
        return Shapes;
    }

    public void handleOutput(ArrayList<Shape> Shapes, String outputFileName) {
        List<String> list = new ArrayList<String>();
        for(int i = 0;i < Shapes.size();i++){
            list.add(Shapes.get(i).toString());
        }

        try {
            FileWriter fw = new FileWriter(outputFileName);
            BufferedWriter bw = new BufferedWriter(fw);

            for (String s: list){
                bw.write(s);    // 寫入資料
                bw.newLine();   // 新增一行
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Shape ConstructShape(String str) throws NumberFormatException, Exception {
        Scanner inf = new Scanner(str);
        if(inf.next() == "Circle"){
            try{
                double r;
                r = inf.nextDouble();
                inf.close();
                return new Circle(r);
            }
            catch(Exception e){
                throw new ArithmeticException("It's not a circle!");
            }
        }
        else if(inf.next() == "Triangle"){
            try{
                double l1,l2,l3;
                l1 = inf.nextDouble();
                l2 = inf.nextDouble();
                l3 = inf.nextDouble();
                inf.close();
                return new Triangle(l1, l2, l3);
            }
            catch(Exception e){
                throw new ArithmeticException("It's not a Triangle!");
            }
        }
        else if(inf.next() == "Rectangle"){
            try{
                double h,w;
                h = inf.nextDouble();
                w = inf.nextDouble();
                inf.close();
                return new Rectangle(h, w);
            }
            catch(Exception e){
                throw new ArithmeticException("It's not a Rectangle!");
            }
        }
        inf.close();
        return null;
    }
}
