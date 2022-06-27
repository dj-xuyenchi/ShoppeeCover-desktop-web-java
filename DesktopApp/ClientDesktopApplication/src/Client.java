
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class Client {

    private Socket socket = null;
//tao ket noi den server
    public Client() throws IOException {
        socket = new Socket("localhost", 6969);
        System.out.println("Connected...");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(getReadyImg());
    }
// method tao file de gui
    public ImgInfo getReadyImg() {
        //lay file dau vao
        File fileImg = new File("D:\\pic\\IMG-2820.jpg");
        ImgInfo resultImg = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileImg));
            //tao file dang object o day la ImgInfo
            resultImg = new ImgInfo(fileImg.getName(), fileImg.getPath(), null);
            // ghi byte[] vao file object de gui bang BufferredInputStream
            byte[] data = new byte[(int) fileImg.length()];
            //ghi byte vao mang byte
            bis.read(data, 0, data.length);
            //chuyen du lieu sang object
            resultImg.setFileData(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultImg;
    }
    public static void main(String[] args) {
        Client c;
        try {
            c = new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
