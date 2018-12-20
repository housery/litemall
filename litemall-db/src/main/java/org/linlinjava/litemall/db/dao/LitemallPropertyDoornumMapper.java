package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallPropertyDoornum;
import org.linlinjava.litemall.db.domain.LitemallPropertyDoornumExample;

public interface LitemallPropertyDoornumMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    long countByExample(LitemallPropertyDoornumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallPropertyDoornumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    int insert(LitemallPropertyDoornum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    int insertSelective(LitemallPropertyDoornum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallPropertyDoornum selectOneByExample(LitemallPropertyDoornumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallPropertyDoornum selectOneByExampleSelective(@Param("example") LitemallPropertyDoornumExample example, @Param("selective") LitemallPropertyDoornum.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallPropertyDoornum> selectByExampleSelective(@Param("example") LitemallPropertyDoornumExample example, @Param("selective") LitemallPropertyDoornum.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    List<LitemallPropertyDoornum> selectByExample(LitemallPropertyDoornumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallPropertyDoornum selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallPropertyDoornum.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    LitemallPropertyDoornum selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallPropertyDoornum record, @Param("example") LitemallPropertyDoornumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallPropertyDoornum record, @Param("example") LitemallPropertyDoornumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallPropertyDoornum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_doornum
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallPropertyDoornum record);
}