package socket;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread {

    // create serverSocket object
    private ServerSocket serverSocket;
    private int port = 9900;

    /**
     * run program
     *
     * @author viettuts.vn
     * @param args
     */
    public static void main(String[] args) {
        TCPServer tcpServer = new TCPServer();
        tcpServer.open();
        tcpServer.start();
    }

    /**
     * open server
     *
     * @author viettuts.vn
     */
    public void open() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server is open on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * handle event
     *
     * @author vietuts.vn
     */
    public void run() {
        while (true) {
            Socket server = null;
            DataInputStream inFromClient = null;
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;

            try {
                // accept connect from client and create Socket object
                server = serverSocket.accept();
                System.out.println("connected to "
                        + server.getRemoteSocketAddress());

                // get greeting from client
                inFromClient = new DataInputStream(server.getInputStream());
                System.out.println(inFromClient.readUTF());

                // receive file info
                ois = new ObjectInputStream(server.getInputStream());
                FileInfo fileInfo = (FileInfo) ois.readObject();
                if (fileInfo != null) {
                    createFile(fileInfo);
                }

                // confirm that file is received
                oos = new ObjectOutputStream(server.getOutputStream());
                fileInfo.setStatus("success");
                fileInfo.setDataBytes(null);
                oos.writeObject(fileInfo);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                // close all stream
                closeStream(ois);
                closeStream(oos);
                closeStream(inFromClient);
                // close session
                closeSocket(server);
            }
        }
    }

    /**
     * create file with fileInfo
     *
     * @author viettuts.vn
     * @param fileInfo
     * @return file is created or not
     */
    private boolean createFile(FileInfo fileInfo) {
        BufferedOutputStream bos = null;

        try {
            if (fileInfo != null) {
                File fileReceive = new File(fileInfo.getDestinationDirectory()
                        + fileInfo.getFilename());
                bos = new BufferedOutputStream(
                        new FileOutputStream(fileReceive));
                // write file content
                bos.write(fileInfo.getDataBytes());
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeStream(bos);
        }
        return true;
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
