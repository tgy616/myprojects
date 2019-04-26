package com.tgy.sbwebjsp.controller;

import com.tgy.sbwebjsp.model.Page;
import com.tgy.sbwebjsp.model.PageBean;
import com.tgy.sbwebjsp.service.FileService;
import com.tgy.sbwebjsp.service.UserService;
import com.tgy.sbwebjsp.util.CommonUtil;
import com.tgy.sbwebjsp.util.MD5Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Controller
public class FileController {
    public static final String storePath;
    private static final int normallimit = 20000000;
    private static final int viplimit = 50000000;
    private static final int factor = 1000000;
    @Autowired
    private FileService fileService;
    @Autowired
    private UserService userService;

    public FileController() {
    }

    @RequestMapping({"/upload"})
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpSession Session, HttpServletRequest req, String MD5) {
        String user_name = (String)Session.getAttribute("user_name");
        if (user_name != null && !"".equals(user_name)) {
            Integer isvip = null;

            try {
                isvip = this.userService.isVip(user_name);
                req.setAttribute("isvip", isvip);
            } catch (Exception var15) {
                var15.printStackTrace();
                req.setAttribute("message", "未知错误，请重试");
                return "redirect:/searchUserfile";
            }

            File store = null;

            try {
                store = new File(storePath + File.separator + user_name, file.getOriginalFilename());
            } catch (Exception var14) {
                req.setAttribute("message", "请先选择文件！");
                return "redirect:/searchUserfile";
            }

            long size = file.getSize();
            if (!this.checkFile(store, storePath, isvip, size, req)) {
                return "redirect:/searchUserfile";
            } else {

                com.tgy.sbwebjsp.model.File f = new  com.tgy.sbwebjsp.model.File();
                f.setCreatetime(new Date((new java.util.Date()).getTime()));
                f.setFilename(file.getOriginalFilename());
                f.setFilepath(user_name);
                f.setFilesize(String.valueOf(size / 1024L + 1L));
                f.setCanshare(0);
                f.setMD5(MD5);
                MD5Mapper.MAP.put(MD5, f);
                Integer flag = null;

                try {
                    f.setUser_id(this.userService.findUserID(user_name));
                    flag = this.fileService.insertFile(f);
                    file.transferTo(store);
                } catch (Exception var13) {
                    var13.printStackTrace();
                }

                if (flag != null) {
                    req.setAttribute("message", "上传成功！");
                }

                return "redirect:/searchUserfile";
            }
        } else {
            return "login";
        }
    }

    @RequestMapping({"/FastUpload"})
    public String fastUpload(HttpSession session, String MD5) {
        String username = (String)session.getAttribute("user_name");
        com.tgy.sbwebjsp.model.File source = MD5Mapper.MAP.get(MD5);
        String SourthPath = storePath + File.separator + source.getFilepath() + File.separator + source.getFilename();
        String userPath = storePath + File.separator + username + File.separator + source.getFilename();
        this.fileService.copyFile(SourthPath, userPath);
        source.setFilepath(username);

        try {
            source.setUser_id(this.userService.findUserID(username));
            this.fileService.insertFile(source);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return "redirect:/searchUserfile";
    }

    private boolean checkFile(File store, String storePath, int isvip, long size, HttpServletRequest req) {
        if (store.exists()) {
            req.setAttribute("message", "文件已存在");
            return false;
        } else if (size == 0L) {
            req.setAttribute("message", "文件大小不能为0");
            return false;
        } else if (isvip == 0 && size > 20000000L) {
            req.setAttribute("message", "普通用户最大只能上传20Mb的文件");
            return false;
        } else if (isvip == 1 && size > 50000000L) {
            req.setAttribute("message", "VIP用户最大只能上传50Mb的文件");
            return false;
        } else {
            return true;
        }
    }

    @RequestMapping({"/searchFile"})
    public String Search(String searchcontent, Page page, Model mv) {
        if (page.getPageSize() == 0) {
            page.setPageSize(5);
        }

        if (page.getCurrentpage() == 0) {
            page.setCurrentpage(1);
        }

        page.setSearchcontent(searchcontent);
        PageBean pageBean = new PageBean();

        List list;
        try {
            list = this.fileService.getAllFiles(page);
        } catch (Exception var8) {
            var8.printStackTrace();
            return "redirect:/index";
        }

        pageBean.setList(list);
        pageBean.setCurrentpage(page.getCurrentpage());
        pageBean.setPagesize(page.getPageSize());

        try {
            pageBean.setTotalrecord(this.fileService.countShareFiles(searchcontent));
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        mv.addAttribute("pagebean", pageBean);
        mv.addAttribute("searchcontent", searchcontent);
        return "showsearchfiles";
    }

    @RequestMapping({"/download"})
    public String download(int id, String filename, HttpServletRequest req, HttpServletResponse rep) {
        Object var5 = null;

        try {
            String path = this.fileService.findFilepathById(id);
            if (path != null && !"".equals(path)) {
                path = "C:" + File.separator + "upload" + File.separator + path;
                File file = new File(path + File.separator + filename);
                long fileLength = file.length();
                long pastLength = 0L;
                int rangeSwitch = 0;
                long toLength = 0L;
                long contentLength = 0L;
                String rangeBytes = "";
                BufferedOutputStream out = null;
                RandomAccessFile raf = null;
                int len = 0;
                byte[] b = new byte[1024];
                String contentRange;
                if (req.getHeader("Range") != null) {
                    rep.setStatus(206);
                    rangeBytes = req.getHeader("Range").replaceAll("bytes=", "");
                    if (rangeBytes.indexOf(45) == rangeBytes.length() - 1) {
                        rangeSwitch = 1;
                        rangeBytes = rangeBytes.substring(0, rangeBytes.indexOf(45));
                        pastLength = Long.parseLong(rangeBytes.trim());
                        contentLength = fileLength - pastLength;
                    } else {
                        rangeSwitch = 2;
                        contentRange = rangeBytes.substring(0, rangeBytes.indexOf(45));
                        String temp2 = rangeBytes.substring(rangeBytes.indexOf(45) + 1, rangeBytes.length());
                        pastLength = Long.parseLong(contentRange.trim());
                        toLength = Long.parseLong(temp2);
                        contentLength = toLength - pastLength;
                    }
                } else {
                    contentLength = fileLength;
                }

                rep.reset();
                rep.setHeader("Accept-Ranges", "bytes");
                if (pastLength != 0L) {
                    System.out.println("----------------------------不是从开始进行下载！服务器即将开始断点续传...");
                    switch(rangeSwitch) {
                        case 1:
                            contentRange = "bytes " + (new Long(pastLength)).toString() + "-" + (new Long(fileLength - 1L)).toString() + "/" + (new Long(fileLength)).toString();
                            rep.setHeader("Content-Range", contentRange);
                            break;
                        case 2:
                            contentRange = rangeBytes + "/" + (new Long(fileLength)).toString();
                            rep.setHeader("Content-Range", contentRange);
                    }
                } else {
                    System.out.println("----------------------------是从开始进行下载！");
                }

                try {
                    rep.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
                    rep.setContentType(CommonUtil.setContentType(file.getName()));
                    rep.addHeader("Content-Length", String.valueOf(contentLength));
                    OutputStream os = rep.getOutputStream();
                    out = new BufferedOutputStream(os);
                    raf = new RandomAccessFile(file, "r");

                    try {
                        boolean mark;
                        int n;
                        label199:
                        switch(rangeSwitch) {
                            case 0:
                            case 1:
                                raf.seek(pastLength);
                                mark = false;

                                while(true) {
                                    if ((n = raf.read(b, 0, 1024)) == -1) {
                                        break label199;
                                    }

                                    out.write(b, 0, n);
                                }
                            case 2:
                                raf.seek(pastLength);
                                mark = false;
                                long readLength = 0L;

                                while(readLength <= contentLength - 1024L) {
                                    n = raf.read(b, 0, 1024);
                                    readLength += 1024L;
                                    out.write(b, 0, n);
                                }

                                if (readLength <= contentLength) {
                                    n = raf.read(b, 0, (int)(contentLength - readLength));
                                    out.write(b, 0, n);
                                }
                        }

                        out.flush();
                    } catch (IOException var40) {
                        System.out.println("#提醒# 向客户端传输时出现IO异常，但此异常是允许的的，有可能客户端取消了下载，导致此异常，不用关心！");
                    }
                } catch (Exception var41) {

                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException var39) {

                        }
                    }

                    if (raf != null) {
                        try {
                            raf.close();
                        } catch (IOException var38) {

                        }
                    }

                }

                return null;
            } else {
                req.setAttribute("message", "对不起，您要下载的资源已被删除");
                return "help";
            }
        } catch (Exception var43) {
            var43.printStackTrace();
            return null;
        }
    }

    @RequestMapping({"/Share"})
    public String share(Page page, int id, int canshare, HttpSession Session, HttpServletRequest req) {
        try {
            String username = this.fileService.findFilepathById(id);
            String login_user = (String)Session.getAttribute("user_name");
            if (username != null && login_user.equals(username)) {
                this.fileService.updateFileById(canshare, id);
                return "redirect:/searchUserfile";
            } else {
                req.setAttribute("globalmessage", "该文件可能不属于你");
                return "redirect:/searchUserfile";
            }
        } catch (Exception var8) {
            var8.printStackTrace();
            req.setAttribute("globalmessage", "未知错误，可能是参数异常");
            return "redirect:/searchUserfile";
        }
    }

    @RequestMapping({"/deleteFile"})
    public String Del(int id, Page page, HttpSession Session, HttpServletRequest req) {
        try {
            String username = this.fileService.findFilepathById(id);
            String login_user = (String)Session.getAttribute("user_name");
            String filename = this.fileService.findFilenameById(id);
            if (username != null && login_user.equals(username)) {
                this.fileService.deleteFileById(id);
                String storepath = new String("C:" + File.separator + "upload" + File.separator + login_user + File.separator);
                storepath = storepath + filename;
                System.out.println(storepath);
                File file = new File(storepath);
                if (file.exists()) {
                    file.delete();
                    return "redirect:searchUserfile";
                } else {
                    req.setAttribute("globalmessage", "文件已不存在");
                    return "help";
                }
            } else {
                req.setAttribute("globalmessage", "该文件可能不属于你");
                return "help";
            }
        } catch (Exception var10) {
            var10.printStackTrace();
            req.setAttribute("globalmessage", "该文件可能不属于你");
            return "redirect:searchUserfile";
        }
    }

    static {
        storePath = "C:" + File.separator + "upload";
    }
}
