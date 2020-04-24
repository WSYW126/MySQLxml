package com.wsyw126.MySQLxml.utils;

import com.wsyw126.MySQLxml.exception.SQLException;
import org.springframework.core.io.FileSystemResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * CachedFileSystemResource.
 *
 * @author xinzhi.zhang
 */
public class CachedFileSystemResource extends FileSystemResource {

    private byte[] data;

    public CachedFileSystemResource(String path) {
        super(path);
    }

    @Override
    synchronized public InputStream getInputStream() {
        if (data == null) {
            try {
                InputStream tem = super.getInputStream();
                List<Byte> temData = new ArrayList<Byte>();
                for (int i = tem.read(); i != -1; i = tem.read()) {
                    temData.add((byte) i);
                }
                data = new byte[temData.size()];
                for (int i = 0; i < temData.size(); i++) {
                    data[i] = temData.get(i);
                }
            } catch (IOException e) {
                throw new SQLException(e);
            }
        }

        return new ByteArrayInputStream(data);
    }
}
