package com.tgy.clouddisk.service;

import com.tgy.clouddisk.entity.UserDTO;
import com.tgy.clouddisk.entity.UserFileDTO;
import com.tgy.clouddisk.entity.UserFolder;
import com.tgy.clouddisk.entity.UserFolderDTO;

import java.util.List;
import java.util.Map;

/**
 * 文件 I/O 操作相关
 * @author tanggy
 * @date 2018/11/1
 */
public interface DiskService {
    Map<String, Object> getMenuContents(Integer userId, String menu);

    Map<String, Object> getFolderContents(Integer userId, Integer folderId, Integer sortType);

    Map<String, Object> search(Integer userId, String input);

    Map<String, Object> move(List<Integer> folders, List<Integer> files, Integer dest);

    UserFolderDTO renameFolder(Integer folderId, String fileName);

    UserFileDTO renameFile(Integer fileId, String fileName, String fileType);

    UserFolderDTO newFolder(UserFolder unsaved);

    UserDTO shred(List<Integer> folders, List<Integer> files, Integer userId);
}
