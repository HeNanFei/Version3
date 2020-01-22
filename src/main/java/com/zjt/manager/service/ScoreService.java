package com.zjt.manager.service;

import com.zjt.manager.pojo.Score;
import com.zjt.manager.pojo.result.ScoreResult;
import com.zjt.manager.pojo.search.SearchCriteron;

import java.util.List;
import java.util.Map;

public interface ScoreService {
    void insertScore(Score score);

    List<Score> list();

    Score selectScoreByName(String scorename);

    List<Score> getScoresByIds(List<Integer> uids);

    Score getById(Integer id);

    void updateScore(Score score);

    void deleteScore(List<Integer> uids);

    List<Score> selectByCriterion(String sname);

    Score selectScoreById(Integer uid);

    List<ScoreResult> getAllScoreReults(SearchCriteron searchCriteron);

    Map getEchartsData(SearchCriteron searchCriteron);


    Map getAllScoresInfor(SearchCriteron searchCriteron);


    Map getSourceData();

}
