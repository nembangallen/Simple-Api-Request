package com.allennembang.np.apirequest;

import java.util.List;

public class JokesByNameRP {
    /**
     * type : success
     * value : {"id":254,"joke":"John Doe doesn't look both ways before he crosses the street... he just roundhouses any cars that get too close.","categories":[]}
     */

    private String type;
    private ValueBean value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ValueBean getValue() {
        return value;
    }

    public void setValue(ValueBean value) {
        this.value = value;
    }

    public static class ValueBean {
        /**
         * id : 254
         * joke : John Doe doesn't look both ways before he crosses the street... he just roundhouses any cars that get too close.
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
