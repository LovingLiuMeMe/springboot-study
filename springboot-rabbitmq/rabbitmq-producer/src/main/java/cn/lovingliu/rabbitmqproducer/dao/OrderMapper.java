package cn.lovingliu.rabbitmqproducer.dao;

import cn.lovingliu.rabbitmqproducer.domain.Order;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Sep 24 23:15:58 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Sep 24 23:15:58 CST 2019
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Sep 24 23:15:58 CST 2019
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Sep 24 23:15:58 CST 2019
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Sep 24 23:15:58 CST 2019
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Sep 24 23:15:58 CST 2019
     */
    int updateByPrimaryKey(Order record);
}