package top.sunhu.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sunhu.community.dto.QuestionDTO;
import top.sunhu.community.mapper.QuestionMapper;
import top.sunhu.community.mapper.UserMapper;
import top.sunhu.community.pojo.Question;
import top.sunhu.community.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: QuestionService
 * @date: 2019/10/13 14:57
 * @author: SunHu
 */
@Service
public class QuestionService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;


    public List<QuestionDTO> list() {
        List<Question> questionList = questionMapper.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);

            questionDTOList.add(questionDTO);

        }

        return questionDTOList;
    }
}
