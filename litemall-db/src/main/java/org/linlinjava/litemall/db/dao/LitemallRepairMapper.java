package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallRepair;
import org.linlinjava.litemall.db.domain.LitemallRepairExample;

public interface LitemallRepairMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    long countByExample(LitemallRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    int insert(LitemallRepair record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    int insertSelective(LitemallRepair record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRepair selectOneByExample(LitemallRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRepair selectOneByExampleSelective(@Param("example") LitemallRepairExample example, @Param("selective") LitemallRepair.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallRepair> selectByExampleSelective(@Param("example") LitemallRepairExample example, @Param("selective") LitemallRepair.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    List<LitemallRepair> selectByExample(LitemallRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRepair selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallRepair.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    LitemallRepair selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallRepair record, @Param("example") LitemallRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallRepair record, @Param("example") LitemallRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallRepair record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_repair
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallRepair record);
}