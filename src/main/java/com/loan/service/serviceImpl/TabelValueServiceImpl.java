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
    public  String[][] findAll() {
        LoanTableValueExample example = new LoanTableValueExample();
        example.setOrderByClause("value_type ASC, id ASC");
        List<LoanTableValue> list =  loanTableValueDao.selectByExample(example);
        int[] colNum = new int[5];
        for(int i = 0; i <5; i++){
            int count = 0;
            for(int j=0; j<list.size();j++) {
                LoanTableValue loanTableValue = list.get(j);
                if (loanTableValue.getValueType() == i) {
                    count+=1;
                } else {
                    continue;
                }
                colNum[i] = count;
            }
        }
        String[][] result = new String[5][];
        for(int k = 0; k<5;k++) {
            result[k] = new String[colNum[k]];
            int col = 0;
            for (int i = 0; i < list.size(); i++) {
                LoanTableValue loanTableValue = list.get(i);
                if (loanTableValue.getValueType() == k) {
                    try {
                        String newLoanTableValue = "{ id: " + loanTableValue.getId() +
                                ", valueType: " + loanTableValue.getValueType() +
                                ", value: '" + loanTableValue.getValue() +
                                "', remark: '" + loanTableValue.getRemark() +
                                "'}";
                        result[k][col] = newLoanTableValue;
                        col++;
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                } else {
                    continue;
                }
            }
        }
        return result;
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

    @Override
    public List<LoanTableValue> findValueByRemark(String remark) {
        LoanTableValueExample example = new LoanTableValueExample();
        example.or().andRemarkEqualTo(remark);
        example.setOrderByClause("id ASC");
        return loanTableValueDao.selectByExample(example);
    }

}
