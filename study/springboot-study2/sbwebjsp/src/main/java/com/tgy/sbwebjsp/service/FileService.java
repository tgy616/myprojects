package com.tgy.sbwebjsp.service;

import com.tgy.sbwebjsp.mapper.FileMapper;
import com.tgy.sbwebjsp.model.File;
import com.tgy.sbwebjsp.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.util.List;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Service("fileService")
public class FileService {
    @Autowired
    private FileMapper dao;

    public FileService() {
    }

    public List<File> getAllFiles(Page page) throws Exception {
        page.setSearchcontent("%" + page.getSearchcontent() + "%");
        return this.dao.getAllFiles(page);
    }

    public int countShareFiles(String searchcontent) throws Exception {
        searchcontent = "%" + searchcontent + "%";
        return this.dao.count(searchcontent);
    }

    public String findFilepathById(int id) throws Exception {
        return this.dao.findFilepathById(id);
    }

    public Integer insertFile(File file) throws Exception {
        return this.dao.insertFile(file);
    }

    public List<File> getUserFiles(Page page) throws Exception {
        return this.dao.getUserFiles(page);
    }

    public int countUserFiles(String username) throws Exception {
        return this.dao.countUserFiles(username);
    }

    public boolean copyFile(String file, String path) {
        try {
            Files.copy((new java.io.File(file)).toPath(), (new java.io.File(path)).toPath());
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public void updateFileById(int canshare, int id) throws Exception {
        this.dao.updateFileById(canshare, id);
    }

    public void deleteFileById(int id) {
        this.dao.deleteFileById(id);
    }

    public String findFilenameById(int id) {
        return this.dao.findFilenameById(id);
    }
}
