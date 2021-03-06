package com.sample.Filhåndtering;

import com.sample.ProduktData.Produkter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.util.List;

public class FileReader extends Reader {
    public FileReader(String path) {
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }

    public static class readFile {

        public static List<Produkter> readSerializedFile(){
            System.out.println("Reading file.");

            try{
                FileInputStream fileInputStream = new FileInputStream("objectSuperList.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                List<Produkter> produkters = (List<Produkter>) objectInputStream.readObject();

                System.out.print("Objects are read from file.");

                System.out.println();
                System.out.println("Read Successful.\n");
                objectInputStream.close();
                return produkters;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Read Failed.\n" );
                return null;
            }
        }
    }
}

