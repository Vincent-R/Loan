package com.loan.service;

import com.loan.entity.LoanTableValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Angel on 2018/8/29.
 */
@Service
public interface TableValueService {

    /**
     * 根据值的ID类型查找值
     * @param id
     * @return
     */

    LoanTableValue findOneById(Integer id);

    /**
     * 根据类型查找所有值
     * @return
     */
    List<LoanTableValue> findValueByType(Integer valueTpye);


    /**
     * 查找所有值
     * @return
     */

    String[][] findAll();
    /**
     * 添加值
     * @param loanTableValue
     * @return
     */
    int insert(LoanTableValue loanTableValue);


    /**
     * 根据id修改值
     * @param loanTableValue
     * @return
     */
    int updateById(LoanTableValue loanTableValue);

    /**
     * 根据id删除值
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据键来拿静态索引
     *
     * @param remark
     * @return
     */
    List<LoanTableValue> findValueByRemark(String remark);
}
