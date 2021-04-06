package top.loorzve.boot.aop.controller;

import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;
import top.loorzve.boot.aop.annotation.ControllerWebLog;
import top.loorzve.boot.aop.controller.dto.AjaxResponse;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/4/1 2:48 下午
 */
@Slf4j
@RestController
@RequestMapping(value = "api")
public class HelloController {

    @GetMapping("hello")
    @ControllerWebLog(name = "getHello", isSaved = true)
    public String hello(String name, String title) {
        log.info("controller的name参数" + name);
        log.info("controller的title参数" + title);
        //休眠，模拟接口耗时
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int a = 5 / 0;
        return "hello";
    }

    @PostMapping("upload")
    public AjaxResponse handleUpload(MultipartFile[] files, HttpServletRequest request) {
        List fileName = new ArrayList();
        //创建文件在服务器的存放路径
        YearMonth ym = YearMonth.now();
        Calendar now = Calendar.getInstance();
        for (MultipartFile file : files) {
            // 判断文件是否有内容
            if (file.isEmpty()) {
                System.out.println("该文件无任何内容!!!");
            } else {
                //生成文件在服务器的名称的前缀
                String prefixName = UUID.randomUUID().toString();
                //取得源文件名
                String originalFilename = file.getOriginalFilename();
                //从源文件名分离出扩展名
                assert originalFilename != null;
                String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
                //拼接新的文件名
                String newFileName = prefixName + suffixName;
                String newFileName1 = "1" + prefixName + suffixName;
                String newFileName2 = "2" + prefixName + suffixName;

                //处理文件夹
//                String s = ym.format(DateTimeFormatter.ofPattern("yyyy-MM"));
//                int d = now.get(Calendar.DAY_OF_MONTH);
                String path = request.getServletContext().getRealPath("upload");

                log.info(path);
                File fileDir = new File(path);
                if (!fileDir.exists()) {
                    boolean flag = fileDir.mkdirs();
                    log.info("flag:" + flag);
                }

                //创建上传的文件对象
                File saveFile = new File(path + "/" + newFileName);
                //上传
                try {
                    file.transferTo(saveFile);
                } catch (IOException e) {
                    e.printStackTrace();
                    log.info(e.getMessage());
                    AjaxResponse.failure("文件上传失败");
                }
                File saveFile1 = new File(path + "/" + newFileName1);
                File saveFile2 = new File(path + "/" + newFileName2);
                QrCodeUtil.generate("http://potato-rice.cn.utools.club/upload/" + newFileName, 300, 300, FileUtil.file(saveFile1));
                System.out.println(saveFile);
                fileName.add(newFileName);
                fileName.add(newFileName1);
                fileName.add(newFileName2);
                ImgUtil.pressText(
                        FileUtil.file(saveFile),
                        FileUtil.file(saveFile2),
                        "Potato-Rice", Color.WHITE, //文字
                        new Font("黑体", Font.BOLD, 100), //字体
                        0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                        0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                        0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
                );


//                Img.from(FileUtil.file(saveFile))
//                        .setQuality(0.8)//压缩比率
//                        .write(FileUtil.file(saveFile));
//                log.info(fileName.toString());
            }
        }
        return AjaxResponse.success(fileName);
    }
}
