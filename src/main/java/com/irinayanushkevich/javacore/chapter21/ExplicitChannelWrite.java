package main.java.com.irinayanushkevich.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class ExplicitChannelWrite {

    public static void main(String[] args) {

        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            ByteBuffer mBuf = ByteBuffer.allocate(26);

            // for (int h = 0; h < 3; h++) {

            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }

            mBuf.rewind();
            fChan.write(mBuf);

            // mBuf.rewind();
            // }

        } catch (InvalidPathException e) {
            System.out.println("Path error: " + e);

        } catch (IOException e) {
            System.out.println("Input/Output error: " + e);
            System.exit(1);
        }
    }
}
