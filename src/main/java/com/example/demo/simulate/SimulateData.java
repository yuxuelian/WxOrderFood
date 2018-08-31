package com.example.demo.simulate;

import java.util.List;

/**
 * @author kaibo
 * @date 2018/8/31 10:12
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public class SimulateData {

    private SellerBean seller;
    private List<GoodsBean> goods;
    private List<RatingsBean> ratings;

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public List<RatingsBean> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingsBean> ratings) {
        this.ratings = ratings;
    }

    public static class SellerBean {
        /**
         * name : 粥品香坊（回龙观）
         * description : 蜂鸟专送
         * deliveryTime : 38
         * score : 4.2
         * serviceScore : 4.1
         * foodScore : 4.3
         * rankRate : 69.2
         * minPrice : 20
         * deliveryPrice : 4
         * ratingCount : 24
         * sellCount : 90
         * bulletin : 粥品香坊其烹饪粥料的秘方源于中国千年古法，在融和现代制作工艺，由世界烹饪大师屈浩先生领衔研发。坚守纯天然、0添加的良心品质深得消费者青睐，发展至今成为粥类的引领品牌。是2008年奥运会和2013年园博会指定餐饮服务商。
         * supports : [{"type":0,"description":"在线支付满28减5"},{"type":1,"description":"VC无限橙果汁全场8折"},{"type":2,"description":"单人精彩套餐"},{"type":3,"description":"该商家支持发票,请下单写好发票抬头"},{"type":4,"description":"已加入\u201c外卖保\u201d计划,食品安全保障"}]
         * avatar : http://static.galileo.xiaojukeji.com/static/tms/seller_avatar_256px.jpg
         * pics : ["http://fuss10.elemecdn.com/8/71/c5cf5715740998d5040dda6e66abfjpeg.jpeg?imageView2/1/w/180/h/180","http://fuss10.elemecdn.com/b/6c/75bd250e5ba69868f3b1178afbda3jpeg.jpeg?imageView2/1/w/180/h/180","http://fuss10.elemecdn.com/f/96/3d608c5811bc2d902fc9ab9a5baa7jpeg.jpeg?imageView2/1/w/180/h/180","http://fuss10.elemecdn.com/6/ad/779f8620ff49f701cd4c58f6448b6jpeg.jpeg?imageView2/1/w/180/h/180"]
         * infos : ["该商家支持发票,请下单写好发票抬头","品类:其他菜系,包子粥店","北京市昌平区回龙观西大街龙观置业大厦底商B座102单元1340","营业时间:10:00-20:30"]
         */

        private String name;
        private String description;
        private int deliveryTime;
        private double score;
        private double serviceScore;
        private double foodScore;
        private double rankRate;
        private int minPrice;
        private int deliveryPrice;
        private int ratingCount;
        private int sellCount;
        private String bulletin;
        private String avatar;
        private List<SupportsBean> supports;
        private List<String> pics;
        private List<String> infos;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(int deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public double getServiceScore() {
            return serviceScore;
        }

        public void setServiceScore(double serviceScore) {
            this.serviceScore = serviceScore;
        }

        public double getFoodScore() {
            return foodScore;
        }

        public void setFoodScore(double foodScore) {
            this.foodScore = foodScore;
        }

        public double getRankRate() {
            return rankRate;
        }

        public void setRankRate(double rankRate) {
            this.rankRate = rankRate;
        }

        public int getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getDeliveryPrice() {
            return deliveryPrice;
        }

        public void setDeliveryPrice(int deliveryPrice) {
            this.deliveryPrice = deliveryPrice;
        }

        public int getRatingCount() {
            return ratingCount;
        }

        public void setRatingCount(int ratingCount) {
            this.ratingCount = ratingCount;
        }

        public int getSellCount() {
            return sellCount;
        }

        public void setSellCount(int sellCount) {
            this.sellCount = sellCount;
        }

        public String getBulletin() {
            return bulletin;
        }

        public void setBulletin(String bulletin) {
            this.bulletin = bulletin;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public List<SupportsBean> getSupports() {
            return supports;
        }

        public void setSupports(List<SupportsBean> supports) {
            this.supports = supports;
        }

        public List<String> getPics() {
            return pics;
        }

        public void setPics(List<String> pics) {
            this.pics = pics;
        }

        public List<String> getInfos() {
            return infos;
        }

        public void setInfos(List<String> infos) {
            this.infos = infos;
        }

        public static class SupportsBean {
            /**
             * type : 0
             * description : 在线支付满28减5
             */

            private int type;
            private String description;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }

    public static class GoodsBean {
        /**
         * name : 热销榜
         * type : -1
         * foods : [{"name":"皮蛋瘦肉粥","price":10,"oldPrice":"","description":"咸粥","sellCount":229,"rating":100,"info":"一碗皮蛋瘦肉粥，总是我到粥店时的不二之选。香浓软滑，饱腹暖心，皮蛋的Q弹与瘦肉的滑嫩伴着粥香溢于满口，让人喝这样的一碗粥也觉得心满意足","ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":0,"text":"很喜欢的粥","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":1,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"扁豆焖面","price":14,"oldPrice":"","description":"","sellCount":188,"rating":96,"ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":1,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"info":"","icon":"http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"葱花饼","price":10,"oldPrice":"","description":"","sellCount":124,"rating":85,"info":"","ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":1,"text":"没啥味道","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":1,"text":"很一般啊","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"牛肉馅饼","price":14,"oldPrice":"","description":"","sellCount":114,"rating":91,"info":"","ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":1,"text":"难吃不推荐","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/d/b9/bcab0e8ad97758e65ae5a62b2664ejpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/d/b9/bcab0e8ad97758e65ae5a62b2664ejpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"招牌猪肉白菜锅贴/10个","price":17,"oldPrice":"","description":"","sellCount":101,"rating":78,"info":"","ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":1,"text":"不脆,不好吃","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/7/72/9a580c1462ca1e4d3c07e112bc035jpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/7/72/9a580c1462ca1e4d3c07e112bc035jpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"南瓜粥","price":9,"oldPrice":"","description":"甜粥","sellCount":91,"rating":100,"ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/8/a6/453f65f16b1391942af11511b7a90jpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/8/a6/453f65f16b1391942af11511b7a90jpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"红豆薏米美肤粥","price":12,"oldPrice":"","description":"甜粥","sellCount":86,"rating":100,"info":"","ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/d/22/260bd78ee6ac6051136c5447fe307jpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/d/22/260bd78ee6ac6051136c5447fe307jpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"八宝酱菜","price":4,"oldPrice":"","description":"","sellCount":84,"rating":100,"info":"","ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"红枣山药糙米粥","price":10,"oldPrice":"","description":"","sellCount":81,"rating":91,"info":"","ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/750/h/750"},{"name":"糊塌子","price":10,"oldPrice":"","description":"","sellCount":80,"rating":93,"info":"","ratings":[{"username":"3******c","rateTime":1469281964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}],"icon":"http://fuss10.elemecdn.com/0/05/097a2a59fd2a2292d08067e16380cjpeg.jpeg?imageView2/1/w/114/h/114","image":"http://fuss10.elemecdn.com/0/05/097a2a59fd2a2292d08067e16380cjpeg.jpeg?imageView2/1/w/750/h/750"}]
         */

        private String name;
        private int type;
        private List<FoodsBean> foods;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<FoodsBean> getFoods() {
            return foods;
        }

        public void setFoods(List<FoodsBean> foods) {
            this.foods = foods;
        }

        public static class FoodsBean {
            /**
             * name : 皮蛋瘦肉粥
             * price : 10
             * oldPrice :
             * description : 咸粥
             * sellCount : 229
             * rating : 100
             * info : 一碗皮蛋瘦肉粥，总是我到粥店时的不二之选。香浓软滑，饱腹暖心，皮蛋的Q弹与瘦肉的滑嫩伴着粥香溢于满口，让人喝这样的一碗粥也觉得心满意足
             * ratings : [{"username":"3******c","rateTime":1469281964000,"rateType":0,"text":"很喜欢的粥","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"2******3","rateTime":1469271264000,"rateType":0,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"},{"username":"3******b","rateTime":1469261964000,"rateType":1,"text":"","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png"}]
             * icon : http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114
             * image : http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/750/h/750
             */

            private String name;
            private int price;
            private String oldPrice;
            private String description;
            private int sellCount;
            private int rating;
            private String info;
            private String icon;
            private String image;
            private List<RatingsBean> ratings;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getOldPrice() {
                return oldPrice;
            }

            public void setOldPrice(String oldPrice) {
                this.oldPrice = oldPrice;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getSellCount() {
                return sellCount;
            }

            public void setSellCount(int sellCount) {
                this.sellCount = sellCount;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public List<RatingsBean> getRatings() {
                return ratings;
            }

            public void setRatings(List<RatingsBean> ratings) {
                this.ratings = ratings;
            }

            public static class RatingsBean {
                /**
                 * username : 3******c
                 * rateTime : 1469281964000
                 * rateType : 0
                 * text : 很喜欢的粥
                 * avatar : http://static.galileo.xiaojukeji.com/static/tms/default_header.png
                 */

                private String username;
                private long rateTime;
                private int rateType;
                private String text;
                private String avatar;

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public long getRateTime() {
                    return rateTime;
                }

                public void setRateTime(long rateTime) {
                    this.rateTime = rateTime;
                }

                public int getRateType() {
                    return rateType;
                }

                public void setRateType(int rateType) {
                    this.rateType = rateType;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }
            }
        }
    }

    public static class RatingsBean {
        /**
         * username : 3******c
         * rateTime : 1469281964000
         * deliveryTime : 30
         * score : 5
         * rateType : 0
         * text : 不错,粥很好喝,我经常吃这一家,非常赞,以后也会常来吃,强烈推荐.
         * avatar : http://static.galileo.xiaojukeji.com/static/tms/default_header.png
         * recommend : ["南瓜粥","皮蛋瘦肉粥","扁豆焖面","娃娃菜炖豆腐","牛肉馅饼"]
         */

        private String username;
        private long rateTime;
        private int deliveryTime;
        private int score;
        private int rateType;
        private String text;
        private String avatar;
        private List<String> recommend;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public long getRateTime() {
            return rateTime;
        }

        public void setRateTime(long rateTime) {
            this.rateTime = rateTime;
        }

        public int getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(int deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getRateType() {
            return rateType;
        }

        public void setRateType(int rateType) {
            this.rateType = rateType;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public List<String> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<String> recommend) {
            this.recommend = recommend;
        }
    }
}
