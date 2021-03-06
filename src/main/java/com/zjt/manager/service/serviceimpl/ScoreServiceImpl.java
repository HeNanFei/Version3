package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.ScoreMapper;
import com.zjt.manager.pojo.Score;
import com.zjt.manager.pojo.ScoreExample;
import com.zjt.manager.pojo.result.ScoreResult;
import com.zjt.manager.pojo.result.SourceData;
import com.zjt.manager.pojo.search.SearchCriteron;
import com.zjt.manager.service.ScoreService;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

        criteria.andScoreidIsNotNull();

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
        criteria.andScoreidIn(uids);
        return scoreMapper.selectByExample(scoreExample);
    }

    @Override
    public Score getById(Integer id) {
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andScoreidEqualTo(id);
        return scoreMapper.selectByExample(scoreExample).get(0);
    }

    @Override
    public void updateScore(Score score) {

        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andScoreidEqualTo(score.getScoreid());
        scoreMapper.updateByExampleSelective(score,scoreExample);
    }

    @Override
    public void deleteScore(List<Integer> uids) {

        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andScoreidIn(uids);
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
        criteria.andScoreidEqualTo(uid);

        return scoreMapper.selectByExample(scoreExample).get(0);
    }

    @Override
    public List<ScoreResult> getAllScoreReults(SearchCriteron searchCriteron) {



        return  scoreMapper.selectAllByProject(searchCriteron);
    }

    @Override
    public Map<String,List> getEchartsData(SearchCriteron searchCriteron) {

        Map map = new HashMap();
        List<ScoreResult> singleProject = scoreMapper.getSingleProject(searchCriteron);
        List<String> lnames = new ArrayList<>();
        List<Integer> chinese = new ArrayList<>();
        List<Integer> math = new ArrayList<>();
        List<Integer> english = new ArrayList<>();
        List<Integer> physics = new ArrayList<>();
        List<Integer> chemistry = new ArrayList<>();
        List<Integer> biology = new ArrayList<>();



        for(ScoreResult scoreResult :singleProject){
            lnames.add(scoreResult.getLname());
            chinese.add(scoreResult.getScore());
        }

        map.put("lnames",lnames);
        return map;
    }

    @Override
    public Map getAllScoresInfor(SearchCriteron searchCriteron) {


        Map map = new HashMap();
        List<ScoreResult> allScoresInfor = scoreMapper.getAllScoresInfor(searchCriteron);
        List<String> lnames = new ArrayList<>();
        List<String> chinames = new ArrayList<>();
        List<String> matnames = new ArrayList<>();
        List<String> phynames = new ArrayList<>();
        List<String> chenames = new ArrayList<>();
        List<String> bionames = new ArrayList<>();
        List<String> englnames = new ArrayList<>();
        List<Integer> chinese = new ArrayList<>();
        List<Integer> math = new ArrayList<>();
        List<Integer> english = new ArrayList<>();
        List<Integer> physics = new ArrayList<>();
        List<Integer> chemistry = new ArrayList<>();
        List<Integer> biology = new ArrayList<>();

        List<String> elnames = new ArrayList<>();

        //考试次数



        SearchCriteron temp = new SearchCriteron();
        temp.setCname("语文");
        temp.setSname(searchCriteron.getSname());
        List<ScoreResult> chineseResult = scoreMapper.getSingleProject(temp);
        for (ScoreResult scoreResult:chineseResult){
            chinames.add(scoreResult.getLname());
        }

        SearchCriteron mathLnames = new SearchCriteron();
        mathLnames.setCname("数学");
        mathLnames.setSname(searchCriteron.getSname());
        List<ScoreResult> mathResult = scoreMapper.getSingleProject(mathLnames);
        for (ScoreResult scoreResult:mathResult){
            matnames.add(scoreResult.getLname());
        }

        SearchCriteron englishLnames = new SearchCriteron();
        englishLnames.setCname("英语");
        englishLnames.setSname(searchCriteron.getSname());
        List<ScoreResult> englishResult = scoreMapper.getSingleProject(englishLnames);
        for (ScoreResult scoreResult:englishResult){
            System.out.println(scoreResult.getLname());
            englnames.add(scoreResult.getLname());
        }

        SearchCriteron physicsLnames = new SearchCriteron();
        physicsLnames.setCname("物理");
        physicsLnames.setSname(searchCriteron.getSname());
        List<ScoreResult> physicsResult = scoreMapper.getSingleProject(physicsLnames);
        for (ScoreResult scoreResult:physicsResult){
            phynames.add(scoreResult.getLname());
        }

        SearchCriteron biologyNames = new SearchCriteron();
        biologyNames.setCname("生物");
        biologyNames.setSname(searchCriteron.getSname());
        List<ScoreResult> biologyResult = scoreMapper.getSingleProject(biologyNames);
        for (ScoreResult scoreResult:biologyResult){
            bionames.add(scoreResult.getLname());
        }

        SearchCriteron chemistryLnames = new SearchCriteron();
        chemistryLnames.setCname("化学");
        chemistryLnames.setSname(searchCriteron.getSname());
        List<ScoreResult> chemistryResult = scoreMapper.getSingleProject(chemistryLnames);
        for (ScoreResult scoreResult:chemistryResult){
            chenames.add(scoreResult.getLname());
        }

        for(int i=0;i<allScoresInfor.size();i++){
          if(allScoresInfor.get(i).getCname().contains("语文")){
              chinese.add(allScoresInfor.get(i).getScore());
            }else if(allScoresInfor.get(i).getCname().contains("数学")){
              math.add(allScoresInfor.get(i).getScore());
          }else if(allScoresInfor.get(i).getCname().contains("英语")){
              english.add(allScoresInfor.get(i).getScore());
          }else if(allScoresInfor.get(i).getCname().contains("物理")){
              physics.add(allScoresInfor.get(i).getScore());
          }else if(allScoresInfor.get(i).getCname().contains("化学")){
              chemistry.add(allScoresInfor.get(i).getScore());
          }else if(allScoresInfor.get(i).getCname().contains("生物")){
              biology.add(allScoresInfor.get(i).getScore());
          }

        }
        Integer chineseTimes = chineseResult.size();
        Integer mathTimes = mathResult.size();
        Integer englishTimes = englishResult.size();
        Integer physicsTimes = physicsResult.size();
        Integer chemistryTimes = chemistryResult.size();
        Integer biologyTimes = biologyResult.size();
        //上课科目
        List<String> onGoing = new ArrayList<>();


        //判断课程科目数量
        int totalProjects = 0;
        if(chineseResult.size() != 0){
            onGoing.add("语文");
            totalProjects++;
        } if(mathResult.size() != 0){
            onGoing.add("数学");

            totalProjects++;
        } if(englishResult.size() != 0){
            onGoing.add("英语");

            totalProjects++;
        } if(physicsResult.size() != 0){
            onGoing.add("物理");

            totalProjects++;
        } if(chemistryResult.size() != 0){
            onGoing.add("化学");

            totalProjects++;
        } if(biologyResult.size() != 0){
            onGoing.add("生物");

            totalProjects++;
        }
        //最佳科目和最low科目
        List<Integer> balanceScores = new ArrayList<>();
        balanceScores.add(getBalance(chinese));
        balanceScores.add(getBalance(math));
        balanceScores.add(getBalance(english));
        balanceScores.add(getBalance(physics));
        balanceScores.add(getBalance(chemistry));
        balanceScores.add(getBalance(biology));
        //最高平均分
        Integer max = Collections.max(balanceScores);
        //最低平均分
        Integer min = Collections.min(balanceScores);
        //最佳科目
        String bestProject = null;
        String poorProject = null;
        for (int i=0;i<balanceScores.size();i++){
            if ( balanceScores.get(i).equals(max)){
                if(i==0){
                    bestProject = "语文";
                }
                if(i==1){
                    bestProject = "数学";
                }
                if(i==2){
                    bestProject = "英语";
                }
                if(i==3){
                    bestProject = "物理";
                } if(i==4){
                    bestProject = "化学";
                } if(i==5){
                    bestProject = "生物";
                }
            }
            if ( balanceScores.get(i).equals(min)){
                if(i==0){
                    poorProject = "语文";
                }
                if(i==1){
                    poorProject = "数学";
                }
                if(i==2){
                    poorProject = "英语";
                }
                if(i==3){
                    poorProject = "物理";
                } if(i==4){
                    poorProject = "化学";
                } if(i==5){
                    poorProject = "生物";
                }
            }
        }







        Map timesMap = new HashMap();
        timesMap.put("chineseTimes",chineseTimes);
        timesMap.put("mathTimes",mathTimes);
        timesMap.put("englishTimes",englishTimes);
        timesMap.put("physicsTimes",physicsTimes);
        timesMap.put("chemistryTimes",chemistryTimes);
        timesMap.put("biologyTimes",biologyTimes);

        map.put("max",max);
        map.put("min",min);
        map.put("bestProject",bestProject);
        map.put("poorProject",poorProject);
        map.put("lnames",lnames);
        map.put("chinese",chinese);
        map.put("math",math);
        map.put("english",english);
        map.put("physics",physics);
        map.put("chemistry",chemistry);
        map.put("biology",biology);

        map.put("chinames",chinames);
        map.put("matnames",matnames);
        map.put("englnames",englnames);
        map.put("phynames",phynames);
        map.put("chenames",chenames);
        map.put("bionames",bionames);
        map.put("timesMap",timesMap);
        map.put("totalProjects",totalProjects);
        map.put("onGoing",onGoing);
        map.put("totalProjects",totalProjects);





        return map;
    }

    @Override
    public Map getSourceData() {
        Map map = new HashMap();
        //获取饼状图数据

        //小学统计
        List<Map> juniorList = new ArrayList<>();
        List<String> juniorNames = new ArrayList<>();


        //中学统计
        List<Map> seniorList = new ArrayList<>();
        List<String> seniorNames = new ArrayList<>();


        List<SourceData> seniorData = scoreMapper.getSeniorData();
        List<SourceData> juniorData = scoreMapper.getJuniorData();
        for(int i=0;i<seniorData.size();i++){
            Map<String,Object> seniorMap = new HashMap<>();
            seniorMap.put("name",seniorData.get(i).getSchool());
            seniorMap.put("value",seniorData.get(i).getCount());
            seniorList.add(seniorMap);
            seniorNames.add(seniorData.get(i).getSchool());
        }
        for(int i=0;i<juniorData.size();i++){
            Map<String,Object> juniorMap = new HashMap<>();
            juniorMap.put("name",juniorData.get(i).getSchool());
            juniorMap.put("value",juniorData.get(i).getCount());
            juniorList.add(juniorMap);
            juniorNames.add(juniorData.get(i).getSchool());
        }



        //饼状图
        map.put("seniorList",seniorList);
        map.put("juniorList",juniorList);
        map.put("seniorNames",seniorNames);
        map.put("juniorNames",juniorNames);
        return map;
    }


    //平均数
    public static int getBalance(List<Integer> list){
        int temp = 0;
        int total = 0;
        for (int i=0;i<list.size();i++){
            temp = list.get(i);
            total+=temp;
        }
        if(total == 0){
            return 0;
        }else{
            return total/list.size();
        }

    }

}
