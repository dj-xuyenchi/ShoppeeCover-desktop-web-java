package socket;

import java.io.Serializable;

public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String destinationDirectory;
    private String sourceDirectory;
    private String filename;
    private long fileSize;
    private int piecesOfFile;
    private int lastByteLength;
    private byte[] dataBytes;
    private String status;
    // Constructor
    // getter & setter

    public FileInfo() {
    }

    public FileInfo(String destinationDirectory, String sourceDirectory, String filename, long fileSize, int piecesOfFile, int lastByteLength, byte[] dataBytes, String status) {
        this.destinationDirectory = destinationDirectory;
        this.sourceDirectory = sourceDirectory;
        this.filename = filename;
        this.fileSize = fileSize;
        this.piecesOfFile = piecesOfFile;
        this.lastByteLength = lastByteLength;
        this.dataBytes = dataBytes;
        this.status = status;
    }

    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public void setDestinationDirectory(String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getPiecesOfFile() {
        return piecesOfFile;
    }

    public void setPiecesOfFile(int piecesOfFile) {
        this.piecesOfFile = piecesOfFile;
    }

    public int getLastByteLength() {
        return lastByteLength;
    }

    public void setLastByteLength(int lastByteLength) {
        this.lastByteLength = lastByteLength;
    }

    public byte[] getDataBytes() {
        return dataBytes;
    }

    public void setDataBytes(byte[] dataBytes) {
        this.dataBytes = dataBytes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
