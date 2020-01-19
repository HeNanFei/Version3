package com.zjt.manager.mapper;

import com.zjt.manager.pojo.Score;
import com.zjt.manager.pojo.ScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score
     *
     * @mbg.generated Sat Jan 18 22:23:27 CST 2020
     */
    long countByExample(ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score
     *
     * @mbg.generated Sat Jan 18 22:23:27 CST 2020
     */
    int deleteByExample(ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score
     *
     * @mbg.generated Sat Jan 18 22:23:27 CST 2020
     */
    int insert(Score record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score
     *
     * @mbg.generated Sat Jan 18 22:23:27 CST 2020
     */
    int insertSelective(Score record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score
     *
     * @mbg.generated Sat Jan 18 22:23:27 CST 2020
     */
    List<Score> selectByExample(ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score
     *
     * @mbg.generated Sat Jan 18 22:23:27 CST 2020
     */
    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score
     *
     * @mbg.generated Sat Jan 18 22:23:27 CST 2020
     */
    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    List<Score> selectByLimit(Integer page, Integer limit);

    List<Score> selectByCriteron(String sname);
}