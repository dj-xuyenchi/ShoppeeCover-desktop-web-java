
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class Server extends Thread {

    private ServerSocket server = null;
    private int port = 6969;
// Tao Server 
    public Server() throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server Online...");
    }
// Tao thread tiep nhan nhieu ket noi
    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Connected.."+socket.getRemoteSocketAddress());
                //Nhan object chua data dang byte[] ve server
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // tao object chua file nhan ve
                Object recei =   ois.readObject();
                ImgInfo receiImg = (ImgInfo) recei;
                if (receiImg != null) {
                    // tao file tu object
                    createImgToThisComputer(receiImg);
                }
                ois.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } 
        }
    }

    public void createImgToThisComputer(ImgInfo input) {
        //tao file ghi vao thu muc luc nay file chua co du lieu gi chi co ten
        File result = new File("C:\\Users\\PC\\Desktop\\jav3\\lib\\" + input.getFileName());
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(result));
            // ghi du lieu vao file
            bos.write(input.getFileData());
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
