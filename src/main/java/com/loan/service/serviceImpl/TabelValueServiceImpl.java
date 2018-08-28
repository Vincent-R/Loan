package com.loan.service.serviceImpl;


import com.loan.dao.LoanTableValueDao;
import com.loan.entity.LoanTableValue;
import com.loan.entity.LoanTableValueExample;
import com.loan.service.TableValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Angel on 2018/8/29.
 */
@Service
public class TabelValueServiceImpl implements TableValueService {

    @Autowired
    private LoanTableValueDao loanTableValueDao;



    /**
     * 根据值的ID类型查找值
     * @param id
     * @return
     */
    @Override
    public LoanTableValue findOneById(Integer id) {
        return loanTableValueDao.selectByPrimaryKey(id);
    }

    /**
     * 根据类型查找所有值
     * @return
     */
    @Override
    public List<LoanTableValue> findValueByType(Integer valueType) {
        LoanTableValueExample example = new LoanTableValueExample();
        example.or().andValueTypeEqualTo(valueType);
        example.setOrderByClause("id ASC");
        return loanTableValueDao.selectByExample(example);
    }

    /**
     * 查找所有值
     * @return
     */
    @Override
    public List<LoanTableValue> findAll() {
        LoanTableValueExample example = new LoanTableValueExample();
        example.setOrderByClause("value_type ASC, id ASC");
        return loanTableValueDao.selectByExample(example);
    }

    /**
     * 添加值
     * @param loanTableValue
     * @return
     */
    @Override
    public int insert(LoanTableValue loanTableValue) {
        return loanTableValueDao.insert(loanTableValue);
    }

    /**
     * 根据id修改值
     * @param loanTableValue
     * @return
     */
    @Override
    public int updateById(LoanTableValue loanTableValue) {
        return loanTableValueDao.updateByPrimaryKey(loanTableValue);
    }

    /**
     * 根据id删除值
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return loanTableValueDao.deleteByPrimaryKey(id);
    }

}
