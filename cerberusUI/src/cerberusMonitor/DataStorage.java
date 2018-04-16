package cerberusMonitor;

import java.io.*;

public class DataStorage {

    // serializes object
    public void storeData(Object s1)throws Exception{
        FileOutputStream fout = new FileOutputStream("test.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(s1);
        out.flush();
        System.out.println("success");
    }

    // deserializes object
    public void getData()throws Exception{
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("test.txt"));
        DataObject d = (DataObject) in.readObject();
        System.out.println(d.getIpAddr().toString());

        in.close();
    }
}
