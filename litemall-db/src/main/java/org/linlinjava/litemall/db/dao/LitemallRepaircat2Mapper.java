package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallRepaircat2;
import org.linlinjava.litemall.db.domain.LitemallRepaircat2Example;

public interface LitemallRepaircat2Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    long countByExample(LitemallRepaircat2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallRepaircat2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    int insert(LitemallRepaircat2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    int insertSelective(LitemallRepaircat2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRepaircat2 selectOneByExample(LitemallRepaircat2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRepaircat2 selectOneByExampleSelective(@Param("example") LitemallRepaircat2Example example, @Param("selective") LitemallRepaircat2.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallRepaircat2> selectByExampleSelective(@Param("example") LitemallRepaircat2Example example, @Param("selective") LitemallRepaircat2.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    List<LitemallRepaircat2> selectByExample(LitemallRepaircat2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRepaircat2 selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallRepaircat2.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    LitemallRepaircat2 selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallRepaircat2 record, @Param("example") LitemallRepaircat2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallRepaircat2 record, @Param("example") LitemallRepaircat2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallRepaircat2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repaircat2
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallRepaircat2 record);
}