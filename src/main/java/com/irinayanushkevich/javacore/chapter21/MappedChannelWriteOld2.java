package main.java.com.irinayanushkevich.javacore.chapter21;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

class MappedChannelWriteOld2 {

    public static void main(String[] args) {

        RandomAccessFile fOut = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;

        try {

            fOut = new RandomAccessFile("test.txt", "rw");
            fChan = fOut.getChannel();
            mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e);

        } finally {

            try {
                if (fChan != null) {
                    fChan.close();
                }
            } catch (IOException e) {
                System.out.println("Closing channel error");
            }

            try {
                if (fOut != null) {
                    fOut.close();
                }
            } catch (IOException e) {
                System.out.println("Closing file error");
            }
        }
    }
}
