
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class ImgInfo implements Serializable{
    private String fileName;
    private String addressFile;
    private byte[] fileData;

    public ImgInfo() {
    }

    public ImgInfo(String fileName, String addressFile, byte[] fileData) {
        this.fileName = fileName;
        this.addressFile = addressFile;
        this.fileData = fileData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAddressFile() {
        return addressFile;
    }

    public void setAddressFile(String addressFile) {
        this.addressFile = addressFile;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
}
