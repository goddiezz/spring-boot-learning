package top.potatorice.boot.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/4/5 2:56 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rank {
    private String id;
    private String cover;
    private String title;
    private String link;
    private String content1;
    private String hot;
}
