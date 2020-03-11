package com.health.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


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
public class Diet {

    private Integer id;

    private Double total;

    private Double breakfast;

    private Double lunch;

    private Double dinner;

    private Double sport;

    @TableField("Abreakfast")
    private Double Abreakfast;

    @TableField("Adinner")
    private Double Adinner;

    @TableField("Alunch")
    private Double Alunch;

    @TableField("Asport")
    private Double Asport;


}
