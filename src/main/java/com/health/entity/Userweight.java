package com.health.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Userweight{

    private Integer id;

    private LocalDateTime date;

    private Double weight;
    //最高体重 最低体重 平均体重   日均变化  记录天数 体重变化
    private Double max;

    private Double min;

    private Double ave;

    private Integer Rday;

    private Double Dchange;

    private Double Wchange;


}
