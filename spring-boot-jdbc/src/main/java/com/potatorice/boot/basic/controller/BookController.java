package com.potatorice.boot.basic.controller;

import com.potatorice.boot.basic.controller.dto.AjaxResponse;
import com.potatorice.boot.basic.entity.Book;
import com.potatorice.boot.basic.entity.BookReader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/5 12:12 下午
 */
@RestController
@RequestMapping(value = "/api/v1/books")
@Slf4j
@Api(tags = "⽂章管理接⼝")
public class BookController {
    /**
     * 查询⽂章，id为URL查询参数
     *
     * @return AjaxResponse
     */
    @ApiOperation("获取所有图书")
    @GetMapping("all")
    public AjaxResponse selectBooks() {
        BookReader[] readers = {
                BookReader.builder()
                        .name("aaa")
                        .age(20)
                        .build(),
                BookReader.builder()
                        .name("bbb")
                        .age(19)
                        .build(),
        };
        List<BookReader> readerList = Arrays.asList(readers);
        Book book1 = Book.builder()
                .id(123)
                .author("potota")
                .title("SpringBoot")
                .content("从入门到精通")
                .createTime(new Date())
                .readers(readerList)
                .build();
        Book book2 = Book.builder()
                .id(456)
                .author("potota")
                .title("vue.js")
                .content("从入门到精通")
                .createTime(new Date())
                .readers(readerList)
                .build();
        Book[] books = {book1, book2};
        List<Book> bookList = Arrays.asList(books);

        return AjaxResponse.success(bookList);
    }

    @ApiOperation("URL传参，根据id获取⽂章")
    @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id) {
        Book book = Book.builder()
                .id(id)
                .author("potota")
                .title("java")
                .content("java")
                .createTime(new Date())
                .build();
        return AjaxResponse.success(book);
    }

    @GetMapping()
    @ApiOperation("根据id，url传参查询文章")
    public AjaxResponse selectBook(
            @ApiParam("文章id")
            @RequestParam int id
    ){
        Book book = Book.builder()
                .id(id)
                .author("potato")
                .title("《spring》")
                .content("spring学着试试看")
                .createTime(new Date())
                .build();
        return AjaxResponse.success(book);
    }

    @ApiOperation("JSON对象添加图书")
    @PostMapping()
    public AjaxResponse saveBook(@RequestBody Book book) {
        log.info("saveBook" + book);
        return AjaxResponse.success(book);
    }

    @PostMapping("param")
    @ApiOperation("URL传参新增文章")
    public AjaxResponse saveArticle(
            @ApiParam("文章id")
            @RequestParam(value = "id", defaultValue = "111", required = false) int id,
            @ApiParam("作者")
            @RequestParam(value = "author", defaultValue = "potatoRice", required = false) String author,
            @ApiParam("标题")
//            @Length(min = 5 , max = 20, message = "文章表弟长度必须为5～20")
            @RequestParam String title,
            @ApiParam("内容")
            @RequestParam String content,
            @ApiParam("创建时间")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam(value = "createTime", defaultValue = "2021-03-07 23:20:00") Date createTime
    ){
        Book book = Book.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .createTime(createTime)
                .build();
        log.info("saveArticle: " + book);
        return AjaxResponse.success(book);
    }

    @ApiOperation("修改图书信息")
    @PutMapping()
    public AjaxResponse updateBook(@RequestBody Book book) {
        Book book1 = Book.builder()
                .id(111)
                .author("potota")
                .title("java")
                .content("java")
                .createTime(new Date())
                .build();
        log.info("book:" + book1);

        book1.setId(book.getId());
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        book1.setContent(book.getContent());

        log.info("book:" + book1);
        return AjaxResponse.success(book1);
    }

    @ApiOperation("删除图书")
    @DeleteMapping("{id}")
    public AjaxResponse deleteArticle(@PathVariable int id) {
        log.info("id:" + id);
        return AjaxResponse.success();
    }

    @PostMapping("upload")
    public AjaxResponse handleUpload(MultipartFile[] files, HttpServletRequest request){
        List fileName = new ArrayList();
        //创建文件在服务器的存放路径
        YearMonth ym = YearMonth.now();
        Calendar now = Calendar.getInstance();
        for (MultipartFile file : files) {
            // 判断文件是否有内容
            if (file.isEmpty()) {
                System.out.println("请勿上传空文件!!!");
            }else {
                //生成文件在服务器的名称的前缀
                String prefixName = UUID.randomUUID().toString();
                //取得源文件名
                String originalFilename = file.getOriginalFilename();
                //从源文件名分离出扩展名
                assert originalFilename != null;
                String suffixName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                //拼接新的文件名
                String newFileName = prefixName + suffixName;

                //处理文件夹
                String s = ym.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                int d = now.get(Calendar.DAY_OF_MONTH);
                String path = request.getServletContext().getRealPath("upload/" + s + "/" + d + "/" + suffixName);
                log.info(path);
                File fileDir = new File(path);
                if(!fileDir.exists()){
                    boolean flag = fileDir.mkdirs();
                    log.info("flag:"+ flag);
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
                fileName.add(newFileName);
                log.info(fileName.toString());
            }
        }
        return AjaxResponse.success(fileName);
    }
}
