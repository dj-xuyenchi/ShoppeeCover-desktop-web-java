package socket;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    // create Socket object
    private Socket client;
    private String serverHost = "localhost";
    private int serverPort = 9900;

    /**
     * run program
     *
     * @author viettuts.vn
     * @param args
     */
    public static void main(String[] args) {
        String sourceFilePath = "D:\\pic\\girl.jpg";
        String destinationDir = "D:\\server\\";
        TCPClient tcpClient = new TCPClient();
        tcpClient.connectServer();
        tcpClient.sendFile(sourceFilePath, destinationDir);
        tcpClient.closeSocket(tcpClient.client);
    }

    /**
     * connect to server
     *
     * @author viettuts.vn
     */
    public void connectServer() {
        try {
            client = new Socket(serverHost, serverPort);
            System.out.println("connected to server");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * send file to server
     *
     * @param sourceFilePath
     * @param destinationDir
     */
    public void sendFile(String sourceFilePath, String destinationDir) {
        DataOutputStream outToServer = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            // make greeting
            outToServer = new DataOutputStream(
                    client.getOutputStream());
            outToServer.writeUTF("Hello from "
                    + client.getLocalSocketAddress());

            // get file info
            FileInfo fileInfo = getFileInfo(sourceFilePath, destinationDir);

            // send file
            oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(fileInfo);

            // get confirmation
            ois = new ObjectInputStream(client.getInputStream());
            fileInfo = (FileInfo) ois.readObject();
            if (fileInfo != null) {
                System.out.println(fileInfo.getStatus());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // close all stream
            closeStream(oos);
            closeStream(ois);
            closeStream(outToServer);
        }
    }

    /**
     * get source file info
     *
     * @author viettuts.vn
     * @param sourceFilePath
     * @param destinationDir
     * @return FileInfo
     */
    private FileInfo getFileInfo(String sourceFilePath, String destinationDir) {
        FileInfo fileInfo = null;
        BufferedInputStream bis = null;
        try {
            File sourceFile = new File(sourceFilePath);
            bis = new BufferedInputStream(new FileInputStream(sourceFile));
            fileInfo = new FileInfo();
            byte[] fileBytes = new byte[(int) sourceFile.length()];
            // get file info
            bis.read(fileBytes, 0, fileBytes.length);
            fileInfo.setFilename(sourceFile.getName());
            fileInfo.setDataBytes(fileBytes);
            fileInfo.setDestinationDirectory(destinationDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeStream(bis);
        }
        return fileInfo;
    }

    /**
     * close socket
     *
     * @author viettuts.vn
     */
    public void closeSocket(Socket socket) {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * close input stream
     *
     * @author viettuts.vn
     */
    public void closeStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * close output stream
     *
     * @author viettuts.vn
     */
    public void closeStream(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
