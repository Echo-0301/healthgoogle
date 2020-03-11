package com.health.entity;

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
public class Userinf {

    private Integer id;

    private Double weight;

    private Double height;

    private Double bmi;

    private Integer target;

    private Double dbw;


}
