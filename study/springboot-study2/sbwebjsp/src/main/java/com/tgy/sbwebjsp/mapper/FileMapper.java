package com.tgy.sbwebjsp.mapper;


import com.tgy.sbwebjsp.model.File;
import com.tgy.sbwebjsp.model.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Mapper
public interface FileMapper {
    @Select({"SELECT * FROM file WHERE canshare=1 AND filename LIKE #{searchcontent} LIMIT #{startindex},#{pagesize}"})
    List<File> getAllFiles(Page page) throws Exception;

    @Select({"SELECT COUNT(id) totalrecord FROM file WHERE canshare=1 AND filename LIKE #{searchcontent}"})
    int count(String searchcontent) throws Exception;

    @Select({"SELECT file.filepath FROM file WHERE id=#{value}"})
    String findFilepathById(int id) throws Exception;

    @Insert({"INSERT INTO icloud.file (filename,filepath,filesize,createtime,canshare,user_id,MD5) VALUES(#{filename},#{filepath},#{filesize},#{createtime},#{canshare},#{user_id},#{MD5})"})
    Integer insertFile(File file) throws Exception;

    @Select({"SELECT * FROM file WHERE filepath=#{filepath} order by createtime desc LIMIT #{startindex},#{pagesize}"})
    List<File> getUserFiles(Page page) throws Exception;

    @Select({"SELECT COUNT(id) totalrecord FROM file WHERE filepath=#{username}"})
    int countUserFiles(String username) throws Exception;

    @Update({"UPDATE FILE SET canshare=#{arg0} WHERE id=#{arg1}"})
    void updateFileById(int canshare, int id) throws Exception;

    @Delete({"DELETE FROM FILE WHERE id=#{value}"})
    void deleteFileById(int id);

    @Select({"SELECT file.filename FROM file WHERE id=#{value}"})
    String findFilenameById(int id);
}
