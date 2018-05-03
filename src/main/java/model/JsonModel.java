package model;

import java.util.ArrayList;

public class JsonModel {

    private ArrayList<Model> models;

    public JsonModel(Model model){
        models = new ArrayList<>();
        models.add(model);
    }

    public class Model{
        private String answer;
        private ArrayList<String> channels;
        private String master_question;
        private ArrayList<String> questions_negative;
        private ArrayList<String> questions_positive;
        private ArrayList<String> tags;
        private Double threshold_scale_factor;

        public Model(String answer,
                     ArrayList<String> channels,
                     String master_question,
                     ArrayList<String> questions_negative,
                     ArrayList<String> questions_positive,
                     ArrayList<String> tags,
                     Double threshold_scale_factor){

            this.answer = answer;
            this.channels = channels;
            this.master_question = master_question;
            this.questions_negative = questions_negative;
            this.questions_positive = questions_positive;
            this.tags = tags;
            this.threshold_scale_factor = threshold_scale_factor;

        }
        public String getAnswer() {
            return answer;
        }

        public String getMaster_question() {
            return master_question;
        }
    }
}
