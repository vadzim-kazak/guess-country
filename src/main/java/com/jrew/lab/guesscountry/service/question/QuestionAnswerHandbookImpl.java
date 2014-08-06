package com.jrew.lab.guesscountry.service.question;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Component
public class QuestionAnswerHandbookImpl implements QuestionAnswerHandbook {

    @Autowired
    private Map<String, LocalizedQuestionAnswer> questionAnswerBeans;

    @Override
    public List<LocalizedQuestionAnswer> provideQuestionAnswers() {

        List<LocalizedQuestionAnswer> questionAnswers = new ArrayList<>(questionAnswerBeans.values());
        Collections.shuffle(questionAnswers);

        return questionAnswers;
    }
}
