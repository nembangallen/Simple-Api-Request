package com.allennembang.np.apirequest;

import java.util.List;

public class JokesRP {
    /**
     * Step 1 making model
     * type : success
     * value : [{"id":270,"joke":"The phrase 'dead ringer' refers to someone who sits behind Chuck Norris in a movie theater and forgets to turn their cell phone off.","categories":[]},{"id":418,"joke":"Chuck Norris doesn't believe in ravioli. He stuffs a live turtle with beef and smothers it in pig's blood.","categories":[]},{"id":348,"joke":"There?s an order to the universe: space, time, Chuck Norris.... Just kidding, Chuck Norris is first.","categories":[]},{"id":110,"joke":"You know how they say if you die in your dream then you will die in real life? In actuality, if you dream of death then Chuck Norris will find you and kill you.","categories":[]}]
     */

    private String type;
    private List<ValueBean> value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ValueBean> getValue() {
        return value;
    }

    public void setValue(List<ValueBean> value) {
        this.value = value;
    }

    public static class ValueBean {
        /**
         * id : 270
         * joke : The phrase 'dead ringer' refers to someone who sits behind Chuck Norris in a movie theater and forgets to turn their cell phone off.
         * categories : []
         */

        private int id;
        private String joke;
        private List<?> categories;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJoke() {
            return joke;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }

        public List<?> getCategories() {
            return categories;
        }

        public void setCategories(List<?> categories) {
            this.categories = categories;
        }
    }
}
