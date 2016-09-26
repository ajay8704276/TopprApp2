package com.app.hack.toppr.model;

/**
 * Created by Ajay Kumar on 9/24/2016.
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Websites {

    @SerializedName("websites")
    @Expose
    private List<Website> websites = new ArrayList<Website>();
    @SerializedName("quote_max")
    @Expose
    private String quoteMax;
    @SerializedName("quote_available")
    @Expose
    private String quoteAvailable;

    /**
     * No args constructor for use in serialization
     *
     */
   /* public Websites() {
    }*/

    /**
     *
     * @param quoteAvailable
     * @param websites
     * @param quoteMax
     */
    public Websites(List<Website> websites, String quoteMax, String quoteAvailable) {
        this.websites = websites;
        this.quoteMax = quoteMax;
        this.quoteAvailable = quoteAvailable;
    }

    /**
     *
     * @return
     * The websites
     */
    public List<Website> getWebsites() {
        return websites;
    }

    /**
     *
     * @param websites
     * The websites
     */
    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    /**
     *
     * @return
     * The quoteMax
     */
    public String getQuoteMax() {
        return quoteMax;
    }

    /**
     *
     * @param quoteMax
     * The quote_max
     */
    public void setQuoteMax(String quoteMax) {
        this.quoteMax = quoteMax;
    }

    /**
     *
     * @return
     * The quoteAvailable
     */
    public String getQuoteAvailable() {
        return quoteAvailable;
    }

    /**
     *
     * @param quoteAvailable
     * The quote_available
     */
    public void setQuoteAvailable(String quoteAvailable) {
        this.quoteAvailable = quoteAvailable;
    }

    @Generated("org.jsonschema2pojo")
    public class Website {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("experience")
        @Expose
        private String experience;

        /**
         * No args constructor for use in serialization
         *
         */
   /* public Website() {
    }*/

        /**
         *
         * @param id
         * @param category
         * @param description
         * @param name
         * @param image
         * @param experience
         */
        public Website(String id, String name, String image, String category, String description, String experience) {
            this.id = id;
            this.name = name;
            this.image = image;
            this.category = category;
            this.description = description;
            this.experience = experience;
        }

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The image
         */
        public String getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(String image) {
            this.image = image;
        }

        /**
         *
         * @return
         * The category
         */
        public String getCategory() {
            return category;
        }

        /**
         *
         * @param category
         * The category
         */
        public void setCategory(String category) {
            this.category = category;
        }

        /**
         *
         * @return
         * The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         *
         * @return
         * The experience
         */
        public String getExperience() {
            return experience;
        }

        /**
         *
         * @param experience
         * The experience
         */
        public void setExperience(String experience) {
            this.experience = experience;
        }





    }


}
