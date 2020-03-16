package com.health.mapper;

import com.health.entity.Userweight;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Repository
public interface UserweightMapper{

    List<Userweight> getAll(@RequestParam("id") Integer id);

    List<Userweight> getOneMounth(@RequestParam("id") Integer id);

    List<Userweight> getSevenDay(@RequestParam("id") Integer id);

    double getMax(@RequestParam("id")Integer id);

    double getMin(@RequestParam("id")Integer id);

    double getAve(@RequestParam("id")Integer id);

    double getToday(@RequestParam("id")Integer id);

    double getYesterday(@RequestParam("id")Integer id);
}
