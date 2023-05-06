package com.example.dhara_parmar_project2;

import android.widget.ImageView;

public class Product {
        public Product(String image, String name, String flavor, String price) {
            this.image = image;
            this.name = name;
            this.flavor = flavor;
            this.price = price;

        }

        private String image;

//    public Product(String description) {
//        this.description = description;
//    }

    private String name;
        private String flavor;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFlavor() {
            return flavor;
        }

        public void setFlavor(String flavor) {
            this.flavor = flavor;
        }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    }


