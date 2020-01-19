package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.ScoreMapper;
import com.zjt.manager.pojo.Score;
import com.zjt.manager.pojo.ScoreExample;
import com.zjt.manager.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    private static final Logger LOG = LoggerFactory.getLogger(ScoreServiceImpl.class);
    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public void insertScore(Score score) {
        scoreMapper.insert(score);
    }

    @Override
    public List<Score> list() {
        ScoreExample scoreExample = new ScoreExample();

        ScoreExample.Criteria criteria = scoreExample.createCriteria();

        criteria.andSidIsNotNull();

        return scoreMapper.selectByExample(scoreExample);
    }

    @Override
    public Score selectScoreByName(String scorename) {

        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andSnameEqualTo(scorename);
        System.out.println("根据用户名查询的用户长度"+scoreMapper.selectByExample(scoreExample).size());
        return scoreMapper.selectByExample(scoreExample).get(0);
    }

    @Override
    public List<Score> getScoresByIds(List<Integer> uids) {

        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andSidIn(uids);
        return scoreMapper.selectByExample(scoreExample);
    }

    @Override
    public Score getById(Integer id) {
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andSidEqualTo(id);
        return scoreMapper.selectByExample(scoreExample).get(0);
    }

    @Override
    public void updateScore(Score score) {

        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andSidEqualTo(score.getSid());
        scoreMapper.updateByExampleSelective(score,scoreExample);
    }

    @Override
    public void deleteScore(List<Integer> uids) {

        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andSidIn(uids);
        scoreMapper.deleteByExample(scoreExample);
    }

    @Override
    public List<Score> selectByCriterion(String sname) {


        return scoreMapper.selectByCriteron(sname);
    }

    @Override
    public Score selectScoreById(Integer uid) {
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andSidEqualTo(uid);

        return scoreMapper.selectByExample(scoreExample).get(0);
    }

}
